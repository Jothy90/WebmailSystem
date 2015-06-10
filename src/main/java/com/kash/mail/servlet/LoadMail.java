package com.kash.mail.servlet;

import com.kash.mail.repository.model.Email;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoadMail extends HttpServlet {
    public void init(ServletConfig config)
            throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        //Email email= DataLayer.getEmailById(Integer.parseInt(request.getParameter("id")));
        //TODO:
        Email email=Email.getAMail();
        session.setAttribute("email", email);
        //response.setContentType("text/html");
        //response.sendRedirect("WEB-INF/pages/mail.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/mail.jsp");
        dispatcher.forward(request, response);
    }
}
   
