package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUser();
    public void saveUsers(User user);
    public void deleteUsers(int id);
    public User getUsers(int id);
    public void updateUsers(User updateUsers);

}
