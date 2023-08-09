package com.teamProject.syusyu.domain.product;

import java.util.List;
import java.util.Objects;

public class SearchConditionDTO {
    private String dateType;
    private String startDate;
    private String endDate;
    private String searchKeyword;
    private String searchType;
    private List<Integer> statusList;
    private String largeNm;
    private String middleNm;
    private String smallNm;
    private Boolean loadInitialData;

    public SearchConditionDTO(){}

    public SearchConditionDTO(String largeNm, String middleNm, String smallNm, String dateType, String startDate, String endDate, String searchKeyword, String searchType, List<Integer> statusList, Boolean loadInitialData) {
        this.largeNm = largeNm;
        this.middleNm = middleNm;
        this.smallNm = smallNm;
        this.dateType = dateType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.searchKeyword = searchKeyword;
        this.searchType = searchType;
        this.statusList = statusList;
        this.loadInitialData = loadInitialData;
    }

    public SearchConditionDTO(Boolean loadInitialData) {
        this.loadInitialData = loadInitialData;
    }

    public Boolean getLoadInitialData() {
        return loadInitialData;
    }

    public void setLoadInitialData(Boolean loadInitialData) {
        this.loadInitialData = loadInitialData;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public List<Integer> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Integer> statusList) {
        this.statusList = statusList;
    }

    public String getLargeNm() {
        return largeNm;
    }

    public void setLargeNm(String largeNm) {
        this.largeNm = largeNm;
    }

    public String getMiddleNm() {
        return middleNm;
    }

    public void setMiddleNm(String middleNm) {
        this.middleNm = middleNm;
    }

    public String getSmallNm() {
        return smallNm;
    }

    public void setSmallNm(String smallNm) {
        this.smallNm = smallNm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchConditionDTO that = (SearchConditionDTO) o;
        return Objects.equals(dateType, that.dateType) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(searchKeyword, that.searchKeyword) && Objects.equals(searchType, that.searchType) && Objects.equals(statusList, that.statusList) && Objects.equals(largeNm, that.largeNm) && Objects.equals(middleNm, that.middleNm) && Objects.equals(smallNm, that.smallNm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateType, startDate, endDate, searchKeyword, searchType, statusList, largeNm, middleNm, smallNm);
    }

    @Override
    public String toString() {
        return "SearchConditionDTO{" +
                "dateType='" + dateType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", searchKeyword='" + searchKeyword + '\'' +
                ", searchType='" + searchType + '\'' +
                ", statusList=" + statusList +
                ", largeNm='" + largeNm + '\'' +
                ", middleNm='" + middleNm + '\'' +
                ", smallNm='" + smallNm + '\'' +
                '}';
    }
}
