package com.crayyy_zee.MissionChiefMetrics.AllianceMember.Models;

import com.crayyy_zee.MissionChiefMetrics.Alliance.Models.Alliance;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Data
@Table(name="alliance_members")
public class AllianceMember {
    public AllianceMember() {

    }

    public enum Role {
        ALLIANCE_FINANCES,
        TRANSPORT_REQUEST_ADMIN,
        EVENT_MANAGER,
        ALLIANCE_OWNER,
        ALLIANCE_ADMIN,
        ALLIANCE_STAFF,
        ALLIANCE_EDUCATOR,
        MODERATOR_ACTION_LOG,
        ALLIANCE_CO_ADMIN;
    }

    public enum ActivityStatus {
        ONLINE, OFFLINE;
    }


    @Id
    @Column(name="id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="alliance_id", nullable = false)
    private Alliance alliance;

    @NotNull
    @Column(name="name", nullable = false)
    private String name;

    @NotNull
    @Column(name="credits", nullable = false)
    private Double credits;

    @Column(name="status", nullable = false)
    @NotNull
    private ActivityStatus status;

    @Column(name="flair")
    private String flair;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "member_roles", joinColumns = @JoinColumn(name = "member_id"))
    @Enumerated(EnumType.STRING)
    @NotNull
    private Set<Role> roles = new HashSet<>();

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public ActivityStatus getStatus() {
        return status;
    }

    public void setStatus(ActivityStatus status) {
        this.status = status;
    }

    public String getFlair() {
        return flair;
    }

    public void setFlair(String flair) {
        this.flair = flair;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }

    public AllianceMember(int id, String name, double credits, ActivityStatus status, String flair, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.status = status;
        this.flair = flair;
        this.roles = roles;
    }



}
