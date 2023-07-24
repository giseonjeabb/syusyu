package com.teamProject.syusyu.domain.product;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class CategoryDTO {
    private int cateId;
    private String largeNm;
    private int largeNo;
    private String middleNm;
    private int middleNo;
    private String smallNm;
    private int smallNo;
    private boolean dspyYn;
    private String regrId;
    private Date regDttm;
    private String updrId;
    private Date updDttm;
    private Date delDttm;
    private String delrId;
    private boolean deletionYn;

    public CategoryDTO() {
    }

    public CategoryDTO(String largeNm, int largeNo, String middleNm, int middleNo, String smallNm, int smallNo) {
        this.largeNm = largeNm;
        this.largeNo = largeNo;
        this.middleNm = middleNm;
        this.middleNo = middleNo;
        this.smallNm = smallNm;
        this.smallNo = smallNo;
    }

    public CategoryDTO(int cateId, String largeNm, int largeNo, String middleNm, int middleNo, String smallNm, int smallNo, boolean dspyYn, String regrId, Date regDttm, String updrId, Date updDttm, Date delDttm, String delrId, boolean deletionYn) {
        this.cateId = cateId;
        this.largeNm = largeNm;
        this.largeNo = largeNo;
        this.middleNm = middleNm;
        this.middleNo = middleNo;
        this.smallNm = smallNm;
        this.smallNo = smallNo;
        this.dspyYn = dspyYn;
        this.regrId = regrId;
        this.regDttm = regDttm;
        this.updrId = updrId;
        this.updDttm = updDttm;
        this.delDttm = delDttm;
        this.delrId = delrId;
        this.deletionYn = deletionYn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDTO that = (CategoryDTO) o;
        return cateId == that.cateId && largeNo == that.largeNo && middleNo == that.middleNo && smallNo == that.smallNo && dspyYn == that.dspyYn && deletionYn == that.deletionYn && Objects.equals(largeNm, that.largeNm) && Objects.equals(middleNm, that.middleNm) && Objects.equals(smallNm, that.smallNm) && Objects.equals(regrId, that.regrId) && Objects.equals(regDttm, that.regDttm) && Objects.equals(updrId, that.updrId) && Objects.equals(updDttm, that.updDttm) && Objects.equals(delDttm, that.delDttm) && Objects.equals(delrId, that.delrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cateId, largeNm, largeNo, middleNm, middleNo, smallNm, smallNo, dspyYn, regrId, regDttm, updrId, updDttm, delDttm, delrId, deletionYn);
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getLargeNm() {
        return largeNm;
    }

    public void setLargeNm(String largeNm) {
        this.largeNm = largeNm;
    }

    public int getLargeNo() {
        return largeNo;
    }

    public void setLargeNo(int largeNo) {
        this.largeNo = largeNo;
    }

    public String getMiddleNm() {
        return middleNm;
    }

    public void setMiddleNm(String middleNm) {
        this.middleNm = middleNm;
    }

    public int getMiddleNo() {
        return middleNo;
    }

    public void setMiddleNo(int middleNo) {
        this.middleNo = middleNo;
    }

    public String getSmallNm() {
        return smallNm;
    }

    public void setSmallNm(String smallNm) {
        this.smallNm = smallNm;
    }

    public int getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(int smallNo) {
        this.smallNo = smallNo;
    }

    public boolean isDspyYn() {
        return dspyYn;
    }

    public void setDspyYn(boolean dspyYn) {
        this.dspyYn = dspyYn;
    }

    public String getRegrId() {
        return regrId;
    }

    public void setRegrId(String regrId) {
        this.regrId = regrId;
    }

    public Date getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    public String getUpdrId() {
        return updrId;
    }

    public void setUpdrId(String updrId) {
        this.updrId = updrId;
    }

    public Date getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(Date updDttm) {
        this.updDttm = updDttm;
    }

    public Date getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(Date delDttm) {
        this.delDttm = delDttm;
    }

    public String getDelrId() {
        return delrId;
    }

    public void setDelrId(String delrId) {
        this.delrId = delrId;
    }

    public boolean isDeletionYn() {
        return deletionYn;
    }

    public void setDeletionYn(boolean deletionYn) {
        this.deletionYn = deletionYn;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "cateId=" + cateId +
                ", largeNm='" + largeNm + '\'' +
                ", largeNo=" + largeNo +
                ", middleNm='" + middleNm + '\'' +
                ", middleNo=" + middleNo +
                ", smallNm='" + smallNm + '\'' +
                ", smallNo=" + smallNo +
                ", dspyYn=" + dspyYn +
                ", regrId='" + regrId + '\'' +
                ", regDttm=" + regDttm +
                ", updrId='" + updrId + '\'' +
                ", updDttm=" + updDttm +
                ", delDttm=" + delDttm +
                ", delrId='" + delrId + '\'' +
                ", deletionYn=" + deletionYn +
                '}';
    }
}