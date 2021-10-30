package br.com.predictown.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import packageMain.Machine;
import packageMain.TypeMachine;

public class JDBCMachineDAO {

    private Connection connection;

    public JDBCMachineDAO(Connection connection) {
	this.connection = connection;
    }

    public boolean editMachine(Machine machine) {
	/*
	 * TODO: alterar a coluna para name
	 */
	String command = "UPDATE machine set nome=?, descriptionMachine=?, cMax=?, cMin=?,"
		+ " tMax=?, tMin=?, tempMax=?, tempMin=?, typemachine_idType=? WHERE idmachine=?";
		
	PreparedStatement p;

	try {
	    p = this.connection.prepareStatement(command);

	    p.setString(1, machine.getName());
	    p.setString(2, machine.getDescriptionMachine());
	    p.setDouble(3, machine.getcMax());
	    p.setDouble(4, machine.getcMin());
	    p.setDouble(5, machine.gettMax());
	    p.setDouble(6, machine.gettMin());
	    p.setDouble(7, machine.getTempMax());
	    p.setDouble(8, machine.getTempMin());
	    p.setInt(9, machine.getTypeMachine_idType());
	    p.setInt(10, machine.getIdMachine());

	    p.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	return true;
    }

    public Machine searchRegistryById(int idMachine) {
	String command = "SELECT * FROM machine WHERE idmachine = " + idMachine;
	Machine machine = new Machine();
	try {
	    Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery(command);
	    while (rs.next()) {

		int id = rs.getInt("idMachine");
		String name = rs.getString("nome");
		String description = rs.getString("descriptionMachine");
		Double cMin = rs.getDouble("cMin");
		Double cMax = rs.getDouble("cMax");
		Double tMin = rs.getDouble("tMin");
		Double tMax = rs.getDouble("tMax");
		Double tempMin = rs.getDouble("tempMin");
		Double tempMax = rs.getDouble("tempMax");
		int typemachine_idType = rs.getInt("typemachine_idType");

		machine.setIdMachine(id);
		machine.setName(name);
		machine.setDescriptionMachine(description);
		machine.setcMin(cMin);
		machine.setcMax(cMax);
		machine.settMin(tMin);
		machine.settMax(tMax);
		machine.setTempMin(tempMin);
		machine.setTempMax(tempMax);
		machine.setTypeMachine_idType(typemachine_idType);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return machine;
    }

    public boolean deleteMachine(int idMachine) {
	String command = "DELETE FROM machine WHERE idMachine = ?";
	PreparedStatement p;

	try {
	    p = this.connection.prepareStatement(command);
	    p.setInt(1, idMachine);
	    p.execute();
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	return true;
    }

    public boolean insert(Machine machine) {
	/*
	 * TODO: alterar a coluna para name
	 */
	String command = "INSERT INTO machine (idMachine, nome, descriptionMachine, cMax, cMin, tMax, tMin, tempMax, tempMin, typemachine_idType)"
		+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
	PreparedStatement p;

	try {
	    p = this.connection.prepareStatement(command);

	    p.setInt(1, machine.getIdMachine());
	    p.setString(2, machine.getName());
	    p.setString(3, machine.getDescriptionMachine());
	    p.setDouble(4, machine.getcMax());
	    p.setDouble(5, machine.getcMin());
	    p.setDouble(6, machine.gettMax());
	    p.setDouble(7, machine.gettMin());
	    p.setDouble(8, machine.getTempMax());
	    p.setDouble(9, machine.getTempMin());
	    p.setInt(10, machine.getTypeMachine_idType());

	    p.execute();

	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	return true;
    }

    public List<Machine> searchRegistryMachine() {

	String command = "SELECT * FROM machine";
	List<Machine> listMachine = new ArrayList<Machine>();
	Machine machine = null;
	try {
	    Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery(command);

	    while (rs.next()) {
		machine = new Machine();
		int typemachine_idType = rs.getInt("typemachine_idType");
		int idMachine = rs.getInt("idMachine");
		String name = rs.getString("nome");
		String description = rs.getString("descriptionMachine");
		machine.setIdMachine(idMachine);
		machine.setName(name);
		machine.setDescriptionMachine(description);
		machine.setTypeMachine_idType(typemachine_idType);

		listMachine.add(machine);

	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return listMachine;
    }

    public List<TypeMachine> searchTypeMachine() {
	String command = "SELECT * FROM typemachine";
	List<TypeMachine> listType = new ArrayList<TypeMachine>();
	TypeMachine type = null;
	try {
	    Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery(command);
	    while (rs.next()) {
		type = new TypeMachine();
		int idType = rs.getInt("idType");
		String name = rs.getString("name");
		String descriptionType = rs.getString("descriptionType");
		type.setIdType(idType);
		type.setName(name);
		type.setDescriptionType(descriptionType);

		listType.add(type);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return listType;
    }

}
