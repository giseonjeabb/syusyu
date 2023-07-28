package com.teamProject.syusyu.domain.order;

import java.util.Date;

public class DeliveryDTO {
    private int dlvNo;        // 배송번호
    private int ordDtlNo;     // 주문상세번호
    private String dlvStus;   // 배송상태
    private String dlvTp;     // 배송방법
    private Date dispatchDttm;// 발송처리일시
    private Integer pickupDttm;// 집화처리일시
    private Date shmtDttm;    // 출하일시
    private Date cmplDttm;    // 배송완료일시
    private String dlvCom;    // 택배사
    private String trckNo;    // 송장번호
    private Date regDttm;     // 등록일시
    private int regId;        // 등록자
    private Date updDttm;     // 수정일시
    private Integer updId;    // 수정자

    public int getDlvNo() {
        return dlvNo;
    }

    public void setDlvNo(int dlvNo) {
        this.dlvNo = dlvNo;
    }

    public int getOrdDtlNo() {
        return ordDtlNo;
    }

    public void setOrdDtlNo(int ordDtlNo) {
        this.ordDtlNo = ordDtlNo;
    }

    public String getDlvStus() {
        return dlvStus;
    }

    public void setDlvStus(String dlvStus) {
        this.dlvStus = dlvStus;
    }

    public String getDlvTp() {
        return dlvTp;
    }

    public void setDlvTp(String dlvTp) {
        this.dlvTp = dlvTp;
    }

    public Date getDispatchDttm() {
        return dispatchDttm;
    }

    public void setDispatchDttm(Date dispatchDttm) {
        this.dispatchDttm = dispatchDttm;
    }

    public Integer getPickupDttm() {
        return pickupDttm;
    }

    public void setPickupDttm(Integer pickupDttm) {
        this.pickupDttm = pickupDttm;
    }

    public Date getShmtDttm() {
        return shmtDttm;
    }

    public void setShmtDttm(Date shmtDttm) {
        this.shmtDttm = shmtDttm;
    }

    public Date getCmplDttm() {
        return cmplDttm;
    }

    public void setCmplDttm(Date cmplDttm) {
        this.cmplDttm = cmplDttm;
    }

    public String getDlvCom() {
        return dlvCom;
    }

    public void setDlvCom(String dlvCom) {
        this.dlvCom = dlvCom;
    }

    public String getTrckNo() {
        return trckNo;
    }

    public void setTrckNo(String trckNo) {
        this.trckNo = trckNo;
    }

    public Date getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public Date getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(Date updDttm) {
        this.updDttm = updDttm;
    }

    public Integer getUpdId() {
        return updId;
    }

    public void setUpdId(Integer updId) {
        this.updId = updId;
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "dlvNo=" + dlvNo +
                ", ordDtlNo=" + ordDtlNo +
                ", dlvStus='" + dlvStus + '\'' +
                ", dlvTp='" + dlvTp + '\'' +
                ", dispatchDttm=" + dispatchDttm +
                ", pickupDttm=" + pickupDttm +
                ", shmtDttm=" + shmtDttm +
                ", cmplDttm=" + cmplDttm +
                ", dlvCom='" + dlvCom + '\'' +
                ", trckNo='" + trckNo + '\'' +
                ", regDttm=" + regDttm +
                ", regId=" + regId +
                ", updDttm=" + updDttm +
                ", updId=" + updId +
                '}';
    }
}
