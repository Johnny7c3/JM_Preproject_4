package service;

import model.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    List<User> getAllUser();
    User getUserById(Long id);
    boolean userExist(User user);
    void updateUser(User user);
    void deletUser(Long id);
}
