package com.teamProject.syusyu.controller.bos.product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.common.util.FileUploadUtils;
import com.teamProject.syusyu.domain.product.*;
import com.teamProject.syusyu.service.base.product.CategoryServiceBase;
import com.teamProject.syusyu.service.bos.product.BOS_ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(ViewPath.BOS)
public class BOS_ProductController {

    //로그 선언.
    private static final Logger LOGGER = LoggerFactory.getLogger(BOS_ProductController.class);

    @Autowired
    private FileUploadUtils fileUploadUtils;
    @Autowired
    CategoryServiceBase categoryService;
    @Autowired
    BOS_ProductService productService;

    /**
     * 상품 등록 페이지를 불러오는 메소드입니다.
     * 상품 등록 페이지에서 필요한 데이터(카테고리, 브랜드, 제조사, 제조국)를 가져와서 model에 추가합니다.
     *
     * @param model Model 객체. 뷰에 데이터를 전달하는 데 사용됩니다.
     * @return 상품 등록 페이지의 뷰 경로를 반환합니다.
     * @author soso
     * @since 2023/07/27
     */
    @GetMapping("productRegister")
    public String addProduct(Model model) {
        Map<String, Object> categories = null;
        List<CategoryDTO> allCategory = null;
        Map<String, Object> productInfo = null; //brand, 제조사, 제조국 정보
        try {
            //select에 들어갈 category
            categories = categoryService.getCategoryAllList();
            model.addAttribute("categories", categories);

            //카테고리json문자열로 바꾸고 자스에서 select된 카테고리들 비교해서 cateId찾기.
            allCategory = (List<CategoryDTO>) categories.get("cateList");
            ObjectMapper mapper = new ObjectMapper();
            String jsonCateList = mapper.writeValueAsString(allCategory);  // List를 JSON 문자열로 변환
            model.addAttribute("jsonCateList", jsonCateList);

            //브랜드, 제조사, 제조국 화면에 나오게하기.
            List<BrandDTO> brandList = (List<BrandDTO>) productService.getProductInfo().get("brandList");
            List<BrandDTO> mftNatnList = (List<BrandDTO>) productService.getProductInfo().get("mftNatnList");
            List<BrandDTO> mftcoList = (List<BrandDTO>) productService.getProductInfo().get("mftcoList");
            model.addAttribute("brandList", brandList);
            model.addAttribute("mftNatnList", mftNatnList);
            model.addAttribute("mftcoList", mftcoList);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return ViewPath.BOS_PRODUCT + "productRegister";
    }

    /**
     * 이 메소드는 상품 등록 요청을 처리합니다.
     * 클라이언트로부터 상품 정보와 이미지 파일을 받아, 서버에 저장하고 상품을 데이터베이스에 등록합니다.
     *
     * @param productInfo 상품 정보가 포함된 JSON 문자열
     * @param repImg      대표 이미지 파일
     * @param smlImgList  추가 이미지 파일 목록
     * @param mbrId       세션에 저장된 회원 ID
     * @return 상품 등록이 성공하면 HTTP 상태 코드 200(OK)를 반환,
     * 필수 파라미터가 누락되었을 경우 HTTP 상태 코드 400(BAD REQUEST)를 반환하고,
     * 그 외의 예외 발생 시 HTTP 상태 코드 500(INTERNAL SERVER ERROR)를 반환합니다.
     * @throws IOException 이미지 파일 저장 중에 발생하는 예외
     * @throws Exception   데이터베이스 삽입 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/29
     */
    @PostMapping("/productRegister")
    public ResponseEntity<?> registerProduct(
            @RequestParam(value = "data", required = false) String productInfo,
            @RequestParam(value = "repImg", required = false) MultipartFile repImg,
            @RequestParam(value = "smlImgList", required = false) List<MultipartFile> smlImgList,
            @SessionAttribute int mbrId
    ) {

        if (productInfo == null || repImg == null || smlImgList == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Required parameters are missing");
        }

        try {

            // JSON 문자열을 Map으로 변환
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> productMap = mapper.readValue(productInfo, new TypeReference<Map<String, Object>>() {
            });

            // product 정보 넣기 (대표 이미지 파일 처리 및 저장)
            ProductDTO product = mapper.convertValue(productMap.get("product"), ProductDTO.class);
            try {
                String repImgUri = fileUploadUtils.saveFileAndGetUri(repImg);
                // product 정보 넣기
                product.setRepImg(repImgUri);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid image file");
            }


            //Price
            PriceDTO price = mapper.convertValue(productMap.get("price"), PriceDTO.class);

            // 작은 이미지 파일 목록 처리 및 저장
            List<ImageDTO> imageList = new ArrayList<>();
            for (MultipartFile smlImg : smlImgList) {
                // 먼저 파일이 null이 아니고 비어 있지 않은지 확인합니다.
                if (smlImg == null || smlImg.isEmpty()) {
                    LOGGER.error("제공된 이미지 파일이 비어 있습니다.");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provided image file is empty");
                }

                try {
                    ImageDTO imageDTO = new ImageDTO();

                    // 파일 저장 시도 후에 로그를 출력합니다.
                    String uri = fileUploadUtils.saveFileAndGetUri(smlImg);
//                    LOGGER.info("Saved file with URI: {}", uri);

//                    imageDTO.setImagePath(uri);
                    LOGGER.info("Saved image path: " + imageDTO.getImagePath());

//                    LOGGER.info("Successfully saved image: {}", smlImg.getOriginalFilename());
                    imageList.add(imageDTO);

                } catch (IOException e) {
                    LOGGER.error("Error while saving small image: {}", e.getMessage());
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid image file");
                }
            }
            // 받은 smlImgList의 크기를 로그로 출력합니다.
            LOGGER.info("Received 'smlImgList' with size: {}", (smlImgList != null ? smlImgList.size() : "null"));

            //옵션정보 넣기
            //opotGrp
            List<OptGrpDTO> optGrpNmList = mapper.convertValue(productMap.get("optGrpNms"), new TypeReference<List<OptGrpDTO>>() {
            });


            //prodOpt
            List<ProdOptDTO> optPrcList = mapper.convertValue(productMap.get("optPrices"), new TypeReference<List<ProdOptDTO>>() {
            });
            List<ProdOptDTO> optInvQtyList = mapper.convertValue(productMap.get("optInvQtys"), new TypeReference<List<ProdOptDTO>>() {
            });
            List<ProdOptDTO> prodOptList = new ArrayList<>();
            for (int i = 0; i < optPrcList.size(); i++) {
                ProdOptDTO prodOptDTO = new ProdOptDTO();
                prodOptDTO.setOptPrc(optPrcList.get(i).getOptPrc());
                prodOptDTO.setInvQty(optInvQtyList.get(i).getInvQty());
                prodOptList.add(prodOptDTO);
            }

            //prodItem
            List<OptItemDTO> optItemDTOList = mapper.convertValue(productMap.get("optItemNms"), new TypeReference<List<OptItemDTO>>() {
            });

            productService.addProductData(product, price, imageList, optGrpNmList, prodOptList, optItemDTOList, mbrId);


            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/product/productList")
    public String getProductView(Model model){
        //select에 들어갈 category
        Map<String, Object> categories = categoryService.getCategoryAllList();
        model.addAttribute("categories", categories);
        return ViewPath.BOS_PRODUCT+"productManagement";
    }

    @PostMapping("/product/productList")
    public ResponseEntity<List<ProductDTO>> getProductList(@RequestBody SearchConditionDTO searchConditionDTO) {
//        LOGGER.info("Inside getProductList method. Search conditions: {}", searchConditionDTO); // 로그 추가
        if(searchConditionDTO.getLoadInitialData() == null) {
            searchConditionDTO.setLoadInitialData(true);  // 처음 로딩 시에는 true로 설정
        }
        List<ProductDTO> productInfoList;
        try {
            productInfoList = productService.getProductBosList(searchConditionDTO);
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching product list.", e); // 오류 로그 추가
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productInfoList, HttpStatus.OK);
    }

}

