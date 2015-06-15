package com.kash.mail.repository;

import com.kash.mail.rmi.Client;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: 123
 * Date: 6/7/15
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class DbConnection {
    public static Connection getConnection() throws Exception {
        String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String url = "jdbc:odbc:EmailApp";
        String username = "";
        String password = "";
        Class.forName(driver); // load JDBC-ODBC driver
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String args[]){
        System.out.println(Client.getQuote());
        /*System.out.println(DataLayer.isExistingUserName("kamalan"));

        LoginUser l1 = new LoginUser();
        l1.setUserName("kamalan");
        l1.setPassword("kamalan");
        System.out.println(DataLayer.getUserId(l1));

        UserProfile u1 = new UserProfile();
        u1.setFirstName("kashink");
        u1.setLastName("kashink");
        u1.setAddress("malesiya");
        u1.setMobileNo("0941234567");


       //System.out.println(DataLayer.insertNewUser(u1,l1));

        System.out.println(DataLayer.loadEmailUsers());

        Email e1 = new Email();
        e1.setSendFrom("john");
        e1.setSendTo("kamalan");
        e1.setDate("10-06-2105");
        e1.setMessage("hi; how are you?");
        e1.setSubject("introduction");*/

//        System.out.println(DataLayer.insertMail(e1));


    }
}
