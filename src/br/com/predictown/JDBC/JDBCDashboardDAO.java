package br.com.predictown.JDBC;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashMap;


public class JDBCDashboardDAO {

    private Connection connection;

    public JDBCDashboardDAO(Connection connection) {
	this.connection = connection;
    }

    public HashMap<String, Double> getLastValues() {

	HashMap<String, Double> map = new HashMap<String, Double>();

	/*
	 * TODO: idmachine está fixo!
	 */
	String command = "SELECT * FROM valuesmachine vm WHERE vm.machine_idmachine = 13 ORDER BY vm.idValues DESC limit 1";

	try {
	    Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery(command);
	    
	    while(rs.next()) {
	    map.put("c1", rs.getDouble("c1"));
	    map.put("c2", rs.getDouble("c2"));
	    map.put("c3", rs.getDouble("c3"));
	    map.put("t1", rs.getDouble("t1"));
	    map.put("t2", rs.getDouble("t2"));
	    map.put("t3", rs.getDouble("t3"));
	    map.put("machineTemp", rs.getDouble("machineTemp"));
	    map.put("localTemp", rs.getDouble("localTemp"));
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return map;

    }

}
