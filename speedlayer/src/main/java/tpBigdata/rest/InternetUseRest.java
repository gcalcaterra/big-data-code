package tpBigdata.rest;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import tpBigdata.ejb.InternetUseDAO;
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
