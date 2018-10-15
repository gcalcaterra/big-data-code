package tpBigdata.rest;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import tpBigdata.ejb.InternetUseDAO;
import tpBigdata.ejb.InternetUseViewDAO;
import tpBigdata.model.InternetUse;
import tpBigdata.model.InternetUseView;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.UUID.randomUUID;


@Path("internetUse")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class InternetUseRest {
	public static final String CSV_DATA = "/tmp/data/";

	@EJB
	private InternetUseDAO internetUseDAO;
	
	@EJB
	private InternetUseViewDAO internetUseViewDAO;
	
	@Context
	protected UriInfo uriInfo;

	@GET
	@Path("/")
	public Response consultar() throws WebApplicationException{
		List<InternetUseView> listEntity = null;
		Long total = null;
		total = internetUseDAO.total();
		listEntity = internetUseDAO.lista();
		Map<String,Object> mapaResultado= new HashMap<>();
		mapaResultado.put("total", total);
		mapaResultado.put("lista", listEntity);

		return Response.ok(mapaResultado).build();
	}

	@POST
	@Path("/")
	public Response agregar(InternetUse internetUse) throws WebApplicationException {
		//Guarda el resultado en un archivo .csv
		File archivoCSV = new File(CSV_DATA + randomUUID() + ".csv");
		CSVPrinter csvPrinter;
		try {
			new File(CSV_DATA).mkdirs();
			archivoCSV.createNewFile();

			csvPrinter = CSVFormat.EXCEL
					.withHeader("indic_is", "ind_type", "geo\\time", "year", "percent")
					.print(archivoCSV, Charset.forName("UTF-8"));

			ArrayList<String> record = new ArrayList<>();

			record.add(internetUse.getInternetUseId());
			record.add(internetUse.getIndividualTypeId());
			record.add(internetUse.getGeographyId());
			record.add(Integer.toString(internetUse.getYear()));
			record.add(Integer.toString(internetUse.getUnits()));

			csvPrinter.printRecord(record);
			csvPrinter.close();

		} catch (IOException e) {
			throw new WebApplicationException(e);
		}

		
		InternetUseView internetUseView = internetUseViewDAO.get(internetUse.getInternetUseId());
		if (internetUseView != null) {
			//Actualizar la suma
			internetUseView.setSum(internetUseView.getSum() + internetUse.getUnits());
			//Actualizar min
			internetUseView.setUnitsMin(Math.min(internetUseView.getUnitsMin(), internetUse.getUnits()));
			//Actualizar max
			internetUseView.setUnitsMax(Math.max(internetUseView.getUnitsMax(), internetUse.getUnits()));
			//Actualizar prom
			//https://math.stackexchange.com/questions/95909/why-is-an-average-of-an-average-usually-incorrect
			Double oldCount = (double)internetUseView.getCount();
			Double allCount = oldCount + 1;
			Double oldAvg = (oldCount/allCount)*internetUseView.getAvg();
			Double newAvg = (1/(allCount))*internetUse.getUnits();
			internetUseView.setAvg((long) (oldAvg + newAvg));
			//Actualizar cont
			internetUseView.setCount(internetUseView.getCount()+1);
			//Guardar
			internetUseViewDAO.merge(internetUseView);
		} else {
			internetUseView = new InternetUseView();
			internetUseView.setInternetUseId(internetUse.getInternetUseId());
			internetUseView.setSum(internetUse.getUnits().longValue());
			internetUseView.setUnitsMin(internetUse.getUnits().doubleValue());
			internetUseView.setUnitsMax(internetUse.getUnits().doubleValue());
			internetUseView.setAvg(internetUse.getUnits().longValue());
			internetUseView.setCount((long)1);
			internetUseViewDAO.persist(internetUseView);
		}
		
		//Responde con estado 201 (Creado)
		try {
			UriBuilder resourcePathBuilder = UriBuilder.fromUri(uriInfo
					.getAbsolutePath());

			URI resourceUri = resourcePathBuilder
					.path(URLEncoder.encode(internetUse.getInternetUseId(), "UTF-8")).build();
			return Response.created(resourceUri).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}
