package com.cognizant.truyum.dao;
import java.util.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	public static void testGetMenuItemListAdmin()
	{
		MenuItemDao menuItemDao;
		try
		{
			menuItemDao = new MenuItemDaoCollectionImpl();
			ArrayList<MenuItem> menuItems = new ArrayList <MenuItem>();
			menuItems = menuItemDao.getMenuItemListAdmin();
            System.out.println("Menu item list for admin"); 
            System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));   
			for (MenuItem items : menuItems) {

				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",items.getName(),items.getPrice(),items.isActive(),items.getDateOfLaunch(),items.getCategory(),items.isFreeDelivery()));

			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void testGetMenuItemListCustomer()
	{
		
		MenuItemDao menuItemDao;

		try {

			menuItemDao = new MenuItemDaoCollectionImpl();

			ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

			menuItems = menuItemDao.getMenuItemListCustomer();

			System.out.println("Menu item list for customer"); 

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));

			for (MenuItem items : menuItems) {

				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",items.getName(),items.getPrice(),items.isActive(),items.getDateOfLaunch(),items.getCategory(),items.isFreeDelivery()));


			}

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}
	public static void testmodifyMenuItem()
	{
		try {

			MenuItem menuItem = new MenuItem((long) 05,"Chocolate Brownie", "Dessert",(float)150.0, true,true, DateUtil.convertToDate("02/11/2022"));

			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

			if(menuItemDao.getMenuItem(menuItem.getId()) == menuItem);

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery")); 

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",menuItem.getName(),menuItem.getPrice(),menuItem.isActive(),menuItem.getDateOfLaunch(),menuItem.getCategory(),menuItem.isFreeDelivery()));


			System.out.println("Modification Done");

		} catch (Exception e) {

			// TODO Auto-generated catch block

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
