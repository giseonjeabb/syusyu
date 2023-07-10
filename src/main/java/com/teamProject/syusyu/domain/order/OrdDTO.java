package com.teamProject.syusyu.domain.order;

import java.time.LocalDateTime;
import java.util.Objects;

public class OrdDTO {
    private int ordNo;
    private int ordrId;
    private LocalDateTime regDttm;
    private int regrId;
    private LocalDateTime updDttm;
    private Integer updrId;

    public OrdDTO() {}

    public OrdDTO(int ordrId, int regrId, Integer updrId) {
        this.ordrId = ordrId;
        this.regrId = regrId;
        this.updrId = updrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdDTO ordDTO = (OrdDTO) o;
        return ordNo == ordDTO.ordNo && ordrId == ordDTO.ordrId && regrId == ordDTO.regrId && Objects.equals(updrId, ordDTO.updrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordNo, ordrId, regrId, updrId);
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
    }

    public int getOrdrId() {
        return ordrId;
    }

    public void setOrdrId(int ordrId) {
        this.ordrId = ordrId;
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
        return "OrdDTO{" +
                "ordNo=" + ordNo +
                ", ordrId=" + ordrId +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                '}';
    }
}
