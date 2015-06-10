package com.kash.mail.servlet;

import com.kash.mail.repository.DataLayer;
import com.kash.mail.repository.model.Email;
import com.kash.mail.repository.model.LoginUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class Login extends HttpServlet {
    public void init(ServletConfig config)
            throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LoginUser user=new LoginUser();
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        HttpSession session = request.getSession(true);


        int userId=DataLayer.getUserId(user);
        //int userId=1;

        if (userId>0) {
            user.setId(userId);
            List<Email> inboxMails= DataLayer.loadInboxMails(userId);
            List<Email> sendEmails= DataLayer.loadSendEmails(userId);

            session.setAttribute("user", user);
            session.setAttribute("inboxMails",inboxMails);
            session.setAttribute("sendEmails",sendEmails);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/pages/inbox.jsp");
            dispatcher.forward(request, response);
            //response.setContentType("text/html");
            //response.sendRedirect("inbox.jsp");
        } else {
            request.setAttribute("Response", "Invalid User name and password");
            getServletContext().getNamedDispatcher("member").forward(request, response);
        }

    }
}
   
