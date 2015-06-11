package com.kash.mail.servlet;

import com.kash.mail.repository.DataLayer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class Compose extends HttpServlet {
    public void init(ServletConfig config)
            throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("user")!=null){
            List<String> emails=DataLayer.loadEmailUsers();
            session.setAttribute("emails",emails);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/compose.jsp");
            dispatcher.forward(request, response);
        }else{
            session.setAttribute("error", "Session Expired");
            response.sendRedirect("login.jsp");
        }

    }
}
   
