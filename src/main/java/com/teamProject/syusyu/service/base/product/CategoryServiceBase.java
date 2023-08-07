package com.teamProject.syusyu.service.base.product;

import com.teamProject.syusyu.dao.product.CategoryDAO;
import com.teamProject.syusyu.domain.product.CategoryDTO;
import com.teamProject.syusyu.service.fos.product.FOS_CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceBase implements FOS_CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    /**
     * 모든 카테고리 목록을 가져오는 메소드입니다.
     *
     * @return 전체 카테고리 목록을 담은 Map 객체를 반환합니다.
     * @throws Exception 카테고리 서비스에서 카테고리 목록을 가져오는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/06
     */
    @Override
    public Map<String, Object> getCategoryAllList() {
        List<CategoryDTO> allCategory = categoryDAO.selectCategoryAllList();
        //대분류
        LinkedHashMap<Integer, String> largeCategories = new LinkedHashMap<>();
        //중분류
        LinkedHashMap<Integer, String> middleCategories = new LinkedHashMap<>();
        //소분류
        Map<Integer, Map<Integer, String>> smallCategories = new HashMap<>();
        //컨트롤러로 보낼 맵
        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < allCategory.size(); i++) {
            largeCategories.put(allCategory.get(i).getLargeNo(), allCategory.get(i).getLargeNm());
            middleCategories.put(allCategory.get(i).getMiddleNo(), allCategory.get(i).getMiddleNm());

            if (!smallCategories.containsKey(allCategory.get(i).getMiddleNo())) {
                smallCategories.put(allCategory.get(i).getMiddleNo(), new HashMap<>());
            }

            Map<Integer, String> smallMap = smallCategories.get(allCategory.get(i).getMiddleNo());
            smallMap.put(allCategory.get(i).getSmallNo(), allCategory.get(i).getSmallNm());
        }

        map.put("cateList", allCategory);
        map.put("largeCategories", largeCategories);
        map.put("middleCategories", middleCategories);
        map.put("smallCategories", smallCategories);

        return map;
    }
}
