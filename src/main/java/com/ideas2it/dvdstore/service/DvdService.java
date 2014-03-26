/*
 *========================================
 * File:      DvdService.java
 * Project:   DVD Rental Store
 *
 * Author:    Dinakaran
 * Revision:  1.0
 *----------------------------------------
 * Copyright 2013 Ideas2it
 *========================================
 */

package com.ideas2it.dvdstore.service;

import com.ideas2it.dvdstore.model.Dvd;
import com.ideas2it.dvdstore.dao.DvdDao;

import java.util.List;

/** 
 * <p>This is a service class which makes connection to the main class and dao class.
 * Receives input from main and sends it to dao.
 * Receives output from dao and sends it to main.</p>
 */
public class DvdService {
	
	/** 
	* calls the dao method forinserting the Dvd details 
	* @param Dvd class's Object
	* @returns Dvd class's object 
	* @throws Exception
	*/
	
	public Dvd create(Dvd dvd) throws Exception {
		Dvd returnDvd = null;
		try {
			DvdDao dvdDao = new DvdDao();
			returnDvd =  dvdDao.create(dvd);
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		return returnDvd;
	}

	/**
	* calls the dao method for particular Dvd details 
	* @parameter id that should be searched
	* @returns Dvd class's object 
	* @throws Exception
	*/	
	 
	public Dvd search(Dvd searchDvd) throws Exception {
		Dvd dvd=null;
		try {
			DvdDao dvdDao = new DvdDao();
			dvd = dvdDao.search(searchDvd);
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		return dvd;
	}

	/**
	* calls the dao method to update Dvd details 
	* @parameter values to be updated 
	* @returns Dvd class's object 
	* @throws Exception
	*/	
	 
	public Dvd update(Dvd dvd) throws Exception {
		Dvd returnDvd=null;		
		try {
			DvdDao dvdDao = new DvdDao();
			returnDvd = dvdDao.update(dvd);
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		return returnDvd;
	}

	/**
	* calls the dao method to delete Dvd details 
	* @parameter values to be Deleted 
	* @returns Dvd class's object 
	* @throws Exception
	*/
	
	public boolean delete(int id) throws Exception {
		Dvd dvd=null;		
		boolean isdelete = false;		
		try {
			DvdDao dvdDao = new DvdDao();
			isdelete = dvdDao.delete(id);
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		return isdelete;
	}
	
	/**
	* calls the dao method for all the Dvd details 
	* @parameter no parameters 
	* @returns list of Dvd class's object 
	* @throws Exception
	*/
	
	public List<Dvd> getAll() throws Exception {
		List<Dvd> dvdList = null;
		try {
			DvdDao dvdDao = new DvdDao();
			dvdList = dvdDao.getAll();
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		return dvdList;
	}
}
