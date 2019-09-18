package com.cognizant.truyum.dao;

import java.util.*;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {

	public void addCartItem(long userId,Long menuItemId);
	public ArrayList getAllCartItems(long userId) throws CartEmptyException;
	public void removeCartItem(long userId,long menuItemId);
}
