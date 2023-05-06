package org.example.ManyToManyCompositeKey.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class UserGroupId implements Serializable {

    private UserComposite user;
    private GroupComposite group;


    @ManyToOne(cascade = CascadeType.ALL)
    public UserComposite getUsers() {
        return user;
    }

    public void setUsers(UserComposite user) {
        this.user = user;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public GroupComposite getGroups() {
        return group;
    }

    public void setGroups(GroupComposite group) {
        this.group = group;
    }
}
