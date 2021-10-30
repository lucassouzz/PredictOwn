package br.com.predictown.db;

import java.sql.Connection;

public class Connect {

    private Connection conec;
	
	public Connection openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//.newInstance();
			conec = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/mydb?user=root&password=root&useTimezone=true&serverTimezone=UTC");
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return conec;
	}
	
	public void closeConnection() {
		try {
		    conec.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
}
