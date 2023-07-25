package com.teamProject.syusyu.domain.cs;

import org.springframework.web.util.UriComponentsBuilder;

public class FaqSearchCondition {

    // 검색 에 필요한 클래스

    // FAQ 는 페이징 처리 안할려고 page , pageSize 사용 x

    private String keyword = ""; // 검색어
    private String option = "";  // 검색 종류
    private String key = ""; // FAQ 타입 종류 검색

    public FaqSearchCondition() {}

    public FaqSearchCondition(String keyword, String option, String key) {
        this.keyword = keyword;
        this.option = option;
        this.key = key;
    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "FaqSearchCondition{" +
                "keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                ", key='" + key + '\'' +
                '}';
    }


}