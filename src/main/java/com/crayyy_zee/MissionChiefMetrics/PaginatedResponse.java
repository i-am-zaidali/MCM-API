package com.crayyy_zee.MissionChiefMetrics;

import java.util.List;

public class PaginatedResponse<T> {
    private final List<T> data;
    private final Integer pageNumber;
    private final Integer perPage;
    private final Integer totalPages;
    private final Integer totalElements;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }


    public List<T> getData() {
        return data;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public Integer getElementsOnThisPage() {
        return data.size();
    }

    public PaginatedResponse(Integer pageNumber, Integer perPage, Integer totalPages, Integer totalElements, List<T> data) {
        this.pageNumber = pageNumber;
        this.perPage = perPage;
        this.totalPages = totalPages;
        this.data = data;
        this.totalElements = totalElements;
    }
}
