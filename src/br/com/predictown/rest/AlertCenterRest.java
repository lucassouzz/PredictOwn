package br.com.predictown.rest;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.predictown.JDBC.JDBCMachineDAO;
import br.com.predictown.JDBC.JDBCTriggerAlertDAO;
import br.com.predictown.JDBC.JDBCTypeMachineDAO;
import br.com.predictown.JDBC.JDBCValuesDAO;
import br.com.predictown.db.Connect;
import packageMain.Machine;
import packageMain.TypeMachine;
import packageMain.Values;


@Path("/alertCenter")
public class AlertCenterRest extends UtilRest {
    
    @GET
    @Path("/triggerAlert")
    @Consumes("application/*")
    public Response triggerAlert () {
	
	try {
	    List<Values> listValuesMachine = new ArrayList<Values>();

	    Values values = new Values();
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCTriggerAlertDAO jdbcAlert = new JDBCTriggerAlertDAO(connection);
	    
	    listValuesMachine = jdbcAlert.TriggerAlert();

	    conec.closeConnection();

	    return this.buildResponse(listValuesMachine);
	    
	}
	catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse("Erro ao coletar dados");
	}
	
    }

}
