package com.cognizant.truyum.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	
	public static void testGetMenuItemListAdmin()
	{
		
		MenuItemDaoSqlImpl menuItemDao = null;
		try {
			menuItemDao = new MenuItemDaoSqlImpl();
			ArrayList<MenuItem> menuItems = new ArrayList <MenuItem>();
			menuItems = menuItemDao.getMenuItemListAdmin();
	        System.out.println("Menu item list for admin"); 
	        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");
	        System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));   
			for (MenuItem items : menuItems) {

				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",items.getName(),items.getPrice(),items.isActive(),simple.format(items.getDateOfLaunch()),items.getCategory(),items.isFreeDelivery()));

			}	
		} 
		catch (Exception e) 
		{
		
			e.printStackTrace();
		}
		
	}
	public static void testGetMenuItemListCustomer()
	{
		
		MenuItemDaoSqlImpl menuItemDao = null;

		try {

			menuItemDao = new MenuItemDaoSqlImpl();

			ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

			menuItems = menuItemDao.getMenuItemListCustomer();

			System.out.println("Menu item list for customer"); 
			SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));

			for (MenuItem items : menuItems) {

				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",items.getName(),items.getPrice(),items.isActive(),simple.format(items.getDateOfLaunch()),items.getCategory(),items.isFreeDelivery()));


			}

		} 
		catch (Exception e) 
		{

		  e.printStackTrace();

		}
	}
	public static void testmodifyMenuItem()
	{
		try {

			MenuItem menuItem = new MenuItem((long) 05,"Chocolate Brownie", "Dessert",(float)150.0, true,true, DateUtil.convertToDate("02/11/2022"));

			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
			SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");

			if(menuItemDao.getMenuItem(menuItem.getId()) == menuItem);

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery")); 

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",menuItem.getName(),menuItem.getPrice(),menuItem.isActive(),simple.format(menuItem.getDateOfLaunch()),menuItem.getCategory(),menuItem.isFreeDelivery()));


			System.out.println("Modification Done");

		} 
		catch (Exception e)
		{

         e.printStackTrace();

		}
	}
	public static void main(String[] args) throws CartEmptyException
	{
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
        testmodifyMenuItem();
		
		
	}
	

}
