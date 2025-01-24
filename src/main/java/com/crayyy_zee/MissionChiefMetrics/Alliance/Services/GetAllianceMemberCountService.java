package com.crayyy_zee.MissionChiefMetrics.Alliance.Services;

import com.crayyy_zee.MissionChiefMetrics.Alliance.Models.AllianceMemberCountResponse;
import com.crayyy_zee.MissionChiefMetrics.AllianceMember.AllianceMemberRepository;
import com.crayyy_zee.MissionChiefMetrics.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetAllianceMemberCountService implements Query<Integer, AllianceMemberCountResponse> {

    private final AllianceMemberRepository allianceMemberRepository;

    public GetAllianceMemberCountService(AllianceMemberRepository allianceMemberRepository) {
        this.allianceMemberRepository = allianceMemberRepository;
    }

    @Override
    public ResponseEntity<AllianceMemberCountResponse> execute(Integer input) {
        var allianceMemberCount = allianceMemberRepository.countAllByAllianceId(input);
        return ResponseEntity.ok().body(new AllianceMemberCountResponse(input, allianceMemberCount));
    }
}
