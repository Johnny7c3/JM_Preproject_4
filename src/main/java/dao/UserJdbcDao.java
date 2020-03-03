package dao;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDao implements UserDao{
    private Connection connection;

    public UserJdbcDao() {
        this.connection = DBHelper.getInstance().getConnection();
    }

    public boolean addUser(User user) {
        if (!userExist(user)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (email, name, surname, password, birthday) VALUES(?, ?, ?, ?, ?)")) {
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getSurname());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getBirthday());
                preparedStatement.execute();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public List<User> getAllUser() {
        List<User> res = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                res.add(new User(resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("password"),
                        resultSet.getString("birthday")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public boolean userExist(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT email FROM users WHERE email = ?")) {
            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("password"),
                        resultSet.getString("birthday"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateUser(User updateUser) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET email = ?, name = ?, surname = ?, password = ?, birthday = ? WHERE id = ?")) {
            preparedStatement.setString(1, updateUser.getEmail());
            preparedStatement.setString(2, updateUser.getName());
            preparedStatement.setString(3, updateUser.getSurname());
            preparedStatement.setString(4, updateUser.getPassword());
            preparedStatement.setString(5, updateUser.getBirthday());
            preparedStatement.setLong(6, updateUser.getId());
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletUser(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletAllUsers() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM users");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


















