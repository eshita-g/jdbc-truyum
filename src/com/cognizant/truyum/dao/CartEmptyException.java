package com.cognizant.truyum.dao;

import java.util.*;
@SuppressWarnings("serial")
public class CartEmptyException extends Exception{

	public CartEmptyException()
	{
		super();
		System.out.println("cart is empty");
	}
}
