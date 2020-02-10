package com.example.demo.dao;




import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDA implements IUserDA {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    DataSource dataSource;




    public void insert(User user) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("insert into person  values (?,?,?,?,?)");
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getFirstname());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setInt(5,user.getId());
            preparedStatement.executeUpdate();
        }

    }

    public List<User> select() throws Exception {
        PreparedStatement preparedStatement;
        preparedStatement = dataSource.getConnection().prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList = new ArrayList();
        while (resultSet.next()) {
            User user
                    = new User();
            user.setUsername(resultSet.getString("username"));
            user.setFirstname(resultSet.getString("firstname"));
            user.setLastname(resultSet.getString("lastname"));
            user.setPassword(resultSet.getString("password"));
            user.setId(resultSet.getInt("id"));
            userList.add(user);
        }
        return userList;
    }

    public void update(User user) throws Exception {
        PreparedStatement preparedStatement;
        preparedStatement = dataSource.getConnection().prepareStatement("update person set password=? , firstname=? , lastname=? , username=? where id=?");
        preparedStatement.setString(1, user.getPassword());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getFirstname());
        preparedStatement.setString(4, user.getLastname());
        preparedStatement.setInt(5,user.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(String username) throws Exception {
        PreparedStatement preparedStatement;
        preparedStatement = dataSource.getConnection().prepareStatement("delete from person where username=?");
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
    }
    public User selectByUser(String username)throws Exception{
        PreparedStatement preparedStatement;
        preparedStatement = dataSource.getConnection().prepareStatement("select from person where username=?");
        preparedStatement.setString(1,username);
       ResultSet resultSet=preparedStatement.executeQuery();
       User user =new User();
        user.setUsername(resultSet.getString("username"));
        user.setFirstname(resultSet.getString("firstname"));
        user.setLastname(resultSet.getString("lastname"));
        user.setPassword(resultSet.getString("password"));
        preparedStatement.executeUpdate();
        return user;
    }


}

