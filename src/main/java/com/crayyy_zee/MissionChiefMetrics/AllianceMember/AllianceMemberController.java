package com.crayyy_zee.MissionChiefMetrics.AllianceMember;

import com.crayyy_zee.MissionChiefMetrics.AllianceMember.Models.AllianceMemberDTO;
import com.crayyy_zee.MissionChiefMetrics.Exceptions.MalformedQuery;
import com.crayyy_zee.MissionChiefMetrics.PaginatedResponse;
import com.crayyy_zee.MissionChiefMetrics.PaginationQuery;
import com.crayyy_zee.MissionChiefMetrics.AllianceMember.Services.GetAllianceMemberInfoService;
import com.crayyy_zee.MissionChiefMetrics.AllianceMember.Services.GetPaginatedAllianceMembersService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllianceMemberController {

    private final GetAllianceMemberInfoService getAllianceMemberInfoService;
    private final GetPaginatedAllianceMembersService getPaginatedAllianceMembersService;

    public AllianceMemberController(GetAllianceMemberInfoService getAllianceMemberInfoService, GetPaginatedAllianceMembersService getPaginatedAllianceMembersService) {
        this.getAllianceMemberInfoService = getAllianceMemberInfoService;
        this.getPaginatedAllianceMembersService = getPaginatedAllianceMembersService;
    }

    @GetMapping("/alliances/members/all")
    public ResponseEntity<PaginatedResponse<AllianceMemberDTO>> getAllAllianceMembers(
            @RequestParam Integer id,
            @RequestParam(required=false, defaultValue = "1", name = "page") Integer pageNumber,
            @RequestParam(required=false, defaultValue = "10", name="per_page") Integer perPage,
            @RequestParam(required=false, defaultValue = "random") String sortOrder,
            @RequestParam(required=false, defaultValue = "id", name = "sort_by") String sortField
    ) {
        if (perPage < 5) {
            throw new MalformedQuery("Invalid \"per_page\" value: Must be greater than 5");
        }
        Sort sortObj;
        if (List.of("id", "credits").contains(sortField.toLowerCase())) {
            sortObj = Sort.by(sortField.toLowerCase());
        } else{
            throw new MalformedQuery("Invalid sort field: Must be one of 'id', 'credits'");
        }
        return getPaginatedAllianceMembersService.execute(PaginationQuery.of(id, pageNumber, perPage, sortObj, sortOrder));
    }

    @GetMapping("/alliances/members/info")
    public ResponseEntity<AllianceMemberDTO> getAllianceMemberInfo(@RequestParam Integer id) {
        return getAllianceMemberInfoService.execute(id);
    }


}
