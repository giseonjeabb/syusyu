package com.teamProject.syusyu.domain.order;

import java.time.LocalDateTime;
import java.util.Objects;

public class PayDTO {
    private int payNo;
    private int payerId;
    private int ordNo;
    private int payStus;
    private int payTp;
    private int ordAmt;
    private int dlvFee;
    private String cpnIssNo;
    private int orgnPayAmt;
    private Integer pntUseAmt;
    private int realPayAmt;
    private LocalDateTime regDttm;
    private int regr;
    private LocalDateTime updDttm;
    private Integer updr;

    public PayDTO() {}

    public PayDTO(int payNo, int payerId, int ordNo, int payStus, int payTp, int ordAmt, int dlvFee, String cpnIssNo, int orgnPayAmt, Integer pntUseAmt, int realPayAmt, int regr, Integer updr) {
        this.payNo = payNo;
        this.payerId = payerId;
        this.ordNo = ordNo;
        this.payStus = payStus;
        this.payTp = payTp;
        this.ordAmt = ordAmt;
        this.dlvFee = dlvFee;
        this.cpnIssNo = cpnIssNo;
        this.orgnPayAmt = orgnPayAmt;
        this.pntUseAmt = pntUseAmt;
        this.realPayAmt = realPayAmt;
        this.regr = regr;
        this.updr = updr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayDTO payDTO = (PayDTO) o;
        return payNo == payDTO.payNo && payerId == payDTO.payerId && ordNo == payDTO.ordNo && payStus == payDTO.payStus && payTp == payDTO.payTp && ordAmt == payDTO.ordAmt && dlvFee == payDTO.dlvFee && orgnPayAmt == payDTO.orgnPayAmt && realPayAmt == payDTO.realPayAmt && regr == payDTO.regr && Objects.equals(cpnIssNo, payDTO.cpnIssNo) && Objects.equals(pntUseAmt, payDTO.pntUseAmt) && Objects.equals(regDttm, payDTO.regDttm) && Objects.equals(updDttm, payDTO.updDttm) && Objects.equals(updr, payDTO.updr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payNo, payerId, ordNo, payStus, payTp, ordAmt, dlvFee, cpnIssNo, orgnPayAmt, pntUseAmt, realPayAmt, regDttm, regr, updDttm, updr);
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

    public int getPayTp() {
        return payTp;
    }

    public void setPayTp(int payTp) {
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

    public String getCpnIssNo() {
        return cpnIssNo;
    }

    public void setCpnIssNo(String cpnIssNo) {
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

    public int getRegr() {
        return regr;
    }

    public void setRegr(int regr) {
        this.regr = regr;
    }

    public LocalDateTime getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(LocalDateTime updDttm) {
        this.updDttm = updDttm;
    }

    public Integer getUpdr() {
        return updr;
    }

    public void setUpdr(Integer updr) {
        this.updr = updr;
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
                ", regr=" + regr +
                ", updDttm=" + updDttm +
                ", updr=" + updr +
                '}';
    }
}
