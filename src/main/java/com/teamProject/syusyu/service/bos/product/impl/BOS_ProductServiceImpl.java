package com.teamProject.syusyu.service.bos.product.impl;

import com.teamProject.syusyu.dao.product.ProdOptDAO;
import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ImageDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.service.bos.product.BOS_ProductService;
import com.teamProject.syusyu.dao.product.BrandDAO;
import com.teamProject.syusyu.domain.product.BrandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param productDTO 상품 정보를 담고 있는 ProductDTO 객체
     * @return prodId 등록된 상품의 ID
     * @throws Exception 상품 등록에 실패한 경우 발생하는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int addProduct(ProductDTO productDTO) throws Exception {
        int productRegistration = productDAO.insertProduct(productDTO);
        if (productRegistration > 0) {
            int prodId = productDTO.getProdId();
            return prodId;
        } else {
            throw new Exception("상품 등록에 실패하였습니다.");
        }
    }

    /**
     * 상품 가격을 추가합니다.
     * @param productDTO 상품 가격 정보가 담긴 DTO
     * @return 처리된 레코드 수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int addPrice(ProductDTO productDTO) throws Exception {
        return productDAO.insertPrice(productDTO);
    }

    /**
     * 이미지들을 추가합니다.
     *
     * @param imageDTO 이미지 정보가 담긴 DTO
     * @return 처리된 레코드 수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int addSmlImg(ImageDTO imageDTO) throws Exception {
        return productDAO.insertSmlImg(imageDTO);
    }

    /**
     * 옵션 그룹을 추가합니다.
     * @param productDTO 옵션 그룹 정보가 담긴 DTO
     * @return optGrpId를 반환
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int addOptGrp(ProductDTO productDTO) throws Exception {
        return prodOptDAO.insertOptGrp(productDTO);
    }

    /**
     * 옵션 아이템을 추가합니다.
     *
     * @param productDTO 옵션 아이템 정보가 담긴 DTO
     * @return optItemId 반환
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int addOptItem(ProductDTO productDTO) throws Exception {
        return prodOptDAO.insertOptItem(productDTO);
    }

    /**
     * 상품 옵션을 추가합니다.
     *
     * @param productDTO 상품 옵션 정보가 담긴 DTO
     * @return optCombNo 반환
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int addProdOpt(ProductDTO productDTO) throws Exception {
        return prodOptDAO.insertProdOpt(productDTO);
    }

    /**
     * 상품 옵션 조합을 추가합니다.
     *
     * @param productDTO 상품 옵션 조합 정보가 담긴 DTO
     * @return 처리된 레코드 수
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int addProdOptComb(ProductDTO productDTO) throws Exception {
        return prodOptDAO.insertProdOptComb(productDTO);
    }

}
