package com.teamProject.syusyu.domain.order;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderInfoDTO {
    private int ordNo; // 주문번호
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ordDttm; // 주문일시
    private int prodId; // 상품아이디
    private String prodNm; // 상품명
    private String ordStus; // 주문상태
    private String ordStusNm; // 주문상태명
    private int qty; // 수량
    private int prodAmt; // 상품금액 (할인가격 + 옵션가) * 주문수량
    private String optNm; // 옵션명
    private String payTp; // 결제방법
    private int realPayAmt; // 결제금액
    private String repImg; // 이미지
    private int ordDtlNo; // 주문상세번호
    private String claimStus; // 클레임 처리상태
    private String ordrNm; // 구매자명
    private String recipient; // 수령인

    OrderInfoDTO() {
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
    }

    public Date getOrdDttm() {
        return ordDttm;
    }

    public void setOrdDttm(Date ordDttm) {
        this.ordDttm = ordDttm;
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

    public String getOrdStus() {
        return ordStus;
    }

    public void setOrdStus(String ordStus) {
        this.ordStus = ordStus;
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

    public int getOrdDtlNo() {
        return ordDtlNo;
    }

    public void setOrdDtlNo(int ordDtlNo) {
        this.ordDtlNo = ordDtlNo;
    }

    public String getClaimStus() {
        return claimStus;
    }

    public void setClaimStus(String claimStus) {
        this.claimStus = claimStus;
    }

    public String getOrdrNm() {
        return ordrNm;
    }

    public void setOrdrNm(String ordrNm) {
        this.ordrNm = ordrNm;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "OrderInfoDTO{" +
                "ordNo=" + ordNo +
                ", ordDttm=" + ordDttm +
                ", prodId=" + prodId +
                ", prodNm='" + prodNm + '\'' +
                ", ordStus='" + ordStus + '\'' +
                ", ordStusNm='" + ordStusNm + '\'' +
                ", qty=" + qty +
                ", prodAmt=" + prodAmt +
                ", optNm='" + optNm + '\'' +
                ", payTp='" + payTp + '\'' +
                ", realPayAmt=" + realPayAmt +
                ", repImg='" + repImg + '\'' +
                ", ordDtlNo=" + ordDtlNo +
                ", claimStus='" + claimStus + '\'' +
                ", ordrNm='" + ordrNm + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }


    public static final class Builder {
        private int ordNo;
        private Date ordDttm;
        private int prodId;
        private String prodNm;
        private String ordStus;
        private String ordStusNm;
        private int qty;
        private int prodAmt;
        private String optNm;
        private String payTp;
        private int realPayAmt;
        private String repImg;
        private int ordDtlNo;
        private String claimStus;
        private String ordrNm;
        private String recipient;

        private Builder() {
        }

        public static Builder anOrderInfoDTO() {
            return new Builder();
        }

        public Builder ordNo(int ordNo) {
            this.ordNo = ordNo;
            return this;
        }

        public Builder ordDttm(Date ordDttm) {
            this.ordDttm = ordDttm;
            return this;
        }

        public Builder prodId(int prodId) {
            this.prodId = prodId;
            return this;
        }

        public Builder prodNm(String prodNm) {
            this.prodNm = prodNm;
            return this;
        }

        public Builder ordStus(String ordStus) {
            this.ordStus = ordStus;
            return this;
        }

        public Builder ordStusNm(String ordStusNm) {
            this.ordStusNm = ordStusNm;
            return this;
        }

        public Builder qty(int qty) {
            this.qty = qty;
            return this;
        }

        public Builder prodAmt(int prodAmt) {
            this.prodAmt = prodAmt;
            return this;
        }

        public Builder optNm(String optNm) {
            this.optNm = optNm;
            return this;
        }

        public Builder payTp(String payTp) {
            this.payTp = payTp;
            return this;
        }

        public Builder realPayAmt(int realPayAmt) {
            this.realPayAmt = realPayAmt;
            return this;
        }

        public Builder repImg(String repImg) {
            this.repImg = repImg;
            return this;
        }

        public Builder ordDtlNo(int ordDtlNo) {
            this.ordDtlNo = ordDtlNo;
            return this;
        }

        public Builder claimStus(String claimStus) {
            this.claimStus = claimStus;
            return this;
        }

        public Builder ordrNm(String ordrNm) {
            this.ordrNm = ordrNm;
            return this;
        }

        public Builder recipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public OrderInfoDTO build() {
            OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
            orderInfoDTO.setOrdNo(ordNo);
            orderInfoDTO.setOrdDttm(ordDttm);
            orderInfoDTO.setProdId(prodId);
            orderInfoDTO.setProdNm(prodNm);
            orderInfoDTO.setOrdStus(ordStus);
            orderInfoDTO.setOrdStusNm(ordStusNm);
            orderInfoDTO.setQty(qty);
            orderInfoDTO.setProdAmt(prodAmt);
            orderInfoDTO.setOptNm(optNm);
            orderInfoDTO.setPayTp(payTp);
            orderInfoDTO.setRealPayAmt(realPayAmt);
            orderInfoDTO.setRepImg(repImg);
            orderInfoDTO.setOrdDtlNo(ordDtlNo);
            orderInfoDTO.setClaimStus(claimStus);
            orderInfoDTO.setOrdrNm(ordrNm);
            orderInfoDTO.setRecipient(recipient);
            return orderInfoDTO;
        }
    }
}
