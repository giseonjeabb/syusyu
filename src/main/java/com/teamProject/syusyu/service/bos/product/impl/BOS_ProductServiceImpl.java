package com.teamProject.syusyu.service.bos.product.impl;

import com.teamProject.syusyu.dao.product.*;
import com.teamProject.syusyu.domain.product.*;
import com.teamProject.syusyu.service.bos.product.BOS_ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class BOS_ProductServiceImpl implements BOS_ProductService {

    @Autowired
    BrandDAO brandDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProdOptDAO prodOptDAO;
    @Autowired
    ProdOptCombDAO prodOptCombDAO;

    @Autowired
    OptGrpDAO optGrpDAO;

    @Autowired
    OptItemDAO optItemDAO;

    @Autowired
    ImageDAO imageDAO;

    @Autowired
    PriceDAO priceDAO;

    /**
     * 상품 정보 조회를 위한 데이터를 가져옵니다.
     * 이 메서드는 브랜드 목록, 제조국 목록, 제조사 목록을 DB에서 조회하여 Map으로 반환합니다.
     * 조회한 데이터들은 각각 BrandDTO, ProductDTO 형식의 리스트로 표현됩니다.
     *
     * @return 브랜드 목록, 제조국 목록, 제조사 목록을 담고 있는 Map 객체를 반환합니다.
     * Map의 key는 "brandList", "mftNatnList", "mftcoList"입니다.
     * 각각의 value는 브랜드 목록, 제조국 목록, 제조사 목록을 담고 있는 리스트입니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/29
     */
    @Override
    public Map<String, Object> getProductInfo() throws Exception {
        List<BrandDTO> brandList = brandDAO.selectBrandList();
        List<ProductDTO> mftNatnList = productDAO.selectMftNatnList();
        List<ProductDTO> mftcoList = productDAO.selectMftcoList();

        Map<String, Object> map = new HashMap<>();
        map.put("brandList", brandList);
        map.put("mftNatnList", mftNatnList);
        map.put("mftcoList", mftcoList);
        return map;

    }

    /**
     * 이 메서드는 상품 정보, 가격, 이미지, 옵션 등을 등록하는 역할을 합니다.
     * 각각의 DTO는 관련 정보를 담고 있으며, 모든 데이터는 DB에 저장됩니다.
     * 이 모든 과정이 하나의 트랜잭션으로 관리되며, 어떤 하나의 등록 과정에서 예외가 발생하면,
     * 모든 과정이 롤백되고, "Failed to add product data"라는 메시지와 함께 예외를 던집니다.
     *
     * @param product       상품 정보가 담긴 ProductDTO 객체
     * @param price         가격 정보가 담긴 PriceDTO 객체
     * @param imageList     이미지 정보 목록이 담긴 ImageDTO 리스트
     * @param optGrpNmList  옵션 그룹 목록이 담긴 OptGrpDTO 리스트
     * @param prodOptList   상품 옵션 목록이 담긴 ProdOptDTO 리스트
     * @param optItemNmList 옵션 아이템 목록이 담긴 OptItemDTO 리스트
     * @param mbrId         상품을 등록하는 회원 ID
     * @throws Exception 상품 등록 과정에서 발생하는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Transactional
    public void addProductData(ProductDTO product,
                               PriceDTO price,
                               List<ImageDTO> imageList,
                               List<OptGrpDTO> optGrpNmList,
                               List<ProdOptDTO> prodOptList,
                               List<OptItemDTO> optItemNmList,
                               int mbrId
    ) throws Exception {

        try {
            int prodId = 0;
            //상품등록
            product.setRegrId(mbrId);
            productDAO.insertProduct(product);
            prodId = product.getProdId();


            //가격등록
            price.setRegrId(mbrId);
            price.setProdId(prodId);
            priceDAO.insertPrice(price);

            //이미지등록
            for (ImageDTO smlImgDTO : imageList) {
                smlImgDTO.setRegrId(mbrId);
                smlImgDTO.setProdId(prodId);
                imageDAO.insertImage(smlImgDTO);
            }

            //옵션등록
            //옵션그룹(color, size 옵션명 저장하고 optGrpId를 반환)
            List<Integer> optGrpIdList = new ArrayList<>();
            for (OptGrpDTO optGrpDTO : optGrpNmList) {
                optGrpDTO.setRegrId(mbrId);
                optGrpDTO.setProdId(prodId);
                optGrpDAO.insertOptGrp(optGrpDTO);
                optGrpIdList.add(optGrpDTO.getOptGrpId());
            }

            //prodOpt
            List<Integer> optCombNoList = new ArrayList<>();
            for (ProdOptDTO prodOptDTO : prodOptList) {
                prodOptDTO.setRegrId(mbrId);
                prodOptDTO.setProdId(prodId);
                prodOptDAO.insertProdOpt(prodOptDTO);
                optCombNoList.add(prodOptDTO.getOptCombNo());
            }

            //optItem
            List<Integer> optItemIdList = new ArrayList<>();
            OptItemDTO optItemDTO = new OptItemDTO();
            optItemDTO.setOptItemNm(optItemNmList.get(0).getOptItemNm());
            optItemDTO.setOptGrpId(optGrpIdList.get(0));
            optItemDTO.setRegrId(mbrId);
            optItemDAO.insertOptItem(optItemDTO);
            optItemIdList.add(optItemDTO.getOptItemId());

            for (int i = 1; i < optItemNmList.size(); i++) {
                OptItemDTO optItemDto = new OptItemDTO();
                optItemDto.setOptItemNm(optItemNmList.get(i).getOptItemNm());
                optItemDto.setOptGrpId(optGrpIdList.get(1));
                optItemDto.setRegrId(mbrId);
                optItemDAO.insertOptItem(optItemDto);
                optItemIdList.add(optItemDto.getOptItemId());
            }

            //prodOptComb
            for (int i = 0; i < optCombNoList.size(); i++) {
                ProdOptCombDTO prodOptCombDTO = new ProdOptCombDTO();
                prodOptCombDTO.setOptCombNo(optCombNoList.get(i));
                prodOptCombDTO.setOptItemId(optItemIdList.get(0));
                prodOptCombDTO.setRegrId(mbrId);
                prodOptCombDAO.insertProdOptComb(prodOptCombDTO);
                ProdOptCombDTO prodOptCombDTO1 = new ProdOptCombDTO();
                prodOptCombDTO1.setOptCombNo(optCombNoList.get(i));
                prodOptCombDTO1.setOptItemId(optItemIdList.get(i + 1));
                prodOptCombDTO1.setRegrId(mbrId);
                prodOptCombDAO.insertProdOptComb(prodOptCombDTO1);
            }


        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new Exception("Failed to add product data");
        }
    }

    @Override
    public List<ProductDTO> getProductBosList(SearchConditionDTO searchConditionDTO){
        return productDAO.selectProductBosList(searchConditionDTO);
    }


}
