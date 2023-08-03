package com.teamProject.syusyu.domain.product;

import java.util.Date;
import java.util.Objects;

public class OptItemDTO {
    private int optItemId;
    private String optItemNm;
    private int optGrpId;

    private Date regDttm;
    private int regrId;
    private Date updDttm;
    private int updrId;
    private Date delDttm;
    private int dertId;
    private String delYn;

    public OptItemDTO() {
    }

    public OptItemDTO(String optItemNm, int optGrpId, int regrId){
        this.optItemNm=optItemNm;
        this.optGrpId=optGrpId;
        this.regrId=regrId;
    }

    public OptItemDTO(String s, String s1, int i) {
    }

    public int getOptItemId() {
        return optItemId;
    }

    public void setOptItemId(int optItemId) {
        this.optItemId = optItemId;
    }

    public String getOptItemNm() {
        return optItemNm;
    }

    public void setOptItemNm(String optItemNm) {
        this.optItemNm = optItemNm;
    }

    public int getOptGrpId() {
        return optGrpId;
    }

    public void setOptGrpId(int optGrpId) {
        this.optGrpId = optGrpId;
    }

    public Date getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    public int getRegrId() {
        return regrId;
    }

    public void setRegrId(int regrId) {
        this.regrId = regrId;
    }

    public Date getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(Date updDttm) {
        this.updDttm = updDttm;
    }

    public int getUpdrId() {
        return updrId;
    }

    public void setUpdrId(int updrId) {
        this.updrId = updrId;
    }

    public Date getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(Date delDttm) {
        this.delDttm = delDttm;
    }

    public int getDertId() {
        return dertId;
    }

    public void setDertId(int dertId) {
        this.dertId = dertId;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptItemDTO that = (OptItemDTO) o;
        return optItemId == that.optItemId && optGrpId == that.optGrpId && regrId == that.regrId && updrId == that.updrId && dertId == that.dertId && Objects.equals(optItemNm, that.optItemNm) && Objects.equals(regDttm, that.regDttm) && Objects.equals(updDttm, that.updDttm) && Objects.equals(delDttm, that.delDttm) && Objects.equals(delYn, that.delYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optItemId, optItemNm, optGrpId, regDttm, regrId, updDttm, updrId, delDttm, dertId, delYn);
    }

    @Override
    public String toString() {
        return "OptItemDTO{" +
                "optItemId=" + optItemId +
                ", optItemNm='" + optItemNm + '\'' +
                ", optGrpId=" + optGrpId +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                ", delDttm=" + delDttm +
                ", dertId=" + dertId +
                ", delYn='" + delYn + '\'' +
                '}';
    }
}
