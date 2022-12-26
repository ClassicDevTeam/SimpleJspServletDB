package com.daniel.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	private static Connection connection = null;
	public static String DRIVER = "com.mysql.jdbc.Driver";
	public static String URL = "jdbc:mysql://localhost:3306/test";
	public static String USER = "root";
	public static String PASSWORD = "";
	
	
    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            	/*
            	Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                */
                String driver = DRIVER;
                String url = URL;
                String user = USER;
                String password = PASSWORD;
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}
