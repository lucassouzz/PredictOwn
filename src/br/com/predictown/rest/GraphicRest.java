package br.com.predictown.rest;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.core.Response;


import br.com.predictown.JDBC.JDBCFutureValuesDAO;

import br.com.predictown.JDBC.JDBCValuesDAO;
import br.com.predictown.db.Connect;
import packageMain.FutureValues;

import packageMain.Values;

@Path("/graphic")
public class GraphicRest extends UtilRest {

    @GET
    @Path("/updateValues")
    @Consumes("application/*")
    public Response updateValues () {
	try {
	    
	    List <Values> listValues = new ArrayList<Values>();
	    
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
	
    @GET
    @Path("/updateFutureValues")
    @Consumes("application/*")
    public Response updateFutureValues () {
	try {
	    
	    List <FutureValues> listFutureValues = new ArrayList<FutureValues>();
	    
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCFutureValuesDAO jdbcFutureValues = new JDBCFutureValuesDAO(connection);
	    
	    listFutureValues = jdbcFutureValues.searchFutureValues();
	    
	    conec.closeConnection();
	    
	    return this.buildResponse(listFutureValues);
	    
	}
	catch(Exception e){
	    e.printStackTrace();
	    return this.buildErrorResponse("Erro ao coletar dados");
	}
    }	
}
