package com.teamProject.syusyu.domain.prodect;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProductDTO {
    private int prodId;
    private int cateId;
    private String prodNm;
    private String modelNm;
    private int brandId;
    private LocalDateTime rlesDt;//출시일
    private int price;
    private Integer dcPer;
    private Integer dlvGhg;
    private Integer dlvChgDtl;//최대구매횟수
    private String prodDtlDesc;
    private String mfgdMatr; //소재
    private int mftco; //제조사
    private int mftNatn; //제조국
    private String repImg;
    private int saleStus;
    private LocalDateTime saleStDttm;
    private LocalDateTime saleEdDttm;
    private LocalDateTime dcStDttm;
    private LocalDateTime dcEdDttm;
    private LocalDateTime regDttm;
    private int regrId;
    private LocalDateTime UpdDttm;
    private int updrId;
    private LocalDateTime delDttm;
    private int dertId;
    private String delYN;

    //브랜드이름
    private String brandNm;

    //카테고리
    private String largeNm;
    private String middleNm;
    private String smallNm;


    //그룹 옵션
    private int optGrpId;
    private String optGrpNm;

    //옵션항목
    private int optItemId;
    private String optItemNm;

    //옵션조합번호
    private int optCombNo;

    //상품옵션
    private int optPrc;
    private int invQty;

    ProductDTO(){}


    @Override
    public String toString() {
        return "ProductDTO{" +
                "prodId=" + prodId +
                ", cateId=" + cateId +
                ", prodNm='" + prodNm + '\'' +
                ", modelNm='" + modelNm + '\'' +
                ", brandId=" + brandId +
                ", rlesDt=" + rlesDt +
                ", price=" + price +
                ", dcPer=" + dcPer +
                ", dlvGhg=" + dlvGhg +
                ", dlvChgDtl=" + dlvChgDtl +
                ", prodDtlDesc='" + prodDtlDesc + '\'' +
                ", mfgdMatr='" + mfgdMatr + '\'' +
                ", mftco=" + mftco +
                ", mftNatn=" + mftNatn +
                ", repImg='" + repImg + '\'' +
                ", saleStus=" + saleStus +
                ", saleStDttm=" + saleStDttm +
                ", saleEdDttm=" + saleEdDttm +
                ", dcStDttm=" + dcStDttm +
                ", dcEdDttm=" + dcEdDttm +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", UpdDttm=" + UpdDttm +
                ", updrId=" + updrId +
                ", delDttm=" + delDttm +
                ", dertId=" + dertId +
                ", delYN='" + delYN + '\'' +
                ", brandNm='" + brandNm + '\'' +
                ", largeNm='" + largeNm + '\'' +
                ", middleNm='" + middleNm + '\'' +
                ", smallNm='" + smallNm + '\'' +
                ", optGrpId=" + optGrpId +
                ", optGrpNm='" + optGrpNm + '\'' +
                ", optItemId=" + optItemId +
                ", optItemNm='" + optItemNm + '\'' +
                ", optCombNo=" + optCombNo +
                ", optPrc=" + optPrc +
                ", invQty=" + invQty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return prodId == that.prodId && cateId == that.cateId && brandId == that.brandId && price == that.price && mftco == that.mftco && mftNatn == that.mftNatn && saleStus == that.saleStus && regrId == that.regrId && updrId == that.updrId && dertId == that.dertId && optGrpId == that.optGrpId && optItemId == that.optItemId && optCombNo == that.optCombNo && optPrc == that.optPrc && invQty == that.invQty && Objects.equals(prodNm, that.prodNm) && Objects.equals(modelNm, that.modelNm) && Objects.equals(rlesDt, that.rlesDt) && Objects.equals(dcPer, that.dcPer) && Objects.equals(dlvGhg, that.dlvGhg) && Objects.equals(dlvChgDtl, that.dlvChgDtl) && Objects.equals(prodDtlDesc, that.prodDtlDesc) && Objects.equals(mfgdMatr, that.mfgdMatr) && Objects.equals(repImg, that.repImg) && Objects.equals(saleStDttm, that.saleStDttm) && Objects.equals(saleEdDttm, that.saleEdDttm) && Objects.equals(dcStDttm, that.dcStDttm) && Objects.equals(dcEdDttm, that.dcEdDttm) && Objects.equals(regDttm, that.regDttm) && Objects.equals(UpdDttm, that.UpdDttm) && Objects.equals(delDttm, that.delDttm) && Objects.equals(delYN, that.delYN) && Objects.equals(brandNm, that.brandNm) && Objects.equals(largeNm, that.largeNm) && Objects.equals(middleNm, that.middleNm) && Objects.equals(smallNm, that.smallNm) && Objects.equals(optGrpNm, that.optGrpNm) && Objects.equals(optItemNm, that.optItemNm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, cateId, prodNm, modelNm, brandId, rlesDt, price, dcPer, dlvGhg, dlvChgDtl, prodDtlDesc, mfgdMatr, mftco, mftNatn, repImg, saleStus, saleStDttm, saleEdDttm, dcStDttm, dcEdDttm, regDttm, regrId, UpdDttm, updrId, delDttm, dertId, delYN, brandNm, largeNm, middleNm, smallNm, optGrpId, optGrpNm, optItemId, optItemNm, optCombNo, optPrc, invQty);
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getProdNm() {
        return prodNm;
    }

    public void setProdNm(String prodNm) {
        this.prodNm = prodNm;
    }

    public String getModelNm() {
        return modelNm;
    }

    public void setModelNm(String modelNm) {
        this.modelNm = modelNm;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getRlesDt() {
        return rlesDt;
    }

    public void setRlesDt(LocalDateTime rlesDt) {
        this.rlesDt = rlesDt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getDcPer() {
        return dcPer;
    }

    public void setDcPer(Integer dcPer) {
        this.dcPer = dcPer;
    }

    public Integer getDlvGhg() {
        return dlvGhg;
    }

    public void setDlvGhg(Integer dlvGhg) {
        this.dlvGhg = dlvGhg;
    }

    public Integer getDlvChgDtl() {
        return dlvChgDtl;
    }

    public void setDlvChgDtl(Integer dlvChgDtl) {
        this.dlvChgDtl = dlvChgDtl;
    }

    public String getProdDtlDesc() {
        return prodDtlDesc;
    }

    public void setProdDtlDesc(String prodDtlDesc) {
        this.prodDtlDesc = prodDtlDesc;
    }

    public String getMfgdMatr() {
        return mfgdMatr;
    }

    public void setMfgdMatr(String mfgdMatr) {
        this.mfgdMatr = mfgdMatr;
    }

    public int getMftco() {
        return mftco;
    }

    public void setMftco(int mftco) {
        this.mftco = mftco;
    }

    public int getMftNatn() {
        return mftNatn;
    }

    public void setMftNatn(int mftNatn) {
        this.mftNatn = mftNatn;
    }

    public String getRepImg() {
        return repImg;
    }

    public void setRepImg(String repImg) {
        this.repImg = repImg;
    }

    public int getSaleStus() {
        return saleStus;
    }

    public void setSaleStus(int saleStus) {
        this.saleStus = saleStus;
    }

    public LocalDateTime getSaleStDttm() {
        return saleStDttm;
    }

    public void setSaleStDttm(LocalDateTime saleStDttm) {
        this.saleStDttm = saleStDttm;
    }

    public LocalDateTime getSaleEdDttm() {
        return saleEdDttm;
    }

    public void setSaleEdDttm(LocalDateTime saleEdDttm) {
        this.saleEdDttm = saleEdDttm;
    }

    public LocalDateTime getDcStDttm() {
        return dcStDttm;
    }

    public void setDcStDttm(LocalDateTime dcStDttm) {
        this.dcStDttm = dcStDttm;
    }

    public LocalDateTime getDcEdDttm() {
        return dcEdDttm;
    }

    public void setDcEdDttm(LocalDateTime dcEdDttm) {
        this.dcEdDttm = dcEdDttm;
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
        return UpdDttm;
    }

    public void setUpdDttm(LocalDateTime updDttm) {
        UpdDttm = updDttm;
    }

    public int getUpdrId() {
        return updrId;
    }

    public void setUpdrId(int updrId) {
        this.updrId = updrId;
    }

    public LocalDateTime getDelDttm() {
        return delDttm;
    }

    public void setDelDttm(LocalDateTime delDttm) {
        this.delDttm = delDttm;
    }

    public int getDertId() {
        return dertId;
    }

    public void setDertId(int dertId) {
        this.dertId = dertId;
    }

    public String getDelYN() {
        return delYN;
    }

    public void setDelYN(String delYN) {
        this.delYN = delYN;
    }

    public String getBrandNm() {
        return brandNm;
    }

    public void setBrandNm(String brandNm) {
        this.brandNm = brandNm;
    }

    public String getLargeNm() {
        return largeNm;
    }

    public void setLargeNm(String largeNm) {
        this.largeNm = largeNm;
    }

    public String getMiddleNm() {
        return middleNm;
    }

    public void setMiddleNm(String middleNm) {
        this.middleNm = middleNm;
    }

    public String getSmallNm() {
        return smallNm;
    }

    public void setSmallNm(String smallNm) {
        this.smallNm = smallNm;
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

    public int getOptItemId() {
        return optItemId;
    }

    public void setOptItemId(int optItemId) {
        this.optItemId = optItemId;
    }

    public String getOptItemNm() {
        return optItemNm;
    }

    public void setOptItemNm(String optItemNm) {
        this.optItemNm = optItemNm;
    }

    public int getOptCombNo() {
        return optCombNo;
    }

    public void setOptCombNo(int optCombNo) {
        this.optCombNo = optCombNo;
    }

    public int getOptPrc() {
        return optPrc;
    }

    public void setOptPrc(int optPrc) {
        this.optPrc = optPrc;
    }

    public int getInvQty() {
        return invQty;
    }

    public void setInvQty(int invQty) {
        this.invQty = invQty;
    }
}
