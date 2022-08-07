package com.turkcell.atm.sql;

import lombok.Data;

@Data
public abstract class DatabaseInformation {
	
	private String url;
	private String userName;
	private String userPassword;
	private String forNameData;
	
	// Parametresiz constructor
	public DatabaseInformation() {
		// postgreSQL
		this.url = "jdbc:postgresql://localhost:5432/turkcell_db";
		this.userName = "postgres";
		this.userPassword = "12345";
		this.forNameData = "org.postgresql.Driver";
	}
	
	// Parametreli constructor
	public DatabaseInformation(String url, String userName, String userPassword, String forNameData) {
		this.url = url;
		this.userName = userName;
		this.userPassword = userPassword;
		this.forNameData = forNameData;
	}
	
}
