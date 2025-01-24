package com.crayyy_zee.MissionChiefMetrics.AllianceMember.Services;

import com.crayyy_zee.MissionChiefMetrics.AllianceMember.AllianceMemberRepository;
import com.crayyy_zee.MissionChiefMetrics.AllianceMember.Models.AllianceMember;
import com.crayyy_zee.MissionChiefMetrics.AllianceMember.Models.AllianceMemberDTO;
import com.crayyy_zee.MissionChiefMetrics.Query;
import org.hibernate.Hibernate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetAllianceMemberInfoService implements Query<Integer, AllianceMemberDTO> {

    private final AllianceMemberRepository allianceMemberRepository;

    public GetAllianceMemberInfoService(AllianceMemberRepository allianceMemberRepository) {
        this.allianceMemberRepository = allianceMemberRepository;
    }

    @Override
    public ResponseEntity<AllianceMemberDTO> execute(Integer input) {
        var option = allianceMemberRepository.findById(input);
        if (option.isPresent()) {
            var allianceMember = option.get();
            Hibernate.initialize(allianceMember.getAlliance());
            return ResponseEntity.ok(AllianceMemberDTO.fromEntity(allianceMember));
        }
        return ResponseEntity.notFound().build();
    }
}
