/*
 *========================================
 * File:      Dvd.java
 * Project:   DVD Rental Store
 *
 * Author:    Dinakaran
 * Revision:  1.0
 *----------------------------------------
 * Copyright 2013 Ideas2it
 *========================================
 */

package com.ideas2it.dvdstore.model;

/**
 * <p>This model class includes dvd variable declarations.
 * </p>
 * 
 * @author Dinakaran
 */


public class Dvd {

	private int id;
	private String title;
	private int cost;
	private String category;
	private String rating;
	public Dvd() {
	}
	public Dvd(int id,String title, int cost, String category, String rating){
		this.id = id;
		this.title = title;
		this.cost = cost;
		this.category = category;
		this.rating = rating;
	}

	public Dvd(int id){
		this.id = id;
	}

	public int getId() {
	        return id;
	}
	public void setId(int id) {
	        this.id = id;
	}

	public String getTitle() {
	        return title;
	}
	public void setTitle(String title) {
	        this.title = title;
	}

	public int getCost() {
	        return cost;
	}
	public void setCost(int cost) {
	        this.cost = cost;
	}
	public String getCategory() {
	        return category;
	}
	public void setCategory(String category) {
	        this.category = category;
	}
	public String getRating() {
	        return rating;
	}
	public void setRating(String rating) {
	        this.rating = rating;
	}








}


