package com.teamProject.syusyu.domain.order;


import java.util.Objects;

public class CartProductDTO {
    private int cartProdNo;
    private int cartId;
    private int prodId;
    private String prodNm;
    private int qty;
    private int salePrc;
    private String repImg;

    public CartProductDTO() {}

    public CartProductDTO(int cartId, int prodId, String prodNm, int qty, int salePrc, String repImg) {
        this.cartId = cartId;
        this.prodId = prodId;
        this.prodNm = prodNm;
        this.qty = qty;
        this.salePrc = salePrc;
        this.repImg = repImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProductDTO that = (CartProductDTO) o;
        return cartProdNo == that.cartProdNo && cartId == that.cartId && prodId == that.prodId && qty == that.qty && salePrc == that.salePrc && Objects.equals(prodNm, that.prodNm) && Objects.equals(repImg, that.repImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartProdNo, cartId, prodId, prodNm, qty, salePrc, repImg);
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

    public String getRepImg() {
        return repImg;
    }

    public void setRepImg(String repImg) {
        this.repImg = repImg;
    }

    @Override
    public String toString() {
        return "CartProductDTO{" +
                "cartProdNo=" + cartProdNo +
                ", cartId=" + cartId +
                ", prodId=" + prodId +
                ", prodNm='" + prodNm + '\'' +
                ", qty=" + qty +
                ", salePrc=" + salePrc +
                ", repImg='" + repImg + '\'' +
                '}';
    }
}
