package com.teamProject.syusyu.domain.order;

import java.util.Date;

public class PayInfoDTO {

    private int ordAmt; // 주문금액
    private int dlvFee; // 배송비
    private int cpnDcAmt; // 쿠폰할인
    private int pntUseAmt; // 포인트 사용
    private int realPayAmt; // 총 결제금액(실결제금액)
    private int payTp; // 결제방법
    private String payTpNm; // 결제방법이름
    private Date aprvDttm; // 승일일시(결제일시)

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

    public int getCpnDcAmt() {
        return cpnDcAmt;
    }

    public void setCpnDcAmt(int cpnDcAmt) {
        this.cpnDcAmt = cpnDcAmt;
    }

    public int getPntUseAmt() {
        return pntUseAmt;
    }

    public void setPntUseAmt(int pntUseAmt) {
        this.pntUseAmt = pntUseAmt;
    }

    public int getRealPayAmt() {
        return realPayAmt;
    }

    public void setRealPayAmt(int realPayAmt) {
        this.realPayAmt = realPayAmt;
    }

    public int getPayTp() {
        return payTp;
    }

    public void setPayTp(int payTp) {
        this.payTp = payTp;
    }

    public String getPayTpNm() {
        return payTpNm;
    }

    public void setPayTpNm(String payTpNm) {
        this.payTpNm = payTpNm;
    }

    public Date getAprvDttm() {
        return aprvDttm;
    }

    public void setAprvDttm(Date aprvDttm) {
        this.aprvDttm = aprvDttm;
    }

    @Override
    public String toString() {
        return "PayInfoDTO{" +
                "ordAmt=" + ordAmt +
                ", dlvFee=" + dlvFee +
                ", cpnDcAmt=" + cpnDcAmt +
                ", pntUseAmt=" + pntUseAmt +
                ", realPayAmt=" + realPayAmt +
                ", payTp=" + payTp +
                ", payTpNm='" + payTpNm + '\'' +
                ", aprvDttm=" + aprvDttm +
                '}';
    }
}
