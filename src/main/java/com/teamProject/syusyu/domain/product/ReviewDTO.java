package com.teamProject.syusyu.domain.product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class ReviewDTO {
    private String brndKoNm;
    private String prodNm;
    private Integer revwNo;
    private Integer prodId;
    private BigDecimal starRating;
    private Integer height;
    private BigDecimal weight;
    private Integer shoeSize;
    private Integer likeCnt;
    private String revwCn;
    private Date regDttm;
    private String lginId;
    private Integer regrId;
    private Date updDttm;
    private Integer updrId;
    private Date delDttm;
    private Integer delrId;
    private String delYn;
    private String imageList;


    public ReviewDTO(){}


    public ReviewDTO(String brndKoNm, String prodNm, Integer revwNo, Integer prodId, BigDecimal starRating, Integer height, BigDecimal weight, Integer shoeSize, Integer likeCnt, String revwCn, Date regDttm, String lginId, Integer regrId, Date updDttm, Integer updrId, Date delDttm, Integer delrId, String delYn, String imageList) {
        this.brndKoNm = brndKoNm;
        this.prodNm = prodNm;
        this.revwNo = revwNo;
        this.prodId = prodId;
        this.starRating = starRating;
        this.height = height;
        this.weight = weight;
        this.shoeSize = shoeSize;
        this.likeCnt = likeCnt;
        this.revwCn = revwCn;
        this.regDttm = regDttm;
        this.lginId = lginId;
        this.regrId = regrId;
        this.updDttm = updDttm;
        this.updrId = updrId;
        this.delDttm = delDttm;
        this.delrId = delrId;
        this.delYn = delYn;
        this.imageList = imageList;
    }

    public String getBrndKoNm() {
        return brndKoNm;
    }

    public void setBrndKoNm(String brndKoNm) {
        this.brndKoNm = brndKoNm;
    }

    public String getProdNm() {
        return prodNm;
    }

    public void setProdNm(String prodNm) {
        this.prodNm = prodNm;
    }

    public Integer getRevwNo() {
        return revwNo;
    }

    public void setRevwNo(Integer revwNo) {
        this.revwNo = revwNo;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public BigDecimal getStarRating() {
        return starRating;
    }

    public void setStarRating(BigDecimal starRating) {
        this.starRating = starRating;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(Integer shoeSize) {
        this.shoeSize = shoeSize;
    }

    public Integer getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(Integer likeCnt) {
        this.likeCnt = likeCnt;
    }

    public String getRevwCn() {
        return revwCn;
    }

    public void setRevwCn(String revwCn) {
        this.revwCn = revwCn;
    }

    public Date getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    public String getLginId() {
        return lginId;
    }

    public void setLginId(String lginId) {
        this.lginId = lginId;
    }

    public Integer getRegrId() {
        return regrId;
    }

    public void setRegrId(Integer regrId) {
        this.regrId = regrId;
    }

    public Date getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(Date updDttm) {
        this.updDttm = updDttm;
    }

    public Integer getUpdrId() {
        return updrId;
    }

    public void setUpdrId(Integer updrId) {
        this.updrId = updrId;
    }

    public Date getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(Date delDttm) {
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

    public String getImageList() {
        return imageList;
    }

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "brndKoNm='" + brndKoNm + '\'' +
                ", prodNm='" + prodNm + '\'' +
                ", revwNo=" + revwNo +
                ", prodId=" + prodId +
                ", starRating=" + starRating +
                ", height=" + height +
                ", weight=" + weight +
                ", shoeSize=" + shoeSize +
                ", likeCnt=" + likeCnt +
                ", revwCn='" + revwCn + '\'' +
                ", regDttm=" + regDttm +
                ", lginId='" + lginId + '\'' +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                ", delDttm=" + delDttm +
                ", delrId=" + delrId +
                ", delYn='" + delYn + '\'' +
                ", imageList='" + imageList + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDTO reviewDTO = (ReviewDTO) o;
        return Objects.equals(brndKoNm, reviewDTO.brndKoNm) && Objects.equals(prodNm, reviewDTO.prodNm) && Objects.equals(revwNo, reviewDTO.revwNo) && Objects.equals(prodId, reviewDTO.prodId) && Objects.equals(starRating, reviewDTO.starRating) && Objects.equals(height, reviewDTO.height) && Objects.equals(weight, reviewDTO.weight) && Objects.equals(shoeSize, reviewDTO.shoeSize) && Objects.equals(likeCnt, reviewDTO.likeCnt) && Objects.equals(revwCn, reviewDTO.revwCn) && Objects.equals(regDttm, reviewDTO.regDttm) && Objects.equals(lginId, reviewDTO.lginId) && Objects.equals(regrId, reviewDTO.regrId) && Objects.equals(updDttm, reviewDTO.updDttm) && Objects.equals(updrId, reviewDTO.updrId) && Objects.equals(delDttm, reviewDTO.delDttm) && Objects.equals(delrId, reviewDTO.delrId) && Objects.equals(delYn, reviewDTO.delYn) && Objects.equals(imageList, reviewDTO.imageList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brndKoNm, prodNm, revwNo, prodId, starRating, height, weight, shoeSize, likeCnt, revwCn, regDttm, lginId, regrId, updDttm, updrId, delDttm, delrId, delYn, imageList);
    }
}
