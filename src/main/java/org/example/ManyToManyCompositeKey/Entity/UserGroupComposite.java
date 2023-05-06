package org.example.ManyToManyCompositeKey.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users_groups")
@AssociationOverrides({@AssociationOverride(name = "primaryKey1.users", joinColumns = @JoinColumn(name = "user_id")), @AssociationOverride(name = "primaryKey1.groups", joinColumns = @JoinColumn(name = "group_id"))})
public class UserGroupComposite {

    private UserGroupId primaryKey = new UserGroupId();

    private boolean activated;
    private Date registeredDate;

    @EmbeddedId
    public UserGroupId getPrimaryKey1() {
        return primaryKey;
    }

    public void setPrimaryKey1(UserGroupId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Column(name = "registered_date")
    @Temporal(TemporalType.DATE)
    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Transient
    public UserComposite getUser() {
        return getPrimaryKey1().getUsers();
    }

    @Transient
    public GroupComposite getGroup() {
        return getPrimaryKey1().getGroups();
    }

    public void setUser(UserComposite user) {
        getPrimaryKey1().setUsers(user);
    }

    public void setGroup(GroupComposite groupComposite) {
        getPrimaryKey1().setGroups(groupComposite);
    }
}

