package org.example.ManyToManySeparatePrimaryKey.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users_new")
public class UserNew {
    private long id;
    private String username;
    private String password;
    private String email;

    private Set<UserGroup> groups = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public long getId() {
        return id;
    }

    @OneToMany(mappedBy = "user")
    public Set<UserGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<UserGroup> groups) {
        this.groups = groups;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public UserNew() {
    }

    public UserNew(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
