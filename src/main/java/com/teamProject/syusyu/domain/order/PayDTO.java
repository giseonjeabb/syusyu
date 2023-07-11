package com.teamProject.syusyu.domain.order;

import java.time.LocalDateTime;
import java.util.Objects;

public class PayDTO {
    private int payNo;
    private int payerId;
    private int ordNo;
    private int payStus;
    private String payTp;
    private int ordAmt;
    private int dlvFee;
    private Integer cpnIssNo;
    private int orgnPayAmt;
    private Integer pntUseAmt;
    private int realPayAmt;
    private LocalDateTime regDttm;
    private int regrId;
    private LocalDateTime updDttm;
    private Integer updrId;

    public PayDTO() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayDTO payDTO = (PayDTO) o;
        return payNo == payDTO.payNo && payerId == payDTO.payerId && ordNo == payDTO.ordNo && payStus == payDTO.payStus && payTp == payDTO.payTp && ordAmt == payDTO.ordAmt && dlvFee == payDTO.dlvFee && orgnPayAmt == payDTO.orgnPayAmt && realPayAmt == payDTO.realPayAmt && regrId == payDTO.regrId && Objects.equals(cpnIssNo, payDTO.cpnIssNo) && Objects.equals(pntUseAmt, payDTO.pntUseAmt) && Objects.equals(regDttm, payDTO.regDttm) && Objects.equals(updDttm, payDTO.updDttm) && Objects.equals(updrId, payDTO.updrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payNo, payerId, ordNo, payStus, payTp, ordAmt, dlvFee, cpnIssNo, orgnPayAmt, pntUseAmt, realPayAmt, regDttm, regrId, updDttm, updrId);
    }

    public int getPayNo() {
        return payNo;
    }

    public void setPayNo(int payNo) {
        this.payNo = payNo;
    }

    public int getPayerId() {
        return payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
    }

    public int getPayStus() {
        return payStus;
    }

    public void setPayStus(int payStus) {
        this.payStus = payStus;
    }

    public String getPayTp() {
        return payTp;
    }

    public void setPayTp(String payTp) {
        this.payTp = payTp;
    }

    public int getOrdAmt() {
        return ordAmt;
    }

    public void setOrdAmt(int ordAmt) {
        this.ordAmt = ordAmt;
    }

    public int getDlvFee() {
        return dlvFee;
    }

    public void setDlvFee(int dlvFee) {
        this.dlvFee = dlvFee;
    }

    public Integer getCpnIssNo() {
        return cpnIssNo;
    }

    public void setCpnIssNo(Integer cpnIssNo) {
        this.cpnIssNo = cpnIssNo;
    }

    public int getOrgnPayAmt() {
        return orgnPayAmt;
    }

    public void setOrgnPayAmt(int orgnPayAmt) {
        this.orgnPayAmt = orgnPayAmt;
    }

    public Integer getPntUseAmt() {
        return pntUseAmt;
    }

    public void setPntUseAmt(Integer pntUseAmt) {
        this.pntUseAmt = pntUseAmt;
    }

    public int getRealPayAmt() {
        return realPayAmt;
    }

    public void setRealPayAmt(int realPayAmt) {
        this.realPayAmt = realPayAmt;
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
        return "PayDTO{" +
                "payNo=" + payNo +
                ", payerId=" + payerId +
                ", ordNo=" + ordNo +
                ", payStus=" + payStus +
                ", payTp=" + payTp +
                ", ordAmt=" + ordAmt +
                ", dlvFee=" + dlvFee +
                ", cpnIssNo='" + cpnIssNo + '\'' +
                ", orgnPayAmt=" + orgnPayAmt +
                ", pntUseAmt=" + pntUseAmt +
                ", realPayAmt=" + realPayAmt +
                ", regDttm=" + regDttm +
                ", regr=" + regrId +
                ", updDttm=" + updDttm +
                ", updr=" + updrId +
                '}';
    }

    public static final class Builder {
        private int payNo;
        private int payerId;
        private int ordNo;
        private int payStus;
        private String payTp;
        private int ordAmt;
        private int dlvFee;
        private Integer cpnIssNo;
        private int orgnPayAmt;
        private Integer pntUseAmt;
        private int realPayAmt;
        private int regrId;
        private Integer updrId;

        private Builder() {
        }

        public static Builder aPayDTO() {
            return new Builder();
        }

        public Builder payNo(int payNo) {
            this.payNo = payNo;
            return this;
        }

        public Builder payerId(int payerId) {
            this.payerId = payerId;
            return this;
        }

        public Builder ordNo(int ordNo) {
            this.ordNo = ordNo;
            return this;
        }

        public Builder payStus(int payStus) {
            this.payStus = payStus;
            return this;
        }

        public Builder payTp(String payTp) {
            this.payTp = payTp;
            return this;
        }

        public Builder ordAmt(int ordAmt) {
            this.ordAmt = ordAmt;
            return this;
        }

        public Builder dlvFee(int dlvFee) {
            this.dlvFee = dlvFee;
            return this;
        }

        public Builder cpnIssNo(Integer cpnIssNo) {
            this.cpnIssNo = cpnIssNo;
            return this;
        }

        public Builder orgnPayAmt(int orgnPayAmt) {
            this.orgnPayAmt = orgnPayAmt;
            return this;
        }

        public Builder pntUseAmt(Integer pntUseAmt) {
            this.pntUseAmt = pntUseAmt;
            return this;
        }

        public Builder realPayAmt(int realPayAmt) {
            this.realPayAmt = realPayAmt;
            return this;
        }

        public Builder regrId(int regrId) {
            this.regrId = regrId;
            return this;
        }

        public Builder updrId(Integer updrId) {
            this.updrId = updrId;
            return this;
        }

        public PayDTO build() {
            PayDTO payDTO = new PayDTO();
            payDTO.setPayNo(payNo);
            payDTO.setPayerId(payerId);
            payDTO.setOrdNo(ordNo);
            payDTO.setPayStus(payStus);
            payDTO.setPayTp(payTp);
            payDTO.setOrdAmt(ordAmt);
            payDTO.setDlvFee(dlvFee);
            payDTO.setCpnIssNo(cpnIssNo);
            payDTO.setOrgnPayAmt(orgnPayAmt);
            payDTO.setPntUseAmt(pntUseAmt);
            payDTO.setRealPayAmt(realPayAmt);
            payDTO.setRegrId(regrId);
            payDTO.setUpdrId(updrId);
            return payDTO;
        }
    }
}
