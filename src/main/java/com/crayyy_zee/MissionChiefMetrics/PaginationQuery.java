package com.crayyy_zee.MissionChiefMetrics;

import com.crayyy_zee.MissionChiefMetrics.Exceptions.MalformedQuery;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

public class PaginationQuery {

//    public enum SortOrder {
//        ASCENDING,
//        DESCENDING,
//        RANDOM
//    }
//    public enum SortField {
//        ID,
//        CREDITS
//    }

    private final Integer allianceId;
    private final PageRequest pageRequest;

    public PaginationQuery(Integer allianceId, PageRequest pageRequest/*, Integer pageNumber, Integer perPage, SortOrder sort, SortField sortField, */) {
        this.allianceId = allianceId;
        this.pageRequest = pageRequest;
//        this.pageNumber = pageNumber;
//        this.perPage = perPage;
//        this.sort = sort;
//        this.sortField = sortField;
    }


    public Integer getAllianceId() {
        return allianceId;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public static PaginationQuery of(Integer allianceId /* Integer cause it needs to be null */,
                                     int pageNumber,
                                     int perPage,
                                     Sort sort,
                                     String sortOrder) {
        if (pageNumber < 1) {
            throw new MalformedQuery("Invalid page number: Must not be less than 1");
        }
        switch (sortOrder.toLowerCase()) {
            case "ascending":
                sort = sort.ascending();
                break;
            case "descending":
                sort = sort.descending();
                break;
            case "random":
                break;

            default:
                throw new MalformedQuery("Invalid sort order: Must be one of 'ascending', 'descending', 'random'");
        }
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, perPage, sort);
        return new PaginationQuery(allianceId, pageRequest);
    }

}
