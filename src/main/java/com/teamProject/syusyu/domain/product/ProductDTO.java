package com.teamProject.syusyu.domain.product;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;
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
    private String mftcoNm;
    private int mftNatn; //제조국
    private String mftNatnNm;
    private String repImg;
    private int status; //판매중, 품절
    private String statusNm;
    private String dspyYn;
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
    private int buyCnt;
    private int buyPrc;

    //브랜드이름
    private String brndNm;
    private String brndKoNm;

    //카테고리
    private int largeNo;
    private String largeNm;
    private int middleNo;
    private String middleNm;
    private int smallNo;
    private String smallNm;
    //정렬
    private String sort;
    //공통코드
    private int code;
    private String cdNm;
    private int totQty;
    private int point;
    private int totPrc;
    private String mftcoName;
    private String mftNatnName;
    private int vwCnt;

    public ProductDTO() {
    }

    public ProductDTO(int code, String cdNm) {
        this.code = code;
        this.cdNm = cdNm;
    }


    //상품등록
    public ProductDTO(int cateId, String prodNm, String modelNm, int brndId, Date rlesDt, Integer dlvChgDtl, String prodDtlDesc, String mfgdMatr, int mftco, int mftNatn, String repImg, int status, int regrId) {
        this.cateId = cateId;
        this.prodNm = prodNm;
        this.modelNm = modelNm;
        this.brndId = brndId;
        this.rlesDt = rlesDt;
        this.dlvChgDtl = dlvChgDtl;
        this.prodDtlDesc = prodDtlDesc;
        this.mfgdMatr = mfgdMatr;
        this.mftco = mftco;
        this.mftNatn = mftNatn;
        this.repImg = repImg;
        this.status = status;
        this.regrId = regrId;
    }

    public ProductDTO(int prodId, int cateId, int middleNo, String middleNm, int smallNo, String smallNm, String prodNm, String modelNm, int brndId, String brndNm, int salePrc, int dcPer, Integer dcPrc, String repImg, int status, Date saleStDttm, Date saleEdDttm, Date dcStDttm, Date dcEdDttm, Date regDttm, int regrId, double avgStarRating, Integer revwCnt, String sort, int buyCnt) {
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
        this.sort = sort;
    }

    public ProductDTO(String mftcoNm, String mftNatnNm, String statusNm, int prodId, int cateId, String prodNm, String modelNm, int brndId, Date rlesDt, int salePrc, Integer dcPer, Integer dcPrc, double avgStarRating, Integer revwCnt, String prodDtlDesc, String mfgdMatr, int mftco, int mftNatn, String repImg, int status, Date saleStDttm, Date saleEdDttm, Date dcEdDttm, Date regDttm, String brndNm, int middleNo, String middleNm, int smallNo, String smallNm, String sort) {
        this.mftcoNm = mftcoNm;
        this.mftNatnNm = mftNatnNm;
        this.statusNm = statusNm;
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
        this.sort = sort;

    }

    //상품조회
    public ProductDTO(int prodId, int cateId, String prodNm, String modelNm, int salePrc, Integer dcPer, Integer dcPrc, double avgStarRating, Integer revwCnt, Integer dlvGhg, Integer dlvChgDtl, String prodDtlDesc, String mfgdMatr, String mftcoNm, String mftNatnNm, String statusNm, String dspyYn, Date saleStDttm, Date saleEdDttm, Date dcStDttm, Date dcEdDttm, Date regDttm, int regrId, Date updDttm, int buyCnt, String brndNm, String largeNm, String middleNm, String smallNm, String sort, int code, String cdNm, int totQty, int buyPrc, int point, int totPrc, String mftcoName, String mftNatnName, int vwCnt, String brndKoNm) {
        this.prodId = prodId;
        this.cateId = cateId;
        this.prodNm = prodNm;
        this.modelNm = modelNm;
        this.salePrc = salePrc;
        this.dcPer = dcPer;
        this.dcPrc = dcPrc;
        this.avgStarRating = avgStarRating;
        this.revwCnt = revwCnt;
        this.dlvGhg = dlvGhg;
        this.dlvChgDtl = dlvChgDtl;
        this.prodDtlDesc = prodDtlDesc;
        this.mfgdMatr = mfgdMatr;
        this.mftcoNm = mftcoNm;
        this.mftNatnNm = mftNatnNm;
        this.statusNm = statusNm;
        this.dspyYn = dspyYn;
        this.saleStDttm = saleStDttm;
        this.saleEdDttm = saleEdDttm;
        this.dcStDttm = dcStDttm;
        this.dcEdDttm = dcEdDttm;
        this.regDttm = regDttm;
        this.regrId = regrId;
        this.updDttm = updDttm;
        this.buyCnt = buyCnt;
        this.brndNm = brndNm;
        this.largeNm = largeNm;
        this.middleNm = middleNm;
        this.smallNm = smallNm;
        this.sort = sort;
        this.code = code;
        this.cdNm = cdNm;
        this.totQty = totQty;
        this.buyPrc = buyPrc;
        this.point = point;
        this.totPrc = totPrc;
        this.mftcoName = mftcoName;
        this.mftNatnName = mftNatnName;
        this.vwCnt = vwCnt;
        this.brndKoNm=brndKoNm;
    }

    //메인상품진열
    public ProductDTO(int prodId, int cateId, int middleNo, String middleNm, int smallNo, String smallNm, String prodNm, String modelNm, int brndId, String brndNm, int salePrc, int dcPer, Integer dcPrc, String repImg, int status, Date saleStDttm, Date saleEdDttm, Date dcStDttm, Date dcEdDttm, Date regDttm, int regrId, double avgStarRating, Integer revwCnt, int buyCnt) {
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
        this.buyCnt=buyCnt;
    }
    public String getBrndKoNm() {
        return brndKoNm;
    }

    public void setBrndKoNm(String brndKoNm) {
        this.brndKoNm = brndKoNm;
    }

    public int getTotQty() {
        return totQty;
    }

    public void setTotQty(int totQty) {
        this.totQty = totQty;
    }

    public int getBuyPrc() {
        return buyPrc;
    }

    public void setBuyPrc(int buyPrc) {
        this.buyPrc = buyPrc;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getTotPrc() {
        return totPrc;
    }

    public void setTotPrc(int totPrc) {
        this.totPrc = totPrc;
    }

    public String getMftcoName() {
        return mftcoName;
    }

    public void setMftcoName(String mftcoName) {
        this.mftcoName = mftcoName;
    }

    public String getMftNatnName() {
        return mftNatnName;
    }

    public void setMftNatnName(String mftNatnName) {
        this.mftNatnName = mftNatnName;
    }

    public int getVwCnt() {
        return vwCnt;
    }

    public void setVwCnt(int vwCnt) {
        this.vwCnt = vwCnt;
    }

    public int getBuyCnt() {
        return buyCnt;
    }

    public void setBuyCnt(int buyCnt) {
        this.buyCnt = buyCnt;
    }

    public String getDspyYn() {
        return dspyYn;
    }

    public void setDspyYn(String dspyYn) {
        this.dspyYn = dspyYn;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCdNm() {
        return cdNm;
    }

    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }

    public String getMftcoNm() {
        return mftcoNm;
    }

    public void setMftcoNm(String mftcoNm) {
        this.mftcoNm = mftcoNm;
    }

    public String getMftNatnNm() {
        return mftNatnNm;
    }

    public void setMftNatnNm(String mftNatnNm) {
        this.mftNatnNm = mftNatnNm;
    }

    public String getStatusNm() {
        return statusNm;
    }

    public void setStatusNm(String statusNm) {
        this.statusNm = statusNm;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return prodId == that.prodId && cateId == that.cateId && brndId == that.brndId && salePrc == that.salePrc && Double.compare(that.avgStarRating, avgStarRating) == 0 && mftco == that.mftco && mftNatn == that.mftNatn && status == that.status && regrId == that.regrId && updrId == that.updrId && dertId == that.dertId && buyCnt == that.buyCnt && largeNo == that.largeNo && middleNo == that.middleNo && smallNo == that.smallNo && code == that.code && totQty == that.totQty && buyPrc == that.buyPrc && point == that.point && totPrc == that.totPrc && vwCnt == that.vwCnt && Objects.equals(prodNm, that.prodNm) && Objects.equals(modelNm, that.modelNm) && Objects.equals(rlesDt, that.rlesDt) && Objects.equals(dcPer, that.dcPer) && Objects.equals(dcPrc, that.dcPrc) && Objects.equals(revwCnt, that.revwCnt) && Objects.equals(dlvGhg, that.dlvGhg) && Objects.equals(dlvChgDtl, that.dlvChgDtl) && Objects.equals(prodDtlDesc, that.prodDtlDesc) && Objects.equals(mfgdMatr, that.mfgdMatr) && Objects.equals(mftcoNm, that.mftcoNm) && Objects.equals(mftNatnNm, that.mftNatnNm) && Objects.equals(repImg, that.repImg) && Objects.equals(statusNm, that.statusNm) && Objects.equals(dspyYn, that.dspyYn) && Objects.equals(saleStDttm, that.saleStDttm) && Objects.equals(saleEdDttm, that.saleEdDttm) && Objects.equals(dcStDttm, that.dcStDttm) && Objects.equals(dcEdDttm, that.dcEdDttm) && Objects.equals(regDttm, that.regDttm) && Objects.equals(updDttm, that.updDttm) && Objects.equals(delDttm, that.delDttm) && Objects.equals(delYn, that.delYn) && Objects.equals(brndNm, that.brndNm) && Objects.equals(brndKoNm, that.brndKoNm) && Objects.equals(largeNm, that.largeNm) && Objects.equals(middleNm, that.middleNm) && Objects.equals(smallNm, that.smallNm) && Objects.equals(sort, that.sort) && Objects.equals(cdNm, that.cdNm) && Objects.equals(mftcoName, that.mftcoName) && Objects.equals(mftNatnName, that.mftNatnName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, cateId, prodNm, modelNm, brndId, rlesDt, salePrc, dcPer, dcPrc, avgStarRating, revwCnt, dlvGhg, dlvChgDtl, prodDtlDesc, mfgdMatr, mftco, mftcoNm, mftNatn, mftNatnNm, repImg, status, statusNm, dspyYn, saleStDttm, saleEdDttm, dcStDttm, dcEdDttm, regDttm, regrId, updDttm, updrId, delDttm, dertId, delYn, buyCnt, brndNm, brndKoNm, largeNo, largeNm, middleNo, middleNm, smallNo, smallNm, sort, code, cdNm, totQty, buyPrc, point, totPrc, mftcoName, mftNatnName, vwCnt);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "prodId=" + prodId +
                ", cateId=" + cateId +
                ", prodNm='" + prodNm + '\'' +
                ", modelNm='" + modelNm + '\'' +
                ", brndId=" + brndId +
                ", rlesDt=" + rlesDt +
                ", salePrc=" + salePrc +
                ", dcPer=" + dcPer +
                ", dcPrc=" + dcPrc +
                ", avgStarRating=" + avgStarRating +
                ", revwCnt=" + revwCnt +
                ", dlvGhg=" + dlvGhg +
                ", dlvChgDtl=" + dlvChgDtl +
                ", prodDtlDesc='" + prodDtlDesc + '\'' +
                ", mfgdMatr='" + mfgdMatr + '\'' +
                ", mftco=" + mftco +
                ", mftcoNm='" + mftcoNm + '\'' +
                ", mftNatn=" + mftNatn +
                ", mftNatnNm='" + mftNatnNm + '\'' +
                ", repImg='" + repImg + '\'' +
                ", status=" + status +
                ", statusNm='" + statusNm + '\'' +
                ", dspyYn='" + dspyYn + '\'' +
                ", saleStDttm=" + saleStDttm +
                ", saleEdDttm=" + saleEdDttm +
                ", dcStDttm=" + dcStDttm +
                ", dcEdDttm=" + dcEdDttm +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                ", delDttm=" + delDttm +
                ", dertId=" + dertId +
                ", delYn='" + delYn + '\'' +
                ", buyCnt=" + buyCnt +
                ", brndNm='" + brndNm + '\'' +
                ", brndKoNm='" + brndKoNm + '\'' +
                ", largeNo=" + largeNo +
                ", largeNm='" + largeNm + '\'' +
                ", middleNo=" + middleNo +
                ", middleNm='" + middleNm + '\'' +
                ", smallNo=" + smallNo +
                ", smallNm='" + smallNm + '\'' +
                ", sort='" + sort + '\'' +
                ", code=" + code +
                ", cdNm='" + cdNm + '\'' +
                ", totQty=" + totQty +
                ", buyPrc=" + buyPrc +
                ", point=" + point +
                ", totPrc=" + totPrc +
                ", mftcoName='" + mftcoName + '\'' +
                ", mftNatnName='" + mftNatnName + '\'' +
                ", vwCnt=" + vwCnt +
                '}';
    }
}

