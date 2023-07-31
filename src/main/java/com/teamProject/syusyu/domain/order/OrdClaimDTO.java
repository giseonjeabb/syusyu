package com.teamProject.syusyu.domain.order;

import java.util.Date;

public class OrdClaimDTO {
    private int ordClaimNo; // 주문클레임번호
    private int ordNo; // 주문번호
    private int ordDtlNo; // 주문상세번호
    private int claimTp; // 주문클레임 분류
    private String claimStus; // 주문클레임 처리상태
    private char rfndYn; // 환불완료여부(Y/N)
    private int totRfndAmt; // 총환불금액
    private int cardRfndAmt; // 카드환불금액
    private int rfndPnt; // 반환포인트
    private int reqrId; // 요청자
    private String reqRsn; // 요청사유
    private String reqDtlRsn; // 요청상세사유
    private Date aprvDttm; // 승인일시
    private Integer aprvrId; // 승인자
    private Date wdDttm; // 철회일시
    private Integer wdrId; // 철회자
    private String wdRsn; // 철회사유
    private String claimPic1; // 사진1
    private String claimPic2; // 사진2
    private String claimPic3; // 사진3
    private Integer claimDlvChg; // 배송비
    private char prodPuYn; // 상품수거여부
    private Integer payTy; // 결제정보코드
    private Integer puTp; // 수거방법
    private Integer puDlvCom; // 수거 택배사
    private String puTrackNo; // 수거 송장번호
    private Integer reDlvStus; // 재배송 상태
    private Integer reDlvTp; // 재배송 방법
    private Integer reDlvCom; // 재배송 택배사
    private String reDlvTrackNo; // 재배송 송장번호
    private Date regDttm; // 등록일시
    private int regrId; // 등록자
    private Date updDttm; // 수정일시
    private Integer updrId; // 수정자

    public int getOrdClaimNo() {
        return ordClaimNo;
    }

    public void setOrdClaimNo(int ordClaimNo) {
        this.ordClaimNo = ordClaimNo;
    }

    public int getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
    }

    public int getOrdDtlNo() {
        return ordDtlNo;
    }

    public void setOrdDtlNo(int ordDtlNo) {
        this.ordDtlNo = ordDtlNo;
    }

    public int getClaimTp() {
        return claimTp;
    }

    public void setClaimTp(int claimTp) {
        this.claimTp = claimTp;
    }

    public String getClaimStus() {
        return claimStus;
    }

    public void setClaimStus(String claimStus) {
        this.claimStus = claimStus;
    }

    public char getRfndYn() {
        return rfndYn;
    }

    public void setRfndYn(char rfndYn) {
        this.rfndYn = rfndYn;
    }

    public int getTotRfndAmt() {
        return totRfndAmt;
    }

    public void setTotRfndAmt(int totRfndAmt) {
        this.totRfndAmt = totRfndAmt;
    }

    public int getCardRfndAmt() {
        return cardRfndAmt;
    }

    public void setCardRfndAmt(int cardRfndAmt) {
        this.cardRfndAmt = cardRfndAmt;
    }

    public int getRfndPnt() {
        return rfndPnt;
    }

    public void setRfndPnt(int rfndPnt) {
        this.rfndPnt = rfndPnt;
    }

    public int getReqrId() {
        return reqrId;
    }

    public void setReqrId(int reqrId) {
        this.reqrId = reqrId;
    }

    public String getReqRsn() {
        return reqRsn;
    }

    public void setReqRsn(String reqRsn) {
        this.reqRsn = reqRsn;
    }

    public String getReqDtlRsn() {
        return reqDtlRsn;
    }

    public void setReqDtlRsn(String reqDtlRsn) {
        this.reqDtlRsn = reqDtlRsn;
    }

    public Date getAprvDttm() {
        return aprvDttm;
    }

    public void setAprvDttm(Date aprvDttm) {
        this.aprvDttm = aprvDttm;
    }

    public Integer getAprvrId() {
        return aprvrId;
    }

    public void setAprvrId(Integer aprvrId) {
        this.aprvrId = aprvrId;
    }

    public Date getWdDttm() {
        return wdDttm;
    }

    public void setWdDttm(Date wdDttm) {
        this.wdDttm = wdDttm;
    }

    public Integer getWdrId() {
        return wdrId;
    }

    public void setWdrId(Integer wdrId) {
        this.wdrId = wdrId;
    }

    public String getWdRsn() {
        return wdRsn;
    }

    public void setWdRsn(String wdRsn) {
        this.wdRsn = wdRsn;
    }

    public String getClaimPic1() {
        return claimPic1;
    }

    public void setClaimPic1(String claimPic1) {
        this.claimPic1 = claimPic1;
    }

    public String getClaimPic2() {
        return claimPic2;
    }

    public void setClaimPic2(String claimPic2) {
        this.claimPic2 = claimPic2;
    }

    public String getClaimPic3() {
        return claimPic3;
    }

    public void setClaimPic3(String claimPic3) {
        this.claimPic3 = claimPic3;
    }

    public Integer getClaimDlvChg() {
        return claimDlvChg;
    }

    public void setClaimDlvChg(Integer claimDlvChg) {
        this.claimDlvChg = claimDlvChg;
    }

    public char getProdPuYn() {
        return prodPuYn;
    }

    public void setProdPuYn(char prodPuYn) {
        this.prodPuYn = prodPuYn;
    }

    public Integer getPayTy() {
        return payTy;
    }

    public void setPayTy(Integer payTy) {
        this.payTy = payTy;
    }

    public Integer getPuTp() {
        return puTp;
    }

    public void setPuTp(Integer puTp) {
        this.puTp = puTp;
    }

    public Integer getPuDlvCom() {
        return puDlvCom;
    }

    public void setPuDlvCom(Integer puDlvCom) {
        this.puDlvCom = puDlvCom;
    }

    public String getPuTrackNo() {
        return puTrackNo;
    }

    public void setPuTrackNo(String puTrackNo) {
        this.puTrackNo = puTrackNo;
    }

    public Integer getReDlvStus() {
        return reDlvStus;
    }

    public void setReDlvStus(Integer reDlvStus) {
        this.reDlvStus = reDlvStus;
    }

    public Integer getReDlvTp() {
        return reDlvTp;
    }

    public void setReDlvTp(Integer reDlvTp) {
        this.reDlvTp = reDlvTp;
    }

    public Integer getReDlvCom() {
        return reDlvCom;
    }

    public void setReDlvCom(Integer reDlvCom) {
        this.reDlvCom = reDlvCom;
    }

    public String getReDlvTrackNo() {
        return reDlvTrackNo;
    }

    public void setReDlvTrackNo(String reDlvTrackNo) {
        this.reDlvTrackNo = reDlvTrackNo;
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

    public Integer getUpdrId() {
        return updrId;
    }

    public void setUpdrId(Integer updrId) {
        this.updrId = updrId;
    }

    @Override
    public String toString() {
        return "OrdClaimDTO{" +
                "ordClaimNo=" + ordClaimNo +
                ", ordNo=" + ordNo +
                ", ordDtlNo=" + ordDtlNo +
                ", claimTp=" + claimTp +
                ", claimStus='" + claimStus + '\'' +
                ", rfndYn=" + rfndYn +
                ", totRfndAmt=" + totRfndAmt +
                ", cardRfndAmt=" + cardRfndAmt +
                ", rfndPnt=" + rfndPnt +
                ", reqrId=" + reqrId +
                ", reqRsn='" + reqRsn + '\'' +
                ", reqDtlRsn='" + reqDtlRsn + '\'' +
                ", aprvDttm=" + aprvDttm +
                ", aprvrId=" + aprvrId +
                ", wdDttm=" + wdDttm +
                ", wdrId=" + wdrId +
                ", wdRsn='" + wdRsn + '\'' +
                ", claimPic1='" + claimPic1 + '\'' +
                ", claimPic2='" + claimPic2 + '\'' +
                ", claimPic3='" + claimPic3 + '\'' +
                ", claimDlvChg=" + claimDlvChg +
                ", prodPuYn=" + prodPuYn +
                ", payTy=" + payTy +
                ", puTp=" + puTp +
                ", puDlvCom=" + puDlvCom +
                ", puTrackNo='" + puTrackNo + '\'' +
                ", reDlvStus=" + reDlvStus +
                ", reDlvTp=" + reDlvTp +
                ", reDlvCom=" + reDlvCom +
                ", reDlvTrackNo='" + reDlvTrackNo + '\'' +
                ", regDttm=" + regDttm +
                ", regrId=" + regrId +
                ", updDttm=" + updDttm +
                ", updrId=" + updrId +
                '}';
    }

    public static final class Builder {
        private int ordClaimNo;
        private int ordNo;
        private int ordDtlNo;
        private int claimTp;
        private String claimStus;
        private char rfndYn;
        private int totRfndAmt;
        private int cardRfndAmt;
        private int rfndPnt;
        private int reqrId;
        private String reqRsn;
        private String reqDtlRsn;
        private Date aprvDttm;
        private Integer aprvrId;
        private Date wdDttm;
        private Integer wdrId;
        private String wdRsn;
        private String claimPic1;
        private String claimPic2;
        private String claimPic3;
        private Integer claimDlvChg;
        private char prodPuYn;
        private Integer payTy;
        private Integer puTp;
        private Integer puDlvCom;
        private String puTrackNo;
        private Integer reDlvStus;
        private Integer reDlvTp;
        private Integer reDlvCom;
        private String reDlvTrackNo;
        private Date regDttm;
        private int regrId;
        private Date updDttm;
        private Integer updrId;

        private Builder() {
        }

        public static Builder anOrdClaimDTO() {
            return new Builder();
        }

        public Builder ordClaimNo(int ordClaimNo) {
            this.ordClaimNo = ordClaimNo;
            return this;
        }

        public Builder ordNo(int ordNo) {
            this.ordNo = ordNo;
            return this;
        }

        public Builder ordDtlNo(int ordDtlNo) {
            this.ordDtlNo = ordDtlNo;
            return this;
        }

        public Builder claimTp(int claimTp) {
            this.claimTp = claimTp;
            return this;
        }

        public Builder claimStus(String claimStus) {
            this.claimStus = claimStus;
            return this;
        }

        public Builder rfndYn(char rfndYn) {
            this.rfndYn = rfndYn;
            return this;
        }

        public Builder totRfndAmt(int totRfndAmt) {
            this.totRfndAmt = totRfndAmt;
            return this;
        }

        public Builder cardRfndAmt(int cardRfndAmt) {
            this.cardRfndAmt = cardRfndAmt;
            return this;
        }

        public Builder rfndPnt(int rfndPnt) {
            this.rfndPnt = rfndPnt;
            return this;
        }

        public Builder reqrId(int reqrId) {
            this.reqrId = reqrId;
            return this;
        }

        public Builder reqRsn(String reqRsn) {
            this.reqRsn = reqRsn;
            return this;
        }

        public Builder reqDtlRsn(String reqDtlRsn) {
            this.reqDtlRsn = reqDtlRsn;
            return this;
        }

        public Builder aprvDttm(Date aprvDttm) {
            this.aprvDttm = aprvDttm;
            return this;
        }

        public Builder aprvrId(Integer aprvrId) {
            this.aprvrId = aprvrId;
            return this;
        }

        public Builder wdDttm(Date wdDttm) {
            this.wdDttm = wdDttm;
            return this;
        }

        public Builder wdrId(Integer wdrId) {
            this.wdrId = wdrId;
            return this;
        }

        public Builder wdRsn(String wdRsn) {
            this.wdRsn = wdRsn;
            return this;
        }

        public Builder claimPic1(String claimPic1) {
            this.claimPic1 = claimPic1;
            return this;
        }

        public Builder claimPic2(String claimPic2) {
            this.claimPic2 = claimPic2;
            return this;
        }

        public Builder claimPic3(String claimPic3) {
            this.claimPic3 = claimPic3;
            return this;
        }

        public Builder claimDlvChg(Integer claimDlvChg) {
            this.claimDlvChg = claimDlvChg;
            return this;
        }

        public Builder prodPuYn(char prodPuYn) {
            this.prodPuYn = prodPuYn;
            return this;
        }

        public Builder payTy(Integer payTy) {
            this.payTy = payTy;
            return this;
        }

        public Builder puTp(Integer puTp) {
            this.puTp = puTp;
            return this;
        }

        public Builder puDlvCom(Integer puDlvCom) {
            this.puDlvCom = puDlvCom;
            return this;
        }

        public Builder puTrackNo(String puTrackNo) {
            this.puTrackNo = puTrackNo;
            return this;
        }

        public Builder reDlvStus(Integer reDlvStus) {
            this.reDlvStus = reDlvStus;
            return this;
        }

        public Builder reDlvTp(Integer reDlvTp) {
            this.reDlvTp = reDlvTp;
            return this;
        }

        public Builder reDlvCom(Integer reDlvCom) {
            this.reDlvCom = reDlvCom;
            return this;
        }

        public Builder reDlvTrackNo(String reDlvTrackNo) {
            this.reDlvTrackNo = reDlvTrackNo;
            return this;
        }

        public Builder regDttm(Date regDttm) {
            this.regDttm = regDttm;
            return this;
        }

        public Builder regrId(int regrId) {
            this.regrId = regrId;
            return this;
        }

        public Builder updDttm(Date updDttm) {
            this.updDttm = updDttm;
            return this;
        }

        public Builder updrId(Integer updrId) {
            this.updrId = updrId;
            return this;
        }

        public OrdClaimDTO build() {
            OrdClaimDTO ordClaimDTO = new OrdClaimDTO();
            ordClaimDTO.setOrdClaimNo(ordClaimNo);
            ordClaimDTO.setOrdNo(ordNo);
            ordClaimDTO.setOrdDtlNo(ordDtlNo);
            ordClaimDTO.setClaimTp(claimTp);
            ordClaimDTO.setClaimStus(claimStus);
            ordClaimDTO.setRfndYn(rfndYn);
            ordClaimDTO.setTotRfndAmt(totRfndAmt);
            ordClaimDTO.setCardRfndAmt(cardRfndAmt);
            ordClaimDTO.setRfndPnt(rfndPnt);
            ordClaimDTO.setReqrId(reqrId);
            ordClaimDTO.setReqRsn(reqRsn);
            ordClaimDTO.setReqDtlRsn(reqDtlRsn);
            ordClaimDTO.setAprvDttm(aprvDttm);
            ordClaimDTO.setAprvrId(aprvrId);
            ordClaimDTO.setWdDttm(wdDttm);
            ordClaimDTO.setWdrId(wdrId);
            ordClaimDTO.setWdRsn(wdRsn);
            ordClaimDTO.setClaimPic1(claimPic1);
            ordClaimDTO.setClaimPic2(claimPic2);
            ordClaimDTO.setClaimPic3(claimPic3);
            ordClaimDTO.setClaimDlvChg(claimDlvChg);
            ordClaimDTO.setProdPuYn(prodPuYn);
            ordClaimDTO.setPayTy(payTy);
            ordClaimDTO.setPuTp(puTp);
            ordClaimDTO.setPuDlvCom(puDlvCom);
            ordClaimDTO.setPuTrackNo(puTrackNo);
            ordClaimDTO.setReDlvStus(reDlvStus);
            ordClaimDTO.setReDlvTp(reDlvTp);
            ordClaimDTO.setReDlvCom(reDlvCom);
            ordClaimDTO.setReDlvTrackNo(reDlvTrackNo);
            ordClaimDTO.setRegDttm(regDttm);
            ordClaimDTO.setRegrId(regrId);
            ordClaimDTO.setUpdDttm(updDttm);
            ordClaimDTO.setUpdrId(updrId);
            return ordClaimDTO;
        }
    }
}

