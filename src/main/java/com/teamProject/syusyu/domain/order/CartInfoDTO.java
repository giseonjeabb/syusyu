package com.teamProject.syusyu.domain.order;

import java.util.List;
import java.util.Objects;

public class CartInfoDTO {
    private List<CartProductDTO> cartProduct;
    private CartTotalDTO cartTotal;

    public CartInfoDTO() {}

    public CartInfoDTO(List<CartProductDTO> cartProducts, CartTotalDTO cartTotal) {
        this.cartProduct = cartProducts;
        this.cartTotal = cartTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartInfoDTO that = (CartInfoDTO) o;
        return Objects.equals(cartProduct, that.cartProduct) && Objects.equals(cartTotal, that.cartTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartProduct, cartTotal);
    }

    public List<CartProductDTO> getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(List<CartProductDTO> cartProduct) {
        this.cartProduct = cartProduct;
    }

    public CartTotalDTO getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(CartTotalDTO cartTotal) {
        this.cartTotal = cartTotal;
    }

    @Override
    public String toString() {
        return "CartInfoDTO{" +
                "cartProducts=" + cartProduct +
                ", cartTotal=" + cartTotal +
                '}';
    }
}
