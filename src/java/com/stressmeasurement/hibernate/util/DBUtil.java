/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stressmeasurement.hibernate.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LQwabe
 */
public class DBUtil {

    public static Connection getConnection() {
        Connection connection = null;
        if (connection != null) {
            return connection;
        }
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/central_stress_measurements",
                    "root", "13579");
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
