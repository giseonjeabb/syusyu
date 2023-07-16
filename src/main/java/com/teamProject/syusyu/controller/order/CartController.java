package com.teamProject.syusyu.controller.order;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.order.CartProdDTO;
import com.teamProject.syusyu.service.order.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    CartService service;

    /**
     * 장바구니에 상품을 추가한다.
     *
     * @param cartProductDTO 추가할 상품 정보
     * @return 결과 메시지와 HTTP 상태 코드
     * @author min
     * @since  2023/07/03
     */
    @PostMapping("/cart")
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody CartProdDTO cartProductDTO) {
        try {
            // 1. 재고수량이 있는지 체크한다.
            // 1-1. 재고수량이 없다면 리턴

            // 1-2. 재고수량이 있다면 장바구니에 추가한다.
            service.add(cartProductDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("ADD_ERR", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("ADD_OK", HttpStatus.OK);
    }

    /**
     * 장바구니 페이지를 보여준다.
     *
     * @return 장바구니 페이지 경로
     * @author min
     * @since  2023/07/03
     *
     */
    @GetMapping("/cart")
    public String cartView() {
        return ViewPath.FOS_ORDER + "cart";
    }

    /**
     * 현재 로그인된 사용자의 장바구니 상품 목록을 가져온다.
     *
     * @param mbrId 세션에 저장된 사용자 아이디
     * @return 사용자의 장바구니 상품 목록과 HTTP 상태 코드
     * @author min
     * @since  2023/07/03
     */
    @GetMapping("/cartList")
    @ResponseBody
    public ResponseEntity<List<CartProdDTO>> list(@SessionAttribute int mbrId) {
        List<CartProdDTO> cartProdList = null;

        try {
            cartProdList = service.getCartInfo(mbrId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(cartProdList, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(cartProdList, HttpStatus.OK);
    }

    /**
     * 장바구니 상품 정보를 수정한다.
     *
     * @param cartProdNo 수정할 상품의 아이디
     * @param cartProductDTO 수정할 상품 정보
     * @param mbrId 세션에 저장된 사용자 아이디
     * @return 결과 메시지와 HTTP 상태 코드
     * @author min
     * @since  2023/07/03
     */
    @PatchMapping("/cart/{cartProdNo}")
    @ResponseBody
    public ResponseEntity<String> modify(@PathVariable Integer cartProdNo, @RequestBody CartProdDTO cartProductDTO, @SessionAttribute int mbrId) {
        try {
            cartProductDTO.setCartProdNo(cartProdNo);
            cartProductDTO.setUpdrId(mbrId);
            service.modify(cartProductDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("MOD_ERR", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("MOD_OK", HttpStatus.OK);
    }

    /**
     * 장바구니에서 상품을 삭제한다.
     *
     * @param cartProdNoArr 삭제할 상품 아이디 배열
     * @param mbrId 세션에 저장된 사용자 아이디
     * @return 결과 메시지와 HTTP 상태 코드
     * @author min
     * @since  2023/07/03
     */
    @DeleteMapping("/cart")
    @ResponseBody
    public ResponseEntity<String> remove(@RequestBody int[] cartProdNoArr, @SessionAttribute int mbrId) {
        try {
            service.remove(cartProdNoArr, mbrId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
    }

//    @PostMapping("/cartOrder")
//    @ResponseBody
//    public ResponseEntity<List<Integer>> cartOrder(@RequestBody List<Integer> cartProdNo) {
//        // 1. 선택한 상품이 품절되지 않았는지 체크한다.
//        return new ResponseEntity<List<Integer>>(cartProdNo, HttpStatus.OK);
//    }

//    @GetMapping("/orderSheet")
//    public String orderSheet(int[] cartOrderNo) {
////    public String orderSheet(@RequestParam List<Integer> cartOrderNo) {
////        System.out.println("Arrays.toString(cartOrderNo) = " + Arrays.toString(cartOrderNo));
//        System.out.println("Arrays.toString(cartOrderNo) = " + Arrays.toString(cartOrderNo));
//
//        // 주문&결제 시 필요한 정보들을 조회해와서 화면에 뿌려줘야 한다.
//
//        return ViewPath.ORDER + "orderSheet";
//    }

//    @GetMapping("/orderSheet")
//    public String orderSheet(int[] cartOrderNo, Model model) {
//        // 1. 주문상품
//        List<CartProductDTO> cartProductList = cartService.getList(80001);
//        // 2. 주문자 정보(Member 정보 가져오기)
//
//
//        // 3. 배송지 정보(기본 배송지)
//        // 4. 할인 정보
//
//        model.addAttribute("cartProductList", cartProductList);
//
//        return ViewPath.ORDER + "orderSheet";
//    }


}
