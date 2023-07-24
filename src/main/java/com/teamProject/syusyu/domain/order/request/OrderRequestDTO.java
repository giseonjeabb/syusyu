package com.teamProject.syusyu.domain.order.request;

import java.util.List;

public class OrderRequestDTO {
    private List<OrderProductRequestDTO> orderProductList;
    private String payTp;
    private int dlvFee;
    private Integer cpnIssNo;
    private int pntUseAmt;
    private String recipient;
    private String mpNo;
    private String safetNoYn;
    private String zipcode;
    private String dfltAddr;
    private String dtlAddr;
    private String dlvReqComt;

    public List<OrderProductRequestDTO> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProductRequestDTO> orderProductList) {
        this.orderProductList = orderProductList;
    }

    public String getPayTp() {
        return payTp;
    }

    public void setPayTp(String payTp) {
        this.payTp = payTp;
    }

    public int getDlvFee() {
        return dlvFee;
    }

    public void setDlvFee(int dlvFee) {
        this.dlvFee = dlvFee;
    }

    public Integer getCpnIssNo() {
        return cpnIssNo;
    }

    public void setCpnIssNo(Integer cpnIssNo) {
        this.cpnIssNo = cpnIssNo;
    }

    public int getPntUseAmt() {
        return pntUseAmt;
    }

    public void setPntUseAmt(int pntUseAmt) {
        this.pntUseAmt = pntUseAmt;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMpNo() {
        return mpNo;
    }

    public void setMpNo(String mpNo) {
        this.mpNo = mpNo;
    }

    public String getSafetNoYn() {
        return safetNoYn;
    }

    public void setSafetNoYn(String safetNoYn) {
        this.safetNoYn = safetNoYn;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDfltAddr() {
        return dfltAddr;
    }

    public void setDfltAddr(String dfltAddr) {
        this.dfltAddr = dfltAddr;
    }

    public String getDtlAddr() {
        return dtlAddr;
    }

    public void setDtlAddr(String dtlAddr) {
        this.dtlAddr = dtlAddr;
    }

    public String getDlvReqComt() {
        return dlvReqComt;
    }

    public void setDlvReqComt(String dlvReqComt) {
        this.dlvReqComt = dlvReqComt;
    }

    @Override
    public String toString() {
        return "OrderRequestDTO{" +
                "orderProductList=" + orderProductList +
                ", payTp='" + payTp + '\'' +
                ", dlvFee=" + dlvFee +
                ", cpnIssNo=" + cpnIssNo +
                ", pntUseAmt=" + pntUseAmt +
                ", recipient='" + recipient + '\'' +
                ", mpNo='" + mpNo + '\'' +
                ", safetNoYn='" + safetNoYn + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", dfltAddr='" + dfltAddr + '\'' +
                ", dtlAddr='" + dtlAddr + '\'' +
                ", dlvReqComt='" + dlvReqComt + '\'' +
                '}';
    }


    public static final class Builder {
        private List<OrderProductRequestDTO> orderProductList;
        private String payTp;
        private int dlvFee;
        private Integer cpnIssNo;
        private int pntUseAmt;
        private String recipient;
        private String mpNo;
        private String safetNoYn;
        private String zipcode;
        private String dfltAddr;
        private String dtlAddr;
        private String dlvReqComt;

        private Builder() {
        }

        public static Builder anOrderRequestDTO() {
            return new Builder();
        }

        public Builder orderProductList(List<OrderProductRequestDTO> orderProductList) {
            this.orderProductList = orderProductList;
            return this;
        }

        public Builder payTp(String payTp) {
            this.payTp = payTp;
            return this;
        }

        public Builder dlvFee(int dlvFee) {
            this.dlvFee = dlvFee;
            return this;
        }

        public Builder cpnIssNo(Integer cpnIssNo) {
            this.cpnIssNo = cpnIssNo;
            return this;
        }

        public Builder pntUseAmt(int pntUseAmt) {
            this.pntUseAmt = pntUseAmt;
            return this;
        }

        public Builder recipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder mpNo(String mpNo) {
            this.mpNo = mpNo;
            return this;
        }

        public Builder safetNoYn(String safetNoYn) {
            this.safetNoYn = safetNoYn;
            return this;
        }

        public Builder zipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public Builder dfltAddr(String dfltAddr) {
            this.dfltAddr = dfltAddr;
            return this;
        }

        public Builder dtlAddr(String dtlAddr) {
            this.dtlAddr = dtlAddr;
            return this;
        }

        public Builder dlvReqComt(String dlvReqComt) {
            this.dlvReqComt = dlvReqComt;
            return this;
        }

        public OrderRequestDTO build() {
            OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
            orderRequestDTO.setOrderProductList(orderProductList);
            orderRequestDTO.setPayTp(payTp);
            orderRequestDTO.setDlvFee(dlvFee);
            orderRequestDTO.setCpnIssNo(cpnIssNo);
            orderRequestDTO.setPntUseAmt(pntUseAmt);
            orderRequestDTO.setRecipient(recipient);
            orderRequestDTO.setMpNo(mpNo);
            orderRequestDTO.setSafetNoYn(safetNoYn);
            orderRequestDTO.setZipcode(zipcode);
            orderRequestDTO.setDfltAddr(dfltAddr);
            orderRequestDTO.setDtlAddr(dtlAddr);
            orderRequestDTO.setDlvReqComt(dlvReqComt);
            return orderRequestDTO;
        }
    }
}
