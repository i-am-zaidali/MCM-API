package com.crayyy_zee.MissionChiefMetrics.Alliance.Services;

import com.crayyy_zee.MissionChiefMetrics.Alliance.AllianceRepository;
import com.crayyy_zee.MissionChiefMetrics.Alliance.Models.Alliance;
import com.crayyy_zee.MissionChiefMetrics.PaginatedResponse;
import com.crayyy_zee.MissionChiefMetrics.Query;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPaginatedAlliancesService implements Query<PageRequest, PaginatedResponse<Alliance>> {
    private final AllianceRepository allianceRepository;

    public GetPaginatedAlliancesService(AllianceRepository allianceRepository) {
        this.allianceRepository = allianceRepository;
    }

    @Override
    public ResponseEntity<PaginatedResponse<Alliance>> execute(PageRequest input) {
        var page = allianceRepository.findAll(input);

        return ResponseEntity.ok(new PaginatedResponse<>(input.getPageNumber()+1, input.getPageSize(), page.getTotalPages(), (int) page.getTotalElements(), page.getContent()));
    }
}
