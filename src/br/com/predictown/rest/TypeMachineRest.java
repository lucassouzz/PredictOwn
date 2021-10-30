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

import br.com.predictown.JDBC.JDBCTypeMachineDAO;
import br.com.predictown.db.Connect;

import packageMain.TypeMachine;

@Path("/type")
public class TypeMachineRest extends UtilRest {

    
    
    @POST
    @Path("/typeEdit")
    @Consumes("application/*")
    public Response typeEdit(String typeMachineParam) {
	String msg = "";
	try {
	    TypeMachine typeMachine = new Gson().fromJson(typeMachineParam, TypeMachine.class);
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCTypeMachineDAO jdbcTypeMachine = new JDBCTypeMachineDAO(connection);
	    boolean return_ = jdbcTypeMachine.editType(typeMachine);
	    if (return_) {
		msg = "Tipo de equipameno editado com sucesso";
	    } else {
		msg = "Ocorreu algo inesperado ao editar o tipo de equipamento informado, "
			+ "tente novamente ou entre em contato com o Administrador.";
	    }
	    
	    conec.closeConnection();
	    
	    return this.buildResponse(msg);
	} catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse(msg);
	}
    }
    
    @DELETE
    @Path("/typeDelete/{idType}")
    @Consumes("application/*")
    public Response deleteType(@PathParam("idType") int idType) {
	String msg = "";
	try {
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCTypeMachineDAO jdbcTypeMachine = new JDBCTypeMachineDAO(connection);
	    boolean return_ = jdbcTypeMachine.deleteType(idType);
	    if (return_) {
		msg = "Tipo de equipameno excluido com sucesso";
	    } else {
		msg = "Ocorreu algo inesperado ao excluir o tipo de equipamento informado, "
			+ "tente novamente ou entre em contato com o Administrador.";
	    }
	    
	    conec.closeConnection();
	    
	    return this.buildResponse(msg);
	} catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse(msg);
	}
    }

    @POST
    @Path("/register")
    @Consumes("application/*")
    public Response insert(String typeParam) {

	String msg = "";
	try {

	    TypeMachine type = new Gson().fromJson(typeParam, TypeMachine.class);
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCTypeMachineDAO jdbcTypeMachine = new JDBCTypeMachineDAO(connection);

	    boolean return_ = jdbcTypeMachine.insert(type);

	    if (return_) {
		msg = "Categoria cadastrada com sucesso!";
	    } else {
		msg = "Ocorreu algo inesperado, tente novamente ou entre em contato com o Administrador.";
	    }

	    conec.closeConnection();

	    return this.buildResponse(msg);

	} catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse(msg);
	}

    }

    @GET
    @Path("/searchRegistryType")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchTypeMachine() {

	try {
	    List<TypeMachine> listTypeMachine = new ArrayList<TypeMachine>();

	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCTypeMachineDAO jdbcTypeMachine = new JDBCTypeMachineDAO(connection);
	    listTypeMachine = jdbcTypeMachine.searchRegistryType();

	    conec.closeConnection();

	    return this.buildResponse(listTypeMachine);
	} catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse(e.getMessage());
	}

    }

}
