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
    private int totDcPrc;
    private int totDcAplPrc;
    private int invQty;
    private String repImg;
    private int regrId;
    private LocalDateTime regDttm;
    private Integer updrId;
    private LocalDateTime updDttm;
    private Integer delrId;
    private LocalDateTime delDttm;

    public CartProdDTO() {
    }

    public CartProdDTO(int cartId, int prodId, int qty, Integer optCombNo, int regrId, Integer updrId, Integer delrId) {
        this.cartId = cartId;
        this.prodId = prodId;
        this.qty = qty;
        this.optCombNo = optCombNo;
        this.regrId = regrId;
        this.updrId = updrId;
        this.delrId = delrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProdDTO that = (CartProdDTO) o;
        return cartProdNo == that.cartProdNo && cartId == that.cartId && prodId == that.prodId && qty == that.qty && regrId == that.regrId && Objects.equals(optCombNo, that.optCombNo) && Objects.equals(updrId, that.updrId) && Objects.equals(delrId, that.delrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartProdNo, cartId, prodId, qty, optCombNo, regrId, updrId, delrId);
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

    public int getTotDcAplPrc() {
        return totDcAplPrc;
    }

    public void setTotDcAplPrc(int totDcAplPrc) {
        this.totDcAplPrc = totDcAplPrc;
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



    public int getTotDcPrc() {
        return totDcPrc;
    }

    public void setTotDcPrc(int totDcPrc) {
        this.totDcPrc = totDcPrc;
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
                '}';
    }
}
