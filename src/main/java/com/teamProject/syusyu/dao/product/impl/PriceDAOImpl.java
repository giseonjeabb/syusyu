package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.domain.product.PriceDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PriceDAOImpl implements com.teamProject.syusyu.dao.product.PriceDAO {
    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.priceMapper.";

    /**
     * 상품의 가격 정보를 데이터베이스에 삽입합니다.
     * 이 메서드는 ProductDTO 객체를 인수로 받아 그 정보를 이용해 상품의 가격 정보를 생성하고,
     * 이를 데이터베이스에 삽입하는 역할을 합니다.
     *
     * @param priceDTO 상품의 가격 정보를 담고 있는 DTO 객체.
     *                   이 객체는 상품명, 상품 ID, 가격 등의 필드를 포함합니다.
     * @return 삽입된 가격 정보의 수를 반환합니다.
     * @throws Exception 데이터베이스 삽입 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/31
     */
    @Override
    public int insertPrice(PriceDTO priceDTO) throws Exception{
        return session.insert(namespace+"insertPrice", priceDTO);
    }
}
