package com.teamProject.syusyu.domain.cs;

import org.springframework.web.util.UriComponentsBuilder;

public class FaqSearchCondition {

    private String keyword = ""; // 검색어
    private String option = "";  // 검색 종류


    public FaqSearchCondition(){}


    public FaqSearchCondition( String keyword, String option) {
        this.keyword = keyword;
        this.option = option;
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

    @Override
    public String toString() {
        return "FaqSearchCondition{" +
                "keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }


}
