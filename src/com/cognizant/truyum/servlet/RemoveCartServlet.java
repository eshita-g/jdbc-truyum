package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;


@WebServlet("/RemoveCart")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RemoveCartServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long Menuid =Long.parseLong( request.getParameter("id"));
		CartDaoSqlImpl cartdao = new CartDaoSqlImpl();
		long userId =1;
		cartdao.removeCartItem(userId, Menuid);
		boolean removeCartItemStatus = true;
		try 
		{
			ArrayList <MenuItem> cartItems = cartdao.getAllCartItems(userId);
			double newTotal = cartdao.getTotal();
			request.setAttribute("total", newTotal);
			request.setAttribute("removeCart", removeCartItemStatus);
			request.setAttribute("x", cartItems);
			RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
			rd.forward(request,response);
		} 
		catch (CartEmptyException e) 
		{
	
			RequestDispatcher rd=request.getRequestDispatcher("/cart-empty.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
