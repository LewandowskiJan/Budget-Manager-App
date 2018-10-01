package com.lewandowski.budget.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private boolean enable;

    @ElementCollection
    @CollectionTable(name="roles")
    private List<String> roles;

    public User() {
    }

    public List<String> getRoles() {
        return roles;
    }

    public User setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }


    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}
