package com.teamProject.syusyu.domain.cs;


import org.springframework.stereotype.Component;

@Component
public class inqryData {
    private String inqryTitle; // 문의 제목

    private String inqryContent; // 문의 내용

    private int inqryType; // 문의 유형

    public inqryData(){}

    public inqryData(String inqryTitle, String inqryContent, int inqryType) {
        this.inqryTitle = inqryTitle;
        this.inqryContent = inqryContent;
        this.inqryType = inqryType;
    }

    @Override
    public String toString() {
        return "inqryData{" +
                "inqryTitle='" + inqryTitle + '\'' +
                ", inqryContent='" + inqryContent + '\'' +
                ", inqryType=" + inqryType +
                '}';
    }

    public String getInqryTitle() {
        return inqryTitle;
    }

    public void setInqryTitle(String inqryTitle) {
        this.inqryTitle = inqryTitle;
    }

    public String getInqryContent() {
        return inqryContent;
    }

    public void setInqryContent(String inqryContent) {
        this.inqryContent = inqryContent;
    }

    public int getInqryType() {
        return inqryType;
    }

    public void setInqryType(int inqryType) {
        this.inqryType = inqryType;
    }
}
