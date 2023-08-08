package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.ProductDAO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.domain.product.SearchConditionDTO;
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
     * 특정 중분류 번호(middleNo), 소분류 번호(smallNo) 및 정렬 기준(sort)에 따라 상품 목록을 데이터베이스에서 조회합니다.
     * 이 메소드는 MyBatis의 SqlSession을 사용하여 DB에서 상품 정보를 가져옵니다.
     *
     * @param middleNo 중분류 번호, 이 번호는 상품의 중분류 카테고리를 식별하는 데 사용됩니다.
     * @param smallNo  소분류 번호, 이 번호는 상품의 소분류 카테고리를 식별하는 데 사용됩니다.
     * @param sort     상품 목록을 정렬하는 기준을 나타내는 문자열입니다.
     * @return 해당 중분류와 소분류 번호에 해당하며 정렬 기준에 맞게 정렬된 상품들의 리스트를 반환합니다.
     * 각 상품은 ProductDTO 객체로 표현됩니다.
     * @throws Exception DB에서 상품 정보를 조회하는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/07
     */
    @Override
    public List<ProductDTO> selectProductList(int middleNo, int smallNo, String sort) throws Exception {
        Map map = new HashMap<>();
        map.put("middleNo", middleNo);
        map.put("smallNo", smallNo);
        map.put("sort", sort);
        return session.selectList(namespace + "selectProductList", map);

    }

    /**
     * 주어진 중분류 번호(middleNo)와 정렬 기준(sort)에 따라 모든 상품 목록을 데이터베이스에서 조회합니다.
     * 이 메소드는 MyBatis의 SqlSession을 사용하여 DB에서 상품 정보를 가져옵니다.
     *
     * @param middleNo 중분류 번호, 이 번호는 상품의 중분류 카테고리를 식별하는 데 사용됩니다.
     * @param sort     상품 목록을 정렬하는 기준을 나타내는 문자열입니다.
     * @return 해당 중분류 번호에 해당하며 정렬 기준에 맞게 정렬된 모든 상품들의 리스트를 반환합니다.
     * 각 상품은 ProductDTO 객체로 표현됩니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/07
     */
    @Override
    public List<ProductDTO> selectProductAllList(int middleNo, String sort) {
        Map map = new HashMap<>();
        map.put("middleNo", middleNo);
        map.put("sort", sort);
        return session.selectList(namespace + "selectProductAllList", map);

    }

    /**
     * 주어진 상품 ID 배열(prodIdArr)에 해당하는 상품들의 상태를 조회합니다.
     * 이 메소드는 MyBatis의 SqlSession을 사용하여 DB에서 상품 상태 정보를 가져옵니다.
     *
     * @param prodIdArr 상품 ID를 담고 있는 배열입니다. 각 상품 ID는 고유한 상품을 식별하는 데 사용됩니다.
     * @return 상품 ID 배열에 해당하는 상품들의 상태 정보를 담은 리스트를 반환합니다.
     * 각 상품의 상태 정보는 ProductDTO 객체로 표현됩니다.
     * @author min
     * @since 2023/08/04
     */
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
     * 제조국 코드(MftNatn) 목록을 조회합니다.
     * 이 메서드는 MyBatis의 SqlSession을 사용하여 DB에서 제조국 코드(MftNatn)를 가져옵니다.
     *
     * @return 제조국 코드(MftNatn)의 목록을 반환합니다.
     * 목록은 ProductDTO 객체로 표현됩니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/20
     */
    @Override
    public List<ProductDTO> selectMftNatnList() {
        return session.selectList(namespace + "selectMftNatnList");
    }

    /**
     * 제조사 코드(Mftco) 목록을 조회합니다.
     * 이 메서드는 MyBatis의 SqlSession을 사용하여 DB에서 제조사 코드(Mftco)를 가져옵니다.
     *
     * @return 제조사 코드(Mftco)의 목록을 반환합니다.
     * 목록은 ProductDTO 객체로 표현됩니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/20
     */
    @Override
    public List<ProductDTO> selectMftcoList() {
        return session.selectList(namespace + "selectMftcoList");
    }

    /**
     * 상품 정보를 등록합니다.
     * 이 메서드는 MyBatis의 SqlSession을 사용하여 상품 정보를 DB에 삽입합니다.
     *
     * @param productDTO 등록할 상품 정보를 담고 있는 ProductDTO 객체입니다.
     * @return DB에 삽입된 행의 개수를 반환합니다.
     * @throws Exception DB 등록 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/29
     */
    @Override
    public int insertProduct(ProductDTO productDTO) throws Exception {
        return session.insert(namespace + "insertProduct", productDTO);
    }

    /**
     * 상품 목록을 조회합니다.
     * 이 메서드는 MyBatis의 SqlSession을 사용하여 상품 목록을 DB에서 가져옵니다.
     *
     * @param params 조회에 사용되는 파라미터를 담고 있는 Map 객체입니다.
     *               예: 검색 키워드, 필터 조건, 정렬 조건, 페이지네이션 정보 등
     * @return 조회된 상품 정보를 담고 있는 ProductDTO의 List를 반환합니다.
     * @throws Exception 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/08/07
     */
    @Override
    public List<ProductDTO> selectProductBosList(SearchConditionDTO params){
        return session.selectList(namespace + "selectProductBosList", params);
    }

    @Override
    public List<ProductDTO> selectNewProductList(){
        return session.selectList(namespace+"selectNewProductList");
    }

    @Override
    public List<ProductDTO> selectPickProductList(){
        return session.selectList(namespace+"selectPickProductList");
    }

    @Override
    public List<ProductDTO> selectPopularProductList(){
        return session.selectList(namespace+"selectPopularProductList");
    }

}
