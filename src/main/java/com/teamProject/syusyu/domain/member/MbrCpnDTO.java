package com.teamProject.syusyu.domain.member;

import java.time.LocalDateTime;

public class MbrCpnDTO {
    private int cpnIssNo; // 쿠폰발행번호
    private String cpnNm; // # 쿠폰명
    private String cpnBnef; // # 쿠폰혜택
    private String bnefTp; // # 혜택타입(01=금액, 02=%)
    private Integer maxDcAmt; // # 최대할인금액
    private int mbrId; // 회원번호
    private Integer cpnId; // 쿠폰번호
    private LocalDateTime issDttm; // 쿠폰발행일시
    private LocalDateTime endDttm; // 쿠폰만료일시
    private String useStus; // 사용상태
    private Integer ordNo; // 주문번호
    private LocalDateTime useDttm; // 사용한일시
    private LocalDateTime regDttm; // 등록일시
    private int regrId; // 등록자
    private LocalDateTime updDttm; // 수정일시
    private Integer updrId; // 수정자
    private LocalDateTime delDttm; // 삭제일시
    private Integer delrId; // 삭제자
    private String delYn; // 삭제여부

    public int getCpnIssNo() {
        return cpnIssNo;
    }

    public void setCpnIssNo(int cpnIssNo) {
        this.cpnIssNo = cpnIssNo;
    }

    public String getCpnNm() {
        return cpnNm;
    }

    public void setCpnNm(String cpnNm) {
        this.cpnNm = cpnNm;
    }

    public String getCpnBnef() {
        return cpnBnef;
    }

    public void setCpnBnef(String cpnBnef) {
        this.cpnBnef = cpnBnef;
    }

    public String getBnefTp() {
        return bnefTp;
    }

    public void setBnefTp(String bnefTp) {
        this.bnefTp = bnefTp;
    }

    public Integer getMaxDcAmt() {
        return maxDcAmt;
    }

    public void setMaxDcAmt(Integer maxDcAmt) {
        this.maxDcAmt = maxDcAmt;
    }

    public int getMbrId() {
        return mbrId;
    }

    public void setMbrId(int mbrId) {
        this.mbrId = mbrId;
    }

    public Integer getCpnId() {
        return cpnId;
    }

    public void setCpnId(Integer cpnId) {
        this.cpnId = cpnId;
    }

    public LocalDateTime getIssDttm() {
        return issDttm;
    }

    public void setIssDttm(LocalDateTime issDttm) {
        this.issDttm = issDttm;
    }

    public LocalDateTime getEndDttm() {
        return endDttm;
    }

    public void setEndDttm(LocalDateTime endDttm) {
        this.endDttm = endDttm;
    }

    public String getUseStus() {
        return useStus;
    }

    public void setUseStus(String useStus) {
        this.useStus = useStus;
    }

    public Integer getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(Integer ordNo) {
        this.ordNo = ordNo;
    }

    public LocalDateTime getUseDttm() {
        return useDttm;
    }

    public void setUseDttm(LocalDateTime useDttm) {
        this.useDttm = useDttm;
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

    public Integer getDelrId() {
        return delrId;
    }

    public void setDelrId(Integer delrId) {
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
        return "MbrCpnDTO{" +
                "cpnIssNo=" + cpnIssNo +
                ", cpnNm='" + cpnNm + '\'' +
                ", cpnBnef='" + cpnBnef + '\'' +
                ", bnefTp='" + bnefTp + '\'' +
                ", maxDcAmt=" + maxDcAmt +
                ", mbrId=" + mbrId +
                ", cpnId=" + cpnId +
                ", issDttm=" + issDttm +
                ", endDttm=" + endDttm +
                ", useStus='" + useStus + '\'' +
                ", ordNo=" + ordNo +
                ", useDttm=" + useDttm +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                ", delDttm=" + delDttm +
                ", delrId=" + delrId +
                ", delYn='" + delYn + '\'' +
                '}';
    }
}
