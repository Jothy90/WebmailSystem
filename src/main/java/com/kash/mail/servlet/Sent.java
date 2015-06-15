package com.kash.mail.servlet;

import com.kash.mail.Client;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Sent extends HttpServlet {
    public void init(ServletConfig config)
            throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        if(session.getAttribute("user")!=null){
            Email email=new Email();
            email.setSendTo(request.getParameter("to"));
            email.setSubject(request.getParameter("subject") + "\n Quote for Mail: " + Client.getQuote());
            email.setMessage(request.getParameter("body"));
            email.setSendFrom(((LoginUser)session.getAttribute("user")).getUserName());

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            email.setDate(dateFormat.format(date)); //2014/08/06 15:59:48
            DataLayer.insertMail(email);

            List<Email> sendEmails= DataLayer.loadSendEmails(((LoginUser)session.getAttribute("user")).getId());
            session.setAttribute("sendEmails",sendEmails);
            session.setAttribute("outboxCount",sendEmails.size());
            response.sendRedirect("inbox");
        }else{
            session.setAttribute("error", "Session Expired");
            response.sendRedirect("login.jsp");
        }
    }
}
   
