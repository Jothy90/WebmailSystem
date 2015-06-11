package com.kash.mail.servlet;

import com.kash.mail.repository.DataLayer;
import com.kash.mail.repository.model.Email;
import com.kash.mail.repository.model.LoginUser;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class Outbox extends HttpServlet {
    public void init(ServletConfig config)
            throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        if(session.getAttribute("user")!=null){
            List<Email> sendEmails= DataLayer.loadSendEmails(((LoginUser) session.getAttribute("user")).getId());
            session.setAttribute("sendEmails",sendEmails);
            response.sendRedirect("inbox");
        }else{
            session.setAttribute("error", "Session Expired");
            response.sendRedirect("login.jsp");
        }
    }
}
   
