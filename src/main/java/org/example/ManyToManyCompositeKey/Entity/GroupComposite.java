package org.example.ManyToManyCompositeKey.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class GroupComposite {
    private long id;
    private String name;
    private Set<UserGroupComposite> userGroupComposites = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "primaryKey1.groups", cascade = CascadeType.ALL)
    public Set<UserGroupComposite> getUserGroupComposites() {
        return userGroupComposites;
    }

    public void setUserGroupComposites(Set<UserGroupComposite> userGroupComposites) {
        this.userGroupComposites = userGroupComposites;
    }

    public GroupComposite(String name) {
        this.name = name;
    }

    public GroupComposite() {
    }

    public void setUserGroups(Set<UserGroupComposite> groups){
        this.userGroupComposites = groups;
    }

    public void addUserGroup(UserGroupComposite userGroupComposite){
        this.userGroupComposites.add(userGroupComposite);
    }

    @Override
    public String toString() {
        return "GroupComposite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userGroupComposites=" + userGroupComposites +
                '}';
    }
}
