package br.com.predictown.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.predictown.db.Connect;
import packageMain.TypeMachine;

public class JDBCTypeMachineDAO {

    private Connection connection;

    public JDBCTypeMachineDAO(Connection connection) {
	this.connection = connection;
    }
    
    public boolean editType(TypeMachine typeMachine) {
	String command = "UPDATE typemachine SET name=?, descriptionType=? WHERE idType=?";
	PreparedStatement p;				
	
	try {
	    p = this.connection.prepareStatement(command);
	    p.setString(1, typeMachine.getName());
	    p.setString(2, typeMachine.getDescriptionType());
	    p.setInt(3, typeMachine.getIdType());
	    p.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	return true;
    }
    
    
    public boolean deleteType(int idType) {
	String command = "DELETE FROM typemachine WHERE idType = ?";
	PreparedStatement p;
	
	try {
	    p = this.connection.prepareStatement(command);
	    p.setInt(1, idType);
	    p.execute();
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	return true;
    }

    public boolean insert(TypeMachine typeMachine) {

	String command = "INSERT INTO typemachine (idType, name, descriptionType) VALUES (?,?,?)";

	PreparedStatement p;

	try {

	    p = this.connection.prepareStatement(command);

	    p.setInt(1, typeMachine.getIdType());
	    p.setString(2, typeMachine.getName());
	    p.setString(3, typeMachine.getDescriptionType());
	    p.execute();
	    

	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	}
	return true;
    }
    
    
    public List<TypeMachine> searchRegistryType() {

   	String command = "SELECT * FROM typemachine";
   	List<TypeMachine> listTypeMachine = new ArrayList<TypeMachine>();
   	TypeMachine typeMachine = null;
   	try {
   	    Statement stmt = connection.createStatement();
   	    ResultSet rs = stmt.executeQuery(command);

   	    while (rs.next()) {
   		typeMachine = new TypeMachine();

   		int idTypeMachine = rs.getInt("idType");
   		String name = rs.getString("name");
   		String descriptionType = rs.getString("descriptionType");
   		typeMachine.setIdType(idTypeMachine);
   		typeMachine.setName(name);
   		typeMachine.setDescriptionType(descriptionType);

   		listTypeMachine.add(typeMachine);

   	    }
   	} catch (SQLException e) {
   	    e.printStackTrace();
   	}

   	return listTypeMachine;
       }

}
