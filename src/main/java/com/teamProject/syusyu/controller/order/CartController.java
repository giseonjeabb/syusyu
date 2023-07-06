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
            return new ResponseEntity<>("ADD_OK", HttpStatus.OK);
        }

        return new ResponseEntity<>("ADD_ERR", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/cart")
    public String cartView() {
        return ViewPath.FOS_ORDER + "cart";
    }

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
