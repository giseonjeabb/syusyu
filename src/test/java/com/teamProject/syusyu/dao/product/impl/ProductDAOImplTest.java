package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.*;
import com.teamProject.syusyu.domain.product.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductDAOImplTest {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProdOptDAO prodOptDAO;
    @Autowired
    OptGrpDAO optGrpDAO;
    @Autowired
    OptItemDAO optItemDAO;
    @Autowired
    ProdOptCombDAO prodOptCombDAO;

    @Autowired
    PriceDAO priceDAO;
    @Autowired
    ImageDAO imageDAO;

    @Test //상품조회리스트
    public void getProductList() throws Exception {
//        System.out.println("productDAO : "+productDAO.getProductList(1,1));
//        assertTrue(productDAO != null);
//        System.out.println("productDAO = " + productDAO);

//        assertTrue(productDAO.selectProductList(2, 3).stream().count() == 0);
//        System.out.println("productDAO : " + productDAO.selectProductList(1, 1));


//        assertTrue(productDAO.selectProductList(1, 1) != null);
//        System.out.println("productDAO : " + productDAO.selectProductList(1, 1));
//        System.out.println("dao: " + productDAO.selectProductAllList(1));
    }

    //    @Test //상품조회리스트
//    public void getProductAllList() throws Exception {
//        System.out.println("dao: "+ productDAO.selectProductAllList(1));
//    }
    @Test //상품조회
    public void selectProductTest() throws Exception {
        System.out.println("dao:" + productDAO.selectProduct(10002));
    }

    @Test
    public void selectProductStatusTest() throws Exception {
        // TODO product insert 생기면 insert하고 내가 넣은 상태값이랑 select 해온 상태값이란 같은지 검증해야 함
        List<ProductDTO> ProductStatus = productDAO.selectProductStatus(new int[]{10001, 10007});
        System.out.println("ProductStatus = " + ProductStatus);
    }

    @Test //상품 옵션 조회
    public void selectProdOptSizeList() {
        List<ProdOptDTO> optList = prodOptDAO.selectProdOptSizeList(10001);
        System.out.println("shoes : " + optList);
    }

    @Test
    public void insertProduct() throws Exception {

        int prodId = 0;
        try {

            ProductDTO productDTO = new ProductDTO(1, "3300", null, 1, null, 99999, "", "겉감 : 천연가죽(소), 면 100%, 합성가죽 / 안감 : 면 100%, 합성가죽 / 창 : 천연고무, 합성고무", 31, 805, "/static/image/product/vansVN000D3HY281ref.jpeg", 601, 80000);

            //product
            productDAO.insertProduct(productDTO);
            prodId = productDTO.getProdId();
            System.out.println("prodId=============>" + prodId);

            // 현재 날짜를 가져옴
            LocalDate today = LocalDate.now();
            LocalDate fiveDaysLater = today.plusDays(5);
            Date endDate = Date.valueOf(fiveDaysLater);
            Date startDate = Date.valueOf(today);

            //price
            PriceDTO priceDTO = new PriceDTO(prodId, 129000, 60000, 0, startDate, endDate, null, null, 80000);
            assertTrue(priceDAO.insertPrice(priceDTO) == 1);

            //image
            ImageDTO imageDTO = new ImageDTO(prodId, "/static/image/product/vansVN000D3HY281ref.jpeg", 80000);
            assertTrue(imageDAO.insertImage(imageDTO) == 1);

            List<String> optGrpNmList = new ArrayList<>();
            optGrpNmList.add("color");
            optGrpNmList.add("size");

            //optGrp
            List<Integer> optGrpIdList = new ArrayList<>();
            for (String optGrpNm : optGrpNmList) {
                OptGrpDTO optGrpDTO = new OptGrpDTO(optGrpNm, prodId, 80000);
                optGrpDAO.insertOptGrp(optGrpDTO);
                optGrpIdList.add(optGrpDTO.getOptGrpId());
            }
            System.out.println("optGrpID=====>" + optGrpIdList.get(0) + ", " + optGrpIdList.get(1));

            //prodOpt
            List<Integer> optPrcList = new ArrayList<>();
            List<Integer> invQtyList = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                optPrcList.add(0);
                invQtyList.add(5);
            }

            List<Integer> optCombNoList = new ArrayList<>();
            for (int i = 0; i < optPrcList.size(); i++) {
                ProdOptDTO prodOptDTO = new ProdOptDTO();
                prodOptDTO.setOptPrc(optPrcList.get(i));
                prodOptDTO.setInvQty(invQtyList.get(i));
                prodOptDTO.setProdId(prodId);
                prodOptDTO.setRegrId(80000);
                prodOptDAO.insertProdOpt(prodOptDTO);
                optCombNoList.add(prodOptDTO.getOptCombNo());
                System.out.println("prodOptComb===>" + optCombNoList.get(i));
            }

            //optItem
            List<String> optItemNmList = new ArrayList<>();
            optItemNmList.add("GRAY");
            optItemNmList.add("220");
            optItemNmList.add("230");
            optItemNmList.add("240");
            optItemNmList.add("250");

            List<Integer> optItemIdList = new ArrayList<>();

            OptItemDTO optItemDTO = new OptItemDTO(optItemNmList.get(0), optGrpIdList.get(0), 80000);
            optItemDAO.insertOptItem(optItemDTO);
            optItemIdList.add(optItemDTO.getOptItemId());
            for (int i = 1; i < optItemNmList.size(); i++) {
                OptItemDTO optItemDto = new OptItemDTO(optItemNmList.get(i), optGrpIdList.get(1), 80000);
                optItemDAO.insertOptItem(optItemDto);
                optItemIdList.add(optItemDto.getOptItemId());
            }

            //prodOptComb
//            optCombNo optItemId
//            20001 50001 80000
//            20001 50002 80000
//            20002 50001 80000
//            20002 50003 80000
//            20003 50001 80000
//            20003 50004 80000
//            20004 50001 80000
//            20004 50005 80000
            for (int i = 0; i < optCombNoList.size(); i++) {

                ProdOptCombDTO prodOptCombDTO = new ProdOptCombDTO();
                prodOptCombDTO.setOptCombNo(optCombNoList.get(i));
                prodOptCombDTO.setOptItemId(optItemIdList.get(0));
                prodOptCombDTO.setRegrId(80000);
                prodOptCombDAO.insertProdOptComb(prodOptCombDTO);

                ProdOptCombDTO prodOptCombDTO1 = new ProdOptCombDTO();
                prodOptCombDTO1.setOptCombNo(optCombNoList.get(i));
                prodOptCombDTO1.setOptItemId(optItemIdList.get(i + 1));
                prodOptCombDTO1.setRegrId(80000);
                prodOptCombDAO.insertProdOptComb(prodOptCombDTO1);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(prodId);

    }

    @Test
    public void test() {
        List<Integer> optCombNoList = new ArrayList<>();
        optCombNoList.add(1);
        optCombNoList.add(2);
        optCombNoList.add(3);
        optCombNoList.add(4);

        List<Integer> optItemIdList = new ArrayList<>();
        optItemIdList.add(50001);
        optItemIdList.add(50002);
        optItemIdList.add(50003);
        optItemIdList.add(50004);
        optItemIdList.add(50005);

        int regrId = 80000; // 정수 regrId 선언과 초기화

        for (int i = 0; i < optCombNoList.size(); i++) {
            System.out.println(optCombNoList.get(i) + ", " + optItemIdList.get(0));
            System.out.println(optCombNoList.get(i) + ", " + optItemIdList.get(i + 1));
        }
    }

    @Test
    public void testPopprod() {
//        System.out.println(productDAO.selectPopularProductList());
//        System.out.println(productDAO.selectPickProductList());
        System.out.println(productDAO.selectNewProductList());
    }
}
