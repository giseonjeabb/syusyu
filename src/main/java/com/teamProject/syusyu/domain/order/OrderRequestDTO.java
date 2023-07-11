package com.teamProject.syusyu.domain.order;

import java.util.List;

public class OrderRequestDTO {
    private List<OrderProduct> orderProductList;
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

    public List<OrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProduct> orderProductList) {
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
}
