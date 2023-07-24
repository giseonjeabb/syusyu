package com.teamProject.syusyu.domain.order.request;

public class OrderSearchRequestDTO {
    String startDate; // 조회시작일
    String endDate; // 조회종료일
    String searchType; // 조회조건
    String searchKeyword; // 검색어

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

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    @Override
    public String toString() {
        return "OrderSearchDTO{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", searchType='" + searchType + '\'' +
                ", keyword='" + searchKeyword + '\'' +
                '}';
    }

    public static final class Builder {
        private String startDate;
        private String endDate;
        private String searchType;
        private String searchKeyword;

        private Builder() {
        }

        public static Builder anOrderSearchRequestDTO() {
            return new Builder();
        }

        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder searchType(String searchType) {
            this.searchType = searchType;
            return this;
        }

        public Builder searchKeyword(String searchKeyword) {
            this.searchKeyword = searchKeyword;
            return this;
        }

        public OrderSearchRequestDTO build() {
            OrderSearchRequestDTO orderSearchRequestDTO = new OrderSearchRequestDTO();
            orderSearchRequestDTO.setStartDate(startDate);
            orderSearchRequestDTO.setEndDate(endDate);
            orderSearchRequestDTO.setSearchType(searchType);
            orderSearchRequestDTO.setSearchKeyword(searchKeyword);
            return orderSearchRequestDTO;
        }
    }
}
