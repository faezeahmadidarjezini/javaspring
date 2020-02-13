package com.example.demo.model;import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.ResourceProperties;import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;public int getId() {
        return id;
    }public void setId(int id) {
        this.id = id;
    }public String getLastname() {
        return lastname;
    }public void setLastname(String lastname) {
        this.lastname = lastname;
    }public String getFirstname() {
        return firstname;
    }public void setFirstname(String firstname) {
        this.firstname = firstname;
    }public String getPassword() {
        return password;
    }public void setPassword(String password) {
        this.password = password;
    }public String getUsername() {
        return username;
    }public void setUsername(String username) {
        this.username = username;
    }@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;User user = (User) o;if (!getUsername().equals(user.getUsername())) return false;
        return getPassword().equals(user.getPassword());
    }@Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
