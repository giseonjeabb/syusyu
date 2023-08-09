package com.teamProject.syusyu.controller.fos.product;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.product.ImageDTO;
import com.teamProject.syusyu.domain.product.ProdOptDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.domain.product.ReviewDTO;
import com.teamProject.syusyu.service.base.product.CategoryServiceBase;
import com.teamProject.syusyu.service.fos.product.FOS_ProductService;
import com.teamProject.syusyu.service.fos.product.FOS_ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(ViewPath.FOS)
public class FOS_ProductController {

    private static final Logger logger = LoggerFactory.getLogger(FOS_ProductController.class);
    @Autowired
    CategoryServiceBase categoryService;
    @Autowired
    FOS_ProductService fosProductService;
    @Autowired
    FOS_ReviewService fosReviewService;


    @GetMapping("products")
    public String productLargeView() {

        return ViewPath.FOS_PRODUCT + "productList";
    }

    /**
     * 상품 목록 뷰를 반환하는 메소드입니다.
     * 이 메소드는 상품 목록 페이지를 보여주는 역할을 담당합니다.
     *
     * @return 상품 목록 뷰의 경로를 나타내는 문자열을 반환합니다. 이 문자열은 ViewPath 클래스의 FOS_PRODUCT 상수와 "productList" 문자열을 합쳐서 생성됩니다.
     * @author soso
     * @since 2023/07/06
     */
    @GetMapping("products/{middleNo}/{smallNo}")
    public String productListView(@PathVariable("middleNo") Integer middleNo,
                                  @PathVariable("smallNo") Integer smallNo,
                                  Model model) {
//        logger.info("Entering productListView() method with middleNo: " + middleNo + ", smallNo: " + smallNo);

        model.addAttribute("middleNo", middleNo);
        model.addAttribute("smallNo", smallNo);

//        logger.info("Exiting productListView() method");
        return ViewPath.FOS_PRODUCT + "productList";
    }


    /**
     * 주어진 중분류, 소분류 번호 및 정렬 방식을 사용하여 해당 카테고리에 속한 상품 목록을 가져오는 메소드입니다.
     * 이 메소드는 HTTP GET 요청을 통해 호출되며, 반환 값은 JSON 형식의 상품 목록과 총 상품 갯수입니다.
     *
     * @param middleNo 카테고리 중분류 번호. 이 값이 null인 경우, 디폴트 값으로 1이 사용됩니다.
     * @param smallNo  카테고리 소분류 번호. 이 값이 null인 경우, 디폴트 값으로 1이 사용됩니다.
     * @param sort     상품 정렬 방식. 이 값이 없을 경우 상품 서비스는 디폴트 정렬 방식을 사용합니다.
     * @return 해당 중분류와 소분류 번호에 속한 상품 목록과 총 상품 갯수를 담은 Map을 ResponseEntity 객체로 반환합니다.
     * 성공적인 경우 HTTP 상태 코드 200 (OK)와 상품 정보를 담은 Map을, 그렇지 않은 경우 400 (Bad Request)와 null을 반환합니다.
     * @throws Exception 상품 서비스에서 상품 목록을 가져오는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/07
     */
    @GetMapping("productsData/{middleNo}/{smallNo}/{sort}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getProductList(
            @PathVariable Integer middleNo,
            @PathVariable Integer smallNo,
            @PathVariable String sort) {
//        logger.info("Entering getProductList() method with middleNo: " + middleNo + ", smallNo: " + smallNo + ", sort: " + sort);

        Map<String, Object> productInfo = null;

        try {
            if (middleNo == null || smallNo == null) {
                middleNo = 1;
                smallNo = 1;
            }
            productInfo = fosProductService.getProductList(middleNo, smallNo, sort);
            System.out.println(productInfo.get("확인" + "productList"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("An error occurred in getProductList(): ", e);
            return new ResponseEntity<>(productInfo, HttpStatus.BAD_REQUEST);
        }
//        logger.info("Exiting getProductList() method");
        return new ResponseEntity<>(productInfo, HttpStatus.OK);
    }

    /**
     * 중분류 번호를 사용하여 해당 카테고리에 속한 모든 상품 목록을 보여주는 메소드입니다.
     * 이 메소드는 HTTP GET 요청을 통해 호출되며, 상품 목록을 보여주는 뷰 경로를 반환합니다.
     *
     * @param middleNo 카테고리 중분류 번호
     * @return 상품 목록을 보여주는 뷰 경로
     * @author soso
     * @since 2023/07/10
     */
    @GetMapping("products/{middleNo}")
    public String getProductAllList(@PathVariable("middleNo") Integer middleNo, Model model) {
        model.addAttribute("middleNo", middleNo);
        return ViewPath.FOS_PRODUCT + "productList";
    }

    /**
     * 중분류 번호를 사용하여 해당 카테고리에 속한 모든 상품 목록을 보여주는 메소드입니다.
     * 이 메소드는 HTTP GET 요청을 통해 호출되며, 상품 목록을 보여주는 뷰 경로를 반환합니다.
     *
     * @param middleNo 카테고리 중분류 번호
     * @param sort     상품 정렬 방식. 이 값이 없을 경우 상품 서비스는 디폴트 정렬 방식을 사용합니다.
     * @return 상품 목록을 보여주는 뷰 경로
     * @author soso
     * @since 2023/07/08
     */
    @GetMapping("productsData/{middleNo}/{sort}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getProductAllList(@PathVariable Integer middleNo,
                                                                 @PathVariable String sort) {
        Map<String, Object> productInfo = null;

        if (middleNo == null || middleNo == 0) {
            middleNo = 1;
        }
        try {

            // 상품 리스트를 가져옵니다. 이때, 정렬 기준(sortId)를 함께 넘겨줍니다.
            productInfo = fosProductService.getProductAllList(middleNo, sort);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(productInfo, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productInfo, HttpStatus.OK);
    }

    /**
     * 주어진 상품 아이디 배열을 사용하여 각 상품의 상태를 조회하는 메소드입니다.
     * 이 메소드는 HTTP GET 요청을 통해 호출되며, 반환 값은 JSON 형식의 상품 상태 목록입니다.
     *
     * @param prodIdArr 상품 아이디 배열. 이 배열의 각 요소는 조회하려는 상품의 아이디입니다.
     * @return 각 상품 아이디에 해당하는 상품 상태 정보를 담은 List를 ResponseEntity 객체로 반환합니다.
     * 성공적인 경우 HTTP 상태 코드 200 (OK)와 상품 상태 정보를 담은 List를, 그렇지 않은 경우 400 (Bad Request)와 null을 반환합니다.
     * @throws Exception 상품 서비스에서 상품 상태를 조회하는 도중 발생할 수 있는 예외
     * @author min
     * @since 2023/08/04
     */
    @GetMapping("productStatus")
    @ResponseBody
    public ResponseEntity<List<ProductDTO>> getProductStatus(int[] prodIdArr) {
        List<ProductDTO> productStatusList = null;

        try {
            productStatusList = fosProductService.getProductStatus(prodIdArr);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(productStatusList, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productStatusList, HttpStatus.OK);
    }

    /**
     * 이 메소드는 주어진 상품 ID에 대한 상세 정보, 이미지 리스트, 상품 옵션 사이즈 리스트를 가져와 모델에 추가하는 기능을 수행합니다.
     * HTTP GET 요청을 통해 호출되며, 반환 값은 view의 경로와 모델에 추가된 상품 정보입니다.
     *
     * @param prodId 상품 ID.
     * @param m      Model 객체. 상품 정보를 view로 전달하기 위해 사용됩니다.
     * @return 상품 정보를 보여주는 view의 경로를 반환합니다. 예외가 발생한 경우 스택 트레이스를 출력합니다.
     * @throws Exception 상품 서비스에서 상품 정보를 가져오는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/19
     */
    @GetMapping("products/product/{prodId}")
    public String getProduct(@PathVariable int prodId, Model m) {
        Map<String, Object> productDetail = null;
        ProductDTO product = null;
        List<ImageDTO> imageList = null;
        List<ProdOptDTO> shoesSizeList = null;
        List<ReviewDTO> reviewList = null;

        try {
            System.out.println("prodId = " + prodId);
            productDetail = fosProductService.getProduct(prodId);

            product = (ProductDTO) productDetail.get("productDetail");
            m.addAttribute("productDetail", product);

            imageList = (List<ImageDTO>) productDetail.get("imageList");
            m.addAttribute("imageList", imageList);

            shoesSizeList = (List<ProdOptDTO>) productDetail.get("shoesSizeList");
            m.addAttribute("shoesSizeList", shoesSizeList);

            reviewList = fosReviewService.getList(prodId);
            m.addAttribute("reviewList", reviewList);
            System.out.println("상훔 후기!! reviewList = " + reviewList);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return ViewPath.FOS_PRODUCT + "product";
    }


    @GetMapping("/categoryProduct")
    public ResponseEntity<Map<String, List<ProductDTO>>> getDspyProductList() {
        Map<String, List<ProductDTO>> mainProductList = new HashMap<>();

        try {
            mainProductList = fosProductService.getDspyProductList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(mainProductList, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(mainProductList, HttpStatus.OK);
    }
}