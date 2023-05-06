package org.example.ManyToManySeparatePrimaryKey.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_group_new")
public class UserGroup {

    private long id;
    private UserNew userNew;
    private GroupNew groupNew;

    private boolean activated;
    private Date registeredDate;

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

    public UserGroup() {
    }

    public UserGroup(UserNew userNew, GroupNew groupNew) {
        this.userNew = userNew;
        this.groupNew = groupNew;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_group_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public UserNew getUser() {
        return userNew;
    }

    public void setUser(UserNew userNew) {
        this.userNew = userNew;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    public GroupNew getGroup() {
        return groupNew;
    }

    public void setGroup(GroupNew groupNew) {
        this.groupNew = groupNew;
    }


}
