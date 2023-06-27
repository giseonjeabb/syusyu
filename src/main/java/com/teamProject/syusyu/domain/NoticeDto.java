package com.teamProject.syusyu.domain;

import java.util.Date;
import java.util.Objects;

public class NoticeDto {

    private Integer notcNo;
    private String notcTp;
    private String title;
    private String content;
    private Integer viewCnt;
    private char fixYn;
    private Date startDttm;
    private Date endDttm;
    private Date regDttm;
    private Integer regrId;
    private Date updDttm;
    private Integer updrId;
    private Date delDttm;
    private Integer delrId;
    private char delYn;


    public NoticeDto(Integer notcNo, String notcTp, String title) {
        this.notcNo = notcNo;
        this.notcTp = notcTp;
        this.title = title;
    }

    public NoticeDto(Integer notcNo, Integer regrId) {
        this.notcNo = notcNo;
        this.regrId = regrId;
    }

    public NoticeDto(Integer notcNo, String notcTp) {
        this.notcNo = notcNo;
        this.notcTp = notcTp;
    }

    public NoticeDto(Integer notcNo, String notcTp, String title, String content, Integer viewCnt, char fixYn, Date startDttm, Date endDttm, Date regDttm, Integer regrId, Date updDttm, Integer updrId, Date delDttm, Integer delrId, char delYn) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoticeDto noticeDto = (NoticeDto) o;
        return fixYn == noticeDto.fixYn && delYn == noticeDto.delYn && Objects.equals(notcNo, noticeDto.notcNo) && Objects.equals(notcTp, noticeDto.notcTp) && Objects.equals(title, noticeDto.title) && Objects.equals(content, noticeDto.content) && Objects.equals(viewCnt, noticeDto.viewCnt) && Objects.equals(startDttm, noticeDto.startDttm) && Objects.equals(endDttm, noticeDto.endDttm) && Objects.equals(regDttm, noticeDto.regDttm) && Objects.equals(regrId, noticeDto.regrId) && Objects.equals(updDttm, noticeDto.updDttm) && Objects.equals(updrId, noticeDto.updrId) && Objects.equals(delDttm, noticeDto.delDttm) && Objects.equals(delrId, noticeDto.delrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notcNo, notcTp, title, content, viewCnt, fixYn, startDttm, endDttm, regDttm, regrId, updDttm, updrId, delDttm, delrId, delYn);
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
                '}';
    }
}

