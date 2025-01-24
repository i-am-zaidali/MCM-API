package com.crayyy_zee.MissionChiefMetrics.AllianceMember.Services;

import com.crayyy_zee.MissionChiefMetrics.AllianceMember.AllianceMemberRepository;
import com.crayyy_zee.MissionChiefMetrics.AllianceMember.Models.AllianceMemberDTO;
import com.crayyy_zee.MissionChiefMetrics.PaginatedResponse;
import com.crayyy_zee.MissionChiefMetrics.PaginationQuery;
import com.crayyy_zee.MissionChiefMetrics.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPaginatedAllianceMembersService implements Query<PaginationQuery, PaginatedResponse<AllianceMemberDTO>> {

    private final AllianceMemberRepository allianceMemberRepository;

    public GetPaginatedAllianceMembersService(AllianceMemberRepository allianceMemberRepository) {
        this.allianceMemberRepository = allianceMemberRepository;
    }

    @Override
    public ResponseEntity<PaginatedResponse<AllianceMemberDTO>> execute(PaginationQuery input) {
        var results = allianceMemberRepository.findAllByAllianceId(input.getAllianceId(), input.getPageRequest());
        var request = input.getPageRequest();
        var response = new PaginatedResponse<>(
                request.getPageNumber()+1,
                request.getPageSize(),
                results.getTotalPages(),
                (int) results.getTotalElements(),
                results.stream().map(v -> AllianceMemberDTO.fromEntity(v, input.getAllianceId())).toList()
        );
        return ResponseEntity.ok(response);
    }
}
