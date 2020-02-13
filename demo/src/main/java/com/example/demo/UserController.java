package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("security")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/login")
    public User get(String username, String password, HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (username != null
                && password != null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            User check = userService.check(user);
            if (check != null) {
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", check);
                return check;
            } else {
                return null;
            }
        }
        return null;
    }

    @GetMapping(value = "/CurrentUser")
    public User CurrentUser(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session1 = req.getSession();
        User currentUser = (User) session1.getAttribute("currentUser");
        return currentUser;
    }

    @GetMapping(value = "/Select")
    public List<User> select() throws Exception {
        return userService.get();
    }

    @GetMapping(value = "/load/{id}")
    public User select(@PathParam("id") long id) throws Exception {
        return null;
    }

    @DeleteMapping(value = "/delete")
    public void delete(String username) throws Exception {
        userService.delete(username);
    }

    @PostMapping(value = "/update")
    public void update(@RequestBody User user) throws Exception {
        userService.update(user);
    }
}