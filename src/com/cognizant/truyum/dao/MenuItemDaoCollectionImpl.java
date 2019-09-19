package com.cognizant.truyum.dao;
import java.util.*;
import java.text.ParseException; 
import java.text.SimpleDateFormat; 

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;
public class MenuItemDaoCollectionImpl implements MenuItemDao 
{
   private static ArrayList<MenuItem> menuItemList;
   MenuItemDaoCollectionImpl() throws Exception
   {
	   
	   super();
	   if(menuItemList == null || menuItemList.isEmpty())
	   {
		   menuItemList = new ArrayList<MenuItem>();
		   menuItemList.add(new MenuItem((long) 01, "Sandwich", "Main Course",(float) 99.0, true,true,DateUtil.convertToDate("15/03/2017")));

			menuItemList.add(new MenuItem((long) 02, "Burger", "Main Course",(float) 129.0, true,false,DateUtil.convertToDate("23/12/2017")));

			menuItemList.add(new MenuItem((long) 03, "Pizza","Main Course", (float) 149.0, true,false ,DateUtil.convertToDate("21/08/2018")));

			menuItemList.add(new MenuItem((long) 04, "French Fries","Starters", (float) 57.0, false,true,DateUtil.convertToDate("02/07/2017")));

			menuItemList.add(new MenuItem((long) 05, "Chocolate Brownie", "Dessert",(float) 32.0, true,true,DateUtil.convertToDate("02/11/2022")));
		   
	   }
   }

public ArrayList<MenuItem> getMenuItemListAdmin() {
	
	// TODO Auto-generated method stub
	return menuItemList;
}

public ArrayList<MenuItem> getMenuItemListCustomer(){
	
	ArrayList<MenuItem> fil = new ArrayList<MenuItem>();
	for(MenuItem x:menuItemList)
	{
		Date d = x.getDateOfLaunch();
		String today = "19/08/2019";
		Date tdate = DateUtil.convertToDate(today);
		if(d.before(tdate) || d.equals(tdate))
		{
			if(x.isActive())
			{
				fil.add(x);
			}
		}
	}
	return fil;
	
}


public void modifyMenuItem(MenuItem menuItem) {
	// TODO Auto-generated method stub
	for(MenuItem x:menuItemList)
	{
		if(x.equals(menuItem))
		{
			x.setName(menuItem.getName());
			x.setActive(menuItem.isActive());
			x.setCategory(menuItem.getCategory());
			x.setDateOfLaunch(menuItem.getDateOfLaunch());
			x.setCategory(menuItem.getCategory());
			x.setFreeDelivery(menuItem.isFreeDelivery());
			
		}
	}
	
}

public MenuItem getMenuItem(long menuItemId) {
	// TODO Auto-generated method stub
	for(MenuItem x: menuItemList)
	{
		if(x.getId()== menuItemId)
		{
			return x;
		}
	}
	return null;
}


}
