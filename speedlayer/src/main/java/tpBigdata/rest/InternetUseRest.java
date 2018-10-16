package tpBigdata.rest;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import tpBigdata.ejb.InternetUseDAO;
import tpBigdata.model.InternetUse;

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
import java.util.Map;

import static java.util.UUID.randomUUID;


@Path("internetUse")
@RequestScoped
public class InternetUseRest {
	public static final String CSV_DATA = "/tmp/data/";

	@EJB
	private InternetUseDAO internetUseDAO;
	@Context
	protected UriInfo uriInfo;

	@GET
	@Path("/{internetUseId}")
	@Produces("application/json")
	public Response consultarPorId(@PathParam("internetUseId") String internetUseId) throws WebApplicationException {
		String nombreTabla = "internetUse";

		Map<String,Object> mapaResultado= new HashMap<>();
		Configuration conf = HBaseConfiguration.create();
		Connection conexion;

		try {
			conexion = ConnectionFactory.createConnection(conf);
			Table tabla = conexion.getTable(TableName.valueOf(nombreTabla));

			Get g = new Get(Bytes.toBytes(internetUseId));
			Result result = tabla.get(g);

			for (Cell celda : result.rawCells()) {
				//System.out.println("Familia: " + Bytes.toString(CellUtil.cloneFamily(celda)));
				//String row = Bytes.toString(CellUtil.cloneRow(celda));
				String qualifier = Bytes.toString(CellUtil.cloneQualifier(celda));
				String value = Bytes.toString(CellUtil.cloneValue(celda));

				mapaResultado.put(qualifier, value);
			}

			//Aqui consultar del postgres...

			return Response.ok(mapaResultado).build();

		} catch (IOException e) {
			throw new WebApplicationException(e);
		}

	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public Response agregar(InternetUse... internetUses) throws WebApplicationException {
		//Guarda el resultado en un archivo .csv
		File archivoCSV = new File(CSV_DATA + randomUUID() + ".csv");
		CSVPrinter csvPrinter;
		try {
			new File(CSV_DATA).mkdirs();
			archivoCSV.createNewFile();

			csvPrinter = CSVFormat.EXCEL
					.withHeader("indic_is", "ind_type", "geo\\time", "year", "percent")
					.print(archivoCSV, Charset.forName("UTF-8"));

			for (InternetUse internetUse : internetUses) {
				ArrayList<String> record = new ArrayList<>();
				record.add(internetUse.getInternetUseId());
				record.add(internetUse.getIndividualTypeId());
				record.add(internetUse.getGeographyId());
				record.add(Integer.toString(internetUse.getYear()));
				record.add(Integer.toString(internetUse.getUnits()));
				csvPrinter.printRecord(record);
			}
			csvPrinter.close();

			//Aqui insertar al postgres...

			//Responde con estado 201 (Creado)
			UriBuilder resourcePathBuilder = UriBuilder.fromUri(uriInfo
					.getAbsolutePath());

			URI resourceUri = resourcePathBuilder
					.path(URLEncoder.encode("internetUse", "UTF-8")).build();
			return Response.created(resourceUri).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}
