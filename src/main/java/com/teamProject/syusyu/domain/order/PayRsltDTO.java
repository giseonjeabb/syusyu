package com.teamProject.syusyu.domain.order;

import java.time.LocalDateTime;
import java.util.Objects;

public class PayRsltDTO {
    private int payNo;
    private String aprvNo;
    private LocalDateTime aprvDttm;
    private String cardNum;
    private char cardInterest;
    private String cardQuota;
    private String cardCode;
    private char cardCorpFlag;
    private char cardCheckFlag;
    private char cardPrtcCode;
    private String cardBankCode;
    private char cardSrcCode;
    private char cardPoint;
    private Integer cardUsePoint;
    private Integer cardCouponPrice;
    private Integer cardCouponDiscount;
    private String naverpointUseFreePoint;
    private char naverpointCshrApplYn;
    private String pcoOrderNo;
    private String currency;
    private Integer orgPrice;
    private LocalDateTime regDttm;
    private int regrId;
    private LocalDateTime updDttm;
    private Integer updrId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayRsltDTO that = (PayRsltDTO) o;
        return cardInterest == that.cardInterest && cardCorpFlag == that.cardCorpFlag && cardCheckFlag == that.cardCheckFlag && cardPrtcCode == that.cardPrtcCode && cardSrcCode == that.cardSrcCode && cardPoint == that.cardPoint && naverpointCshrApplYn == that.naverpointCshrApplYn && regrId == that.regrId && Objects.equals(payNo, that.payNo) && Objects.equals(aprvNo, that.aprvNo) && Objects.equals(cardNum, that.cardNum) && Objects.equals(cardQuota, that.cardQuota) && Objects.equals(cardCode, that.cardCode) && Objects.equals(cardBankCode, that.cardBankCode) && Objects.equals(cardUsePoint, that.cardUsePoint) && Objects.equals(cardCouponPrice, that.cardCouponPrice) && Objects.equals(cardCouponDiscount, that.cardCouponDiscount) && Objects.equals(naverpointUseFreePoint, that.naverpointUseFreePoint) && Objects.equals(pcoOrderNo, that.pcoOrderNo) && Objects.equals(currency, that.currency) && Objects.equals(orgPrice, that.orgPrice) && Objects.equals(updrId, that.updrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payNo, aprvNo, cardNum, cardInterest, cardQuota, cardCode, cardCorpFlag, cardCheckFlag, cardPrtcCode, cardBankCode, cardSrcCode, cardPoint, cardUsePoint, cardCouponPrice, cardCouponDiscount, naverpointUseFreePoint, naverpointCshrApplYn, pcoOrderNo, currency, orgPrice, regrId, updrId);
    }

    public int getPayNo() {
        return payNo;
    }

    public void setPayNo(int payNo) {
        this.payNo = payNo;
    }

    public String getAprvNo() {
        return aprvNo;
    }

    public void setAprvNo(String aprvNo) {
        this.aprvNo = aprvNo;
    }

    public LocalDateTime getAprvDttm() {
        return aprvDttm;
    }

    public void setAprvDttm(LocalDateTime aprvDttm) {
        this.aprvDttm = aprvDttm;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public char getCardInterest() {
        return cardInterest;
    }

    public void setCardInterest(char cardInterest) {
        this.cardInterest = cardInterest;
    }

    public String getCardQuota() {
        return cardQuota;
    }

    public void setCardQuota(String cardQuota) {
        this.cardQuota = cardQuota;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public char getCardCorpFlag() {
        return cardCorpFlag;
    }

    public void setCardCorpFlag(char cardCorpFlag) {
        this.cardCorpFlag = cardCorpFlag;
    }

    public char getCardCheckFlag() {
        return cardCheckFlag;
    }

    public void setCardCheckFlag(char cardCheckFlag) {
        this.cardCheckFlag = cardCheckFlag;
    }

    public char getCardPrtcCode() {
        return cardPrtcCode;
    }

    public void setCardPrtcCode(char cardPrtcCode) {
        this.cardPrtcCode = cardPrtcCode;
    }

    public String getCardBankCode() {
        return cardBankCode;
    }

    public void setCardBankCode(String cardBankCode) {
        this.cardBankCode = cardBankCode;
    }

    public char getCardSrcCode() {
        return cardSrcCode;
    }

    public void setCardSrcCode(char cardSrcCode) {
        this.cardSrcCode = cardSrcCode;
    }

    public char getCardPoint() {
        return cardPoint;
    }

    public void setCardPoint(char cardPoint) {
        this.cardPoint = cardPoint;
    }

    public Integer getCardUsePoint() {
        return cardUsePoint;
    }

    public void setCardUsePoint(Integer cardUsePoint) {
        this.cardUsePoint = cardUsePoint;
    }

    public Integer getCardCouponPrice() {
        return cardCouponPrice;
    }

    public void setCardCouponPrice(Integer cardCouponPrice) {
        this.cardCouponPrice = cardCouponPrice;
    }

    public Integer getCardCouponDiscount() {
        return cardCouponDiscount;
    }

    public void setCardCouponDiscount(Integer cardCouponDiscount) {
        this.cardCouponDiscount = cardCouponDiscount;
    }

    public String getNaverpointUseFreePoint() {
        return naverpointUseFreePoint;
    }

    public void setNaverpointUseFreePoint(String naverpointUseFreePoint) {
        this.naverpointUseFreePoint = naverpointUseFreePoint;
    }

    public char getNaverpointCshrApplYn() {
        return naverpointCshrApplYn;
    }

    public void setNaverpointCshrApplYn(char naverpointCshrApplYn) {
        this.naverpointCshrApplYn = naverpointCshrApplYn;
    }

    public String getPcoOrderNo() {
        return pcoOrderNo;
    }

    public void setPcoOrderNo(String pcoOrderNo) {
        this.pcoOrderNo = pcoOrderNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getOrgPrice() {
        return orgPrice;
    }

    public void setOrgPrice(Integer orgPrice) {
        this.orgPrice = orgPrice;
    }

    public LocalDateTime getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(LocalDateTime regDttm) {
        this.regDttm = regDttm;
    }

    public int getRegrId() {
        return regrId;
    }

    public void setRegrId(int regrId) {
        this.regrId = regrId;
    }

    public LocalDateTime getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(LocalDateTime updDttm) {
        this.updDttm = updDttm;
    }

    public Integer getUpdrId() {
        return updrId;
    }

    public void setUpdrId(Integer updrId) {
        this.updrId = updrId;
    }

    @Override
    public String toString() {
        return "PayRsltDTO{" +
                "payNo='" + payNo + '\'' +
                ", aprvNo='" + aprvNo + '\'' +
                ", aprvDttm=" + aprvDttm +
                ", cardNum='" + cardNum + '\'' +
                ", cardInterest=" + cardInterest +
                ", cardQuota='" + cardQuota + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", cardCorpFlag=" + cardCorpFlag +
                ", cardCheckFlag=" + cardCheckFlag +
                ", cardPrtcCode=" + cardPrtcCode +
                ", cardBankCode='" + cardBankCode + '\'' +
                ", cardSrcCode=" + cardSrcCode +
                ", cardPoint=" + cardPoint +
                ", cardUsePoint=" + cardUsePoint +
                ", cardCouponPrice=" + cardCouponPrice +
                ", cardCouponDiscount=" + cardCouponDiscount +
                ", naverpointUseFreePoint='" + naverpointUseFreePoint + '\'' +
                ", naverpointCshrApplYn=" + naverpointCshrApplYn +
                ", pcoOrderNo='" + pcoOrderNo + '\'' +
                ", currency='" + currency + '\'' +
                ", orgPrice=" + orgPrice +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                '}';
    }

    public static final class Builder {
        private int payNo;
        private String aprvNo;
        private LocalDateTime aprvDttm;
        private String cardNum;
        private char cardInterest;
        private String cardQuota;
        private String cardCode;
        private char cardCorpFlag;
        private char cardCheckFlag;
        private char cardPrtcCode;
        private String cardBankCode;
        private char cardSrcCode;
        private char cardPoint;
        private Integer cardUsePoint;
        private Integer cardCouponPrice;
        private Integer cardCouponDiscount;
        private String naverpointUseFreePoint;
        private char naverpointCshrApplYn;
        private String pcoOrderNo;
        private String currency;
        private Integer orgPrice;
        private LocalDateTime regDttm;
        private int regrId;
        private LocalDateTime updDttm;
        private Integer updrId;

        private Builder() {
        }

        public static Builder aPayRsltDTO() {
            return new Builder();
        }

        public Builder payNo(int payNo) {
            this.payNo = payNo;
            return this;
        }

        public Builder aprvNo(String aprvNo) {
            this.aprvNo = aprvNo;
            return this;
        }

        public Builder aprvDttm(LocalDateTime aprvDttm) {
            this.aprvDttm = aprvDttm;
            return this;
        }

        public Builder cardNum(String cardNum) {
            this.cardNum = cardNum;
            return this;
        }

        public Builder cardInterest(char cardInterest) {
            this.cardInterest = cardInterest;
            return this;
        }

        public Builder cardQuota(String cardQuota) {
            this.cardQuota = cardQuota;
            return this;
        }

        public Builder cardCode(String cardCode) {
            this.cardCode = cardCode;
            return this;
        }

        public Builder cardCorpFlag(char cardCorpFlag) {
            this.cardCorpFlag = cardCorpFlag;
            return this;
        }

        public Builder cardCheckFlag(char cardCheckFlag) {
            this.cardCheckFlag = cardCheckFlag;
            return this;
        }

        public Builder cardPrtcCode(char cardPrtcCode) {
            this.cardPrtcCode = cardPrtcCode;
            return this;
        }

        public Builder cardBankCode(String cardBankCode) {
            this.cardBankCode = cardBankCode;
            return this;
        }

        public Builder cardSrcCode(char cardSrcCode) {
            this.cardSrcCode = cardSrcCode;
            return this;
        }

        public Builder cardPoint(char cardPoint) {
            this.cardPoint = cardPoint;
            return this;
        }

        public Builder cardUsePoint(Integer cardUsePoint) {
            this.cardUsePoint = cardUsePoint;
            return this;
        }

        public Builder cardCouponPrice(Integer cardCouponPrice) {
            this.cardCouponPrice = cardCouponPrice;
            return this;
        }

        public Builder cardCouponDiscount(Integer cardCouponDiscount) {
            this.cardCouponDiscount = cardCouponDiscount;
            return this;
        }

        public Builder naverpointUseFreePoint(String naverpointUseFreePoint) {
            this.naverpointUseFreePoint = naverpointUseFreePoint;
            return this;
        }

        public Builder naverpointCshrApplYn(char naverpointCshrApplYn) {
            this.naverpointCshrApplYn = naverpointCshrApplYn;
            return this;
        }

        public Builder pcoOrderNo(String pcoOrderNo) {
            this.pcoOrderNo = pcoOrderNo;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder orgPrice(Integer orgPrice) {
            this.orgPrice = orgPrice;
            return this;
        }

        public Builder regDttm(LocalDateTime regDttm) {
            this.regDttm = regDttm;
            return this;
        }

        public Builder regrId(int regrId) {
            this.regrId = regrId;
            return this;
        }

        public Builder updDttm(LocalDateTime updDttm) {
            this.updDttm = updDttm;
            return this;
        }

        public Builder updrId(Integer updrId) {
            this.updrId = updrId;
            return this;
        }

        public PayRsltDTO build() {
            PayRsltDTO payRsltDTO = new PayRsltDTO();
            payRsltDTO.setPayNo(payNo);
            payRsltDTO.setAprvNo(aprvNo);
            payRsltDTO.setAprvDttm(aprvDttm);
            payRsltDTO.setCardNum(cardNum);
            payRsltDTO.setCardInterest(cardInterest);
            payRsltDTO.setCardQuota(cardQuota);
            payRsltDTO.setCardCode(cardCode);
            payRsltDTO.setCardCorpFlag(cardCorpFlag);
            payRsltDTO.setCardCheckFlag(cardCheckFlag);
            payRsltDTO.setCardPrtcCode(cardPrtcCode);
            payRsltDTO.setCardBankCode(cardBankCode);
            payRsltDTO.setCardSrcCode(cardSrcCode);
            payRsltDTO.setCardPoint(cardPoint);
            payRsltDTO.setCardUsePoint(cardUsePoint);
            payRsltDTO.setCardCouponPrice(cardCouponPrice);
            payRsltDTO.setCardCouponDiscount(cardCouponDiscount);
            payRsltDTO.setNaverpointUseFreePoint(naverpointUseFreePoint);
            payRsltDTO.setNaverpointCshrApplYn(naverpointCshrApplYn);
            payRsltDTO.setPcoOrderNo(pcoOrderNo);
            payRsltDTO.setCurrency(currency);
            payRsltDTO.setOrgPrice(orgPrice);
            payRsltDTO.setRegDttm(regDttm);
            payRsltDTO.setRegrId(regrId);
            payRsltDTO.setUpdDttm(updDttm);
            payRsltDTO.setUpdrId(updrId);
            return payRsltDTO;
        }
    }
}
