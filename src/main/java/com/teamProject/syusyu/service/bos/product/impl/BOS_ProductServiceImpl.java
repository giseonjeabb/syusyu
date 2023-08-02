package com.teamProject.syusyu.service.bos.product.impl;

import com.teamProject.syusyu.dao.product.*;
import com.teamProject.syusyu.domain.product.*;
import com.teamProject.syusyu.service.bos.product.BOS_ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 상품 등록을 수행하는 메서드입니다.
     * 상품 정보를 DB에 등록하고, 등록된 상품의 ID를 반환합니다.
     * 상품 등록에 성공한 경우 등록된 상품의 ID를 반환하며, 실패한 경우 예외를 던집니다.
     *
     * @param product 상품 정보를 담고 있는 ProductDTO 객체
     * @return prodId 등록된 상품의 ID
     * @throws Exception 상품 등록에 실패한 경우 발생하는 예외
     * @author soso
     * @since 2023/07/31
     */

    @Transactional
    public void addProductData(ProductDTO product,
                               PriceDTO price,
                               List<ImageDTO> smlImgDTOs,
                               List<ProdOptDTO> prodOptList,
                               List<OptItemDTO> optItemDTOList,
                               List<OptGrpDTO> optGrpDTOList) throws Exception{
        try {

            int prodId=productDAO.insertProduct(product);

            //가격
            price.setProdId(prodId);
            priceDAO.insertPrice(price);
            //이미지
            for (ImageDTO smlImgDTO : smlImgDTOs) {
                smlImgDTO.setProdId(prodId);
                imageDAO.insertSmlImg(smlImgDTO);
            }

            //옵션그룹(color, size 옵션명 저장하고 optGrpId를 반환)
            List<Integer> optGrpIds = new ArrayList<>();
            for(OptGrpDTO optGrpDTO : optGrpDTOList){
                int newOptGrpId = optGrpDAO.insertOptGrp(optGrpDTO);
                optGrpIds.add(newOptGrpId);
            }

            List<Integer> optCombNos=new ArrayList<>();
            for(ProdOptDTO prodOptDTO: prodOptList){
                prodOptDTO.setProdId(prodId);
                int newOptCombNo= prodOptDAO.insertProdOpt(prodOptDTO);
                optCombNos.add(newOptCombNo);
            }

            List<Integer> optItemIds = new ArrayList<>();
            for(int i=0; i<optItemDTOList.size(); i++) {
                OptItemDTO optItemDTO = optItemDTOList.get(i);
                if(i == 0) {
                    optItemDTO.setOptGrpId(optGrpIds.get(0));
                } else {
                    optItemDTO.setOptGrpId(optGrpIds.get(1));
                }
                int optItemId = optItemDAO.insertOptItem(optItemDTO);
                optItemIds.add(optItemId);
            }


// optCombNos 리스트의 크기를 구합니다.
            int optCombNosSize = optCombNos.size();

// optItemIds 리스트의 크기를 구합니다.
            int optItemIdsSize = optItemIds.size();
            List<ProdOptCombDTO> prodOptCombDTOList = new ArrayList<>();

// optCombNos 리스트를 순회합니다.
            for(int i = 0; i < optCombNosSize; i++){

                // optItemIds 리스트를 순회합니다.
                for(int j = 0; j < optItemIdsSize; j++){

                    // 첫 번째 리스트인 optItemIds의 첫 번째 항목은
                    // optCombNos의 모든 항목과 매칭되는데, 그 이후의 항목들은
                    // 자신의 인덱스보다 작거나 같은 인덱스를 가진 optCombNos 항목과만 매칭되어야 합니다.
                    if(j == 0 && i != 0){
                        continue;
                    }
                    if(j > i + 1){
                        break;
                    }

                    // 새로운 DTO 객체를 생성하고 필드를 설정합니다.
                    ProdOptCombDTO prodOptCombDTO = new ProdOptCombDTO();
                    prodOptCombDTO.setOptItemId(optCombNos.get(i));
                    prodOptCombDTOList.add(prodOptCombDTO);
                    prodOptCombDTO.setOptItemId(optItemIds.get(j));
                    prodOptCombDTOList.add(prodOptCombDTO);

                    // DTO 객체를 데이터베이스에 추가합니다.
                }
            }
            prodOptCombDAO.insertProdOptCombList(prodOptCombDTOList);


        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new Exception("Failed to add product data");
        }
    }

}
