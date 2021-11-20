package br.com.predictown.JDBC;

import java.sql.Connection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonObject;

import packageMain.Values;

public class JDBCTriggerAlertDAO {
    
    private Connection connection;

    public JDBCTriggerAlertDAO(Connection connection) {
	this.connection = connection;
    }
    
    public List<Values> TriggerAlert() {

	List<Values> listValues = new ArrayList<Values>();

	String command = "select * from valuesmachine vm "
		+ "inner join machine m on "
		+ " vm.machineTemp > m.tempMax group by vm.machineTemp";
	
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
		BigDecimal localHum = rs.getBigDecimal("localHum");
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
		values.setLocalHum(localHum);
		values.setT1(voltage1);
		values.setT2(voltage2);
		values.setT3(voltage3);
		values.setDateHour(dateHour);

		listValues.add(values);

	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return listValues;

    }

}
