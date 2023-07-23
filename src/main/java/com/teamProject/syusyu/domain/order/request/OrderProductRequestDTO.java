package com.teamProject.syusyu.domain.order.request;

public class OrderProductRequestDTO {
    private int prodId;
    private String prodNm;
    private Integer optCombNo;
    private int qty;

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

    public Integer getOptCombNo() {
        return optCombNo;
    }

    public void setOptCombNo(Integer optCombNo) {
        this.optCombNo = optCombNo;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "prodId=" + prodId +
                ", prodNm='" + prodNm + '\'' +
                ", optCombNo=" + optCombNo +
                ", qty=" + qty +
                '}';
    }

    public static final class Builder {
        private int prodId;
        private String prodNm;
        private Integer optCombNo;
        private int qty;

        private Builder() {
        }

        public static Builder anOrderProductRequestDTO() {
            return new Builder();
        }

        public Builder prodId(int prodId) {
            this.prodId = prodId;
            return this;
        }

        public Builder prodNm(String prodNm) {
            this.prodNm = prodNm;
            return this;
        }

        public Builder optCombNo(Integer optCombNo) {
            this.optCombNo = optCombNo;
            return this;
        }

        public Builder qty(int qty) {
            this.qty = qty;
            return this;
        }

        public OrderProductRequestDTO build() {
            OrderProductRequestDTO orderProductRequestDTO = new OrderProductRequestDTO();
            orderProductRequestDTO.setProdId(prodId);
            orderProductRequestDTO.setProdNm(prodNm);
            orderProductRequestDTO.setOptCombNo(optCombNo);
            orderProductRequestDTO.setQty(qty);
            return orderProductRequestDTO;
        }
    }
}
