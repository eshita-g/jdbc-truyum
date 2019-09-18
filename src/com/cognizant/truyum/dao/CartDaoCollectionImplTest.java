package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;
import java.util.*;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.util.*;

public class CartDaoCollectionImplTest {
	
	public static void testAddCartItem()
	{
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem((long)1, (long) 2);
		try
		{
			ArrayList<MenuItem> cartList = cartDao.getAllCartItems((long)1);
			System.out.println("items added to cart successfuly");
			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));

			for (MenuItem item : cartList) {

				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));

			}
			
		}
		catch(CartEmptyException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	public static void testGetAllCartItems()
	{
		CartDao cartDao = new CartDaoCollectionImpl();
		try
		{
		 ArrayList<MenuItem> cartItems = cartDao.getAllCartItems((long)1);
		 System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));
		 for(MenuItem item:cartItems)
		 {
			 System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));
		 }
		}
		catch(CartEmptyException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void testRemoveCartItem()
	{
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem((long)1,(long)2);
		try
		{
			ArrayList<MenuItem> cartLefts = cartDao.getAllCartItems((long)1); 
			if(cartLefts.isEmpty())
			{
				throw new CartEmptyException();
			}
			else
			{
				for(MenuItem item:cartLefts)
				{
					System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));
				}
			}
		}
		catch(CartEmptyException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		
	}

	
}
