package com.turkcell.atm.sql.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.turkcell.atm.sql.DatabaseConnection;

public interface IDaoConnection<T> {
	
	// CRUD
	public void create(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public ArrayList<T> list();
	
	// Govdeli metot Interface
	default Connection getInterfaceConnection() {
		return DatabaseConnection.getInstance().getConnection();
	}
	
}
