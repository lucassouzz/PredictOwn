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
import br.com.predictown.db.Connect;
import packageMain.Machine;
import packageMain.TypeMachine;

@Path("/machine")
public class MachineRest extends UtilRest {

    @POST
    @Path("/editMachine")
    @Consumes("application/*")
    public Response editMachine(String machineParam) {
	String msg = "";
	try {
	    Machine machine = new Gson().fromJson(machineParam, Machine.class);
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCMachineDAO jdbcMachine = new JDBCMachineDAO(connection);

	    boolean return_ = jdbcMachine.editMachine(machine);
	    if (return_) {
		msg = "Equipamento editado com sucesso!";
	    } else {
		msg = "Ocorreu algo inesperado, tente novamente ou entre em contato com o Administrador.";
	    }

	    return this.buildResponse(msg);

	} catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse(msg);
	}

    }
    
    @GET
    @Path("/searchRegistryById/{idMachine}")
    @Consumes("application/*")
    public Response searchRegistryById(@PathParam("idMachine") int idMachine) {
	String msg = "Erro ao buscar maquina informada.";
	try {
	    Machine machine = new Machine();
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCMachineDAO jdbcMachine = new JDBCMachineDAO(connection);
	    machine = jdbcMachine.searchRegistryById(idMachine);
	
	    conec.closeConnection();
	    
	    return this.buildResponse(machine);
	} catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse(msg);
	}
    }
    
    @DELETE
    @Path("/machineDelete/{idMachine}")
    @Consumes("application/*")
    public Response deleteMachine(@PathParam("idMachine") int idMachine) {
	String msg = "";
	try {
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCMachineDAO jdbcMachine = new JDBCMachineDAO(connection);
	    boolean return_ = jdbcMachine.deleteMachine(idMachine);
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
    
    @GET
    @Path("/searchRegistryMachine")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchRegistryMachine() {
	
	try {
	    List<Machine> listMachine = new ArrayList<Machine>();
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCMachineDAO jdbcMachine = new JDBCMachineDAO(connection);
	    listMachine = jdbcMachine.searchRegistryMachine();

	    conec.closeConnection();

	    return this.buildResponse(listMachine);
	    
	}catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse(e.getMessage());
	}
    }
    /**
     * Return list of supply select for register machine
     */
    @GET
    @Path("/searchTypeMachine")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchTypeMachine() {

	try {
	    List<TypeMachine> listTypeMachine = new ArrayList<TypeMachine>();

	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCMachineDAO jdbcMachine = new JDBCMachineDAO(connection);
	    listTypeMachine = jdbcMachine.searchTypeMachine();

	    conec.closeConnection();

	    return this.buildResponse(listTypeMachine);
	} catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse(e.getMessage());
	}

    }

    @POST
    @Path("/register")
    @Consumes("application/*")
    public Response insert(String machineParam) {
	String msg = "";
	try {
	    Machine machine = new Gson().fromJson(machineParam, Machine.class);
	    Connect conec = new Connect();
	    Connection connection = conec.openConnection();
	    JDBCMachineDAO jdbcMachine = new JDBCMachineDAO(connection);

	    boolean return_ = jdbcMachine.insert(machine);
	    if (return_) {
		msg = "Equipamento cadastrado com sucesso!";
	    } else {
		msg = "Ocorreu algo inesperado, tente novamente ou entre em contato com o Administrador.";
	    }

	    return this.buildResponse(msg);

	} catch (Exception e) {
	    e.printStackTrace();
	    return this.buildErrorResponse(msg);
	}

    }

}
