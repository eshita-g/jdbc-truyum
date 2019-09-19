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


@WebServlet("/ShowCart")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDaoSqlImpl cartdao = new CartDaoSqlImpl();
		long userId = 1;
		ArrayList<MenuItem> cartList = null;
		try 
		{
			cartList = cartdao.getAllCartItems(userId);
			double totalValue = cartdao.getTotal();
			request.setAttribute("total",totalValue);
			request.setAttribute("x",cartList);
			RequestDispatcher rd=request.getRequestDispatcher("/cart.jsp");
			rd.forward(request, response);
		} catch (CartEmptyException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("/cart-empty.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		
	}

}
