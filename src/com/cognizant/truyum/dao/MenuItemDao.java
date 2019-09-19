package com.cognizant.truyum.dao;

import java.util.*;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	
 public ArrayList<MenuItem> getMenuItemListAdmin();
 public ArrayList<MenuItem> getMenuItemListCustomer();
 public void modifyMenuItem(MenuItem menuItem);
 public MenuItem getMenuItem(long menuItemId);
 
}
