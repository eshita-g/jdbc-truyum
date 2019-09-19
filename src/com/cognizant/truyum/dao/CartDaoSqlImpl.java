package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;



public class CartDaoSqlImpl  implements CartDao{
	
	//public float total = 0.00f;

	
	public void addCartItem(long userId, Long menuItemId) 
	{
		Connection con = ConnectionHandler.getConnection();
		String Query = "insert into cart(ct_us_id,ct_me_id)"+"values (?,?) ";
		//String query1 = "insert into user(us_id)"+"values(?)";
		long cartid = 1;
		try 
		{
			//PreparedStatement stmt1 = con.prepareStatement(query1);
			//stmt1.setLong(1,userId);
			//stmt1.execute();
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			stmt.execute();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}

	
	public ArrayList getAllCartItems(long userId) throws CartEmptyException {
		
		Connection con = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		
		Cart cart = new Cart(0,menuItemList);
		String query = "select * from menu_item JOIN cart ON menu_item.me_id = cart.ct_me_id where cart.ct_us_id = ?";
		try
		{
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();
			float value  = 0.00f;
			while(rs.next())
			{
				long id = rs.getLong("me_id");
				String name  = rs.getString("me_name");
				float price = rs.getFloat("me_price");
				value = value + price;
				String active = rs.getString("me_active");
				Date date1 = rs.getDate("me_date_of_launch");
				String category = rs.getString("me_category");
				String free_delivery = rs.getString("me_free_delivery");
				boolean act = false;
				if(active.equalsIgnoreCase("yes"))
				{
					act = true;
				}
				boolean free=false;
				if(free_delivery.equalsIgnoreCase("yes"))
				{
					free = true;
				}
				MenuItem m1  = new MenuItem(id,name,category,price,act,free,date1);
				menuItemList.add(m1);
				
			}
			//total =  value;
			cart.setTotal(value);
			cart.setMenuItemList(menuItemList);
			
			
			
			
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		
	
		return menuItemList;
	}
	public double getTotal() {
		
	  Cart c = new Cart();
	  return c.getTotal();
	  
		
	}
	
	
	
	public void removeCartItem(long userId, long menuItemId)
	{
		Connection con = ConnectionHandler.getConnection();
		String query = "delete from  cart where ct_us_id = ? AND ct_me_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1,userId);
			stmt.setLong(2, menuItemId);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
