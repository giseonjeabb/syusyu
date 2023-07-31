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

    /**
     * 제조국 코드(MftNatn) 목록을 조회합니다.
     * 이 메서드는 MyBatis의 SqlSession을 사용하여 DB에서 제조국 코드(MftNatn)를 가져옵니다.
     *
     * @return 제조국 코드(MftNatn)의 목록을 반환합니다.
     *         목록은 ProductDTO 객체로 표현됩니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/20
     */
    @Override
    public List<ProductDTO> selectMftNatnList(){
        return session.selectList(namespace+"selectMftNatnList");
    }

    /**
     * 제조사 코드(Mftco) 목록을 조회합니다.
     * 이 메서드는 MyBatis의 SqlSession을 사용하여 DB에서 제조사 코드(Mftco)를 가져옵니다.
     *
     * @return 제조사 코드(Mftco)의 목록을 반환합니다.
     *         목록은 ProductDTO 객체로 표현됩니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/20
     */
    @Override
    public List<ProductDTO> selectMftcoList(){
        return session.selectList(namespace+"selectMftcoList");
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
    public int insertProduct(ProductDTO productDTO) throws Exception{
        return session.insert(namespace+"insertProduct", productDTO);
    }

    /**
     * 상품의 가격 정보를 데이터베이스에 삽입합니다.
     * 이 메서드는 ProductDTO 객체를 인수로 받아 그 정보를 이용해 상품의 가격 정보를 생성하고,
     * 이를 데이터베이스에 삽입하는 역할을 합니다.
     *
     * @param productDTO 상품의 가격 정보를 담고 있는 DTO 객체.
     *                   이 객체는 상품명, 상품 ID, 가격 등의 필드를 포함합니다.
     * @return 삽입된 가격 정보의 수를 반환합니다.
     * @throws Exception 데이터베이스 삽입 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int insertPrice(ProductDTO productDTO) throws Exception{
        return session.insert(namespace+"insertPrice", productDTO);
    }

    /**
     * 상품의 소형 이미지를 데이터베이스에 삽입합니다.
     * 이 메서드는 ProductDTO 객체를 인수로 받아 그 정보를 이용해 상품의 소형 이미지 정보를 생성하고,
     * 이를 데이터베이스에 삽입하는 역할을 합니다.
     *
     * @param imageDTO 상품의 소형 이미지 정보를 담고 있는 DTO 객체.
     *                   이 객체는 상품명, 상품 ID, 소형 이미지 URI 등의 필드를 포함합니다.
     * @return 삽입된 소형 이미지 정보의 수를 반환합니다.
     * @throws Exception 데이터베이스 삽입 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int insertSmlImg(ImageDTO imageDTO) throws Exception{
        return session.insert(namespace+"insertSmlImg", imageDTO);
    }
}
