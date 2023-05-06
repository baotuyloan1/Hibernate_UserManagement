package org.example.ManyToManyCompositeKey.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserComposite {
    private long id;
    private String username;
    private String password;

    private String email;

    @OneToMany(mappedBy = "primaryKey1.users", cascade = CascadeType.ALL)
    public Set<UserGroupComposite> getUserGroupComposites() {
        return userGroups;
    }

    public void setUserGroupComposites(Set<UserGroupComposite> userGroupIds) {
        this.userGroups = userGroupIds;
    }

    private Set<UserGroupComposite> userGroups = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public long getId() {
        return id;
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

    public UserComposite() {
    }

    public UserComposite(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void addUserGroup(UserGroupComposite userGroupComposite) {
        this.userGroups.add(userGroupComposite);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (UserGroupComposite userGroup : userGroups) {
            stringBuilder.append(userGroup.getGroup().getName() + "\t");
        }
        return "UserComposite{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", groups=" + stringBuilder
                + '}';
    }
}
