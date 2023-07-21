package com.teamProject.syusyu.domain.product;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProdOptDTO {
    //그룹 옵션
    private int optGrpId;
    private String optGrpNm;

    //옵션항목
    private int optItemId;
    private String optItemNm;

    //옵션조합번호
    private int optCombNo;

    //상품옵션
    private int optPrc;
    private int invQty;
    private int prodId;
    private String shoesSize;

    private LocalDateTime regDttm;
    private int regrId;
    private LocalDateTime updDttm;
    private int updrId;
    private LocalDateTime delDttm;
    private int dertId;
    private String delYn;

    public ProdOptDTO(){}

    public ProdOptDTO(int optPrc, int invQty, String shoesSize) {
        this.optPrc = optPrc;
        this.invQty = invQty;
        this.shoesSize = shoesSize;
    }

    @Override
    public String toString() {
        return "ProdOptDTO{" +
                "optGrpId=" + optGrpId +
                ", optGrpNm='" + optGrpNm + '\'' +
                ", optItemId=" + optItemId +
                ", optItemNm='" + optItemNm + '\'' +
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
                ", dertId=" + dertId +
                ", delYn='" + delYn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdOptDTO that = (ProdOptDTO) o;
        return optGrpId == that.optGrpId && optItemId == that.optItemId && optCombNo == that.optCombNo && optPrc == that.optPrc && invQty == that.invQty && prodId == that.prodId && regrId == that.regrId && updrId == that.updrId && dertId == that.dertId && Objects.equals(optGrpNm, that.optGrpNm) && Objects.equals(optItemNm, that.optItemNm) && Objects.equals(shoesSize, that.shoesSize) && Objects.equals(regDttm, that.regDttm) && Objects.equals(updDttm, that.updDttm) && Objects.equals(delDttm, that.delDttm) && Objects.equals(delYn, that.delYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optGrpId, optGrpNm, optItemId, optItemNm, optCombNo, optPrc, invQty, prodId, shoesSize, regDttm, regrId, updDttm, updrId, delDttm, dertId, delYn);
    }

    public String getShoesSize() {
        return shoesSize;
    }

    public void setShoesSize(String shoesSize) {
        this.shoesSize = shoesSize;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getOptGrpId() {
        return optGrpId;
    }

    public void setOptGrpId(int optGrpId) {
        this.optGrpId = optGrpId;
    }

    public String getOptGrpNm() {
        return optGrpNm;
    }

    public void setOptGrpNm(String optGrpNm) {
        this.optGrpNm = optGrpNm;
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

    public LocalDateTime getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(LocalDateTime regDttm) {
        this.regDttm = regDttm;
    }

    public int getRegrId() {
        return regrId;
    }

    public void setRegrId(int regrId) {
        this.regrId = regrId;
    }

    public LocalDateTime getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(LocalDateTime updDttm) {
        this.updDttm = updDttm;
    }

    public int getUpdrId() {
        return updrId;
    }

    public void setUpdrId(int updrId) {
        this.updrId = updrId;
    }

    public LocalDateTime getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(LocalDateTime delDttm) {
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
}
