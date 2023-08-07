package com.teamProject.syusyu.service.fos.order.impl;

import com.teamProject.syusyu.dao.member.DlvAddrDAO;
import com.teamProject.syusyu.dao.member.MemberDao;
import com.teamProject.syusyu.dao.order.*;
import com.teamProject.syusyu.dao.order.OrderInfoDAO;
import com.teamProject.syusyu.domain.member.CouponDTO;
import com.teamProject.syusyu.domain.member.DlvAddrDTO;
import com.teamProject.syusyu.domain.member.MemberDTO;
import com.teamProject.syusyu.domain.order.*;
import com.teamProject.syusyu.service.base.order.OrderServiceBase;
import com.teamProject.syusyu.service.fos.order.FOS_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FOS_OrderServiceImpl extends OrderServiceBase implements FOS_OrderService {
    private final MemberDao memberDao;
    private final DlvAddrDAO dlvAddrDAO;
    private final CartProdDAO cartProdDAO;
    private final OrdDAO ordDAO;
    private final OrdDtlDAO ordDtlDAO;
    private final OrdStusHistDAO ordStusHistDAO;
    private final PayDAO payDAO;
    private final PayRsltDAO payRsltDAO;
    private final OrdDlvAddrDAO ordDlvAddrDAO;
    private final OrderInfoDAO orderInfoDAO;
    private final OrdClaimDAO ordClaimDAO;
    private final DeliveryDAO deliveryDAO;

    @Autowired
    public FOS_OrderServiceImpl(MemberDao memberDao, DlvAddrDAO dlvAddrDAO, CartProdDAO cartProdDAO, OrdDAO ordDAO, OrdDtlDAO ordDtlDAO, OrdStusHistDAO ordStusHistDAO, PayDAO payDAO, PayRsltDAO payRsltDAO, OrdDlvAddrDAO ordDlvAddrDAO, OrderInfoDAO orderInfoDAO, OrdClaimDAO ordClaimDAO, DeliveryDAO deliveryDAO) {
        this.memberDao = memberDao;
        this.dlvAddrDAO = dlvAddrDAO;
        this.cartProdDAO = cartProdDAO;
        this.ordDAO = ordDAO;
        this.ordDtlDAO = ordDtlDAO;
        this.ordStusHistDAO = ordStusHistDAO;
        this.payDAO = payDAO;
        this.payRsltDAO = payRsltDAO;
        this.ordDlvAddrDAO = ordDlvAddrDAO;
        this.orderInfoDAO = orderInfoDAO;
        this.ordClaimDAO = ordClaimDAO;
        this.deliveryDAO = deliveryDAO;
    }

    /**
     * 선택한 상품들의 유효성을 검사한다.
     *
     * @param cartProdNoArr 주문할 장바구니상품아이디 배열
     * @param mbrId         장바구니를 조회할 사용자의 아이디
     * @throws Exception 유효성 검사 실패 시 발생하는 예외
     * @author min
     * @since 2023/07/07
     */
    private void validateCartProducts(int[] cartProdNoArr, int mbrId) throws Exception {
        // 1. 유효성검사를 한다.(선택한 상품이 구매가 가능한 상태인지 검증해야 한다.)
        // 1-1. 상품의 판매상태가 601이어야 한다.
        // 1-2. 내가 구매하려는 개수만큼 재고수량이 존재하는지 체크해야 한다.
    }


    /**
     * 주문서에 필요한 정보들을 조회해서 주문서 화면에 넘겨준다.
     *
     * @param cartProdNoArr 주문할 장바구니상품아이디 배열
     * @param mbrId         장바구니를 조회할 사용자의 아이디
     * @return 주문서에 필요한 정보들(주문상품정보, 주문자정보, 배송지정보, 할인정보)
     * @author min
     * @since 2023/07/07
     */
    @Override
    public Map<String, Object> orderSheet(int[] cartProdNoArr, int mbrId) throws Exception {
        // 주문상품정보 조회
        List<CartProdDTO> cartProdList = getOrderCartProdList(cartProdNoArr, mbrId);

        // 주문자정보 조회
        MemberDTO memberInfo = memberDao.selectUserInfo(mbrId);

        // 배송지정보 조회
        DlvAddrDTO dlvAddr = dlvAddrDAO.selectDefaultDlvAddr(mbrId);

        // 할인정보 조회
        int couponCnt = memberDao.memberCouponCnt(mbrId);       // 쿠폰
        int totPoint = memberDao.selectMemberTotalPoint(mbrId); // 포인트

        // 총 주문금액 계산을 위한 값
        int totProdAmt = cartProdList.stream().mapToInt(CartProdDTO::getTotPrc).sum(); // 총 상품금액
        int totDcPrc = cartProdList.stream().mapToInt(CartProdDTO::getTotDcPrc).sum(); // 총 할인적용금액

        int dlvFee = totDcPrc >= 50000 ? 0 : 3000;

        Map<String, Object> orderInfo = new HashMap<>();
        orderInfo.put("cartProdList", cartProdList);
        orderInfo.put("memberInfo", memberInfo);
        orderInfo.put("dlvAddr", dlvAddr);
        orderInfo.put("couponCnt", couponCnt);
        orderInfo.put("totPoint", totPoint);
        orderInfo.put("totProdAmt", totProdAmt);
        orderInfo.put("totDcPrc", totDcPrc);
        orderInfo.put("dlvFee", dlvFee);

        return orderInfo;
    }

    // 주문상품정보 조회
    private List<CartProdDTO> getOrderCartProdList(int[] cartProdNoArr, int mbrId) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("cartProdNoArr", cartProdNoArr);
        param.put("mbrId", mbrId);

        return cartProdDAO.selectOrderCartProd(param);
    }


    /**
     * 주문을 생성한다.
     *
     * @throws Exception 주문 처리 도중 발생하는 예외
     * @author min
     * @since 2023/07/07
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void order(Order order) throws Exception {
        // 1. 주문 정보를 DB에 삽입한다.
        createOrder(order.getOrd());

        // 2. 주문상세정보와 주문상태이력 정보를 DB에 삽입한다.
        addOrderDetailsAndStatusHistories(order.getOrdDtlList(), order.getOrdStusHistList(), order.getOrd().getOrdNo());

        // 3. 결제정보를 DB에 삽입한다.
        addPay(order.getPay(), order.getOrd().getOrdNo());

        // 4. 결제승인결과 정보를 DB에 삽입한다.
        addPayResult(order.getPayRslt(), order.getPay().getPayNo());

        // 5. 주문배송지 정보를 DB에 삽입한다.
        addDeliveryAddressForOrder(order.getOrdDlvAddr(), order.getOrd().getOrdNo());
    }

    /**
     * 주문 정보를 DB에 삽입한다.
     *
     * @param ord 삽입할 주문 정보 DTO
     * @throws Exception 주문 정보 삽입 도중 발생하는 예외
     * @author min
     * @since 2023/07/11
     */
    private void createOrder(OrdDTO ord) throws Exception {
        ordDAO.insertOrder(ord);
    }

    /**
     * 주문 상세 정보와 주문 상태 이력 정보를 DB에 삽입한다.
     *
     * @param ordDtlList      삽입할 주문 상세 정보 DTO 리스트
     * @param ordStusHistList 삽입할 주문 상태 이력 정보 DTO 리스트
     * @param ordNo           주문 번호
     * @throws Exception 주문 상세 정보 및 주문 상태 이력 정보 삽입 도중 발생하는 예외
     * @author min
     * @since 2023/07/11
     */
    private void addOrderDetailsAndStatusHistories(List<OrdDtlDTO> ordDtlList, List<OrdStusHistDTO> ordStusHistList, int ordNo) throws Exception {
        if (ordDtlList.size() != ordStusHistList.size()) {
            throw new IllegalArgumentException("주문 상세 리스트와 주문 상태 이력 리스트의 크기가 같아야 합니다.");
        }

        for (int i = 0; i < ordDtlList.size(); i++) {
            OrdDtlDTO ordDtlDTO = ordDtlList.get(i);
            OrdStusHistDTO ordStusHistDTO = ordStusHistList.get(i);

            // 필요한 데이터 세팅
            ordDtlDTO.setOrdNo(ordNo);

            // ord_dtl 및 주문 상태 이력 insert
            addOrderDetailAndStatusHistory(ordDtlDTO, ordStusHistDTO);
        }
    }

    /**
     * 결제 정보를 DB에 삽입한다.
     *
     * @param pay   삽입할 결제 정보 DTO
     * @param ordNo 주문 번호
     * @throws Exception 결제 정보 삽입 도중 발생하는 예외
     * @author min
     * @since 2023/07/11
     */
    private void addPay(PayDTO pay, int ordNo) throws Exception {
        // 필요한 데이터 세팅
        pay.setOrdNo(ordNo); // 주문번호
        // pay insert
        payDAO.insertPay(pay);
    }

    /**
     * 결제승인결과 정보를 DB에 삽입한다.
     *
     * @param payRslt 삽입할 결제승인결과 정보 DTO
     * @param payNo   결제 번호
     * @throws Exception 결제승인결과 정보 삽입 도중 발생하는 예외
     * @author min
     * @since 2023/07/11
     */
    private void addPayResult(PayRsltDTO payRslt, int payNo) throws Exception {
        // 필요한 정보 세팅
        payRslt.setPayNo(payNo); // 결제번호
        // payRslt insert
        payRsltDAO.insertPayResult(payRslt);
    }

    /**
     * 주문 배송지 정보를 DB에 삽입한다.
     *
     * @param ordDlvAddr 삽입할 주문 배송지 정보 DTO
     * @param ordNo      주문 번호
     * @throws Exception 주문 배송지 정보 삽입 도중 발생하는 예외
     * @author min
     * @since 2023/07/11
     */
    private void addDeliveryAddressForOrder(OrdDlvAddrDTO ordDlvAddr, int ordNo) throws Exception {
        // 필요한 데이터 세팅
        ordDlvAddr.setOrdNo(ordNo); // 주문번호
        // ordDlvAddr insert
        ordDlvAddrDAO.insertOrdDlvAddr(ordDlvAddr);
    }

    /**
     * 주문 상세 정보와 주문 상태 이력 정보를 동시에 DB에 삽입한다.
     *
     * @param ordDtlDTO      주문 상세 정보 DTO
     * @param ordStusHistDTO 주문 상태 이력 정보 DTO
     * @throws Exception 주문 상세 정보 및 주문 상태 이력 정보 삽입 도중 발생하는 예외
     * @author min
     * @since 2023/07/11
     */
    public void addOrderDetailAndStatusHistory(OrdDtlDTO ordDtlDTO, OrdStusHistDTO ordStusHistDTO) throws Exception {
        // 1. 주문 상세 정보를 DB에 insert
        ordDtlDAO.insertOrderDetail(ordDtlDTO);

        // insert 후에 생성된 주문 상세 번호를 가져와서 주문 상태 이력 정보에 주문 상세 번호를 세팅
        ordStusHistDTO.setOrdDtlNo(ordDtlDTO.getOrdDtlNo());
        // 2. 주문 상태 이력 정보를 DB에 insert
        ordStusHistDAO.insertOrderStatusHistory(ordStusHistDTO);
    }

    /**
     * 사용자가 주문/결제 시 사용할 수 있는 쿠폰 리스트를 조회한다.
     * 총 상품금액에 따라 사용 가능한 쿠폰들이 달라진다.(최소 주문금액 만족해야 함)
     *
     * @param mbrId    사용자의 아이디
     * @param totDcPrc 총 할인적용금액
     * @return 사용 가능한 쿠폰 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/16
     */
    @Override
    public List<CouponDTO> getOrderCouponList(int mbrId, int totDcPrc) throws Exception {
        return ordDAO.selectOrderCoupon(mbrId, totDcPrc);
    }

    /**
     * 사용자의 주문 리스트를 조회한다.
     * 조회 기간(startDate, endDate)와 사용자 ID(mbrId)를 파라미터로 받아 해당 기간 동안의 주문을 조회한다.
     *
     * @param param Map 객체로, 'startDate', 'endDate', 'mbrId' 키를 가지며, 각각 조회 시작일, 조회 종료일, 사용자 ID를 값으로 가진다.
     * @return 해당 기간 동안의 주문 정보를 담은 OrderInfoDTO 객체의 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/18
     */
    @Override
    public Map<Integer, List<OrderInfoDTO>> getOrderInfoListByOrdNo(Map<String, Object> param) throws Exception {
        List<OrderInfoDTO> orderInfoDTOList = orderInfoDAO.selectOrderList(param);

        return orderInfoDTOList.stream().collect(Collectors.groupingBy(OrderInfoDTO::getOrdNo, LinkedHashMap::new, Collectors.toList()));
    }

    /**
     * 주어진 조회 조건에 따라 주문 상세 정보를 조회한다.
     *
     * @param param 조회 조건을 담고 있는 Map 객체.
     * @return 조회 조건을 만족하는 주문 상세 정보를 담은 Map 객체
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/18
     */
    @Override
    public Map<String, Object> getOrderDetailList(Map<String, Integer> param) throws Exception {
        Map<String, Object> result = new HashMap<>();
        List<OrderInfoDTO> orderDetailList = orderInfoDAO.selectOrderDetailList(param);
        OrdDlvAddrDTO ordDlvAddr = ordDlvAddrDAO.selectOrdDlvAddrByOrdNo((int) param.get("ordNo"));
        PayInfoDTO payInfo = orderInfoDAO.selectPayInfo(param);

        result.put("orderDetailList", orderDetailList);
        result.put("ordDlvAddr", ordDlvAddr);
        result.put("payInfo", payInfo);

        return result;
    }

    /**
     * 주어진 조회 조건에 따라 주문 취소 가능한 목록을 조회한다.
     * 사용자 ID와 주문번호를 파라미터로 받아 해당 주문에 대한 취소 가능 목록을 조회한다.
     *
     * @param param Map 객체로, 'mbrId', 'ordNo' 키를 가지며, 각각 사용자 ID와 주문번호를 값으로 가진다.
     * @return 주문 취소 가능한 목록을 담은 OrderInfoDTO 객체의 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/07/31
     */
    @Override
    public List<OrderInfoDTO> getCancelOrderList(Map<String, Integer> param) throws Exception {
        return orderInfoDAO.selectOrderDetailList(param);
    }

    /**
     * 주문 취소처리를 한다.
     *
     * @param ordClaimDTO 주문을 취소할 주문 클레임 DTO
     * @param mbrId 사용자의 ID
     * @throws Exception 주문 취소 과정에서 발생할 수 있는 예외
     * @author min
     * @since 2023/07/30
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelOrder(OrdClaimDTO ordClaimDTO, List<Integer> ordDtlNoList, int mbrId) throws Exception {
        for (int ordDtlNo : ordDtlNoList) {
            ordClaimDTO.setOrdDtlNo(ordDtlNo);
            // 1. 주문취소할 주문 건의 주문상태를 '70'(주문취소)로 바꾼다.
            // 2. 주문상태이력 테이블에 상태변경 이력을 남긴다.
            updateOrderStatusAndAddHistory(ordDtlNo, mbrId, "70");
            // 3. 주문 클레임을 등록한다.
            registerOrderClaim(ordClaimDTO, mbrId);
            // 4. 새로운 결제 정보를 삽입한다.
            insertNewPay(ordClaimDTO.getOrdNo(), mbrId);
            // 5. 기존 결제 정보의 결제 상태를 일부 주문취소로 변경한다.
            changePayStatus(ordClaimDTO.getOrdNo(), mbrId, "20");

            // 6. TODO 재고수량 롤백
            // 7. TODO PG 주문취소
        }
    }

    /**
     * 주문 클레임을 생성한다.
     *
     * @param ordClaimDTO 주문 클레임 DTO
     * @throws Exception 주문 클레임 생성 과정에서 발생할 수 있는 예외
     * @author min
     * @since 2023/07/30
     */
    private void registerOrderClaim(OrdClaimDTO ordClaimDTO, int mbrId) throws Exception {
        ordClaimDTO.setRegrId(mbrId);
        ordClaimDAO.insertCancelClaim(ordClaimDTO);
    }

    /**
     * 새로운 결제 정보를 생성한다.
     *
     * @param ordNo 주문 번호
     * @param mbrId 사용자의 ID
     * @throws Exception 결제 정보 생성 과정에서 발생할 수 있는 예외
     * @author min
     * @since 2023/07/30
     */
    private void insertNewPay(int ordNo, int mbrId) throws Exception {
        Map<String, Object> insertCancelPayParam = createParamMapForPay(mbrId, ordNo);
        payDAO.insertCancelPay(insertCancelPayParam);
    }

    /**
     * 결제 상태를 변경한다.
     *
     * @param ordNo 주문번호
     * @param mbrId 사용자의 ID
     * @param newStatus 새로운 결제 상태
     * @throws Exception 결제 상태 변경 과정에서 발생할 수 있는 예외
     * @author min
     * @since 2023/07/30
     */
    private void changePayStatus(int ordNo, int mbrId, String newStatus) throws Exception {
        Map<String, Object> updateCancelPayParam = createParamMapForPay(mbrId, ordNo);
        updateCancelPayParam.put("payStus", newStatus);
        payDAO.updateCancelPay(updateCancelPayParam);
    }

    /**
     * 결제에 대한 매개변수를 생성한다.
     *
     * @param mbrId 사용자의 ID
     * @param ordNo 주문 번호
     * @return 결제 정보를 담은 Map 객체
     * @author min
     * @since 2023/07/30
     */
    private Map<String, Object> createParamMapForPay(int mbrId, int ordNo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("regrId", mbrId);
        paramMap.put("ordNo", ordNo);
        paramMap.put("updrId", mbrId);

        return paramMap;
    }
}
