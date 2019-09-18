package com.cognizant.truyum.model;

import java.util.*;


public class MenuItem {

	private long id;
	private String name,category;
	private float price;
	private boolean active,freeDelivery;
	private Date dateOfLaunch;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isFreeDelivery() {
		return freeDelivery;
	}
	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
   public MenuItem(long id, String name, String category, float price, boolean active, boolean freeDelivery,Date dateOfLaunch) 
   {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.active = active;
		this.freeDelivery = freeDelivery;
		this.dateOfLaunch = dateOfLaunch;
	}

public boolean equals(MenuItem obj)
	{
		if(obj instanceof MenuItem)
		{		
		  MenuItem p3 = (MenuItem)obj;
		
	      return(this.id==p3.id);
		}
		return false;
	}
  
	
}
