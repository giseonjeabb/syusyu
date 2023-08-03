package com.teamProject.syusyu.service.bos.product.impl;

import com.teamProject.syusyu.domain.product.*;
import com.teamProject.syusyu.service.bos.product.BOS_ProductService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BOS_ProductServiceImplTest {

    @Autowired
    BOS_ProductService bosProductService;
    @Test
    public void getProductInfo() throws Exception {
        System.out.println(bosProductService.getProductInfo().get("brands"));

    }

    @Test
    public void getProductRegister() throws Exception{
        ProductDTO product=new ProductDTO();
        product.setCateId(1);
        product.setProdNm("3300");
        product.setBrndId(1);
        product.setDlvChgDtl(99999);
        product.setMfgdMatr("폴리우레탄 100%");
        product.setMftco(832);
        product.setMftNatn(782);
        product.setRepImg("/static/image/product/15695001ref.jpeg");
        product.setStatus(601);
        product.setRegrId(80000);

        List<ImageDTO> imageList=new ArrayList<>();
        for(int i=0;i<4;i++){
            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setImagePath("/static/image/product/15695001ref.jpeg");
            imageDTO.setRegrId(80000);
            imageList.add(imageDTO);
        }

        // 현재 날짜를 가져옴
        LocalDate today=LocalDate.now();
        LocalDate fiveDaysLater = today.plusDays(5);
        Date endDate=Date.valueOf(fiveDaysLater);
        Date startDate=Date.valueOf(today);

        PriceDTO priceDTO=new PriceDTO();
        priceDTO.setSalePrc(10000);
        priceDTO.setBuyPrc(4000);
        priceDTO.setDcPer(0);
        priceDTO.setSaleStDttm(startDate);
        priceDTO.setSaleEdDttm(endDate);
        priceDTO.setRegrId(80000);

        //옵션
        //optGrp
        List<OptGrpDTO> optGrpNmList= new ArrayList<>();
        OptGrpDTO optGrpDTO=new OptGrpDTO();
        optGrpDTO.setOptGrpNm("color");
        optGrpDTO.setRegrId(80000);
        optGrpNmList.add(optGrpDTO);
        OptGrpDTO optGrpDTO1=new OptGrpDTO();
        optGrpDTO1.setOptGrpNm("size");
        optGrpDTO1.setRegrId(80000);
        optGrpNmList.add(optGrpDTO1);

        //prodOpt
        List<ProdOptDTO> prodOptList = new ArrayList<>();
        for(int i=0;i<3;i++) {
            ProdOptDTO prodOptDTO = new ProdOptDTO();
            prodOptDTO.setOptPrc(0);
            prodOptDTO.setInvQty(5);
            prodOptDTO.setRegrId(80000);
            prodOptList.add(prodOptDTO);
        }

        //optItem
        List<OptItemDTO> optItemDTOList =new ArrayList<>();
        OptItemDTO optItemDTO=new OptItemDTO();
        optItemDTO.setOptItemNm("Gray");
        optItemDTO.setRegrId(80000);
        optItemDTOList.add(optItemDTO);
        for(int i=0;i<3;i++){
            OptItemDTO optItemDTO1=new OptItemDTO();
            optItemDTO1.setOptItemNm(String.valueOf(220+(i*10)));
            optItemDTO1.setRegrId(80000);
            optItemDTOList.add(optItemDTO1);
        }

        bosProductService.addProductData(product, priceDTO, imageList, optGrpNmList,prodOptList, optItemDTOList, 80000);
    }
}