package vn.iostrar.controllers;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/login","/dang-nhap"})
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3761713622191550502L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/views/index.html");
		rd.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Nhận dữ liệu từ request URL
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean kt=false;
		if (username.equals("chung") && password.equals("123"))	{
			req.setAttribute("uName", username);
			kt=true;
			req.setAttribute("msg", kt);
			
		} else {
			kt=false;
			req.setAttribute("msg", kt);
			
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
		
		rd.forward(req, resp);
		
	}

}
