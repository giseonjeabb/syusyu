package com.teamProject.syusyu.domain.cs;

import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.Objects;

public class NoticeDTO {

    private Integer notcNo;
    private String notcTp;
    private String notcTpNm;
    private String title;
    private String content;
    private Integer viewCnt;
    private char fixYn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDttm;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDttm;
    private Date regDttm;
    private Integer regrId;
    private Date updDttm;
    private Integer updrId;
    private Date delDttm;
    private Integer delrId;
    private char delYn;

    private String prevTitle;
    private String nextTitle;
    private Integer prevNo;
    private Integer nextNo;


    public NoticeDTO() {
    }

    public NoticeDTO(Integer notcNo, String notcTp, String title, String content, Date startDttm, Date endDttm) {
        this.notcNo = notcNo;
        this.notcTp = notcTp;
        this.title = title;
        this.content = content;
        this.startDttm = startDttm;
        this.endDttm = endDttm;
    }

    public NoticeDTO(Integer notcNo, String notcTp, String title, String content, Date startDttm, Date endDttm, Date regDttm) {
        this.notcNo = notcNo;
        this.notcTp = notcTp;
        this.title = title;
        this.content = content;
        this.startDttm = startDttm;
        this.endDttm = endDttm;
        this.regDttm = regDttm;
    }

    public NoticeDTO(Integer notcNo, String notcTp, String title, String content, Integer viewCnt, Date startDttm, Date endDttm, Date regDttm) {
        this.notcNo = notcNo;
        this.notcTp = notcTp;
        this.title = title;
        this.content = content;
        this.viewCnt = viewCnt;
        this.startDttm = startDttm;
        this.endDttm = endDttm;
        this.regDttm = regDttm;

    }

    public NoticeDTO(String notcTp, String title, String content, Integer regrId) {
        this.notcTp = notcTp;
        this.title = title;
        this.content = content;
        this.regrId = regrId;
    }

    public NoticeDTO(Integer notcNo, String title) {
        this.notcNo = notcNo;
        this.title = title;
    }

    public NoticeDTO(Integer notcNo, String title, Integer prevNo, String prevTitle, Integer nextNo, String nextTitle) {
        this.notcNo = notcNo;
        this.title = title;
        this.prevNo = notcNo;
        this.prevTitle = prevTitle;
        this.nextNo = notcNo;
        this.nextTitle = nextTitle;
    }

    public NoticeDTO(String title, Integer updrId) {
        this.title = title;
        this.updrId = updrId;
    }

    public NoticeDTO(String notcTp, String title, String content) {
        this.notcTp = notcTp;
        this.title = title;
        this.content = content;
    }

    public NoticeDTO(Integer notcNo, String notcTp, String title) {
        this.notcNo = notcNo;
        this.notcTp = notcTp;
        this.title = title;
    }

    public NoticeDTO(Integer notcNo, String notcTp, String title, String content) {
        this.notcNo = notcNo;
        this.notcTp = notcTp;
        this.title = title;
        this.content = content;
    }


    public NoticeDTO(Integer notcNo, String notcTp, String notcTpNm, String title, String content, Integer viewCnt, char fixYn, Date startDttm, Date endDttm, Date regDttm, Integer regrId, Date updDttm, Integer updrId, Date delDttm, Integer delrId, char delYn, String prevTitle, String nextTitle, Integer prevNo, Integer nextNo) {
        this.notcNo = notcNo;
        this.notcTp = notcTp;
        this.notcTpNm = notcTpNm;
        this.title = title;
        this.content = content;
        this.viewCnt = viewCnt;
        this.fixYn = fixYn;
        this.startDttm = startDttm;
        this.endDttm = endDttm;
        this.regDttm = regDttm;
        this.regrId = regrId;
        this.updDttm = updDttm;
        this.updrId = updrId;
        this.delDttm = delDttm;
        this.delrId = delrId;
        this.delYn = delYn;
        this.prevTitle = prevTitle;
        this.nextTitle = nextTitle;
        this.prevNo = prevNo;
        this.nextNo = nextNo;
    }




    public Integer getNotcNo() {
        return notcNo;
    }

    public void setNotcNo(Integer notcNo) {
        this.notcNo = notcNo;
    }

    public String getNotcTp() {
        return notcTp;
    }

    public void setNotcTp(String notcTp) {
        this.notcTp = notcTp;
    }

    public String getNotcTpNm() {
        return notcTpNm;
    }

    public void setNotcTpNm(String notcTpNm) {
        this.notcTpNm = notcTpNm;
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

    public Integer getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(Integer viewCnt) {
        this.viewCnt = viewCnt;
    }

    public char getFixYn() {
        return fixYn;
    }

    public void setFixYn(char fixYn) {
        this.fixYn = fixYn;
    }

    public Date getStartDttm() {
        return startDttm;
    }

    public void setStartDttm(Date startDttm) {
        this.startDttm = startDttm;
    }

    public Date getEndDttm() {
        return endDttm;
    }

    public void setEndDttm(Date endDttm) {
        this.endDttm = endDttm;
    }

    public Date getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    public Integer getRegrId() {
        return regrId;
    }

    public void setRegrId(Integer regrId) {
        this.regrId = regrId;
    }

    public Date getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(Date updDttm) {
        this.updDttm = updDttm;
    }

    public Integer getUpdrId() {
        return updrId;
    }

    public void setUpdrId(Integer updrId) {
        this.updrId = updrId;
    }

    public Date getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(Date delDttm) {
        this.delDttm = delDttm;
    }

    public Integer getDelrId() {
        return delrId;
    }

    public void setDelrId(Integer delrId) {
        this.delrId = delrId;
    }

    public char getDelYn() {
        return delYn;
    }

    public void setDelYn(char delYn) {
        this.delYn = delYn;
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
    public String toString() {
        return "NoticeDTO{" +
                "notcNo=" + notcNo +
                ", notcTp='" + notcTp + '\'' +
                ", notcTpNm='" + notcTpNm + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", viewCnt=" + viewCnt +
                ", fixYn=" + fixYn +
                ", startDttm=" + startDttm +
                ", endDttm=" + endDttm +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                ", delDttm=" + delDttm +
                ", delrId=" + delrId +
                ", delYn=" + delYn +
                ", prevTitle='" + prevTitle + '\'' +
                ", nextTitle='" + nextTitle + '\'' +
                ", prevNo=" + prevNo +
                ", nextNo=" + nextNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoticeDTO noticeDTO = (NoticeDTO) o;
        return fixYn == noticeDTO.fixYn && delYn == noticeDTO.delYn && Objects.equals(notcNo, noticeDTO.notcNo) && Objects.equals(notcTp, noticeDTO.notcTp) && Objects.equals(notcTpNm, noticeDTO.notcTpNm) && Objects.equals(title, noticeDTO.title) && Objects.equals(content, noticeDTO.content) && Objects.equals(viewCnt, noticeDTO.viewCnt) && Objects.equals(startDttm, noticeDTO.startDttm) && Objects.equals(endDttm, noticeDTO.endDttm) && Objects.equals(regDttm, noticeDTO.regDttm) && Objects.equals(regrId, noticeDTO.regrId) && Objects.equals(updDttm, noticeDTO.updDttm) && Objects.equals(updrId, noticeDTO.updrId) && Objects.equals(delDttm, noticeDTO.delDttm) && Objects.equals(delrId, noticeDTO.delrId) && Objects.equals(prevTitle, noticeDTO.prevTitle) && Objects.equals(nextTitle, noticeDTO.nextTitle) && Objects.equals(prevNo, noticeDTO.prevNo) && Objects.equals(nextNo, noticeDTO.nextNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notcNo, notcTp, notcTpNm, title, content, viewCnt, fixYn, startDttm, endDttm, regDttm, regrId, updDttm, updrId, delDttm, delrId, delYn, prevTitle, nextTitle, prevNo, nextNo);
    }
}

