package com.teamProject.syusyu.domain.member;

import java.time.LocalDateTime;

public class CouponDTO {
    private int cpnId; // 쿠폰코드
    private String cpnNm; // 쿠폰명
    private String cpnDesc; // 쿠폰설명
    private int cpnBnef; // 쿠폰혜택
    private String bnefTp; // 혜택타입(쿠폰할인율/금액)
    private String cyclTp; // 주기유형
    private Integer cyclVal; // 주기값
    private Integer minOrdAmt; // 최소주문금액
    private Integer maxDcAmt; // 최대할인금액
    private String target; // 타겟팅대상
    private String cpnIssuYn; // 쿠폰발급상태YN
    private int cpnBnefTermDay; // 쿠폰혜택유지일수
    private LocalDateTime bnefStDttm; // 혜택시작일시
    private LocalDateTime bnefEndDttm; // 혜택종료일시
    private Integer issuLmtQty; // 발급제한수량
    private LocalDateTime regDttm; // 등록일시
    private int regrId; // 등록자
    private LocalDateTime updDttm; // 수정일시
    private Integer updrId; // 수정자
    private LocalDateTime delDttm; // 삭제일시
    private String delrId; // 삭제자
    private String delYn; // 삭제여부_YN

    public int getCpnId() {
        return cpnId;
    }

    public void setCpnId(int cpnId) {
        this.cpnId = cpnId;
    }

    public String getCpnNm() {
        return cpnNm;
    }

    public void setCpnNm(String cpnNm) {
        this.cpnNm = cpnNm;
    }

    public String getCpnDesc() {
        return cpnDesc;
    }

    public void setCpnDesc(String cpnDesc) {
        this.cpnDesc = cpnDesc;
    }

    public int getCpnBnef() {
        return cpnBnef;
    }

    public void setCpnBnef(int cpnBnef) {
        this.cpnBnef = cpnBnef;
    }

    public String getBnefTp() {
        return bnefTp;
    }

    public void setBnefTp(String bnefTp) {
        this.bnefTp = bnefTp;
    }

    public String getCyclTp() {
        return cyclTp;
    }

    public void setCyclTp(String cyclTp) {
        this.cyclTp = cyclTp;
    }

    public Integer getCyclVal() {
        return cyclVal;
    }

    public void setCyclVal(Integer cyclVal) {
        this.cyclVal = cyclVal;
    }

    public Integer getMinOrdAmt() {
        return minOrdAmt;
    }

    public void setMinOrdAmt(Integer minOrdAmt) {
        this.minOrdAmt = minOrdAmt;
    }

    public Integer getMaxDcAmt() {
        return maxDcAmt;
    }

    public void setMaxDcAmt(Integer maxDcAmt) {
        this.maxDcAmt = maxDcAmt;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCpnIssuYn() {
        return cpnIssuYn;
    }

    public void setCpnIssuYn(String cpnIssuYn) {
        this.cpnIssuYn = cpnIssuYn;
    }

    public int getCpnBnefTermDay() {
        return cpnBnefTermDay;
    }

    public void setCpnBnefTermDay(int cpnBnefTermDay) {
        this.cpnBnefTermDay = cpnBnefTermDay;
    }

    public LocalDateTime getBnefStDttm() {
        return bnefStDttm;
    }

    public void setBnefStDttm(LocalDateTime bnefStDttm) {
        this.bnefStDttm = bnefStDttm;
    }

    public LocalDateTime getBnefEndDttm() {
        return bnefEndDttm;
    }

    public void setBnefEndDttm(LocalDateTime bnefEndDttm) {
        this.bnefEndDttm = bnefEndDttm;
    }

    public Integer getIssuLmtQty() {
        return issuLmtQty;
    }

    public void setIssuLmtQty(Integer issuLmtQty) {
        this.issuLmtQty = issuLmtQty;
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

    public LocalDateTime getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(LocalDateTime delDttm) {
        this.delDttm = delDttm;
    }

    public String getDelrId() {
        return delrId;
    }

    public void setDelrId(String delrId) {
        this.delrId = delrId;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    @Override
    public String toString() {
        return "CouponDTO{" +
                "cpnId=" + cpnId +
                ", cpnNm='" + cpnNm + '\'' +
                ", cpnDesc='" + cpnDesc + '\'' +
                ", cpnBnef=" + cpnBnef +
                ", bnefTp='" + bnefTp + '\'' +
                ", cyclTp='" + cyclTp + '\'' +
                ", cyclVal=" + cyclVal +
                ", minOrdAmt=" + minOrdAmt +
                ", maxDcAmt=" + maxDcAmt +
                ", target='" + target + '\'' +
                ", cpnIssuYn='" + cpnIssuYn + '\'' +
                ", cpnBnefTermDay=" + cpnBnefTermDay +
                ", bnefStDttm=" + bnefStDttm +
                ", bnefEndDttm=" + bnefEndDttm +
                ", issuLmtQty=" + issuLmtQty +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                ", delDttm=" + delDttm +
                ", delrId='" + delrId + '\'' +
                ", delYn='" + delYn + '\'' +
                '}';
    }
}
