package dao;

import java.io.IOException;
import java.util.Properties;

public class UserDaoFactory {
    private static UserDaoFactory userDaoFactory;
    
    private UserDaoFactory() {}

    public static UserDaoFactory getInstance() {
        if (userDaoFactory == null) {
            return new UserDaoFactory();
        }
        return userDaoFactory;
    }

    public UserDao getUserDaoFactory() {
        Properties config = new Properties();
        try {
            config.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        switch (config.getProperty("DBConnection")) {
            case ("JDBC"):
                return new UserJdbcDao();
            case ("Hibernate"):
                return new UserHibernateDao();
        }
        return null;
    }
}















