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
@Table(name="SCORING_ROLE")
public class ScoringRole implements EntityBean{

    @Id
    @Column(name="ID")
    @SequenceGenerator(name = "SEQ_SCORING_ROLE", sequenceName = "SEQ_SCORING_ROLE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCORING_ROLE")
    private int id;
    
    @Column(name="ROLE_NAME")
    private String roleName = "";
    
    @Column(name="DESCRIPTION")
    private String description = "N";

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    private List<ScoringUserRole> users;

    public ScoringRole(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ScoringUserRole> getUsers() {
        return users;
    }

    public void setUsers(List<ScoringUserRole> users) {
        this.users = users;
    }

    @Transient
    public Object getModelId() {
        return getId();
    }
}
