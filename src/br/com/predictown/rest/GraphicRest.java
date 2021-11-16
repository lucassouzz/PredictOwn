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
import br.com.predictown.JDBC.JDBCTypeMachineDAO;
import br.com.predictown.JDBC.JDBCValuesDAO;
import br.com.predictown.db.Connect;
import packageMain.Machine;
import packageMain.TypeMachine;
import packageMain.Values;

@Path("/graphic")
public class GraphicRest extends UtilRest {

    @GET
    @Path("/updateValues")
    @Consumes("application/*")
    public Response updateValues () {
	try {
	    
	    List <Values> listValues = new ArrayList<Values>();
	    
	    Values values = new Values();
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCValuesDAO jdbcValues = new JDBCValuesDAO(connection);
	    
	    listValues = jdbcValues.searchValues();
	    
	    conec.closeConnection();
	    
	    return this.buildResponse(listValues);
	    
	}
	catch(Exception e){
	    e.printStackTrace();
	    return this.buildErrorResponse("Erro ao coletar dados");
	}
    }
}
