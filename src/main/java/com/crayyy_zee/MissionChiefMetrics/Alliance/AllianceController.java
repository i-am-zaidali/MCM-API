package com.crayyy_zee.MissionChiefMetrics.Alliance;

import com.crayyy_zee.MissionChiefMetrics.Alliance.Models.AllianceMemberCountResponse;
import com.crayyy_zee.MissionChiefMetrics.Alliance.Services.GetPaginatedAlliancesService;
import com.crayyy_zee.MissionChiefMetrics.Alliance.Services.GetAllianceInfoService;
import com.crayyy_zee.MissionChiefMetrics.Alliance.Models.Alliance;
import com.crayyy_zee.MissionChiefMetrics.Alliance.Services.GetAllianceMemberCountService;
import com.crayyy_zee.MissionChiefMetrics.Exceptions.MalformedQuery;
import com.crayyy_zee.MissionChiefMetrics.PaginatedResponse;
import com.crayyy_zee.MissionChiefMetrics.PaginationQuery;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllianceController {

    private final GetAllianceInfoService getAllianceInfoService;
    private final GetPaginatedAlliancesService getPaginatedAlliancesService;
    private final GetAllianceMemberCountService getAllianceMemberCountService;

    public AllianceController(GetAllianceInfoService getAllianceInfoService, GetPaginatedAlliancesService getPaginatedAlliancesService, GetAllianceMemberCountService getAllianceMemberCountService) {
        this.getAllianceInfoService = getAllianceInfoService;
        this.getPaginatedAlliancesService = getPaginatedAlliancesService;
        this.getAllianceMemberCountService = getAllianceMemberCountService;
    }


    @GetMapping(path="/alliances/info")
    public ResponseEntity<Alliance> getAllianceInfo(@RequestParam Integer id) {
        return getAllianceInfoService.execute(id);
    }


    @GetMapping(path="/alliances/all")
    public ResponseEntity<PaginatedResponse<Alliance>> getAllAlliances(
            @RequestParam(required=false, defaultValue = "1", name = "page") Integer pageNumber,
            @RequestParam(required=false, defaultValue = "10", name="per_page") Integer perPage,
            @RequestParam(required=false, defaultValue = "random") String sort,
            @RequestParam(required=false, defaultValue = "id", name = "sort_by") String sortField
    ) {
        if (perPage < 5) {
            throw new MalformedQuery("Invalid \"per_page\" value: Must be greater than minPage");
        }
        Sort sortObj;
        if (List.of("id", "credits", "position").contains(sortField.toLowerCase())) {
            sortObj = Sort.by(sortField.toLowerCase());
        } else{
            throw new MalformedQuery("Invalid sort field: Must be one of 'id', 'credits', 'position'");
        }

        return getPaginatedAlliancesService.execute(PaginationQuery.of(null, pageNumber, perPage, sortObj, sort).getPageRequest());
    }

    @GetMapping(path="/alliances/membercount")
    public ResponseEntity<AllianceMemberCountResponse> getAllianceMemberCount(@RequestParam Integer id) {
        return getAllianceMemberCountService.execute(id);
    }

}
