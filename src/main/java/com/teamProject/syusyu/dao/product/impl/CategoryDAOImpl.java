package com.teamProject.syusyu.dao.product.impl;

import com.teamProject.syusyu.domain.product.CategoryDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements com.teamProject.syusyu.dao.product.CategoryDAO {
    @Autowired
    private SqlSession session;
    private static final String namespace = "com.teamProject.syusyu.categoryMapper.";

    /**
     * 모든 카테고리를 전체조회합니다.
     *
     * @return 전체 카테고리 리스트를 반환합니다.
     * @throws Exception DB 조회 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/06
     */
    @Override
    public List<CategoryDTO> selectCategoryAllList() {
        return session.selectList(namespace + "selectCategoryAllList");
    }
}
