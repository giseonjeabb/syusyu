package com.teamProject.syusyu.service.fos.order.impl;

import com.teamProject.syusyu.dao.order.CartProdDAO;
import com.teamProject.syusyu.domain.order.CartProdDTO;
import com.teamProject.syusyu.service.fos.order.FOS_CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FOS_CartServiceImpl implements FOS_CartService {
    CartProdDAO cartProdDAO;

    @Autowired
    public FOS_CartServiceImpl(CartProdDAO cartProdDAO) {
        this.cartProdDAO = cartProdDAO;
    }

    /**
     * 사용자의 장바구니에 여러 상품을 추가하는 메소드입니다.
     * 전달받은 상품 정보 리스트(cartProductDTOs)를 이용하여 각각의 상품이 장바구니에 이미 있는지 확인한 후, 없다면 새로 장바구니에 추가합니다.
     * 각각의 상품이 장바구니에 성공적으로 추가되면, 해당 상품의 장바구니 번호를 리스트로 반환합니다.
     * 어느 상품이라도 추가에 실패하면 Exception을 발생시킵니다.
     *
     * @param cartProductDTOs 장바구니에 추가할 상품 정보 리스트
     * @return 장바구니에 성공적으로 추가된 각 상품의 번호 리스트
     * @throws Exception 장바구니에 상품을 추가하는 동안 발생할 수 있는 예외를 처리합니다.
     * @author min
     * @since  2023/07/03
     * @modifier soso
     * @modified 2023/07/25
     */
    @Override
    public List<Integer> addProductsIntoCart(List<CartProdDTO> cartProductDTOs) throws Exception {
        List<Integer> results = new ArrayList<>();
        for (CartProdDTO cartProductDTO : cartProductDTOs) {
            CartProdDTO checkCart = cartProdDAO.selectHaveCart(cartProductDTO.getMbrId());
            System.out.println("gsldkfjasldjf"+checkCart);
            if(checkCart == null){
                cartProdDAO.insertCartNo(cartProductDTO);
            }

            int result = cartProdDAO.insertProductIntoCart(cartProductDTO);
            results.add(result);
        }
        return results;
    }


    /**
     * 사용자 아이디에 해당하는 장바구니 정보를 가져온다.
     * 장바구니에 담긴 각 상품과 그에 해당하는 가격 정보를 포함한다.
     *
     * @param mbrId 장바구니를 조회할 사용자의 아이디
     * @return 해당 사용자의 장바구니에 담긴 상품들의 정보를 담은 List
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/03
     */
    @Override
    public List<CartProdDTO> getCartInfo(int mbrId) throws Exception {
        return cartProdDAO.selectAll(mbrId);
    }

    /**
     * 장바구니에 담긴 특정 상품 정보를 수정한다.
     *
     * @param cartProductDTO 수정할 상품 정보
     * @return 수정된 상품의 ID
     * @throws Exception DB 수정 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/03
     */
    @Override
    public int modify(CartProdDTO cartProductDTO) throws Exception {
        return cartProdDAO.update(cartProductDTO);
    }

    /**
     * 장바구니에서 특정 상품들을 제거한다.
     *
     * @param cartProdNo 제거할 장바구니상품번호 배열
     * @param delrId 상품을 제거하는 사용자의 ID
     * @return 제거된 상품의 수
     * @throws Exception DB 삭제 도중 발생할 수 있는 예외
     * @author min
     * @since  2023/07/03
     */
    @Override
    public int remove(int[] cartProdNo, int delrId) throws Exception {
        return cartProdDAO.delete(cartProdNo, delrId);
    }


}
