package com.teamProject.syusyu.domain.member;

import java.time.LocalDateTime;
import java.util.Objects;

public class DlvAddrDTO {
    private int dlvAddrNo;
    private int mbrId;
    private String dlvAddrNm;
    private String recipient;
    private String mpNo;
    private String zipcode;
    private String dfltAddr;
    private String dtlAddr;
    private String addr;
    private String dlvReqComt;
    private String dfltDlvAddrYn;
    private String safetNoYn;
    private LocalDateTime regDttm;
    private int regrId;
    private LocalDateTime updDttm;
    private Integer updrId;
    private LocalDateTime delDttm;
    private Integer delrId;
    private String delYn;

    DlvAddrDTO() {}

    public DlvAddrDTO(int mbrId, String dlvAddrNm, String recipient, String mpNo, String zipcode, String dfltAddr, String dtlAddr, String addr, String dlvReqComt, String dfltDlvAddrYn, String safetNoYn, int regrId, Integer updrId, Integer delrId, String delYn) {
        this.mbrId = mbrId;
        this.dlvAddrNm = dlvAddrNm;
        this.recipient = recipient;
        this.mpNo = mpNo;
        this.zipcode = zipcode;
        this.dfltAddr = dfltAddr;
        this.dtlAddr = dtlAddr;
        this.addr = addr;
        this.dlvReqComt = dlvReqComt;
        this.dfltDlvAddrYn = dfltDlvAddrYn;
        this.safetNoYn = safetNoYn;
        this.regrId = regrId;
        this.updrId = updrId;
        this.delrId = delrId;
        this.delYn = delYn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DlvAddrDTO that = (DlvAddrDTO) o;
        return dlvAddrNo == that.dlvAddrNo && mbrId == that.mbrId && regrId == that.regrId && Objects.equals(dlvAddrNm, that.dlvAddrNm) && Objects.equals(recipient, that.recipient) && Objects.equals(mpNo, that.mpNo) && Objects.equals(zipcode, that.zipcode) && Objects.equals(dfltAddr, that.dfltAddr) && Objects.equals(dtlAddr, that.dtlAddr) && Objects.equals(dlvReqComt, that.dlvReqComt) && Objects.equals(dfltDlvAddrYn, that.dfltDlvAddrYn) && Objects.equals(safetNoYn, that.safetNoYn) && Objects.equals(regDttm, that.regDttm) && Objects.equals(updDttm, that.updDttm) && Objects.equals(updrId, that.updrId) && Objects.equals(delDttm, that.delDttm) && Objects.equals(delrId, that.delrId) && Objects.equals(delYn, that.delYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dlvAddrNo, mbrId, dlvAddrNm, recipient, mpNo, zipcode, dfltAddr, dtlAddr, dlvReqComt, dfltDlvAddrYn, safetNoYn, regDttm, regrId, updDttm, updrId, delDttm, delrId, delYn);
    }

    public int getDlvAddrNo() {
        return dlvAddrNo;
    }

    public void setDlvAddrNo(int dlvAddrNo) {
        this.dlvAddrNo = dlvAddrNo;
    }

    public int getMbrId() {
        return mbrId;
    }

    public void setMbrId(int mbrId) {
        this.mbrId = mbrId;
    }

    public String getDlvAddrNm() {
        return dlvAddrNm;
    }

    public void setDlvAddrNm(String dlvAddrNm) {
        this.dlvAddrNm = dlvAddrNm;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMpNo() {
        return mpNo;
    }

    public void setMpNo(String mpNo) {
        this.mpNo = mpNo;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDfltAddr() {
        return dfltAddr;
    }

    public void setDfltAddr(String dfltAddr) {
        this.dfltAddr = dfltAddr;
    }

    public String getDtlAddr() {
        return dtlAddr;
    }

    public void setDtlAddr(String dtlAddr) {
        this.dtlAddr = dtlAddr;
    }

    public String getDlvReqComt() {
        return dlvReqComt;
    }

    public void setDlvReqComt(String dlvReqComt) {
        this.dlvReqComt = dlvReqComt;
    }

    public String getDfltDlvAddrYn() {
        return dfltDlvAddrYn;
    }

    public void setDfltDlvAddrYn(String dfltDlvAddrYn) {
        this.dfltDlvAddrYn = dfltDlvAddrYn;
    }

    public String getSafetNoYn() {
        return safetNoYn;
    }

    public void setSafetNoYn(String safetNoYn) {
        this.safetNoYn = safetNoYn;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "DlvAddrDTO{" +
                "dlvAddrNo=" + dlvAddrNo +
                ", mbrId=" + mbrId +
                ", dlvAddrNm='" + dlvAddrNm + '\'' +
                ", recipient='" + recipient + '\'' +
                ", mpNo='" + mpNo + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", dfltAddr='" + dfltAddr + '\'' +
                ", dtlAddr='" + dtlAddr + '\'' +
                ", addr='" + addr + '\'' +
                ", dlvReqComt='" + dlvReqComt + '\'' +
                ", dfltDlvAddrYn='" + dfltDlvAddrYn + '\'' +
                ", safetNoYn='" + safetNoYn + '\'' +
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
