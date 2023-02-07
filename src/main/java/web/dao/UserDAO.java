package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getListUser();
    User getUserById(int id);
    void addUser(User user);
    void update(int id, User user);
    void delete(int id);
}
