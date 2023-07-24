package com.teamProject.syusyu.domain.order;

import com.teamProject.syusyu.domain.order.request.OrderProductRequestDTO;
import com.teamProject.syusyu.domain.order.request.OrderRequestDTO;

import java.util.ArrayList;
import java.util.List;

// 주문 생성 시 필요한 정보들을 묶어서 관리
public class Order {
    private OrdDTO ord;                           // 주문
    private List<OrdDtlDTO> ordDtlList;           // 주문상세
    private List<OrdStusHistDTO> ordStusHistList; // 주문상태이력
    private PayDTO pay;                           // 결제
    private PayRsltDTO payRslt;                   // 결제승인결과
    private OrdDlvAddrDTO ordDlvAddr;             // 주문배송지

    /**
     * 주문 객체를 생성하는 생성자
     * 입력받은 주문 요청 DTO와 주문자 ID를 바탕으로 주문 정보를 생성하고 관련 정보들을 설정
     *
     * @param orderRequestDTO 주문 요청 정보를 담고 있는 DTO
     * @param mbrId           주문자 ID
     * @author min
     * @since 2023/07/11
     */
    public Order(OrderRequestDTO orderRequestDTO, int mbrId) {
        validateOrderRequest(orderRequestDTO, mbrId);
        this.ord = createOrder(mbrId); // 1. 주문(ORD) 정보 세팅
        this.ordDtlList = createOrderDetails(orderRequestDTO, mbrId); // 2. 주문상세(ORD_DTL) 정보 세팅
        this.ordStusHistList = createOrderStatusHistories(orderRequestDTO, mbrId); // 3. 주문상태이력(ORD_STUS_HIST) 정보 세팅
        this.pay = createPayment(orderRequestDTO, mbrId);
        this.payRslt = createPayResult(orderRequestDTO, mbrId);
        this.ordDlvAddr = createOrderDeliveryAddress(orderRequestDTO, mbrId);
    }

    private void validateOrderRequest(OrderRequestDTO orderRequestDTO, int mbrId) {
        // Implement your validation logic here
    }

    /**
     * 주문 정보를 생성한다.
     *
     * @param mbrId 주문자 ID
     * @return 주문 정보
     * @author min
     * @since 2023/07/11
     */
    private OrdDTO createOrder(int mbrId) {
        return OrdDTO.Builder.anOrdDTO()
                .ordrId(mbrId) // 주문자아이디
                .regrId(mbrId) // 등록자아이디
                .build();
    }

    /**
     * 주문 상세 정보 리스트를 생성한다.
     *
     * @param orderRequestDTO 주문 요청 정보를 담고 있는 DTO
     * @param mbrId           주문자 ID
     * @return 주문상세정보 리스트
     * @author min
     * @since 2023/07/11
     */
    private List<OrdDtlDTO> createOrderDetails(OrderRequestDTO orderRequestDTO, int mbrId) {
        List<OrdDtlDTO> ordDtlList = new ArrayList<>();
        for (OrderProductRequestDTO orderProduct : orderRequestDTO.getOrderProductList()) {
            OrdDtlDTO ordDtl = OrdDtlDTO.Builder.anOrdDtlDTO()
                    .prodId(orderProduct.getProdId())       // 상품아아디
                    .prodNm(orderProduct.getProdNm())       // 상품명
                    .optCombNo(orderProduct.getOptCombNo()) // 옵션조합번호
                    .qty(orderProduct.getQty())             // 수량
                    .regrId(mbrId)                          // 등록자
                    .build();
            ordDtlList.add(ordDtl);
        }
        return ordDtlList;
    }

    /**
     * 주문상태이력 리스트를 생성한다.
     *
     * @param orderRequestDTO 주문 요청 정보를 담고 있는 DTO
     * @param mbrId           주문자 ID
     * @return 주문상태이력 리스트
     * @author min
     * @since 2023/07/11
     */
    private List<OrdStusHistDTO> createOrderStatusHistories(OrderRequestDTO orderRequestDTO, int mbrId) {
        List<OrdStusHistDTO> ordStusHistList = new ArrayList<>();
        for (OrderProductRequestDTO orderProduct : orderRequestDTO.getOrderProductList()) {
            OrdStusHistDTO ordStusHist = OrdStusHistDTO.Builder.anOrdStusHistDTO()
                    .nowOrdStus("10") // 현재주문상태
                    .regrId(mbrId)    // 등록자
                    .build();
            ordStusHistList.add(ordStusHist);
        }
        return ordStusHistList;
    }

    /**
     * 결제 정보를 생성한다.
     *
     * @param orderRequestDTO 주문 요청 정보를 담고 있는 DTO
     * @param mbrId           주문자 ID
     * @return 결제 정보
     * @author min
     * @since 2023/07/11
     */
    private PayDTO createPayment(OrderRequestDTO orderRequestDTO, int mbrId) {
        return PayDTO.Builder.aPayDTO()
                .payerId(mbrId)                            // 결제자아이디
                .payTp(orderRequestDTO.getPayTp())         // 결제수단
                .dlvFee(orderRequestDTO.getDlvFee())       // 배송비
                .cpnIssNo(orderRequestDTO.getCpnIssNo())   // 쿠폰발행번호
                .pntUseAmt(orderRequestDTO.getPntUseAmt()) // 포인트사용금액
                .regrId(mbrId)                             // 등록자아아디
                .build();
    }

    /**
     * 결제승인결과를 생성한다.
     *
     * @param orderRequestDTO 주문 요청 정보를 담고 있는 DTO
     * @param mbrId           주문자 ID
     * @return 결제승인결과
     * @author min
     * @since 2023/07/11
     */
    private PayRsltDTO createPayResult(OrderRequestDTO orderRequestDTO, int mbrId) {
        return PayRsltDTO.Builder.aPayRsltDTO()
                .regrId(mbrId) // 등록자아아디
                .build();
    }

    /**
     * 주문배송지 정보를 생성한다.
     *
     * @param orderRequestDTO 주문 요청 정보를 담고 있는 DTO
     * @param mbrId           주문자 ID
     * @return 주문배송지 정보
     * @author min
     * @since 2023/07/11
     */
    private OrdDlvAddrDTO createOrderDeliveryAddress(OrderRequestDTO orderRequestDTO, int mbrId) {
        return OrdDlvAddrDTO.Builder.anOrdDlvAddrDTO()
                .recipient(orderRequestDTO.getRecipient())   // 수령인
                .mpNo(orderRequestDTO.getMpNo())             // 휴대전화번호
                .safetNoYn(orderRequestDTO.getSafetNoYn())   // 안심번호여부YN
                .zipcode(orderRequestDTO.getZipcode())       // 우편번호
                .dfltAddr(orderRequestDTO.getDfltAddr())       // 기본주소
                .dtlAddr(orderRequestDTO.getDtlAddr())       // 상세주소
                .dlvReqComt(orderRequestDTO.getDlvReqComt()) // 배송요청사항
                .regrId(mbrId).build();                      // 등록자아아디
    }

    // start ==================== getter, setter ====================
    public OrdDTO getOrd() {
        return ord;
    }

    public void setOrd(OrdDTO ord) {
        this.ord = ord;
    }

    public List<OrdDtlDTO> getOrdDtlList() {
        return ordDtlList;
    }

    public void setOrdDtlList(List<OrdDtlDTO> ordDtlList) {
        this.ordDtlList = ordDtlList;
    }

    public List<OrdStusHistDTO> getOrdStusHistList() {
        return ordStusHistList;
    }

    public void setOrdStusHistList(List<OrdStusHistDTO> ordStusHistList) {
        this.ordStusHistList = ordStusHistList;
    }

    public PayDTO getPay() {
        return pay;
    }

    public void setPay(PayDTO pay) {
        this.pay = pay;
    }

    public PayRsltDTO getPayRslt() {
        return payRslt;
    }

    public void setPayRslt(PayRsltDTO payRslt) {
        this.payRslt = payRslt;
    }

    public OrdDlvAddrDTO getOrdDlvAddr() {
        return ordDlvAddr;
    }

    public void setOrdDlvAddr(OrdDlvAddrDTO ordDlvAddr) {
        this.ordDlvAddr = ordDlvAddr;
    }

    // ==================== getter, setter ==================== end
}
