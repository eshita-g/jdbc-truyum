package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.*;


@WebServlet("/EditMenuItem")
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditMenuItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Date date=null;
		MenuItemDao menuItemDao=new MenuItemDaoSqlImpl();
		long id =Long.parseLong(request.getParameter("id"));
		String title=request.getParameter("title");
	
		try {
			date = DateUtil.convertToDate(request.getParameter("dateOfLaunch"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float price=Float.parseFloat(request.getParameter("price"));
		String cat=request.getParameter("category");
		String act = request.getParameter("act");
		boolean active;
		if(act.equalsIgnoreCase("Yes"))
		{
			active = true;
		}
		else
		{	
			active = false;
		}
		String free = request.getParameter("fd");
		boolean fd;
		if(free.equalsIgnoreCase("Yes"))
			fd = true;
		else
			fd = false;
		doGet(request, response);
		MenuItem menuitem = new MenuItem(id,title,cat,price,active,fd,date);
		menuItemDao.modifyMenuItem(menuitem);
		RequestDispatcher rd=request.getRequestDispatcher("/edit-menu-item-status.jsp");
		rd.forward(request, response);
	}

}
