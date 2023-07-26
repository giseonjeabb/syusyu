package com.teamProject.syusyu.domain.order;


import java.time.LocalDateTime;
import java.util.Objects;

public class CartProdDTO {
    private int cartProdNo;
    private int cartId;
    private int prodId;
    private String prodNm;
    private int qty;
    private int salePrc;
    private Integer optCombNo;
    private String opt;
    private int totPrc;
    private int totOptPrc;
    private int totDcAmt;
    private int totDcPrc;
    private int invQty;
    private String repImg;
    private int regrId;
    private LocalDateTime regDttm;
    private Integer updrId;
    private LocalDateTime updDttm;
    private Integer delrId;
    private LocalDateTime delDttm;
    private int mbrId;

    public CartProdDTO() {
    }

    public CartProdDTO(int mbrId) {
        this.mbrId = mbrId;
    }

    public CartProdDTO(int regrId, int mbrId) {
        this.regrId = regrId;
        this.mbrId = mbrId;
    }
    public CartProdDTO(int prodId, int qty, Integer optCombNo, int regrId, int mbrId) {
        this.prodId = prodId;
        this.qty = qty;
        this.optCombNo = optCombNo;
        this.regrId = regrId;
        this.mbrId = mbrId;
    }


    public CartProdDTO(int cartId, int prodId, int qty, Integer optCombNo, int regrId, Integer updrId, Integer delrId, int mbrId) {
        this.cartId = cartId;
        this.prodId = prodId;
        this.qty = qty;
        this.optCombNo = optCombNo;
        this.regrId = regrId;
        this.updrId = updrId;
        this.delrId = delrId;
        this.mbrId = mbrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProdDTO that = (CartProdDTO) o;
        return cartProdNo == that.cartProdNo && cartId == that.cartId && prodId == that.prodId && qty == that.qty && salePrc == that.salePrc && totPrc == that.totPrc && totOptPrc == that.totOptPrc && totDcAmt == that.totDcAmt && totDcPrc == that.totDcPrc && invQty == that.invQty && regrId == that.regrId && mbrId == that.mbrId && Objects.equals(prodNm, that.prodNm) && Objects.equals(optCombNo, that.optCombNo) && Objects.equals(opt, that.opt) && Objects.equals(repImg, that.repImg) && Objects.equals(regDttm, that.regDttm) && Objects.equals(updrId, that.updrId) && Objects.equals(updDttm, that.updDttm) && Objects.equals(delrId, that.delrId) && Objects.equals(delDttm, that.delDttm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartProdNo, cartId, prodId, prodNm, qty, salePrc, optCombNo, opt, totPrc, totOptPrc, totDcAmt, totDcPrc, invQty, repImg, regrId, regDttm, updrId, updDttm, delrId, delDttm, mbrId);
    }

    public int getMbrId() {
        return mbrId;
    }

    public void setMbrId(int mbrId) {
        this.mbrId = mbrId;
    }

    public int getCartProdNo() {
        return cartProdNo;
    }

    public void setCartProdNo(int cartProdNo) {
        this.cartProdNo = cartProdNo;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdNm() {
        return prodNm;
    }

    public void setProdNm(String prodNm) {
        this.prodNm = prodNm;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getSalePrc() {
        return salePrc;
    }

    public void setSalePrc(int salePrc) {
        this.salePrc = salePrc;
    }

    public Integer getOptCombNo() {
        return optCombNo;
    }

    public void setOptCombNo(Integer optCombNo) {
        this.optCombNo = optCombNo;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public int getTotOptPrc() {
        return totOptPrc;
    }

    public void setTotOptPrc(int totOptPrc) {
        this.totOptPrc = totOptPrc;
    }

    public int getTotPrc() {
        return totPrc;
    }

    public void setTotPrc(int totPrc) {
        this.totPrc = totPrc;
    }

    public int getTotDcPrc() {
        return totDcPrc;
    }

    public void setTotDcPrc(int totDcPrc) {
        this.totDcPrc = totDcPrc;
    }

    public int getInvQty() {
        return invQty;
    }

    public void setInvQty(int invQty) {
        this.invQty = invQty;
    }

    public String getRepImg() {
        return repImg;
    }

    public void setRepImg(String repImg) {
        this.repImg = repImg;
    }

    public int getRegrId() {
        return regrId;
    }

    public void setRegrId(int regrId) {
        this.regrId = regrId;
    }

    public Integer getUpdrId() {
        return updrId;
    }

    public void setUpdrId(Integer updrId) {
        this.updrId = updrId;
    }

    public Integer getDelrId() {
        return delrId;
    }

    public void setDelrId(Integer delrId) {
        this.delrId = delrId;
    }

    public LocalDateTime getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(LocalDateTime regDttm) {
        this.regDttm = regDttm;
    }

    public LocalDateTime getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(LocalDateTime updDttm) {
        this.updDttm = updDttm;
    }

    public LocalDateTime getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(LocalDateTime delDttm) {
        this.delDttm = delDttm;
    }



    public int getTotDcAmt() {
        return totDcAmt;
    }

    public void setTotDcAmt(int totDcAmt) {
        this.totDcAmt = totDcAmt;
    }

    @Override
    public String toString() {
        return "CartProdDTO{" +
                "cartProdNo=" + cartProdNo +
                ", cartId=" + cartId +
                ", prodId=" + prodId +
                ", qty=" + qty +
                ", optCombNo=" + optCombNo +
                ", regrId=" + regrId +
                ", updrId=" + updrId +
                ", delrId=" + delrId +
                ", mbrId=" + mbrId +
                '}';
    }
}
