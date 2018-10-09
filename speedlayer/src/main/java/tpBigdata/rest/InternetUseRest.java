package tpBigdata.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import tpBigdata.ejb.InternetUseDAO;
import tpBigdata.model.InternetUse;
import tpBigdata.model.InternetUseView;
/*
import com.backtype.hadoop.pail.Pail;
import tpBigData.batchlayer.BatchWorkflow;
import tpBigData.tap.DataPailStructure;
import tpBigData.tap.SplitDataPailStructure;

import static tpBigData.test.DataProcess.makeFacts;

*/

@Path("internetUse")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class InternetUseRest {
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

		/*
		//Insertar en el HDFS
		try {
			Pail newPail = new Pail(BatchWorkflow.NEW_ROOT);
			Pail.TypedRecordOutputStream os = newPail.openWrite();

			String internetUseId = internetUse.getInternetUseId();
			String individualTypeId = internetUse.getIndividualTypeId();
			String geographyId = internetUse.getGeographyId();
			int year = internetUse.getYear();
			int units = internetUse.getUnits();
			long timeSecs = new  Date().getTime();

			os.writeObject(makeFacts(timeSecs, internetUseId, individualTypeId, geographyId, year, units));
			os.close();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
			*/
		UriBuilder resourcePathBuilder = UriBuilder.fromUri(uriInfo
				.getAbsolutePath());
		URI resourceUri=null;
		try {
			resourceUri = resourcePathBuilder
					.path(URLEncoder.encode(internetUse.getInternetUseId(), "UTF-8")).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.created(resourceUri).build();
	}

}
