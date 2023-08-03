package com.teamProject.syusyu.domain.product;

import java.util.Date;
import java.util.Objects;

public class ProdOptCombDTO {
    private int optCombNo;
    private int optItemId;
    private Date regDttm;
    private int regrId;
    private Date updDttm;
    private int updrId;
    private Date delDttm;
    private int dertId;
    private String delYn;

    public ProdOptCombDTO(){}
    public ProdOptCombDTO(int optCombNo, int optItemId, int regrId) {
        this.regrId = regrId;
        this.optItemId = optItemId;
        this.optCombNo = optCombNo;
    }

    public int getOptCombNo() {
        return optCombNo;
    }

    public void setOptCombNo(int optCombNo) {
        this.optCombNo = optCombNo;
    }

    public int getOptItemId() {
        return optItemId;
    }

    public void setOptItemId(int optItemId) {
        this.optItemId = optItemId;
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
        ProdOptCombDTO that = (ProdOptCombDTO) o;
        return optCombNo == that.optCombNo && optItemId == that.optItemId && regrId == that.regrId && updrId == that.updrId && dertId == that.dertId && Objects.equals(regDttm, that.regDttm) && Objects.equals(updDttm, that.updDttm) && Objects.equals(delDttm, that.delDttm) && Objects.equals(delYn, that.delYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optCombNo, optItemId, regDttm, regrId, updDttm, updrId, delDttm, dertId, delYn);
    }

    @Override
    public String toString() {
        return "ProdOptCombDTO{" +
                "optCombNo=" + optCombNo +
                ", optItemId=" + optItemId +
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
