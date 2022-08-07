package com.turkcell.atm.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection extends DatabaseInformation {
	
	// DB baglantisi icin
	private Connection connection;
	
	// DB bilesenleri
	private String url = this.getUrl();
	private String userName = this.getUserName();
	private String userPassword = this.getUserPassword();
	private String forNameData = this.getForNameData();
	
	// Singleton design pattern db connection
	private static DatabaseConnection instance;
	
	private DatabaseConnection() {
		try {
			Class.forName(forNameData);
			System.out.println("Driver Loading...");
			connection = DriverManager.getConnection(url, userName, userPassword);
			System.out.println("Database Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DatabaseConnection getInstance() {
		try {
			if (instance == null || instance.connection.isClosed())
				instance = new DatabaseConnection();
		} catch (Exception e) {
			System.err.println("instance error");
			e.printStackTrace();
		}
		return instance;
	}
	
	public static void setDatabaseConnection(DatabaseConnection databaseConnection) {
		DatabaseConnection.instance = databaseConnection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public static void main(String[] args) {
		// DatabaseConnection connection = new DatabaseConnection();
	}
	
}
