package br.com.predictown.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import packageMain.Controller;

@Path("/type")
public class TypeMachine extends UtilRest{

    @POST
    @Path("/register")
    @Consumes("application/*")
    public Response insert(String typeParam) {

	try {
	    
	    TypeMachine type = new Gson().fromJson(typeParam, TypeMachine.class);
	    Controller control = new Controller();
	    
	    control.salvar(type);
	    
	    
	    return this.buildResponse("deu ruim");

	} catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse("deu muito ruim");
	}
	

    }

}
