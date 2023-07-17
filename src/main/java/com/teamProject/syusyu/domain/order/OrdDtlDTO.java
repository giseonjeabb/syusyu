package com.teamProject.syusyu.domain.order;

import java.time.LocalDateTime;
import java.util.Objects;

public class OrdDtlDTO {
    private int ordDtlNo;
    private int ordNo;
    private int prodId;
    private String prodNm;
    private Integer optCombNo;
    private String ordStus;
    private int prodPrc;
    private Integer prodDcPer;
    private int qty;
    private int prodTotalPayAmt;
    private LocalDateTime sendDdln;
    private LocalDateTime regDttm;
    private int regrId;
    private LocalDateTime updDttm;
    private Integer updrId;

    public OrdDtlDTO() {}

    public OrdDtlDTO(int ordNo, int prodId, String prodNm, Integer optCombNo, String ordStus, int prodPrc, Integer prodDcPer, int qty, int prodTotalPayAmt, LocalDateTime sendDdln, int regrId, Integer updrId) {
        this.ordNo = ordNo;
        this.prodId = prodId;
        this.prodNm = prodNm;
        this.optCombNo = optCombNo;
        this.ordStus = ordStus;
        this.prodPrc = prodPrc;
        this.prodDcPer = prodDcPer;
        this.qty = qty;
        this.prodTotalPayAmt = prodTotalPayAmt;
        this.sendDdln = sendDdln;
        this.regrId = regrId;
        this.updrId = updrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdDtlDTO ordDtlDTO = (OrdDtlDTO) o;
        return ordNo == ordDtlDTO.ordNo && prodId == ordDtlDTO.prodId && ordStus == ordDtlDTO.ordStus && prodPrc == ordDtlDTO.prodPrc && qty == ordDtlDTO.qty && prodTotalPayAmt == ordDtlDTO.prodTotalPayAmt && regrId == ordDtlDTO.regrId && Objects.equals(prodNm, ordDtlDTO.prodNm) && Objects.equals(optCombNo, ordDtlDTO.optCombNo) && Objects.equals(prodDcPer, ordDtlDTO.prodDcPer) && Objects.equals(updrId, ordDtlDTO.updrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordNo, prodId, prodNm, optCombNo, ordStus, prodPrc, prodDcPer, qty, prodTotalPayAmt, regrId, updrId);
    }

    public int getOrdDtlNo() {
        return ordDtlNo;
    }

    public void setOrdDtlNo(int ordDtlNo) {
        this.ordDtlNo = ordDtlNo;
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
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

    public int getprodPrc() {
        return prodPrc;
    }

    public void setprodPrc(int prodPrc) {
        this.prodPrc = prodPrc;
    }

    public Integer getProdDcPer() {
        return prodDcPer;
    }

    public void setProdDcPer(Integer prodDcPer) {
        this.prodDcPer = prodDcPer;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getProdTotalPayAmt() {
        return prodTotalPayAmt;
    }

    public void setProdTotalPayAmt(int prodTotalPayAmt) {
        this.prodTotalPayAmt = prodTotalPayAmt;
    }

    public LocalDateTime getSendDdln() {
        return sendDdln;
    }

    public void setSendDdln(LocalDateTime sendDdln) {
        this.sendDdln = sendDdln;
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
        return "OrdDtlDTO{" +
                "ordDtlNo=" + ordDtlNo +
                ", ordNo=" + ordNo +
                ", prodId=" + prodId +
                ", prodNm='" + prodNm + '\'' +
                ", ordStus=" + ordStus +
                ", prodPrc=" + prodPrc +
                ", prodDcPer=" + prodDcPer +
                ", qty=" + qty +
                ", prodTotalPayAmt=" + prodTotalPayAmt +
                ", sendDdln='" + sendDdln + '\'' +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                '}';
    }

    public Integer getOptCombNo() {
        return optCombNo;
    }

    public void setOptCombNo(Integer optCombNo) {
        this.optCombNo = optCombNo;
    }


    public static final class Builder {
        private int ordNo;
        private int prodId;
        private String prodNm;
        private Integer optCombNo;
        private String ordStus;
        private int prodPrc;
        private Integer prodDcPer;
        private int qty;
        private int prodTotalPayAmt;
        private LocalDateTime sendDdln;
        private int regrId;
        private Integer updrId;

        private Builder() {
        }

        public static Builder anOrdDtlDTO() {
            return new Builder();
        }

        public Builder ordNo(int ordNo) {
            this.ordNo = ordNo;
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

        public Builder optCombNo(Integer optCombNo) {
            this.optCombNo = optCombNo;
            return this;
        }

        public Builder prodPrc(int prodPrc) {
            this.prodPrc = prodPrc;
            return this;
        }

        public Builder prodDcPer(Integer prodDcPer) {
            this.prodDcPer = prodDcPer;
            return this;
        }

        public Builder qty(int qty) {
            this.qty = qty;
            return this;
        }

        public Builder prodTotalPayAmt(int prodTotalPayAmt) {
            this.prodTotalPayAmt = prodTotalPayAmt;
            return this;
        }

        public Builder sendDdln(LocalDateTime sendDdln) {
            this.sendDdln = sendDdln;
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

        public OrdDtlDTO build() {
            OrdDtlDTO ordDtlDTO = new OrdDtlDTO();
            ordDtlDTO.setOrdNo(ordNo);
            ordDtlDTO.setProdId(prodId);
            ordDtlDTO.setProdNm(prodNm);
            ordDtlDTO.setOptCombNo(optCombNo);
            ordDtlDTO.setOrdStus(ordStus);
            ordDtlDTO.setprodPrc(prodPrc);
            ordDtlDTO.setProdDcPer(prodDcPer);
            ordDtlDTO.setQty(qty);
            ordDtlDTO.setProdTotalPayAmt(prodTotalPayAmt);
            ordDtlDTO.setSendDdln(sendDdln);
            ordDtlDTO.setRegrId(regrId);
            ordDtlDTO.setUpdrId(updrId);
            return ordDtlDTO;
        }
    }
}
