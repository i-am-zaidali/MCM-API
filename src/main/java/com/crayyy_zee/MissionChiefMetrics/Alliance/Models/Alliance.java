package com.crayyy_zee.MissionChiefMetrics.Alliance.Models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
//@Data
@Table(name="alliances")
public class Alliance {

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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    @Id
    @NotNull
    @Column(name="id")
    private Integer id;

    @NotNull
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="credits")
    private Double credits;

    @NotNull
    @Column(name="position")
    private Integer position;

    @Nullable
    @Column(name="logo_url")
    private String logoURL;

    public Alliance(int id, String name, double credits, int position, String logoURL) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.position = position;
        this.logoURL = logoURL;
    }


    public Alliance() {
    }
}
