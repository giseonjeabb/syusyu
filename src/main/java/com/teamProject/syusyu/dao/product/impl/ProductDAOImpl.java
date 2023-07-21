package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ImageDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.productMapper.";

    /**
     * 특정 중분류 번호(middleNo)와 소분류 번호(smallNo)에 해당하는 모든 상품들을 조회합니다.
     * 이 메소드는 MyBatis의 SqlSession을 사용하여 DB에서 상품들을 가져옵니다.
     *
     * @param middleNo 중분류 번호, 이 번호는 상품의 중분류 카테고리를 식별하는 데 사용됩니다.
     * @param smallNo  소분류 번호, 이 번호는 상품의 소분류 카테고리를 식별하는 데 사용됩니다.
     * @return 해당 중분류와 소분류 번호에 해당하는 모든 상품들의 리스트를 반환합니다.
     * 각 상품은 ProductDTO 객체로 표현됩니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/07
     */
    @Override
    public List<ProductDTO> selectProductList(int middleNo, int smallNo) throws Exception {
        Map map = new HashMap<>();
        map.put("middleNo", middleNo);
        map.put("smallNo", smallNo);
        return session.selectList(namespace + "selectProductList", map);

    }

    /**
     * 특정 중분류 번호(middleNo)에 해당하는 모든 상품들을 조회합니다.
     * 이 메소드는 MyBatis의 SqlSession을 사용하여 DB에서 상품들을 가져옵니다.
     *
     * @param middleNo 중분류 번호, 이 번호는 상품의 중분류 카테고리를 식별하는 데 사용됩니다.
     * @return 해당 중분류 번호에 해당하는 모든 상품들의 리스트를 반환합니다.
     * 각 상품은 ProductDTO 객체로 표현됩니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/07
     */
    @Override
    public List<ProductDTO> selectProductAllList(int middleNo) {
        return session.selectList(namespace + "selectProductAllList", middleNo);

    }


    @Override
    public List<ProductDTO> selectProductStatus(int[] prodIdArr) {
        return session.selectList(namespace + "selectProductStatus", prodIdArr);
    }

    /**
     * 특정 상품 ID(prodId)에 해당하는 상품을 조회합니다.
     * 이 메소드는 MyBatis의 SqlSession을 사용하여 DB에서 상품을 가져옵니다.
     *
     * @param prodId 상품 ID, 이 번호는 상품을 식별하는 데 사용됩니다.
     * @return 해당 상품 ID에 해당하는 상품을 반환합니다.
     * 상품은 ProductDTO 객체로 표현됩니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author [your_name]
     * @since 2023/07/19
     */
    @Override
    public ProductDTO selectProduct(int prodId) {
        return session.selectOne(namespace + "selectProduct", prodId);
    }

    /**
     * 특정 상품 ID(prodId)에 해당하는 이미지를 조회합니다.
     * 이 메소드는 MyBatis의 SqlSession을 사용하여 DB에서 이미지경로를 가져옵니다.
     *
     * @param prodId 상품 ID, 이 번호는 상품을 식별하는 데 사용됩니다.
     * @return 해당 상품 ID에 해당하는 이미지를 반환합니다.
     *         이미지들은 ImageDTO 객체로 표현됩니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/20
     */
    @Override
    public List<ImageDTO> selectImageList(int prodId) {
        return session.selectList(namespace + "selectImageList", prodId);
    }
}
