package com.votingsystem.ui;

import com.votingsystem.util.DBConnection;
import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("Connection Successful: " + (con != null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
