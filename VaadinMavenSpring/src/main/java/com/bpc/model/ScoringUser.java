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
@Table(name="SCORING_USER")
public class ScoringUser implements EntityBean{

    @Id
    @Column(name="USERNAME")
    private String userName;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="ENABLED")
    private String enabled;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="USERNAME",referencedColumnName = "USERNAME")
    private List<ScoringUserAuthority> authorities;

    public ScoringUser(){}

    public ScoringUser(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public List<ScoringUserAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<ScoringUserAuthority> authorities) {
        this.authorities = authorities;
    }

    @Transient
    public Object getModelId() {
        return getUserName();
    }
}