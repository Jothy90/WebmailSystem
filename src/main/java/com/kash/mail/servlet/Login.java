package com.kash.mail.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends HttpServlet {
    public void init(ServletConfig config)
    	throws ServletException {
    		super.init(config);
    	}
	 public String getContext(String param) {
		ServletContext sc=getServletContext();
		String prop=sc.getInitParameter(param);
		prop=prop!=null&&prop.length()>0?""+prop:"";
		System.out.println("Contex param:"+prop);
		return prop;
	}
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.sendRedirect("home.htm");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection c=null;
        String loginid=request.getParameter("loginid");
        String pswd=request.getParameter("pswd");
  		response.setContentType("text/html");
		HttpSession session=request.getSession(true);
        PrintWriter out = response.getWriter();
  		try{
 	   	  	Class.forName(getContext("Driver"));
            c= DriverManager.getConnection(getContext("Url"),getContext("User"),getContext("Password"));
   	        Statement st =c.createStatement();
            String query = new String("select * from Customer where loginid='" +loginid+ "' and pswd='"+pswd+"'"); 
			System.out.println("Query :"+query);
            ResultSet rs= st.executeQuery(query);
            if(rs.next())  {
					session.setAttribute("Member",loginid);
					response.sendRedirect("webindex.jsp");
            } else { 
					request.setAttribute("Response","Invalid User name and password");
					getServletContext().getNamedDispatcher("member").forward(request,response);

			}
            }catch(Exception e){
            	out.println("Exception"+e.getMessage()+e.toString());
            }
            finally{
            	try{
            		if(c!=null)
            			c.close();
            	}catch(Exception e){
            		out.println("Exception closing the connection"+e.getMessage());
            	}
            }
   		}
   }
   
