package com.bpc.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Bui_qt
 * Date: 11/23/11
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="SCORING_USER_ROLE")
public class ScoringUserRole implements EntityBean{

    @Id
    @Column(name="USER_ID")
    private int userNameId;
    
    @Id
    @Column(name="ROLE_ID")
    private int roleId;
    
    @Column(name="DESCRIPTION")
    private String description="";

    public ScoringUserRole(){}

    public int getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(int userNameId) {
        this.userNameId = userNameId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Transient
    public Object getModelId() {
        return getUserNameId()+"-"+getRoleId();
    }

    /*public int hashCode() {
      return authority.hashCode();
   }

   public boolean equals(Object authorityObj) {
       boolean result =(authorityObj instanceof ScoringUserRole)
              ? authority.equals(((ScoringUserRole) authorityObj).getAuthority()) : false;
       return result;
   }*/

}
