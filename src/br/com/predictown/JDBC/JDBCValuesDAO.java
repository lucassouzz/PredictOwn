package br.com.predictown.JDBC;

import java.math.BigDecimal;
import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import packageMain.Values;

public class JDBCValuesDAO {
    
    private Connection connection;

    public JDBCValuesDAO(Connection connection) {
	this.connection = connection;
    }
    
    public List<Values> searchValues () {
	
	List <Values> listValues = new ArrayList<Values>();
	
	String command = "SELECT * FROM valuesmachine ORDER BY idValues DESC LIMIT 100";
	
	Values values = null;
	
	try {
	    Statement stmt = connection.createStatement();
	    ResultSet rs = stmt.executeQuery(command);
	    while (rs.next()) {
		
		int id = rs.getInt("idValues");
		BigDecimal cCurrency1 = rs.getBigDecimal("c1");
		BigDecimal cCurrency2 = rs.getBigDecimal("c2");
		BigDecimal cCurrency3 = rs.getBigDecimal("c3");
		BigDecimal machineTemp = rs.getBigDecimal("machineTemp");
		BigDecimal localTemp = rs.getBigDecimal("localTemp");
//		BigDecimal localHum = rs.getBigDecimal("localHum");
		BigDecimal voltage1 = rs.getBigDecimal("t1");
		BigDecimal voltage2 = rs.getBigDecimal("t2");
		BigDecimal voltage3 = rs.getBigDecimal("t3");
		Date dateHour = rs.getDate("dateHour");
		
		values = new Values();
		
		values.setIdValues(id);
		values.setC1(cCurrency1);
		values.setC2(cCurrency2);
		values.setC3(cCurrency3);
		values.setMachineTemp(machineTemp);
		values.setLocalTemp(localTemp);
//		values.setLocalHum(localHum);
		values.setT1(voltage1);
		values.setT2(voltage2);
		values.setT3(voltage3);
		values.setDateHour(dateHour);
		
		listValues.add(values);
		
	    }
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
	
	return listValues;
	
    }

}
