package com.cognizant.truyum.model;

import java.util.*;
import java.util.ArrayList;
public class Cart {
	
	private double total;
	private ArrayList<MenuItem> menuItemList;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ArrayList<MenuItem> getMenuItemList() { 
		return menuItemList;
	}
	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public Cart(double total, ArrayList<MenuItem> menuItemList) 
	{
		this.total = total;
		this.menuItemList = menuItemList;
	}
	public Cart() {
		// TODO Auto-generated constructor stub
	}

}
