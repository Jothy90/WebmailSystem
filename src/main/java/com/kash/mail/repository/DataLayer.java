package com.kash.mail.repository;


import com.kash.mail.repository.model.LoginUser;
import com.kash.mail.repository.model.UserProfile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
        String query = "select id from login where userName = '" + loginUser.getUserName() +"' and password = '" + loginUser.getPassword()+"'" ;
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                id = rs.getInt("id");

            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return id;
    }

    public boolean isExistingUserName(String userName){
        String query = "select * from login where userName = '" + userName + "'";
        int row = 0;
        try {
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            row = rs.getRow();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (row == 0){
            return false;
        }else{
            return true;
        }
    }

    public boolean insertNewUser(UserProfile userProfile){
        return true;
    }
}
