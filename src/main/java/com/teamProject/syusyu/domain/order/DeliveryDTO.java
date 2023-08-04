package com.teamProject.syusyu.domain.order;

import java.util.Date;

public class DeliveryDTO {
    private int dlvNo;        // 배송번호
    private int ordDtlNo;     // 주문상세번호
    private String dlvStus;   // 배송상태
    private String dlvTp;     // 배송방법
    private Date dispatchDttm;// 발송처리일시
    private Integer pickupDttm;// 집화처리일시
    private Date shmtDttm;    // 출하일시
    private Date cmplDttm;    // 배송완료일시
    private String dlvCom;    // 택배사
    private String dlvComNm;    // 택배사명
    private String trckNo;    // 송장번호
    private Date regDttm;     // 등록일시
    private int regId;        // 등록자
    private Date updDttm;     // 수정일시
    private Integer updId;    // 수정자

    public int getDlvNo() {
        return dlvNo;
    }

    public void setDlvNo(int dlvNo) {
        this.dlvNo = dlvNo;
    }

    public int getOrdDtlNo() {
        return ordDtlNo;
    }

    public void setOrdDtlNo(int ordDtlNo) {
        this.ordDtlNo = ordDtlNo;
    }

    public String getDlvStus() {
        return dlvStus;
    }

    public void setDlvStus(String dlvStus) {
        this.dlvStus = dlvStus;
    }

    public String getDlvTp() {
        return dlvTp;
    }

    public void setDlvTp(String dlvTp) {
        this.dlvTp = dlvTp;
    }

    public Date getDispatchDttm() {
        return dispatchDttm;
    }

    public void setDispatchDttm(Date dispatchDttm) {
        this.dispatchDttm = dispatchDttm;
    }

    public Integer getPickupDttm() {
        return pickupDttm;
    }

    public void setPickupDttm(Integer pickupDttm) {
        this.pickupDttm = pickupDttm;
    }

    public Date getShmtDttm() {
        return shmtDttm;
    }

    public void setShmtDttm(Date shmtDttm) {
        this.shmtDttm = shmtDttm;
    }

    public Date getCmplDttm() {
        return cmplDttm;
    }

    public void setCmplDttm(Date cmplDttm) {
        this.cmplDttm = cmplDttm;
    }

    public String getDlvCom() {
        return dlvCom;
    }

    public void setDlvCom(String dlvCom) {
        this.dlvCom = dlvCom;
    }

    public String getDlvComNm() {
        return dlvComNm;
    }

    public void setDlvComNm(String dlvComNm) {
        this.dlvComNm = dlvComNm;
    }

    public String getTrckNo() {
        return trckNo;
    }

    public void setTrckNo(String trckNo) {
        this.trckNo = trckNo;
    }

    public Date getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(Date regDttm) {
        this.regDttm = regDttm;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public Date getUpdDttm() {
        return updDttm;
    }

    public void setUpdDttm(Date updDttm) {
        this.updDttm = updDttm;
    }

    public Integer getUpdId() {
        return updId;
    }

    public void setUpdId(Integer updId) {
        this.updId = updId;
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "dlvNo=" + dlvNo +
                ", ordDtlNo=" + ordDtlNo +
                ", dlvStus='" + dlvStus + '\'' +
                ", dlvTp='" + dlvTp + '\'' +
                ", dispatchDttm=" + dispatchDttm +
                ", pickupDttm=" + pickupDttm +
                ", shmtDttm=" + shmtDttm +
                ", cmplDttm=" + cmplDttm +
                ", dlvCom='" + dlvCom + '\'' +
                ", dlvComNm='" + dlvComNm + '\'' +
                ", trckNo='" + trckNo + '\'' +
                ", regDttm=" + regDttm +
                ", regId=" + regId +
                ", updDttm=" + updDttm +
                ", updId=" + updId +
                '}';
    }

    public static final class Builder {
        private int dlvNo;
        private int ordDtlNo;
        private String dlvStus;
        private String dlvTp;
        private Date dispatchDttm;
        private Integer pickupDttm;
        private Date shmtDttm;
        private Date cmplDttm;
        private String dlvCom;
        private String dlvComNm;
        private String trckNo;
        private Date regDttm;
        private int regId;
        private Date updDttm;
        private Integer updId;

        private Builder() {
        }

        public static Builder aDeliveryDTO() {
            return new Builder();
        }

        public Builder dlvNo(int dlvNo) {
            this.dlvNo = dlvNo;
            return this;
        }

        public Builder ordDtlNo(int ordDtlNo) {
            this.ordDtlNo = ordDtlNo;
            return this;
        }

        public Builder dlvStus(String dlvStus) {
            this.dlvStus = dlvStus;
            return this;
        }

        public Builder dlvTp(String dlvTp) {
            this.dlvTp = dlvTp;
            return this;
        }

        public Builder dispatchDttm(Date dispatchDttm) {
            this.dispatchDttm = dispatchDttm;
            return this;
        }

        public Builder pickupDttm(Integer pickupDttm) {
            this.pickupDttm = pickupDttm;
            return this;
        }

        public Builder shmtDttm(Date shmtDttm) {
            this.shmtDttm = shmtDttm;
            return this;
        }

        public Builder cmplDttm(Date cmplDttm) {
            this.cmplDttm = cmplDttm;
            return this;
        }

        public Builder dlvCom(String dlvCom) {
            this.dlvCom = dlvCom;
            return this;
        }

        public Builder dlvComNm(String dlvComNm) {
            this.dlvComNm = dlvComNm;
            return this;
        }

        public Builder trckNo(String trckNo) {
            this.trckNo = trckNo;
            return this;
        }

        public Builder regDttm(Date regDttm) {
            this.regDttm = regDttm;
            return this;
        }

        public Builder regId(int regId) {
            this.regId = regId;
            return this;
        }

        public Builder updDttm(Date updDttm) {
            this.updDttm = updDttm;
            return this;
        }

        public Builder updId(Integer updId) {
            this.updId = updId;
            return this;
        }

        public DeliveryDTO build() {
            DeliveryDTO deliveryDTO = new DeliveryDTO();
            deliveryDTO.setDlvNo(dlvNo);
            deliveryDTO.setOrdDtlNo(ordDtlNo);
            deliveryDTO.setDlvStus(dlvStus);
            deliveryDTO.setDlvTp(dlvTp);
            deliveryDTO.setDispatchDttm(dispatchDttm);
            deliveryDTO.setPickupDttm(pickupDttm);
            deliveryDTO.setShmtDttm(shmtDttm);
            deliveryDTO.setCmplDttm(cmplDttm);
            deliveryDTO.setDlvCom(dlvCom);
            deliveryDTO.setDlvComNm(dlvComNm);
            deliveryDTO.setTrckNo(trckNo);
            deliveryDTO.setRegDttm(regDttm);
            deliveryDTO.setRegId(regId);
            deliveryDTO.setUpdDttm(updDttm);
            deliveryDTO.setUpdId(updId);
            return deliveryDTO;
        }
    }
}
