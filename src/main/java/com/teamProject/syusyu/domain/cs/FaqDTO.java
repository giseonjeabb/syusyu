package com.teamProject.syusyu.domain.cs;

import java.time.LocalDateTime;
import java.util.Objects;

public class FaqDTO {
    private Integer faqNo;
    private String faqTp;
    private String title;
    private String content;
    private Integer sortIdx;
    private LocalDateTime regDttm;
    private Integer regrId;
    private LocalDateTime updDttm;
    private Integer updrId;

    private String prevTitle;
    private String nextTitle;
    private Integer prevNo;
    private Integer nextNo;

    public FaqDTO(){}



    public FaqDTO(Integer faqNo, String title, String prevTitle, String nextTitle, Integer prevNo, Integer nextNo) {
        this.faqNo = faqNo;
        this.title = title;
        this.prevTitle = prevTitle;
        this.nextTitle = nextTitle;
        this.prevNo = faqNo;
        this.nextNo = faqNo;
    }

    public FaqDTO(Integer faqNo, String title, String content, Integer regrId, LocalDateTime updDttm) {
        this.faqNo = faqNo;
        this.title = title;
        this.content = content;
        this.regrId = regrId;
        this.updDttm = updDttm;
    }

    public FaqDTO(String title, String content, Integer regrId) {
        this.title = title;
        this.content = content;
        this.regrId = regrId;
    }

    public FaqDTO(String faqTp, String title, String content, Integer regrId) {
        this.faqTp = faqTp;
        this.title = title;
        this.content = content;
        this.regrId = regrId;
    }


    public FaqDTO(Integer faqNo, Integer regrId) {
        this.faqNo = faqNo;
        this.regrId = regrId;
    }



    public FaqDTO(Integer faqNo, String faqTp, String title, String content, Integer sortIdx, LocalDateTime regDttm, Integer regrId,
                  LocalDateTime updDttm, Integer updrId, String prevTitle, String nextTitle, Integer prevNo, Integer nextNo) {
        this.faqNo = faqNo;
        this.faqTp = faqTp;
        this.title = title;
        this.content = content;
        this.sortIdx = sortIdx;
        this.regDttm = regDttm;
        this.regrId = regrId;
        this.updDttm = updDttm;
        this.updrId = updrId;
        this.prevTitle = prevTitle;
        this.nextTitle = nextTitle;
        this.prevNo = prevNo;
        this.nextNo = nextNo;
    }

    public Integer getFaqNo() {
        return faqNo;
    }

    public void setFaqNo(Integer faqNo) {
        this.faqNo = faqNo;
    }

    public String getFaqTp() {
        return faqTp;
    }

    public void setFaqTp(String faqTp) {
        this.faqTp = faqTp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSortIdx() {
        return sortIdx;
    }

    public void setSortIdx(Integer sortIdx) {
        this.sortIdx = sortIdx;
    }

    public LocalDateTime getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(LocalDateTime regDttm) {
        this.regDttm = regDttm;
    }

    public Integer getRegrId() {
        return regrId;
    }

    public void setRegrId(Integer regrId) {
        this.regrId = regrId;
    }

    public LocalDateTime getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(LocalDateTime updDttm) {
        this.updDttm = updDttm;
    }

    public Integer getUpdrId() {
        return updrId;
    }

    public void setUpdrId(Integer updrId) {
        this.updrId = updrId;
    }

    public String getPrevTitle() {
        return prevTitle;
    }

    public void setPrevTitle(String prevTitle) {
        this.prevTitle = prevTitle;
    }

    public String getNextTitle() {
        return nextTitle;
    }

    public void setNextTitle(String nextTitle) {
        this.nextTitle = nextTitle;
    }

    public Integer getPrevNo() {
        return prevNo;
    }

    public void setPrevNo(Integer prevNo) {
        this.prevNo = prevNo;
    }

    public Integer getNextNo() {
        return nextNo;
    }

    public void setNextNo(Integer nextNo) {
        this.nextNo = nextNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FaqDTO faqDTO = (FaqDTO) o;
        return Objects.equals(faqNo, faqDTO.faqNo) && Objects.equals(faqTp, faqDTO.faqTp) && Objects.equals(title, faqDTO.title) && Objects.equals(content, faqDTO.content) && Objects.equals(sortIdx, faqDTO.sortIdx) && Objects.equals(regDttm, faqDTO.regDttm) && Objects.equals(regrId, faqDTO.regrId) && Objects.equals(updDttm, faqDTO.updDttm) && Objects.equals(updrId, faqDTO.updrId) && Objects.equals(prevTitle, faqDTO.prevTitle) && Objects.equals(nextTitle, faqDTO.nextTitle) && Objects.equals(prevNo, faqDTO.prevNo) && Objects.equals(nextNo, faqDTO.nextNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faqNo, faqTp, title, content, sortIdx, regDttm, regrId, updDttm, updrId, prevTitle, nextTitle, prevNo, nextNo);
    }

    @Override
    public String toString() {
        return "FaqDTO{" +
                "faqNo=" + faqNo +
                ", faqTp='" + faqTp + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sortIdx=" + sortIdx +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                ", prevTitle='" + prevTitle + '\'' +
                ", nextTitle='" + nextTitle + '\'' +
                ", prevNo=" + prevNo +
                ", nextNo=" + nextNo +
                '}';
    }
}
