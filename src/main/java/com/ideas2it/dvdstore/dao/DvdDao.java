/*
 *========================================
 * File:      DvdDao.java
 * Project:   DVD Rental Store
 *
 * Author:    Dinakaran
 * Revision:  1.0
 *----------------------------------------
 * Copyright 2013 Ideas2it
 *========================================
 */

package com.ideas2it.dvdstore.dao;

import com.ideas2it.dvdstore.model.Dvd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>This class includes Dvd operations such as create, search, update and delete dvd's.
 * It performs all the above operations in database Dvd.
 * Gets input from service class and performs operations.
 * Returs the output to service class.
 * </p>
 * 
 * @author Dinakaran
 */

public class DvdDao  {
	
	/** 
	* Establishes database connection
	* @param no arguments
	* @returns Connection class object 
	* @throws ClassNotFoundException
	*/

	public Connection databaseCreateConnection() throws Exception {
		Connection databaseConnection = null;
		String url = "jdbc:mysql://localhost:3306";
		String dataBaseName = "DvdStore";	
		String driverName = "com.mysql.jdbc.Driver";
		
		//Database login details
		String mysqlUserName = "root";
		String mysqlPassword = "root";	
		ResultSet resultSet = null;
		try {
			//Register JDBC driver
			Class.forName(driverName);
			//open connection			
			databaseConnection = DriverManager.getConnection(url+"/"+dataBaseName, mysqlUserName, mysqlPassword);

		}
		catch(Exception e){
			throw new Exception(e);
		}
		return databaseConnection;	
	}
		
	/** 
	* Gets dvd details and store it in database.
	* @param Dvd's class object
	* @returns Dvd's class object
	* @throws ClassNotFoundException
	*/
	public Dvd create(Dvd dvd) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			//Query to insert Dvd details
			String query="insert into Dvd(id,title,cost,category,rating) values (?,?,?,?,?)";
			connection = databaseCreateConnection();
			statement=connection.prepareStatement(query);
			statement.setInt(1,dvd.getId());
			statement.setString(2,dvd.getTitle());
			statement.setInt(3,dvd.getCost());
			statement.setString(4,dvd.getCategory());
			statement.setString(5,dvd.getRating());
			statement.executeUpdate();
			
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			try
			{
				if(statement!=null){try{statement.close();}catch(Exception e){}}
				if(connection!=null){try{connection.close();}catch(Exception e){}}
			}
			catch(Exception e) {
				throw new Exception(e);
			}		
		}
	return dvd;
	}

	/** 
	* Gets dvd id and search for it in database.
	* @param Dvd's class object
	* @return Dvd's class object
	* @throws SQLException,ClassNotFoundException
	*/

	public Dvd search(Dvd dvd) throws Exception {
		Connection connection = null;
		Statement statement = null;
		Dvd searchedDvd = new Dvd();
		try {
			connection = databaseCreateConnection();
			statement = connection.createStatement();
			// Query to retrieve 
			String query="Select *from Dvd where id ='"+dvd.getId()+"'";
			ResultSet resultSet = statement.executeQuery(query);

			while(resultSet.next()) {
				searchedDvd.setId(resultSet.getInt("id"));
				searchedDvd.setTitle(resultSet.getString("title"));
				searchedDvd.setCost(resultSet.getInt("cost"));
				searchedDvd.setCategory(resultSet.getString("category"));
				searchedDvd.setRating(resultSet.getString("rating"));									
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			try
			{
				if(statement!=null){try{statement.close();}catch(Exception e){}}
				if(connection!=null){try{connection.close();}catch(Exception e){}}
			}
			catch(Exception e) {
				throw new Exception(e);
			}		
		}
	return searchedDvd;
	}
	
	/** 
	* Updates the dvd details based on dvd id and stores it in database.
	* @param Dvd's class object
	* @returns Dvd's class object
	* @throws ClassNotFoundException
	*/

	public Dvd update(Dvd dvd) throws Exception {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = databaseCreateConnection();
			statement = connection.createStatement();
			//Query to update the user detais
			String query="update Dvd set title ='"+dvd.getTitle()+"',cost ='"+dvd.getCost()+"',category = '"+dvd.getCategory()+"', rating = '"+dvd.getRating()+"'  where id ='"+dvd.getId()+"'";
			statement.executeUpdate(query);
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
				if(statement!=null){try{statement.close();}catch(Exception e){}}
				if(connection!=null){try{connection.close();}catch(Exception e){}}
			}
		return dvd;
	}

	/** 
	* Gets dvd id and deletes it from the database.
	* @param id to be deleted
	* @return boolean value
	* @throws Exception
	*/

	public  boolean delete(int id) throws Exception {
		Connection connection = databaseCreateConnection();
		Statement statement = null;
		boolean isDelete=false;
		try {
			statement = connection.createStatement();
			//Query to delete the user details
			String query="delete from Dvd where id ='"+id+"'";
			statement.executeUpdate(query);
			isDelete=true;
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			if(statement!=null){try{statement.close();}catch(Exception e){}}
			if(connection!=null){try{connection.close();}catch(Exception e){}}
		}
		return isDelete;
	}

	/** 
	* it gets all the Dvd  details from the database
	* @param id to be deleted
	* @return list of Dvd's
	* @throws Exception
	*/
	
	public  List<Dvd> getAll() throws Exception {
		Connection connection = null;
		Statement statement = null;
		List<Dvd> dvdList = new ArrayList<Dvd>();
		try {
			connection = databaseCreateConnection();
			statement = connection.createStatement();
			// Query to retrieve 
			String query="Select *from Dvd";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				Dvd dvd = new Dvd();
				dvd.setId(resultSet.getInt("id"));
				dvd.setTitle(resultSet.getString("title"));
				dvd.setCost(resultSet.getInt("cost"));
				dvd.setCategory(resultSet.getString("category"));
				dvd.setRating(resultSet.getString("rating"));
				dvdList.add(dvd);
			}
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		finally {
			if(statement!=null){try{statement.close();}catch(Exception e){}}
			if(connection!=null){try{connection.close();}catch(Exception e){}}
		}
		return dvdList;
	}
}
