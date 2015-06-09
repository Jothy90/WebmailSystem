package com.kash.mail.servlet;

import com.kash.mail.repository.model.LoginUser;
import com.kash.mail.repository.model.UserProfile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Register extends HttpServlet {
    public void init(ServletConfig config)
            throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserProfile userProfile=new UserProfile();
        LoginUser loginUser=new LoginUser();
        userProfile.setFirstName(request.getParameter("firstName"));
        userProfile.setLastName(request.getParameter("lastName"));
        userProfile.setAddress(request.getParameter("address"));
        userProfile.setMobileNo(request.getParameter("mobile"));

        loginUser.setUserName(request.getParameter("userName"));
        loginUser.setPassword(request.getParameter("password"));
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);

        session.setAttribute("userName", loginUser.getUserName());
        session.setAttribute("userId", loginUser.getUserName());
        response.sendRedirect("inbox.jsp");
    }
}
   
