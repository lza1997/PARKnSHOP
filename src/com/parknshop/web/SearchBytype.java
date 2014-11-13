package com.parknshop.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parknshop.dao.CommodityDao;
import com.parknshop.model.Commodity;

/**
 * Servlet implementation class SearchBytype
 */
@WebServlet("/SearchBytype")
public class SearchBytype extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBytype() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=(Connection)getServletContext().getAttribute("datesource");
		CommodityDao cd=new CommodityDao(con);
		String type=request.getParameter("type");
		System.out.println(type);
		List<Commodity> clist=cd.searchBytype(type);
		request.setAttribute("clist", clist);
		RequestDispatcher view = request.getRequestDispatcher("/public/search.jsp");
		view.forward(request,response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
