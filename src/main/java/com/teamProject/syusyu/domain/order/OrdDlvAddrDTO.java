package com.teamProject.syusyu.domain.order;

import java.time.LocalDateTime;
import java.util.Objects;

public class OrdDlvAddrDTO {
    private int ordDlvAddrNo;
    private int ordNo;
    private String recipient;
    private String mpNo;
    private String safetNoYn;
    private String zipcode;
    private String dfltAddr;
    private String dtlAddr;
    private String dlvReqComt;
    private LocalDateTime regDttm;
    private int regrId;
    private LocalDateTime updDttm;
    private Integer updrId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdDlvAddrDTO that = (OrdDlvAddrDTO) o;
        return ordNo == that.ordNo && regrId == that.regrId && Objects.equals(recipient, that.recipient) && Objects.equals(mpNo, that.mpNo) && Objects.equals(safetNoYn, that.safetNoYn) && Objects.equals(zipcode, that.zipcode) && Objects.equals(dfltAddr, that.dfltAddr) && Objects.equals(dtlAddr, that.dtlAddr) && Objects.equals(dlvReqComt, that.dlvReqComt) && Objects.equals(updrId, that.updrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordNo, recipient, mpNo, safetNoYn, zipcode, dfltAddr, dtlAddr, dlvReqComt, regrId, updrId);
    }

    public int getOrdDlvAddrNo() {
        return ordDlvAddrNo;
    }

    public void setOrdDlvAddrNo(int ordDlvAddrNo) {
        this.ordDlvAddrNo = ordDlvAddrNo;
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
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

    public String getSafetNoYn() {
        return safetNoYn;
    }

    public void setSafetNoYn(String safetNoYn) {
        this.safetNoYn = safetNoYn;
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
        return "OrdDlvAddrDTO{" +
                "ordDlvAddrNo=" + ordDlvAddrNo +
                ", ordNo=" + ordNo +
                ", recipient='" + recipient + '\'' +
                ", mpNo='" + mpNo + '\'' +
                ", safetNoYn='" + safetNoYn + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", dfltAddr='" + dfltAddr + '\'' +
                ", dtlAddr='" + dtlAddr + '\'' +
                ", dlvReqComt='" + dlvReqComt + '\'' +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                '}';
    }


    public static final class Builder {
        private int ordDlvAddrNo;
        private int ordNo;
        private String recipient;
        private String mpNo;
        private String safetNoYn;
        private String zipcode;
        private String dfltAddr;
        private String dtlAddr;
        private String dlvReqComt;
        private LocalDateTime regDttm;
        private int regrId;
        private LocalDateTime updDttm;
        private Integer updrId;

        private Builder() {
        }

        public static Builder anOrdDlvAddrDTO() {
            return new Builder();
        }

        public Builder ordDlvAddrNo(int ordDlvAddrNo) {
            this.ordDlvAddrNo = ordDlvAddrNo;
            return this;
        }

        public Builder ordNo(int ordNo) {
            this.ordNo = ordNo;
            return this;
        }

        public Builder recipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder mpNo(String mpNo) {
            this.mpNo = mpNo;
            return this;
        }

        public Builder safetNoYn(String safetNoYn) {
            this.safetNoYn = safetNoYn;
            return this;
        }

        public Builder zipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public Builder dfltAddr(String dfltAddr) {
            this.dfltAddr = dfltAddr;
            return this;
        }

        public Builder dtlAddr(String dtlAddr) {
            this.dtlAddr = dtlAddr;
            return this;
        }

        public Builder dlvReqComt(String dlvReqComt) {
            this.dlvReqComt = dlvReqComt;
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

        public OrdDlvAddrDTO build() {
            OrdDlvAddrDTO ordDlvAddrDTO = new OrdDlvAddrDTO();
            ordDlvAddrDTO.setOrdDlvAddrNo(ordDlvAddrNo);
            ordDlvAddrDTO.setOrdNo(ordNo);
            ordDlvAddrDTO.setRecipient(recipient);
            ordDlvAddrDTO.setMpNo(mpNo);
            ordDlvAddrDTO.setSafetNoYn(safetNoYn);
            ordDlvAddrDTO.setZipcode(zipcode);
            ordDlvAddrDTO.setDfltAddr(dfltAddr);
            ordDlvAddrDTO.setDtlAddr(dtlAddr);
            ordDlvAddrDTO.setDlvReqComt(dlvReqComt);
            ordDlvAddrDTO.setRegDttm(regDttm);
            ordDlvAddrDTO.setRegrId(regrId);
            ordDlvAddrDTO.setUpdDttm(updDttm);
            ordDlvAddrDTO.setUpdrId(updrId);
            return ordDlvAddrDTO;
        }
    }
}
