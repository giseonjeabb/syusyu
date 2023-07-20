package com.teamProject.syusyu.domain.cs;

import java.time.LocalDateTime;
import java.util.Objects;

public class NoticeDTO {

    private Integer notcNo;
    private String notcTp;
    private String title;
    private String content;
    private Integer viewCnt;
    private char fixYn;
    private LocalDateTime startDttm;
    private LocalDateTime endDttm;
    private LocalDateTime regDttm;
    private Integer regrId;
    private LocalDateTime updDttm;
    private Integer updrId;
    private LocalDateTime delDttm;
    private Integer delrId;
    private char delYn;

    private String prevTitle;
    private String nextTitle;
    private Integer prevNo;
    private Integer nextNo;




    public NoticeDTO(){}



    public NoticeDTO(Integer notcNo, String notcTp, String title, String content, Integer viewCnt, LocalDateTime startDttm, LocalDateTime endDttm, LocalDateTime regDttm) {
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

    public NoticeDTO(Integer notcNo, String notcTp, String title, String content,
                     Integer viewCnt, char fixYn, LocalDateTime startDttm, LocalDateTime endDttm, LocalDateTime regDttm,
                     Integer regrId, LocalDateTime updDttm, Integer updrId, LocalDateTime delDttm, Integer delrId,
                     char delYn, String prevTitle, String nextTitle, Integer prevNo, Integer nextNo) {
        this.notcNo = notcNo;
        this.notcTp = notcTp;
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



    @Override
    public String toString() {
        return "NoticeDto{" +
                "notcNo=" + notcNo +
                ", notcTp='" + notcTp + '\'' +
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
        NoticeDTO noticeDto = (NoticeDTO) o;
        return fixYn == noticeDto.fixYn && delYn == noticeDto.delYn && Objects.equals(notcNo, noticeDto.notcNo) && Objects.equals(notcTp, noticeDto.notcTp) && Objects.equals(title, noticeDto.title) && Objects.equals(content, noticeDto.content) && Objects.equals(viewCnt, noticeDto.viewCnt) && Objects.equals(startDttm, noticeDto.startDttm) && Objects.equals(endDttm, noticeDto.endDttm) && Objects.equals(regDttm, noticeDto.regDttm) && Objects.equals(regrId, noticeDto.regrId) && Objects.equals(updDttm, noticeDto.updDttm) && Objects.equals(updrId, noticeDto.updrId) && Objects.equals(delDttm, noticeDto.delDttm) && Objects.equals(delrId, noticeDto.delrId) && Objects.equals(prevTitle, noticeDto.prevTitle) && Objects.equals(nextTitle, noticeDto.nextTitle) && Objects.equals(prevNo, noticeDto.prevNo) && Objects.equals(nextNo, noticeDto.nextNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notcNo, notcTp, title, content, viewCnt, fixYn, startDttm, endDttm, regDttm, regrId, updDttm, updrId, delDttm, delrId, delYn, prevTitle, nextTitle, prevNo, nextNo);
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

    public LocalDateTime getStartDttm() {
        return startDttm;
    }

    public void setStartDttm(LocalDateTime startDttm) {
        this.startDttm = startDttm;
    }

    public LocalDateTime getEndDttm() {
        return endDttm;
    }

    public void setEndDttm(LocalDateTime endDttm) {
        this.endDttm = endDttm;
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

    public LocalDateTime getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(LocalDateTime delDttm) {
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
}

