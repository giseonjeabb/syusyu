package com.teamProject.syusyu.domain.product;

import java.util.Date;
import java.util.Objects;

public class OptGrpDTO {
    private int optGrpId;
    private String optGrpNm;
    private int prodId;

    private Date regDttm;
    private int regrId;
    private Date updDttm;
    private int updrId;
    private Date delDttm;
    private int delrId;
    private String delYn;

    public OptGrpDTO(){}

    public OptGrpDTO(String optGrpNm, int prodId, int regrId) {
        this.optGrpNm = optGrpNm;
        this.prodId=prodId;
        this.regrId=regrId;
    }


    public int getOptGrpId() {
        return optGrpId;
    }

    public void setOptGrpId(int optGrpId) {
        this.optGrpId = optGrpId;
    }

    public String getOptGrpNm() {
        return optGrpNm;
    }

    public void setOptGrpNm(String optGrpNm) {
        this.optGrpNm = optGrpNm;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public Date getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    public int getRegrId() {
        return regrId;
    }

    public void setRegrId(int regrId) {
        this.regrId = regrId;
    }

    public Date getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(Date updDttm) {
        this.updDttm = updDttm;
    }

    public int getUpdrId() {
        return updrId;
    }

    public void setUpdrId(int updrId) {
        this.updrId = updrId;
    }

    public Date getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(Date delDttm) {
        this.delDttm = delDttm;
    }

    public int getDelrId() {
        return delrId;
    }

    public void setDelrId(int delrId) {
        this.delrId = delrId;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptGrpDTO optGrpDTO = (OptGrpDTO) o;
        return optGrpId == optGrpDTO.optGrpId && prodId == optGrpDTO.prodId && regrId == optGrpDTO.regrId && updrId == optGrpDTO.updrId && delrId == optGrpDTO.delrId && Objects.equals(optGrpNm, optGrpDTO.optGrpNm) && Objects.equals(regDttm, optGrpDTO.regDttm) && Objects.equals(updDttm, optGrpDTO.updDttm) && Objects.equals(delDttm, optGrpDTO.delDttm) && Objects.equals(delYn, optGrpDTO.delYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optGrpId, optGrpNm, prodId, regDttm, regrId, updDttm, updrId, delDttm, delrId, delYn);
    }

    @Override
    public String toString() {
        return "OptGrpDTO{" +
                "optGrpId=" + optGrpId +
                ", optGrpNm='" + optGrpNm + '\'' +
                ", prodId=" + prodId +
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
