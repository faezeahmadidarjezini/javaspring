package com.example.demo.service;import com.example.demo.dao.UserDA;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;import java.util.List;@Service
public class UserServiceImpl implements UserService {@Autowired
    UserDA userDA;private UserServiceImpl() {
    }public void save(User user) throws Exception {
        userDA.insert(user);
    }public void update(User user) throws Exception {
        userDA.update(user);
    }public void delete(String username) throws Exception {
        userDA.delete(username);
    }public List<User> get() throws Exception {
        List<User> userList = userDA.select();
        return userList;
    }
    public User check(User user) throws Exception {
        List<User> userList = userDA.select();
        for (User user1 : userList) {
            if (user1.equals(user)) {
                return user1;
            }
        }
        return null;
    }
    public String selectByUser(String username) throws Exception{
      User user = userDA.selectByUser(username);
      String s1= user.getFirstname()+ user.getLastname();
      return s1;}
}
