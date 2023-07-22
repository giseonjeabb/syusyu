package com.teamProject.syusyu.service.fos.order.impl;

import com.teamProject.syusyu.dao.member.DlvAddrDAO;
import com.teamProject.syusyu.dao.member.MemberDao;
import com.teamProject.syusyu.dao.order.*;
import com.teamProject.syusyu.dao.order.impl.OrderInfoDAO;
import com.teamProject.syusyu.domain.member.CouponDTO;
import com.teamProject.syusyu.domain.member.DlvAddrDTO;
import com.teamProject.syusyu.domain.member.MemberDTO;
import com.teamProject.syusyu.domain.order.*;
import com.teamProject.syusyu.service.fos.order.FOS_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FOS_OrderServiceImpl implements FOS_OrderService {
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

    @Autowired
    public FOS_OrderServiceImpl(MemberDao memberDao, DlvAddrDAO dlvAddrDAO, CartProdDAO cartProdDAO, OrdDAO ordDAO, OrdDtlDAO ordDtlDAO, OrdStusHistDAO ordStusHistDAO, PayDAO payDAO, PayRsltDAO payRsltDAO, OrdDlvAddrDAO ordDlvAddrDAO, OrderInfoDAO orderInfoDAO) {
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
        List<CartProdDTO> cartProdList = cartProdDAO.selectAll(mbrId);

        // 주문자정보 조회
        MemberDTO memberInfo = memberDao.selectUserInfo(mbrId);

        // 배송지정보 조회
        DlvAddrDTO dlvAddr = dlvAddrDAO.selectDefaultDlvAddr(mbrId);

        // 할인정보 조회
        int couponCnt = memberDao.memberCouponCnt(mbrId);       // 쿠폰
        int totPoint = memberDao.selectMemberTotalPoint(mbrId); // 포인트

        // 총 주문금액 계산을 위한 값
        int totProdAmt = cartProdList.stream().mapToInt(CartProdDTO::getTotPrc).sum(); // 총 상품금액
        int dlvFee = totProdAmt >= 50000 ? 0 : 3000;

        Map<String, Object> orderInfo = new HashMap<>();
        orderInfo.put("cartProdList", cartProdList);
        orderInfo.put("memberInfo", memberInfo);
        orderInfo.put("dlvAddr", dlvAddr);
        orderInfo.put("couponCnt", couponCnt);
        orderInfo.put("totPoint", totPoint);
        orderInfo.put("totProdAmt", totProdAmt);
        orderInfo.put("dlvFee", dlvFee);

        return orderInfo;
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
//        int ordNo = ord.getOrdNo();

        // 2. 주문상세정보와 주문상태이력 정보를 DB에 삽입한다.
        addOrderDetailsAndStatusHistories(order.getOrdDtlList(), order.getOrdStusHistList(), order.getOrd().getOrdNo());

        // 3. 결제정보를 DB에 삽입한다.
        addPayment(order.getPay(), order.getOrd().getOrdNo());

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
    private void addPayment(PayDTO pay, int ordNo) throws Exception {
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
     * @param mbrId 사용자의 아이디
     * @param totProdAmt 총 상품금액
     * @return 사용 가능한 쿠폰 리스트
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/16
     */
    @Override
    public List<CouponDTO> getOrderCouponList(int mbrId, int totProdAmt) throws Exception {
        return ordDAO.selectOrderCoupon(mbrId, totProdAmt);
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

        Map<Integer, List<OrderInfoDTO>> orderInfoListByOrdNo = orderInfoDTOList.stream().collect(Collectors.groupingBy(OrderInfoDTO::getOrdNo));

        orderInfoListByOrdNo.forEach((k, v) -> System.out.println("k : " + k + ", v : " + v));

        return orderInfoListByOrdNo;
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
        OrdDlvAddrDTO ordDlvAddr = orderInfoDAO.selectOrdDlvAddr((int) param.get("ordNo"));
        PayInfoDTO payInfo = orderInfoDAO.selectPayInfo(param);

        result.put("orderDetailList", orderDetailList);
        result.put("ordDlvAddr", ordDlvAddr);
        result.put("payInfo", payInfo);

        return result;
    }

}
