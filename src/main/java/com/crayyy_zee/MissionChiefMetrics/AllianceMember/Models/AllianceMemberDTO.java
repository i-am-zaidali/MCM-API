package com.crayyy_zee.MissionChiefMetrics.AllianceMember.Models;

import com.crayyy_zee.MissionChiefMetrics.Alliance.Models.Alliance;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.Hibernate;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllianceMemberDTO {
    private Integer id;
    private String name;
    private Integer allianceId;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Alliance alliance;
    private Double credits;
    private AllianceMember.ActivityStatus status;
    private String flair;
    private List<AllianceMember.Role> roles;

    public Alliance getAlliance() {
        Hibernate.initialize(alliance);
        return alliance;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }

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

    public Integer getAllianceId() {
        return allianceId;
    }

    public void setAllianceId(Integer allianceId) {
        this.allianceId = allianceId;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public AllianceMember.ActivityStatus getStatus() {
        return status;
    }

    public void setStatus(AllianceMember.ActivityStatus status) {
        this.status = status;
    }

    public String getFlair() {
        return flair;
    }

    public void setFlair(String flair) {
        this.flair = flair;
    }

    public List<AllianceMember.Role> getRoles() {
        return roles;
    }

    public void setRoles(List<AllianceMember.Role> roles) {
        this.roles = roles;
    }

    public AllianceMemberDTO(Integer id, String name, Integer allianceId, Double credits, AllianceMember.ActivityStatus status, String flair, List<AllianceMember.Role> roles) {
        this.id = id;
        this.name = name;
        this.allianceId = allianceId;
        this.credits = credits;
        this.status = status;
        this.flair = flair;
        this.roles = roles;
    }

    public AllianceMemberDTO() {}

    public static AllianceMemberDTO fromEntity(AllianceMember allianceMember) {
        return fromEntity(allianceMember, null);
    }

    public static AllianceMemberDTO fromEntity(AllianceMember allianceMember, Integer allianceId) {
        var dto = new AllianceMemberDTO();
        dto.setId(allianceMember.getId());
        dto.setName(allianceMember.getName());
        if (allianceId == null) {
            dto.setAlliance(allianceMember.getAlliance());
        } else {
            dto.setAllianceId(allianceId);
        }
        dto.setCredits(allianceMember.getCredits());
        dto.setFlair(allianceMember.getFlair());
        dto.setRoles(List.copyOf(allianceMember.getRoles()));
        dto.setStatus(allianceMember.getStatus());
        return dto;
    }
}
