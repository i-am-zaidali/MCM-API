package com.crayyy_zee.MissionChiefMetrics.Alliance.Services;

import com.crayyy_zee.MissionChiefMetrics.Alliance.AllianceRepository;
import com.crayyy_zee.MissionChiefMetrics.Alliance.Models.Alliance;
import com.crayyy_zee.MissionChiefMetrics.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetAllianceInfoService implements Query<Integer, Alliance> {

    private final AllianceRepository allianceRepository;

    public GetAllianceInfoService(AllianceRepository allianceRepository) {
        this.allianceRepository = allianceRepository;
    }

    @Override
    public ResponseEntity<Alliance> execute(Integer id) {
        var alliance = allianceRepository.findById(id);
        return alliance.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
