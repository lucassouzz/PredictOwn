package br.com.predictown.rest;

import java.sql.Connection;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import br.com.predictown.JDBC.JDBCDashboardDAO;

import br.com.predictown.db.Connect;

@Path("/dashboard")
public class DashboardRest extends UtilRest {

    @GET
    @Path("/getLastValues")
    @Consumes("application/*")
    public Response getLastValues() {
	try {
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCDashboardDAO jdbcDashboard = new JDBCDashboardDAO(connection);
	    HashMap<String, Double> map = jdbcDashboard.getLastValues();

	    conec.closeConnection();

	    return this.buildResponse(map);
	    
	} catch (Exception e) {
	    e.printStackTrace();
	    String msg = "Ocorreu algo inesperado!";
	    return this.buildErrorResponse(msg);
	}
    }
}
