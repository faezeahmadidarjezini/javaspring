package com.example.demo.service;import com.example.demo.model.User;import java.util.List;public interface UserService {
    void save(User user) throws Exception;void update(User user) throws Exception;void delete(String username) throws Exception;List<User> get() throws Exception;User check(User user) throws Exception;String selectByUser(String username) throws Exception;}
