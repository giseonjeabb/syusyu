package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.dao.product.ProdOptDAO;
import com.teamProject.syusyu.domain.product.ProdOptDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProdOptDAOImpl implements ProdOptDAO{

    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.prodOptMapper.";
    /**
     * 특정 상품 ID(prodId)에 해당하는 상품옵션(신발사이즈, 옵션가, 재고수량) 조회합니다.
     * 이 메소드는 MyBatis의 SqlSession을 사용하여 DB에서 상품옵션정보를 가져옵니다.
     *
     * @param prodId 상품 ID, 이 번호는 상품을 식별하는 데 사용됩니다.
     * @return 해당 상품 ID에 해당하는 신발사이즈, 옵션가, 재고수량을 반환합니다.
     *         이미지들은 ProdOptDTO 객체로 표현됩니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/21
     */
    @Override
    public List<ProdOptDTO> selectProdOptSizeList(int prodId){
        return session.selectList(namespace+"selectProdOptSizeList", prodId);
    }

    /**
     * 상품의 옵션을 데이터베이스에 삽입합니다.
     * 이 메서드는 ProductDTO 객체를 인수로 받아 그 정보를 이용해 상품의 옵션을 생성하고,
     * 이를 데이터베이스에 삽입하는 역할을 합니다.
     *
     * @param prodOptDTO 상품의 옵션 정보를 담고 있는 DTO 객체.
     *                   이 객체는 상품명, 상품 ID, 옵션 ID 등의 필드를 포함합니다.
     * @return 삽입된 옵션의 수를 반환합니다.
     * @throws Exception 데이터베이스 삽입 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int insertProdOpt(ProdOptDTO prodOptDTO) throws Exception{
        return session.insert(namespace+"insertProdOpt", prodOptDTO);
    }

    /**
     * 상품의 재고수량을 가져온다.
     *
     * @param optCombNoArr 옵션조합번호
     * @return 상품의 재고수량 반환
     * @throws Exception 조회 중 발생할 수 있는 예외
     * @author min
     * @since 2024/01/08
     */
    @Override
    public List<ProdOptDTO> selectProductQty(int[] optCombNoArr) throws Exception {
        return session.selectList(namespace + "selectProductQty", optCombNoArr);
    }

    /**
     * 상품의 재고수량을 감소시킨다
     *
     * @param param 옵션조합번호와 구매하려는 수량이 들어있는 Map
     * @return update 성공 row 개수
     * @throws Exception update 중 발생할 수 있는 예외
     * @author min
     * @since 2024/01/08
     */
    @Override
    public int decreaseProdQty(Map<String, Integer> param) throws Exception {
        return session.update(namespace + "decreaseProdQty", param);
    }

    /**
     * 상품의 재고수량을 변경한다.
     *
     * @param param 옵션조합번호와 변경할 수량이 들어있는 Map
     * @return update 성공 row 개수
     * @throws Exception update 중 발생할 수 있는 예외
     * @author min
     * @since 2024/01/13
     */
    @Override
    public int updateProdQty(Map<String, Integer> param) throws Exception {
        return session.update(namespace + "updateProdQty", param);
    }


}
