package com.teamProject.syusyu.controller.bos.product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.product.*;
import com.teamProject.syusyu.service.bos.product.BOS_ProductService;
import com.teamProject.syusyu.service.fos.product.FOS_CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping(ViewPath.BOS)
public class BOS_ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BOS_ProductController.class);
    //상품 이미지를 저장할 서버 상의 디렉토리 경로를 나타냅니다.
    private final String directory = "/resources/static/image/product/";

    @Autowired
    FOS_CategoryService CategoryService;
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
            categories = CategoryService.getCategoryAllList();
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
     * 상품 등록 요청을 처리하는 메소드입니다.
     * 클라이언트로부터 상품 정보와 이미지 파일을 받아, 서버에 저장하고 상품을 데이터베이스에 등록합니다.
     *
     * @param productStr   등록할 상품 정보가 담긴 ProductDTO 객체
     * @param repImg       대표 이미지 파일
     * @param smlImgList   추가 이미지 파일들
     * @param optPrcStr    옵션가격이 저장되는 리스트
     * @param invQtyStr    옵션 재고수량 저장되는 리스트
     * @param optItemNmStr 옵션값들 저장되는 리스트
     * @param optGrpNmStr  옵션명이 저장되는ㄴ 리스트
     * @param mbrId        세션에 저장된 회원 ID
     * @return 상품 등록이 성공하면 HTTP 상태 코드 200(OK)와 함께 등록된 상품의 ID를 반환, 그렇지 않으면 HTTP 상태 코드 400(BAD REQUEST)를 반환합니다.
     * @author soso
     * @since 2023/07/29
     */
////    @PostMapping("productRegister")
////    public ResponseEntity<String> addProduct(
////            @RequestBody ProductDTO product,
////            @RequestParam PriceDTO price,
////            @RequestParam("optPrices") String optPricesStr,
////            @RequestParam("optInvQtys") String optInvQtysStr,
////            @RequestPart("optItemNms") List<OptItemDTO> optItemNms,
////            @RequestPart("optGrpNms") List<OptGrpDTO> optGrpNms,
////            @RequestPart("repImg") MultipartFile repImg,
////            @RequestPart("smlImgList") MultipartFile[] smlImgList,
////            @SessionAttribute int mbrId) {
//
////    @PostMapping("productRegister")
////    public ResponseEntity<String> addProduct(
////            @RequestPart("data") String dataStr, // JSON 데이터
////            @RequestPart("repImg") MultipartFile repImg,
////            @RequestPart("smlImgList") MultipartFile[] smlImgList,
////            @SessionAttribute int mbrId
////    ) {
//        try {
//            // Convert product, price, prodOpt JSON strings to DTOs
//            ObjectMapper objectMapper = new ObjectMapper();
//            Map<String, Object> data = objectMapper.readValue(dataStr, new TypeReference<Map<String, Object>>() {});
//            // JSON으로부터 DTO를 생성
//            //상품
//            ProductDTO product = objectMapper.convertValue(data.get("product"), ProductDTO.class);
//            String repImgUri = saveFileAndGetUri(repImg);
////            ProductDTO product = objectMapper.readValue(productStr, ProductDTO.class);
//            product.setRepImg(repImgUri);
//            product.setRegrId(mbrId);
//
//            //가격
////            PriceDTO price = objectMapper.readValue(priceStr,PriceDTO.class);
//
//            PriceDTO price = objectMapper.convertValue(data.get("price"), PriceDTO.class);
//            price.setRegrId(mbrId);
//
//            // 사진리스트로 이미지 URI를 관리
//            List<ImageDTO> smlImgDTOs = new ArrayList<>();
//            for (int i = 0; i < smlImgList.length; i++) {
//                String imagePath = saveFileAndGetUri(smlImgList[i]);
//                ImageDTO smlImgDTO = new ImageDTO();
//                smlImgDTO.setImagePath(imagePath);
//                smlImgDTO.setRegrId(mbrId);
//                smlImgDTOs.add(smlImgDTO);
//            }
//
//            //옵션 처리
//            List<ProdOptDTO> optPrices = objectMapper.convertValue(data.get("optPrices"), new TypeReference<List<ProdOptDTO>>() {});
//            List<ProdOptDTO> optInvQtys = objectMapper.convertValue(data.get("optInvQtys"), new TypeReference<List<ProdOptDTO>>() {});
//
////         List<ProdOptDTO> prodOptList = new ArrayList<>();
////            for (int i = 0; i < optPrcList.size(); i++) {
////                ProdOptDTO prodOptDTO = new ProdOptDTO();
////                prodOptDTO.setOptPrc(Integer.parseInt(optPrcList.get(i).get("optPrc")));
////                prodOptDTO.setInvQty(Integer.parseInt(invQtyList.get(i).get("InvQty")));
////                prodOptDTO.setRegrId(mbrId);
////                prodOptList.add(prodOptDTO);
////            }
////            List<ProdOptDTO> optPrcList = objectMapper.readValue(optPricesStr, new TypeReference<List<ProdOptDTO>>() {});
////            List<ProdOptDTO> invQtyList = objectMapper.readValue(optInvQtysStr, new TypeReference<List<ProdOptDTO>>() {});
//
//            List<ProdOptDTO> prodOptList = new ArrayList<>();
//            for (int i = 0; i < optPrices.size(); i++) {
//                ProdOptDTO prodOptDTO = new ProdOptDTO();
//                prodOptDTO.setOptPrc(optPrices.get(i).getOptPrc());
//                prodOptDTO.setInvQty(optInvQtys.get(i).getInvQty());
//                prodOptDTO.setRegrId(mbrId);
//                prodOptList.add(prodOptDTO);
//            }
//            List<OptItemDTO> optItemNms = objectMapper.convertValue(data.get("optItemNms"), new TypeReference<List<OptItemDTO>>() {});
//            List<OptItemDTO> optItemDTOList = new ArrayList<>();
//            for (OptItemDTO optItemDTO : optItemNms) {
//                optItemDTO.setRegrId(mbrId);
//                optItemDTOList.add(optItemDTO);
//            }
//            List<OptGrpDTO> optGrpNms = objectMapper.convertValue(data.get("optGrpNms"), new TypeReference<List<OptGrpDTO>>() {});
//            List<OptGrpDTO> optGrpDTOList = new ArrayList<>();
//            for (OptGrpDTO optGrpDTO : optGrpNms) {
//                optGrpDTO.setRegrId(mbrId);
//                optGrpDTOList.add(optGrpDTO);
//            }
////            List<OptItemDTO> optItemDTOList = new ArrayList<>();
////            for (Map<String, String> optItemNm : optItemNmList) {
////                OptItemDTO optItemDTO = new OptItemDTO();
////                optItemDTO.setOptItemNm(optItemNm.get("optItemNm"));
////                optItemDTO.setRegrId(mbrId);
////                optItemDTOList.add(optItemDTO);
////            }
////
////            List<OptGrpDTO> optGrpDTOList = new ArrayList<>();
////            for (Map<String, String> optGrpNm : optGrpNmList) {
////                OptGrpDTO optGrpDTO = new OptGrpDTO();
////                optGrpDTO.setOptGrpNm(optGrpNm.get("optGrpNm"));
////                optGrpDTO.setRegrId(mbrId);
////                optGrpDTOList.add(optGrpDTO);
////            }
//
//
//            // 서비스 호출하여 상품, 가격, 이미지, 옵션 등록
//            productService.addProductData(product, price, smlImgDTOs, prodOptList, optItemDTOList, optGrpDTOList);
//
//
//            return new ResponseEntity<>("상품을 등록 완료했습니다.", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
    @PostMapping("/productRegister")
    public ResponseEntity<?> registerProduct(
            @RequestParam(value = "data", required = false) String productInfo,
            @RequestParam(value = "repImg", required = false) MultipartFile repImg,
            @RequestParam(value = "smlImgList", required = false) MultipartFile[] smlImgList,
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
                String repImgUri = saveFileAndGetUri(repImg);
                // product 정보 넣기
                product.setRepImg(repImgUri);
            } catch (IOException e) {
                LOGGER.error("Error while saving representative image: {}", e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid image file");
            }


            //Price
            PriceDTO price = mapper.convertValue(productMap.get("price"), PriceDTO.class);

            // 작은 이미지 파일 목록 처리 및 저장
            List<ImageDTO> imageList = new ArrayList<>();
            for (MultipartFile smlImg : smlImgList) {
                try {
                    ImageDTO imageDTO = new ImageDTO();
                    imageDTO.setImagePath(saveFileAndGetUri(smlImg));
                    imageList.add(imageDTO);
                } catch (IOException e) {
                    LOGGER.error("Error while saving small image: {}", e.getMessage());
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid image file");
                }
            }

            //옵션정보 넣기
            //opotGrp
            List<OptGrpDTO> optGrpNmList = mapper.convertValue(productMap.get("optGrpNms"), new TypeReference<List<OptGrpDTO>>(){});


            //prodOpt
            List<Integer> optPrcList = mapper.convertValue(productMap.get("optPrices"), new TypeReference<List<Integer>>(){});
            List<Integer> optInvQtyList = mapper.convertValue(productMap.get("optInvQtys"), new TypeReference<List<Integer>>(){});
            List<ProdOptDTO> prodOptList = new ArrayList<>();
            for (int i = 0; i < optPrcList.size(); i++) {
                ProdOptDTO prodOptDTO = new ProdOptDTO();
                prodOptDTO.setOptPrc(optPrcList.get(i));
                prodOptDTO.setInvQty(optInvQtyList.get(i));
                prodOptList.add(prodOptDTO);
            }

            //prodItem
            List<OptItemDTO> optItemDTOList = mapper.convertValue(productMap.get("optItemNms"), new TypeReference<List<OptItemDTO>>(){});

            productService.addProductData(product, price, imageList, optGrpNmList, prodOptList, optItemDTOList, mbrId);


            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage(), e);
            LOGGER.error("An error occurred while registering a product: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * 이미지 파일을 서버에 저장하고, 저장된 이미지의 URI를 반환하는 메소드입니다.
     * Ï
     *
     * @param file 저장할 이미지 파일
     * @return 저장된 이미지 파일의 URI
     * @throws IOException 파일 저장 도중 발생할 수 있는 IOException
     * @author soso
     * @since 2023/07/31
     */
    private String saveFileAndGetUri(MultipartFile file) throws IOException {
        // 파일 이름을 가져옴
        String originalFilename = file.getOriginalFilename();

        // 파일의 확장자를 얻어와, 악의적인 파일 업로드를 방지함
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String[] allowedExtensions = {".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        if (!Arrays.asList(allowedExtensions).contains(extension.toLowerCase())) {
            LOGGER.error("Disallowed file extension: " + extension);
            throw new IOException("Disallowed file extension: " + extension);
        }

        // 파일 이름에 현재 시간을 추가하여 중복을 방지함
        String filename = originalFilename.substring(0, originalFilename.lastIndexOf("."))
                + "_" + System.currentTimeMillis() + extension;

        // 파일을 디스크에 저장
        InputStream is = file.getInputStream();
        byte[] buffer = new byte[is.available()];
        is.read(buffer);

        // File directory under system's temp directory
        File targetDir = new File(System.getProperty("java.io.tmpdir"), "/static/image/product/");
        if (!targetDir.exists()) {
            if (!targetDir.mkdirs()) {
                LOGGER.error("Error while creating directories: " + targetDir.getPath());
                throw new IOException("Error while creating directories: " + targetDir.getPath());
            }
        }
        File targetFile = new File(targetDir, filename);
        if (!targetFile.exists()) {
            targetFile.createNewFile();
        }
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        outStream.close();
        is.close();

        // 저장된 파일의 절대 경로를 반환
        String filePath = targetFile.getAbsolutePath();
        return filePath;
    }


}
