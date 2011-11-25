package com.bpc.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bui_qt
 * Date: 11/23/11
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="SCORING_AUTHORITY")
public class ScoringUserAuthority implements EntityBean{

    @Id
    @Column(name="USERNAME")
    private String userName;
    @Column(name="AUTHORITY")
    private String authority;
    /*@JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private List<ScoringUser> users;*/

    public ScoringUserAuthority(){}

    public ScoringUserAuthority(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /*public List<ScoringUser> getUsers() {
        return users;
    }

    public void setUsers(List<ScoringUser> users) {
        this.users = users;
    }*/

    @Transient
    public Object getModelId() {
        return getUserName();
    }
}
