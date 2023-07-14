package com.teamProject.syusyu.domain.cs;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {  // 페이징에 필요한 클래스
    private Integer page = 1;   // 페이지
    private Integer pageSize = 10; // 한번에 보여줄 게시물의 개수
    //    private Integer offset = 0;
    private String keyword = ""; // 검색어
    private String option = "";  // 검색 종류


    public SearchCondition(){}

    public SearchCondition(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public SearchCondition(Integer page, Integer pageSize, String keyword, String option) {
        this.page = page;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.option = option;
    }

    public String getQueryString(){
        return getQueryString(page);
    }


    public String getQueryString(Integer page) {
        //page?=1&pageSize=10&option=T&keyword="title"
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize", pageSize)
                .queryParam("option", option)
                .queryParam("keyword", keyword)
                .build().toString();

    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return (page - 1) * pageSize;
    }

//    public void setOffset(Integer offset) {
//        this.offset = offset;
//    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + getOffset() +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}
