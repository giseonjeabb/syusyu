package com.teamProject.syusyu.domain;


public class PageHandler {
//    private int page; // 현재 페이지
//    private int pageSize; // 한 페이지의 크기
//    private String option;
//    private String keyword;
    private SearchCondition sc;
    private int totalCnt; // 총 게시물 개수
    private int naviSize = 10; // 페이지 내비게이션의 크기
    private int totalPage; // 전체 페이지의 개수
    private int beginPage; // 내비게이션의 첫 번째 페이지
    private int endPage; // 내비게이션의 마지막 페이지
    private boolean showPrev; // 이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
    private boolean showNext; // 다음 페이지로 이동하는 링크를 보여줄 것인지의 여부

    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalPage = totalCnt;
        this.sc = sc;

        doPaging(totalCnt, sc);
    }

    // 페이징 계산하는데 필요한게 3가지
    public void doPaging(int totalCnt, SearchCondition sc){
        this.totalCnt = totalCnt;

        totalPage = (int) Math.ceil(totalCnt / (double) sc.getPageSize()); // 남는 페이지가 있을 수 있기 때문에 올림처리
        beginPage = (sc.getPage() - 1) / naviSize * naviSize + 1;
        endPage = Math.min(beginPage + naviSize - 1, totalPage); // endPage가 totalPage보다 작을 수 있기 때문에
        showPrev = beginPage != 1; // 시작 페이지가 1일 때만 안 나오면 된다.
        showNext = endPage != totalPage; // 다음으로 갈게 없으니까 보여주지않음
    }

    // 쿼리스트링을 일일히 만들어주기가 불편함. 그래서 getQueryString 메서드를 호출해서 자동적으로 이런 쿼리스트링을 만들어줘서 반환하려고 하는 것
    // ?page=1&page=10&option="T"&keywork="title"


    // page nav를 print하는 메서드
    public void print() {
        System.out.println("page = " + sc.getPage());

        System.out.print(showPrev ? "[PREV] " : "");
        for (int i = beginPage; i <= endPage; i++) {
            System.out.print(i + " ");
        }
        System.out.println(showNext ? " [NEXT]" : "");
    }

    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getPageSize() {
        return sc.getPageSize();
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

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "sc=" + sc +
                ", totalCnt=" + totalCnt +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
