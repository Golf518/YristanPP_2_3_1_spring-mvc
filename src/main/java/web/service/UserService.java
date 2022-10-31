package web.service;


import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;
@Service
public interface UserService {
    public void updateUsers(User updaeUser);
    public void saveUsers (User user);
    public void deleteUsers (int id);
    public User getUsers(int id);
    public List<User> getAllUser();
}