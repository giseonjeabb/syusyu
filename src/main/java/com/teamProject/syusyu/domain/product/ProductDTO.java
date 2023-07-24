package com.teamProject.syusyu.domain.product;

import java.time.LocalDate;

import java.util.Date;
import java.util.Objects;

public class ProductDTO {
    private int prodId;
    private int cateId;
    private String prodNm;
    private String modelNm;
    private int brndId;
    private Date rlesDt;//출시일
    private int salePrc;
    private Integer dcPer;
    private Integer dcPrc;
    private double avgStarRating;
    private Integer revwCnt;
    private Integer dlvGhg;
    private Integer dlvChgDtl;//최대구매횟수
    private String prodDtlDesc;
    private String mfgdMatr; //소재
    private int mftco; //제조사
    private int mftNatn; //제조국
    private String repImg;
    private int status;
    private Date saleStDttm;
    private Date saleEdDttm;
    private Date dcStDttm;
    private Date dcEdDttm;
    private Date regDttm;
    private int regrId;
    private Date updDttm;
    private int updrId;
    private Date delDttm;
    private int dertId;
    private String delYn;

    //브랜드이름
    private String brndNm;

    //카테고리
    private int largeNo;
    private String largeNm;
    private int middleNo;
    private String middleNm;
    private int smallNo;
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



    public ProductDTO() {
    }



    public ProductDTO(int prodId, int cateId, int middleNo, String middleNm, int smallNo, String smallNm, String prodNm, String modelNm, int brndId, String brndNm, int salePrc, int dcPer, Integer dcPrc, String repImg, int status, Date saleStDttm, Date saleEdDttm, Date dcStDttm, Date dcEdDttm, Date regDttm, int regrId, double avgStarRating, Integer revwCnt) {
        this.prodId = prodId;
        this.cateId = cateId;
        this.middleNo = middleNo;
        this.middleNm = middleNm;
        this.smallNo = smallNo;
        this.smallNm = smallNm;
        this.prodNm = prodNm;
        this.modelNm = modelNm;
        this.brndId = brndId;
        this.brndNm = brndNm;
        this.salePrc = salePrc;
        this.dcPer = dcPer;
        this.dcPrc = dcPrc;
        this.repImg = repImg;
        this.status = status;
        this.saleStDttm = saleStDttm;
        this.saleEdDttm = saleEdDttm;
        this.dcStDttm = dcStDttm;
        this.dcEdDttm = dcEdDttm;
        this.regDttm = regDttm;
        this.regrId = regrId;
        this.avgStarRating = avgStarRating;
        this.revwCnt = revwCnt;
    }

    public ProductDTO(int prodId, int cateId, String prodNm, String modelNm, int brndId, Date rlesDt, int salePrc, Integer dcPer, Integer dcPrc, double avgStarRating, Integer revwCnt, String prodDtlDesc, String mfgdMatr, int mftco, int mftNatn, String repImg, int status, Date saleStDttm, Date saleEdDttm, Date dcEdDttm, Date regDttm, String brndNm, int middleNo, String middleNm, int smallNo, String smallNm) {
        this.prodId = prodId;
        this.cateId = cateId;
        this.prodNm = prodNm;
        this.modelNm = modelNm;
        this.brndId = brndId;
        this.rlesDt = rlesDt;
        this.salePrc = salePrc;
        this.dcPer = dcPer;
        this.dcPrc = dcPrc;
        this.avgStarRating = avgStarRating;
        this.revwCnt = revwCnt;
        this.prodDtlDesc = prodDtlDesc;
        this.mfgdMatr = mfgdMatr;
        this.mftco = mftco;
        this.mftNatn = mftNatn;
        this.repImg = repImg;
        this.status = status;
        this.saleStDttm = saleStDttm;
        this.saleEdDttm = saleEdDttm;
        this.dcEdDttm = dcEdDttm;
        this.regDttm = regDttm;
        this.brndNm = brndNm;
        this.middleNo = middleNo;
        this.middleNm = middleNm;
        this.smallNo = smallNo;
        this.smallNm = smallNm;

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

    public int getBrndId() {
        return brndId;
    }

    public void setBrndId(int brndId) {
        this.brndId = brndId;
    }

    public Date getRlesDt() {
        return rlesDt;
    }

    public void setRlesDt(Date rlesDt) {
        this.rlesDt = rlesDt;
    }

    public int getSalePrc() {
        return salePrc;
    }

    public void setSalePrc(int salePrc) {
        this.salePrc = salePrc;
    }

    public Integer getDcPer() {
        return dcPer;
    }

    public void setDcPer(Integer dcPer) {
        this.dcPer = dcPer;
    }

    public Integer getDcPrc() {
        return dcPrc;
    }

    public void setDcPrc(Integer dcPrc) {
        this.dcPrc = dcPrc;
    }

    public double getAvgStarRating() {
        return avgStarRating;
    }

    public void setAvgStarRating(double avgStarRating) {
        this.avgStarRating = avgStarRating;
    }

    public Integer getRevwCnt() {
        return revwCnt;
    }

    public void setRevwCnt(Integer revwCnt) {
        this.revwCnt = revwCnt;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getSaleStDttm() {
        return saleStDttm;
    }

    public void setSaleStDttm(Date saleStDttm) {
        this.saleStDttm = saleStDttm;
    }

    public Date getSaleEdDttm() {
        return saleEdDttm;
    }

    public void setSaleEdDttm(Date saleEdDttm) {
        this.saleEdDttm = saleEdDttm;
    }

    public Date getDcStDttm() {
        return dcStDttm;
    }

    public void setDcStDttm(Date dcStDttm) {
        this.dcStDttm = dcStDttm;
    }

    public Date getDcEdDttm() {
        return dcEdDttm;
    }

    public void setDcEdDttm(Date dcEdDttm) {
        this.dcEdDttm = dcEdDttm;
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

    public String getBrndNm() {
        return brndNm;
    }

    public void setBrndNm(String brndNm) {
        this.brndNm = brndNm;
    }

    public int getLargeNo() {
        return largeNo;
    }

    public void setLargeNo(int largeNo) {
        this.largeNo = largeNo;
    }

    public String getLargeNm() {
        return largeNm;
    }

    public void setLargeNm(String largeNm) {
        this.largeNm = largeNm;
    }

    public int getMiddleNo() {
        return middleNo;
    }

    public void setMiddleNo(int middleNo) {
        this.middleNo = middleNo;
    }

    public String getMiddleNm() {
        return middleNm;
    }

    public void setMiddleNm(String middleNm) {
        this.middleNm = middleNm;
    }

    public int getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(int smallNo) {
        this.smallNo = smallNo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return prodId == that.prodId && cateId == that.cateId && brndId == that.brndId && salePrc == that.salePrc && Double.compare(that.avgStarRating, avgStarRating) == 0 && mftco == that.mftco && mftNatn == that.mftNatn && status == that.status && regrId == that.regrId && updrId == that.updrId && dertId == that.dertId && largeNo == that.largeNo && middleNo == that.middleNo && smallNo == that.smallNo && optGrpId == that.optGrpId && optItemId == that.optItemId && optCombNo == that.optCombNo && optPrc == that.optPrc && invQty == that.invQty && Objects.equals(prodNm, that.prodNm) && Objects.equals(modelNm, that.modelNm) && Objects.equals(rlesDt, that.rlesDt) && Objects.equals(dcPer, that.dcPer) && Objects.equals(dcPrc, that.dcPrc) && Objects.equals(revwCnt, that.revwCnt) && Objects.equals(dlvGhg, that.dlvGhg) && Objects.equals(dlvChgDtl, that.dlvChgDtl) && Objects.equals(prodDtlDesc, that.prodDtlDesc) && Objects.equals(mfgdMatr, that.mfgdMatr) && Objects.equals(repImg, that.repImg) && Objects.equals(saleStDttm, that.saleStDttm) && Objects.equals(saleEdDttm, that.saleEdDttm) && Objects.equals(dcStDttm, that.dcStDttm) && Objects.equals(dcEdDttm, that.dcEdDttm) && Objects.equals(regDttm, that.regDttm) && Objects.equals(updDttm, that.updDttm) && Objects.equals(delDttm, that.delDttm) && Objects.equals(delYn, that.delYn) && Objects.equals(brndNm, that.brndNm) && Objects.equals(largeNm, that.largeNm) && Objects.equals(middleNm, that.middleNm) && Objects.equals(smallNm, that.smallNm) && Objects.equals(optGrpNm, that.optGrpNm) && Objects.equals(optItemNm, that.optItemNm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, cateId, prodNm, modelNm, brndId, rlesDt, salePrc, dcPer, dcPrc, avgStarRating, revwCnt, dlvGhg, dlvChgDtl, prodDtlDesc, mfgdMatr, mftco, mftNatn, repImg, status, saleStDttm, saleEdDttm, dcStDttm, dcEdDttm, regDttm, regrId, updDttm, updrId, delDttm, dertId, delYn, brndNm, largeNo, largeNm, middleNo, middleNm, smallNo, smallNm, optGrpId, optGrpNm, optItemId, optItemNm, optCombNo, optPrc, invQty);
    }

    
}

