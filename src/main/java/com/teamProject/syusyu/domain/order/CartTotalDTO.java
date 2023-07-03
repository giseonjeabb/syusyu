package com.teamProject.syusyu.domain.order;

import java.util.Objects;

public class CartTotalDTO {
    int cartTotPrc;
    int cartTotDcPrc;
    int cartTotDcAplPrc;
    int dlvFee;
    int cartPayAmt;

    public CartTotalDTO() {}

    public CartTotalDTO(int cartTotPrc, int cartTotDcPrc, int cartTotDcAplPrc, int dlvFee, int cartPayAmt) {
        this.cartTotPrc = cartTotPrc;
        this.cartTotDcPrc = cartTotDcPrc;
        this.cartTotDcAplPrc = cartTotDcAplPrc;
        this.dlvFee = dlvFee;
        this.cartPayAmt = cartPayAmt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartTotalDTO that = (CartTotalDTO) o;
        return cartTotPrc == that.cartTotPrc && cartTotDcPrc == that.cartTotDcPrc && cartTotDcAplPrc == that.cartTotDcAplPrc && dlvFee == that.dlvFee && cartPayAmt == that.cartPayAmt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartTotPrc, cartTotDcPrc, cartTotDcAplPrc, dlvFee, cartPayAmt);
    }

    public int getCartTotPrc() {
        return cartTotPrc;
    }

    public void setCartTotPrc(int cartTotPrc) {
        this.cartTotPrc = cartTotPrc;
    }

    public int getCartTotDcPrc() {
        return cartTotDcPrc;
    }

    public void setCartTotDcPrc(int cartTotDcPrc) {
        this.cartTotDcPrc = cartTotDcPrc;
    }

    public int getCartTotDcAplPrc() {
        return cartTotDcAplPrc;
    }

    public void setCartTotDcAplPrc(int cartTotDcAplPrc) {
        this.cartTotDcAplPrc = cartTotDcAplPrc;
    }

    public int getDlvFee() {
        return dlvFee;
    }

    public void setDlvFee(int dlvFee) {
        this.dlvFee = dlvFee;
    }

    public int getCartPayAmt() {
        return cartPayAmt;
    }

    public void setCartPayAmt(int cartPayAmt) {
        this.cartPayAmt = cartPayAmt;
    }

    @Override
    public String toString() {
        return "CartTotalDTO{" +
                "cartTotPrc=" + cartTotPrc +
                ", cartTotDcPrc=" + cartTotDcPrc +
                ", cartTotDcAplPrc=" + cartTotDcAplPrc +
                ", dlvFee=" + dlvFee +
                ", cartPayAmt=" + cartPayAmt +
                '}';
    }
}
