package com.teamProject.syusyu.domain.product;

import org.springframework.web.util.UriComponentsBuilder;

public class PageHandlerReview {
    private int page = 1;     // 현재 페이지
    private int pageSize = 5;  // 페이지의 크기
    private int totalCnt; // 총 게시물의 개수
    private int naviSize = 10; // 페이지 내비게이션의 크기
    private int totalPage; // 전체 페이지의 개수
    private int beginPage; // 내비게이션의 첫번째 페이지
    private int endPage;   // 내비게이션의 마지막 페이지

    //    private Integer offset = 0;

    public PageHandlerReview(){}

    public PageHandlerReview(int page, int pageSize, int totalCnt) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCnt = totalCnt;
    }

    public PageHandlerReview(int page, int pageSize, int totalCnt, int naviSize) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCnt = totalCnt;
        this.naviSize = naviSize;
        doPaging();
    }

    public String getQueryString(){
        return getQueryString(page);
    }

    public String getQueryString(Integer page) {
        //page?=1&pageSize=10
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize", pageSize)
                .build().toString();
    }

    private void doPaging(){
        totalPage = (int) Math.ceil(totalCnt / (double) pageSize);
        beginPage = (this.page - 1) / naviSize * naviSize + 1;
        endPage = Math.min(beginPage + naviSize - 1, totalPage);
    }

    public Integer getOffset() {
        return (page - 1) * pageSize;
    }

//    public void setOffset(Integer offset) {
//        this.offset = offset;
//    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "PageHandlerReview{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + getOffset() +
                ", totalCnt=" + totalCnt +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                '}';
    }
}
