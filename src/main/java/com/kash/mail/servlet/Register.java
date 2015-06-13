package com.kash.mail.servlet;

import com.kash.mail.repository.DataLayer;
import com.kash.mail.repository.model.Email;
import com.kash.mail.repository.model.LoginUser;
import com.kash.mail.repository.model.UserProfile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


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
        DataLayer.insertNewUser(userProfile,loginUser);


        int userId=DataLayer.getUserId(loginUser);
        loginUser.setId(userId);

        List<Email> inboxMails= DataLayer.loadInboxMails(userId);
        List<Email> sendEmails= DataLayer.loadSendEmails(userId);
        HttpSession session = request.getSession(true);
        session.setAttribute("inboxMails",inboxMails);
        session.setAttribute("sendEmails",sendEmails);
        session.setAttribute("outboxCount",sendEmails.size());
        session.setAttribute("inboxCount",inboxMails.size());
        session.setAttribute("user", loginUser);
        response.sendRedirect("inbox");
    }
}
   
