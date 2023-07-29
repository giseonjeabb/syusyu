package com.teamProject.syusyu.domain.product;

import java.util.Date;
import java.util.Objects;

public class BrandDTO {
    private int brndId;
    private String brndNm;
    private String brndKoNm;
    private String brndDesc;
    private String brndLgPath;
    private int likeCnt;
    private Date regDttm;
    private int regrId;
    private Date updDttm;
    private int updrId;
    private Date delDttm;
    private int dertId;
    private String delYn;

    public BrandDTO() {
    }

    public BrandDTO(int brndId, String brndNm, String brndKoNm, String brndDesc, String brndLgPath, int likeCnt, Date regDttm, int regrId) {
        this.brndId = brndId;
        this.brndNm = brndNm;
        this.brndKoNm = brndKoNm;
        this.brndDesc = brndDesc;
        this.brndLgPath = brndLgPath;
        this.likeCnt = likeCnt;
        this.regDttm = regDttm;
        this.regrId = regrId;
    }

    @Override
    public String toString() {
        return "BrandDTO{" +
                "brndId=" + brndId +
                ", brndNm='" + brndNm + '\'' +
                ", brndKoNm='" + brndKoNm + '\'' +
                ", brndDesc='" + brndDesc + '\'' +
                ", brndLgPath='" + brndLgPath + '\'' +
                ", likeCnt=" + likeCnt +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                ", delDttm=" + delDttm +
                ", dertId=" + dertId +
                ", delYn='" + delYn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandDTO brandDTO = (BrandDTO) o;
        return brndId == brandDTO.brndId && likeCnt == brandDTO.likeCnt && regrId == brandDTO.regrId && updrId == brandDTO.updrId && dertId == brandDTO.dertId && Objects.equals(brndNm, brandDTO.brndNm) && Objects.equals(brndKoNm, brandDTO.brndKoNm) && Objects.equals(brndDesc, brandDTO.brndDesc) && Objects.equals(brndLgPath, brandDTO.brndLgPath) && Objects.equals(regDttm, brandDTO.regDttm) && Objects.equals(updDttm, brandDTO.updDttm) && Objects.equals(delDttm, brandDTO.delDttm) && Objects.equals(delYn, brandDTO.delYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brndId, brndNm, brndKoNm, brndDesc, brndLgPath, likeCnt, regDttm, regrId, updDttm, updrId, delDttm, dertId, delYn);
    }

    public int getBrndId() {
        return brndId;
    }

    public void setBrndId(int brndId) {
        this.brndId = brndId;
    }

    public String getBrndNm() {
        return brndNm;
    }

    public void setBrndNm(String brndNm) {
        this.brndNm = brndNm;
    }

    public String getBrndKoNm() {
        return brndKoNm;
    }

    public void setBrndKoNm(String brndKoNm) {
        this.brndKoNm = brndKoNm;
    }

    public String getBrndDesc() {
        return brndDesc;
    }

    public void setBrndDesc(String brndDesc) {
        this.brndDesc = brndDesc;
    }

    public String getBrndLgPath() {
        return brndLgPath;
    }

    public void setBrndLgPath(String brndLgPath) {
        this.brndLgPath = brndLgPath;
    }

    public int getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(int likeCnt) {
        this.likeCnt = likeCnt;
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

    public int getDertId() {
        return dertId;
    }

    public void setDertId(int dertId) {
        this.dertId = dertId;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }
}
