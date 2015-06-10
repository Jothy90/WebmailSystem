package com.kash.mail.repository;


import com.kash.mail.repository.model.Email;
import com.kash.mail.repository.model.LoginUser;
import com.kash.mail.repository.model.UserProfile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public static ResultSet loadSendEmails(int userId){
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

        String getSendEmailQuery = "select * from email_message where send_from = '" + userName + "'";

        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(getSendEmailQuery);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
       return rs;
    }

    public static ResultSet loadInboxMail(int userId){

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

        String getSendEmailQuery = "select * from email_message where send_to = '" + userName + "'";

        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(getSendEmailQuery);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return rs;

    }

    public static boolean insertMail(Email email){
        String query = "insert into email_message ([send_from], [send_to], [date], [cc], [subject], [message]) values ( " + "'" + email.getSendFrom() + "' , '" + email.getSendTo() + "' , ' " + email.getDate() + "' , '" + email.getCc() + "' , '" + email.getSubject()+ "' , '" + email.getMessage()+ "' )" ;

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

        return true;
    }

    public static ArrayList<String> loadEmailUsers(){
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
}
