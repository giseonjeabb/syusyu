package com.teamProject.syusyu.domain.order;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class OrderInfoDTO {
    private int ordNo;          // 주문번호
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ordDttm;  // 주문일시
    private int prodId;         // 상품아이디
    private String prodNm;      // 상품명
    private String ordStusNm;     // 주문상태
    private int qty;            // 수량
    private int prodAmt;        // 상품금액 (할인가격 + 옵션가) * 주문수량
    private String optNm;       // 옵션명
    private String payTp;       // 결제방법
    private int realPayAmt;     // 결제금액
    private String repImg;      // 이미지

    OrderInfoDTO() {
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
    }

    public LocalDateTime getOrdDttm() {
        return ordDttm;
    }

    public void setOrdDttm(LocalDateTime ordDttm) {
        this.ordDttm = ordDttm;
    }

    public String getProdNm() {
        return prodNm;
    }

    public void setProdNm(String prodNm) {
        this.prodNm = prodNm;
    }

    public String getOrdStusNm() {
        return ordStusNm;
    }

    public void setOrdStusNm(String ordStusNm) {
        this.ordStusNm = ordStusNm;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getProdAmt() {
        return prodAmt;
    }

    public void setProdAmt(int prodAmt) {
        this.prodAmt = prodAmt;
    }

    public String getOptNm() {
        return optNm;
    }

    public void setOptNm(String optNm) {
        this.optNm = optNm;
    }

    public String getPayTp() {
        return payTp;
    }

    public void setPayTp(String payTp) {
        this.payTp = payTp;
    }

    public int getRealPayAmt() {
        return realPayAmt;
    }

    public void setRealPayAmt(int realPayAmt) {
        this.realPayAmt = realPayAmt;
    }

    public String getRepImg() {
        return repImg;
    }

    public void setRepImg(String repImg) {
        this.repImg = repImg;
    }

    @Override
    public String toString() {
        return "OrderInfoDTO{" +
                "ordNo=" + ordNo +
                ", ordDttm=" + ordDttm +
                ", prodNm='" + prodNm + '\'' +
                ", ordStusNm='" + ordStusNm + '\'' +
                ", qty=" + qty +
                ", prodAmt=" + prodAmt +
                ", optNm='" + optNm + '\'' +
                ", payTp='" + payTp + '\'' +
                ", realPayAmt=" + realPayAmt +
                ", repImg='" + repImg + '\'' +
                '}';
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }
}
