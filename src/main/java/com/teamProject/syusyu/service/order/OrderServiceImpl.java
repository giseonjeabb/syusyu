package com.teamProject.syusyu.service.order;

import com.teamProject.syusyu.dao.member.DlvAddrDAO;
import com.teamProject.syusyu.dao.member.MemberDao;
import com.teamProject.syusyu.dao.order.*;
import com.teamProject.syusyu.domain.order.Order;
import com.teamProject.syusyu.domain.member.DlvAddrDTO;
import com.teamProject.syusyu.domain.member.MemberDTO;
import com.teamProject.syusyu.domain.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    private final MemberDao memberDao;
    private final DlvAddrDAO dlvAddrDAO;
    private final CartProdDAO cartProdDAO;
    private final OrdDAO ordDAO;
    private final OrdDtlDAO ordDtlDAO;
    private final OrdStusHistDAO ordStusHistDAO;
    private final PayDAO payDAO;
    private final PayRsltDAO payRsltDAO;
    private final OrdDlvAddrDAO ordDlvAddrDAO;

    @Autowired
    public OrderServiceImpl(MemberDao memberDao, DlvAddrDAO dlvAddrDAO, CartProdDAO cartProdDAO, OrdDAO ordDAO, OrdDtlDAO ordDtlDAO, OrdStusHistDAO ordStusHistDAO, PayDAO payDAO, PayRsltDAO payRsltDAO, OrdDlvAddrDAO ordDlvAddrDAO) {
        this.memberDao = memberDao;
        this.dlvAddrDAO = dlvAddrDAO;
        this.cartProdDAO = cartProdDAO;
        this.ordDAO = ordDAO;
        this.ordDtlDAO = ordDtlDAO;
        this.ordStusHistDAO = ordStusHistDAO;
        this.payDAO = payDAO;
        this.payRsltDAO = payRsltDAO;
        this.ordDlvAddrDAO = ordDlvAddrDAO;
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

        Map<String, Object> orderInfo = new HashMap<>();
        orderInfo.put("cartProdList", cartProdList);
        orderInfo.put("memberInfo", memberInfo);
        orderInfo.put("dlvAddr", dlvAddr);
        orderInfo.put("couponCnt", couponCnt);
        orderInfo.put("totPoint", totPoint);

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

}
