package com.teamProject.syusyu.controller.fos.order;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.order.CartProdDTO;
import com.teamProject.syusyu.service.fos.order.FOS_CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ViewPath.FOS)
public class FOS_CartController {
    private final FOS_CartService service;

    public FOS_CartController(FOS_CartService service) {
        this.service = service;
    }

    /**
     * 장바구니에 상품을 추가한다.
     *
     * @param cartProductDTO 추가할 상품 정보
     * @return 결과 메시지와 HTTP 상태 코드
     * @author min
     * @since  2023/07/03
     */
    @PostMapping("carts")
    public ResponseEntity<String> add(@RequestBody CartProdDTO cartProductDTO, @SessionAttribute int mbrId) {
        try {
            // 1. 재고수량이 있는지 체크한다.
            // 1-1. 재고수량이 없다면 리턴

            // 1-2. 재고수량이 있다면 장바구니에 추가한다.
            cartProductDTO.setMbrId(mbrId);
            service.addProductIntoCart(cartProductDTO);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("ADD_ERR", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("ADD_OK", HttpStatus.OK);
    }

    /**
     * 현재 로그인된 사용자의 장바구니 상품 목록을 가져온다.
     *
     * @param mbrId 세션에 저장된 사용자 아이디
     * @return 사용자의 장바구니 상품 목록과 HTTP 상태 코드
     * @author min
     * @since  2023/07/03
     */
    @GetMapping("carts")
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
    @PatchMapping("carts/{cartProdNo}")
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
    @DeleteMapping("carts")
    public ResponseEntity<String> remove(@RequestBody int[] cartProdNoArr, @SessionAttribute int mbrId) {
        try {
            service.remove(cartProdNoArr, mbrId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
    }
}
