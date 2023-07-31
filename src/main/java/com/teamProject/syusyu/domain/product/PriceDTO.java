package com.teamProject.syusyu.domain.product;

import java.util.Date;
import java.util.Objects;

public class PriceDTO {
    private int prcNo;
    private int prodId;
    private int salePrc;
    private int buyPrc;
    private int dcPer;
    private Date saleStDttm;
    private Date saleEdDttm;
    private Date dcStDttm;
    private Date dcEdDttm;
    private Date regDttm;
    private int regrId;
    private Date updDttm;
    private int updId;
    private Date delDttm;
    private int delrId;
    private String delYn;

    public PriceDTO() {
    }

    public PriceDTO(int prodId, int salePrc, int buyPrc, Integer dcPer, Date saleStDttm, Date saleEdDttm, Date dcStDttm, Date dcEdDttm, int regrId) {
        this.prodId = prodId;
        this.salePrc = salePrc;
        this.buyPrc = buyPrc;
        this.dcPer = dcPer;
        this.saleStDttm = saleStDttm;
        this.saleEdDttm = saleEdDttm;
        this.dcStDttm = dcStDttm;
        this.dcEdDttm = dcEdDttm;
        this.regrId = regrId;
    }

    public int getPrcNo() {
        return prcNo;
    }

    public void setPrcNo(int prcNo) {
        this.prcNo = prcNo;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getSalePrc() {
        return salePrc;
    }

    public void setSalePrc(int salePrc) {
        this.salePrc = salePrc;
    }

    public int getBuyPrc() {
        return buyPrc;
    }

    public void setBuyPrc(int buyPrc) {
        this.buyPrc = buyPrc;
    }

    public int getDcPer() {
        return dcPer;
    }

    public void setDcPer(int dcPer) {
        this.dcPer = dcPer;
    }

    public Date getSaleStDttm() {
        return saleStDttm;
    }

    public void setSaleStDttm(Date saleStDttm) {
        this.saleStDttm = saleStDttm;
    }

    public Date getSaleEdDttm() {
        return saleEdDttm;
    }

    public void setSaleEdDttm(Date saleEdDttm) {
        this.saleEdDttm = saleEdDttm;
    }

    public Date getDcStDttm() {
        return dcStDttm;
    }

    public void setDcStDttm(Date dcStDttm) {
        this.dcStDttm = dcStDttm;
    }

    public Date getDcEdDttm() {
        return dcEdDttm;
    }

    public void setDcEdDttm(Date dcEdDttm) {
        this.dcEdDttm = dcEdDttm;
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

    public int getUpdId() {
        return updId;
    }

    public void setUpdId(int updId) {
        this.updId = updId;
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
        PriceDTO priceDTO = (PriceDTO) o;
        return prcNo == priceDTO.prcNo && prodId == priceDTO.prodId && salePrc == priceDTO.salePrc && buyPrc == priceDTO.buyPrc && dcPer == priceDTO.dcPer && regrId == priceDTO.regrId && updId == priceDTO.updId && delrId == priceDTO.delrId && Objects.equals(saleStDttm, priceDTO.saleStDttm) && Objects.equals(saleEdDttm, priceDTO.saleEdDttm) && Objects.equals(dcStDttm, priceDTO.dcStDttm) && Objects.equals(dcEdDttm, priceDTO.dcEdDttm) && Objects.equals(regDttm, priceDTO.regDttm) && Objects.equals(updDttm, priceDTO.updDttm) && Objects.equals(delDttm, priceDTO.delDttm) && Objects.equals(delYn, priceDTO.delYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prcNo, prodId, salePrc, buyPrc, dcPer, saleStDttm, saleEdDttm, dcStDttm, dcEdDttm, regDttm, regrId, updDttm, updId, delDttm, delrId, delYn);
    }

    @Override
    public String toString() {
        return "PriceDTO{" +
                "prcNo=" + prcNo +
                ", prodId=" + prodId +
                ", salePrc=" + salePrc +
                ", buyPrc=" + buyPrc +
                ", dcPer=" + dcPer +
                ", saleStDttm=" + saleStDttm +
                ", saleEdDttm=" + saleEdDttm +
                ", dcStDttm=" + dcStDttm +
                ", dcEdDttm=" + dcEdDttm +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updId=" + updId +
                ", delDttm=" + delDttm +
                ", delrId=" + delrId +
                ", delYn='" + delYn + '\'' +
                '}';
    }
}
