package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.domain.product.ImageDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDAOImpl implements com.teamProject.syusyu.dao.product.ImageDAO {

    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.imageMapper.";

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
    public int insertImage(ImageDTO imageDTO) throws Exception{
        return session.insert(namespace+"insertImage", imageDTO);
    }
}
