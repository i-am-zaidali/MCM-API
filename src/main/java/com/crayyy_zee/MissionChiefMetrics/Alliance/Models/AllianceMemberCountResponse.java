package com.crayyy_zee.MissionChiefMetrics.Alliance.Models;

public class AllianceMemberCountResponse {
    private Integer allianceId;
    private Integer memberCount;

    public Integer getAllianceId() {
        return allianceId;
    }

    public void setAllianceId(Integer allianceId) {
        this.allianceId = allianceId;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public AllianceMemberCountResponse(Integer allianceId, Integer memberCount) {
        this.allianceId = allianceId;
        this.memberCount = memberCount;
    }
}
