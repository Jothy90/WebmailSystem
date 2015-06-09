package com.kash.mail.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Login extends HttpServlet {
    public void init(ServletConfig config)
            throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);


        if (userName.equals("john") && password.equals("1234")) {




            session.setAttribute("userName", userName);
            session.setAttribute("userId", userName);
            response.sendRedirect("inbox.jsp");
        } else {
            request.setAttribute("Response", "Invalid User name and password");
            getServletContext().getNamedDispatcher("member").forward(request, response);
        }

    }
}
   
