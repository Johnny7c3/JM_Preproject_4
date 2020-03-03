package util;

import org.hibernate.cfg.Configuration;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
    
    private Connection connection;
    private static DBHelper dbHelper;
    private Properties config;

    private DBHelper() {
        config = new Properties();
        try {
            config.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static DBHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
            return dbHelper;
        }
        return dbHelper;
    }

    public Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", config.getProperty("hibernate.dialect"));
        configuration.setProperty("hibernate.connection.driver_class", config.getProperty("driver.DB"));
        configuration.setProperty("hibernate.connection.url", config.getProperty("url.DB") );
        configuration.setProperty("hibernate.connection.username", config.getProperty("username.DB"));
        configuration.setProperty("hibernate.connection.password", config.getProperty("password.DB"));
        configuration.setProperty("hibernate.show_sql", config.getProperty("hibernate.show_sql"));
        configuration.setProperty("hibernate.hbm2ddl.auto", config.getProperty("hibernate.hbm2ddl.auto"));
        return configuration;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName(config.getProperty("driver.DB")).newInstance();
                connection = DriverManager.getConnection(config.getProperty("url.DB"),
                        config.getProperty("username.DB"),
                        config.getProperty("password.DB"));
                System.out.println("Get connection");
                return connection;
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println("Connection Erorr");
            ex.printStackTrace();
            throw new IllegalStateException();
        }
        return connection;
    }
}















