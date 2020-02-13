package com.example.demo.dao;import com.example.demo.model.User;import java.util.List;public interface IUserDA {
    public void insert(User user) throws Exception;
    public List<User> select() throws Exception;
    public void update(User user) throws Exception;
    public void delete(String username) throws Exception;
}
