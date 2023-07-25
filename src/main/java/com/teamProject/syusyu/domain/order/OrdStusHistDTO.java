package com.teamProject.syusyu.domain.order;

import java.time.LocalDateTime;

public class OrdStusHistDTO {
    private int ordStusHistNo;
    private int ordDtlNo;
    private String nowOrdStus;
    private String procMemo;
    private LocalDateTime regDttm;
    private int regrId;
    private LocalDateTime updDttm;
    private Integer updrId;

    public OrdStusHistDTO() {}

    public OrdStusHistDTO(int ordDtlNo, String nowOrdStus, String procMemo, int regrId) {
        this.ordDtlNo = ordDtlNo;
        this.nowOrdStus = nowOrdStus;
        this.procMemo = procMemo;
        this.regrId = regrId;
    }

    public int getOrdStusHistNo() {
        return ordStusHistNo;
    }

    public void setOrdStusHistNo(int ordStusHistNo) {
        this.ordStusHistNo = ordStusHistNo;
    }

    public int getOrdDtlNo() {
        return ordDtlNo;
    }

    public void setOrdDtlNo(int ordDtlNo) {
        this.ordDtlNo = ordDtlNo;
    }

    public String getNowOrdStus() {
        return nowOrdStus;
    }

    public void setNowOrdStus(String nowOrdStus) {
        this.nowOrdStus = nowOrdStus;
    }

    public String getProcMemo() {
        return procMemo;
    }

    public void setProcMemo(String procMemo) {
        this.procMemo = procMemo;
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
        return "OrdStusHistDTO{" +
                "ordStusHistNo=" + ordStusHistNo +
                ", ordDtlNo=" + ordDtlNo +
                ", nowOrdStus='" + nowOrdStus + '\'' +
                ", procMemo='" + procMemo + '\'' +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                '}';
    }

    public static final class Builder {
        private int ordStusHistNo;
        private int ordDtlNo;
        private String nowOrdStus;
        private String procMemo;
        private int regrId;
        private Integer updrId;

        private Builder() {
        }

        public static Builder anOrdStusHistDTO() {
            return new Builder();
        }

        public Builder ordStusHistNo(int ordStusHistNo) {
            this.ordStusHistNo = ordStusHistNo;
            return this;
        }

        public Builder ordDtlNo(int ordDtlNo) {
            this.ordDtlNo = ordDtlNo;
            return this;
        }

        public Builder nowOrdStus(String nowOrdStus) {
            this.nowOrdStus = nowOrdStus;
            return this;
        }

        public Builder procMemo(String procMemo) {
            this.procMemo = procMemo;
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

        public OrdStusHistDTO build() {
            OrdStusHistDTO ordStusHistDTO = new OrdStusHistDTO();
            ordStusHistDTO.setOrdStusHistNo(ordStusHistNo);
            ordStusHistDTO.setOrdDtlNo(ordDtlNo);
            ordStusHistDTO.setNowOrdStus(nowOrdStus);
            ordStusHistDTO.setProcMemo(procMemo);
            ordStusHistDTO.setRegrId(regrId);
            ordStusHistDTO.setUpdrId(updrId);
            return ordStusHistDTO;
        }
    }
}
