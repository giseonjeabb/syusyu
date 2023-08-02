package com.teamProject.syusyu.domain.product;

import java.util.Date;
import java.util.Objects;

public class ProdOptDTO {

    private String optItemNm;

    //옵션조합번호
    private int optCombNo;

    //상품옵션
    private int optPrc;
    private int invQty;
    private int prodId;
    private String shoesSize;

    private Date regDttm;
    private int regrId;
    private Date updDttm;
    private int updrId;
    private Date delDttm;
    private int delrId;
    private String delYn;

    public ProdOptDTO() {
    }

    public ProdOptDTO(int optPrc, int optCombNo, int invQty, String shoesSize) {
        this.optPrc = optPrc;
        this.optCombNo = optCombNo;
        this.invQty = invQty;
        this.shoesSize = shoesSize;
    }


    public ProdOptDTO(int prodId, int regrId, int optCombNo, int optPrc, int invQty) {
        this.prodId = prodId;
        this.regrId = regrId;
        this.optCombNo = optCombNo;
        this.optPrc = optPrc;
        this.invQty = invQty;
    }


    public String getOptItemNm() {
        return optItemNm;
    }

    public void setOptItemNm(String optItemNm) {
        this.optItemNm = optItemNm;
    }

    public int getOptCombNo() {
        return optCombNo;
    }

    public void setOptCombNo(int optCombNo) {
        this.optCombNo = optCombNo;
    }

    public int getOptPrc() {
        return optPrc;
    }

    public void setOptPrc(int optPrc) {
        this.optPrc = optPrc;
    }

    public int getInvQty() {
        return invQty;
    }

    public void setInvQty(int invQty) {
        this.invQty = invQty;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getShoesSize() {
        return shoesSize;
    }

    public void setShoesSize(String shoesSize) {
        this.shoesSize = shoesSize;
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

    public int getDelrId() {
        return delrId;
    }

    public void setDelrId(int delrId) {
        this.delrId = delrId;
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
        ProdOptDTO that = (ProdOptDTO) o;
        return optCombNo == that.optCombNo && optPrc == that.optPrc && invQty == that.invQty && prodId == that.prodId && regrId == that.regrId && updrId == that.updrId && delrId == that.delrId && Objects.equals(optItemNm, that.optItemNm) && Objects.equals(shoesSize, that.shoesSize) && Objects.equals(regDttm, that.regDttm) && Objects.equals(updDttm, that.updDttm) && Objects.equals(delDttm, that.delDttm) && Objects.equals(delYn, that.delYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optItemNm, optCombNo, optPrc, invQty, prodId, shoesSize, regDttm, regrId, updDttm, updrId, delDttm, delrId, delYn);
    }

    @Override
    public String toString() {
        return "ProdOptDTO{" +
                "optItemNm='" + optItemNm + '\'' +
                ", optCombNo=" + optCombNo +
                ", optPrc=" + optPrc +
                ", invQty=" + invQty +
                ", prodId=" + prodId +
                ", shoesSize='" + shoesSize + '\'' +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                ", delDttm=" + delDttm +
                ", delrId=" + delrId +
                ", delYn='" + delYn + '\'' +
                '}';
    }
}
