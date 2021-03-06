package br.com.predictown.JDBC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import packageMain.FutureValues;
import packageMain.Values;

public class JDBCFutureValuesDAO {
    
    private Connection connection;

    public JDBCFutureValuesDAO(Connection connection) {
	this.connection = connection;
    }
    
    public List<FutureValues> searchFutureValues () {
	
	List <FutureValues> listFutureValues = new ArrayList<FutureValues>();
	
   	String command = "SELECT * FROM futurevalues v WHERE machine_idmachine = 13 AND v.idfuturevalues IN("
   		+ "SELECT * FROM (SELECT v2.idfuturevalues FROM futurevalues v2 ORDER BY v2.idfuturevalues DESC LIMIT 60) as t) "
   		+ "ORDER BY v.idfuturevalues ASC";
   	
   	FutureValues futureValues = null;
   	
   	try {
   	    Statement stmt = connection.createStatement();
   	    ResultSet rs = stmt.executeQuery(command);
   	    while (rs.next()) {
   		
   		int id = rs.getInt("idFutureValues");
   		BigDecimal cCurrency1 = rs.getBigDecimal("c1");
   		BigDecimal cCurrency2 = rs.getBigDecimal("c2");
   		BigDecimal cCurrency3 = rs.getBigDecimal("c3");
   		BigDecimal machineTemp = rs.getBigDecimal("machineTemp");
   		BigDecimal localTemp = rs.getBigDecimal("localTemp");
   		BigDecimal voltage1 = rs.getBigDecimal("t1");
   		BigDecimal voltage2 = rs.getBigDecimal("t2");
   		BigDecimal voltage3 = rs.getBigDecimal("t3");
   		Date dateHour = rs.getDate("dateHour");
   		
   		futureValues = new FutureValues();
   		
   		futureValues.setIdFutureValues(id);
   		futureValues.setC1(cCurrency1);
   		futureValues.setC2(cCurrency2);
   		futureValues.setC3(cCurrency3);
   		futureValues.setMachineTemp(machineTemp);
   		futureValues.setLocalTemp(localTemp);
   		futureValues.setT1(voltage1);
   		futureValues.setT2(voltage2);
   		futureValues.setT3(voltage3);
   		futureValues.setDateHour(dateHour);
   		
   		listFutureValues.add(futureValues);
   	    }
   	}
   	catch (Exception e) {
   	    e.printStackTrace();
   	}
   	
   	return listFutureValues;
   	
       }

}
