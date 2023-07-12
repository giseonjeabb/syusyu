package com.teamProject.syusyu.domain.order;

public class OrderProductRequestDTO {
    private int prodId;
    private String prodNm;
    private Integer optCombNo;
    private int prodPrc;
    private Integer dcPer;
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

    public int getprodPrc() {
        return prodPrc;
    }

    public void setprodPrc(int prodPrc) {
        this.prodPrc = prodPrc;
    }

    public Integer getDcPer() {
        return dcPer;
    }

    public void setDcPer(Integer dcPer) {
        this.dcPer = dcPer;
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
                ", prodPrc=" + prodPrc +
                ", dcPer=" + dcPer +
                ", qty=" + qty +
                '}';
    }
}
