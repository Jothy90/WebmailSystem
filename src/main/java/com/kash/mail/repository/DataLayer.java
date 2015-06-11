package com.kash.mail.repository;


import com.kash.mail.repository.model.Email;
import com.kash.mail.repository.model.LoginUser;
import com.kash.mail.repository.model.UserProfile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 123
 * Date: 6/7/15
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataLayer {

    // when the user login; if it is valid user then return userId else return 0
    public static int getUserId(LoginUser loginUser){
        int id = 0;
        String query = "select user_id from login where user_name = '" + loginUser.getUserName() +"' and password = '" + loginUser.getPassword()+"'" ;
        System.out.println(query);
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                id = rs.getInt("user_id");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return id;
    }

    public static boolean isExistingUserName(String userName){
        String query = "select * from login where user_name = '" + userName + "'";
        int id = 0;
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                id = rs.getInt("user_id");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (id > 0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean insertNewUser(UserProfile userProfile,LoginUser loginUser){
        String insertLoginQuery = "insert into login ([user_name], [password]) values (" + "'" +loginUser.getUserName() +"' , '" +loginUser.getPassword()+"' )";
        String insertUserProfileQuery = "insert into user_profile ([first_name],[last_name], [address], [mobile]) values ( " + "'" + userProfile.getFirstName() + "' , '" + userProfile.getLastName()+ "' , '" + userProfile.getAddress()+ "', '" + userProfile.getMobileNo()+"' )" ;
        System.out.println(insertLoginQuery);
        System.out.println(insertUserProfileQuery);
        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insertLoginQuery);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insertUserProfileQuery);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return true;
    }

    public static List<Email> loadSendEmails(int userId){
        String getUserNameQuery = "select user_name from login where user_id = " + userId;
        ResultSet rs = null;
        String userName = null;
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(getUserNameQuery);
            while (rs.next()){
                userName = rs.getString("user_name");
            }
            rs = null;
            con.close();

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        String getSendEmailQuery = "select * from email_message,email_receiver where sender = '" + userName + "' and email_message.is_active = " + 1 + " and email_message.id = email_receiver.email_id" ;
        List<Email> list=new ArrayList<Email>();
        Email email;
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(getSendEmailQuery);
            while (rs.next()) {
                email=new Email();
                email.setId(rs.getInt("id"));
//                email.setCc(rs.getString("cc"));
                email.setDate(rs.getString("date"));
                email.setMessage(rs.getString("message"));
                email.setSendFrom(rs.getString("sender"));
                email.setSendTo(rs.getString("receiver"));
                email.setSubject(rs.getString("subject"));
                list.add(email);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return list;
    }

    public static List<Email> loadInboxMails(int userId){

        String getUserNameQuery = "select user_name from login where user_id = " + userId ;
        ResultSet rs = null;
        String userName = null;
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(getUserNameQuery);
            while (rs.next()){
                userName = rs.getString("user_name");
            }
            rs = null;
            con.close();

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

//        String getSendEmailQuery = "select * from email_message where send_to = '" + userName + "'";
        String getSendEmailQuery = "select * from email_message,email_receiver where receiver = '" + userName + "' and email_receiver.is_active = " + 1 + " and email_message.id = email_receiver.email_id" ;
        System.out.println(getSendEmailQuery);
        List<Email> list=new ArrayList<Email>();
        Email email;

        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(getSendEmailQuery);
            while (rs.next()) {
                email=new Email();
                email.setId(rs.getInt("id"));
//                email.setCc(rs.getString("cc"));
                email.setDate(rs.getString("date"));
                email.setMessage(rs.getString("message"));
                email.setSendFrom(rs.getString("sender"));
                email.setSendTo(rs.getString("receiver"));
                email.setSubject(rs.getString("subject"));
                list.add(email);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return list;

    }

    public static boolean insertMail(Email email){
//        String query = "insert into email_message ([send_from], [send_to], [date], [cc], [subject], [message]) values ( " + "'" + email.getSendFrom() + "' , '" + email.getSendTo() + "' , ' " + email.getDate() + "' , '" + email.getCc() + "' , '" + email.getSubject()+ "' , '" + email.getMessage()+ "' )" ;
//        String query1 = "insert into email_message([sender], [date], [message], [subject], [is_active]), email_receiver([receiver], [is_active], [email_id]) values ("
        //String query ="insert into email_message([sender], [date], [message], [subject], [is_active])values ('abs', '27/04/2012', 'hi', 'panni subject',1)";
        ResultSet rs;
        int id2 = 0;
        String query = "insert into email_message([sender], [date], [message], [subject], [is_active]) values(  " + "'" + email.getSendFrom() + "' , ' " + email.getDate() + "' , '" + email.getMessage() + "' , '" + email.getSubject()+ "' ," + 1 + ")" ;
        System.out.println(query);
        String getEmailIdquery = "select max(id) as max_id from email_message where sender = '" + email.getSendFrom() + "'";
        System.out.println(getEmailIdquery);
        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            rs =stmt.executeQuery(getEmailIdquery);

            while (rs.next()){
               id2 = rs.getInt("max_id");

            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        String query1 = "insert into email_receiver ([receiver],[is_active], [email_id]) values ( " + "'" + email.getSendTo() + "' ,  " + 1 + " , " + id2 + ")";
        System.out.println(query1);

        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query1);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return true;
    }

    public static List<String> loadEmailUsers(){
        String query = "select user_name from login";
        ArrayList<String> users = new ArrayList<String>();
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
              users.add(rs.getString("user_name"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return users;
    }

    public static Email getEmailById(int id) {

        String getSendEmailQuery = "select * from email_message,email_receiver where email_message.id = " + id + " and  email_receiver.email_id = " + id;
        System.out.println(getSendEmailQuery);
        Email email=null;
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs  = stmt.executeQuery(getSendEmailQuery);
            if (rs.next()) {
                email=new Email();
                email.setId(rs.getInt("id"));
//                email.setCc(rs.getString("cc"));
                email.setDate(rs.getString("date"));
                email.setMessage(rs.getString("message"));
                email.setSendFrom(rs.getString("sender"));
                email.setSendTo(rs.getString("receiver"));
                email.setSubject(rs.getString("subject"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return email;
    }

    public static boolean deleteEmail(int emailId, String userName){
        ResultSet rs;
        String senderName = null;
        String query = "select sender from email_message where id = " + emailId ;
        String updatedSenderQuery = "update email_message set is_active = " + 0 + " where id = " + emailId ;
        String updatedReceiverQuery = "update email_receiver set is_active = " + 0 + " where email_id = " + emailId ;

        try {
            Connection conn = DbConnection.getConnection();
            Statement stmt = conn.createStatement();
            rs =stmt.executeQuery(query);

            while (rs.next()){
                senderName = rs.getString("sender");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        if (userName.equals(senderName)){
            System.out.println(updatedSenderQuery);
            try {
                Connection conn = DbConnection.getConnection();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(updatedSenderQuery);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }else{
            try {
                System.out.println(updatedReceiverQuery);
                Connection conn = DbConnection.getConnection();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(updatedReceiverQuery);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        return true;

    }
}
