package com.teamProject.syusyu.service.product.impl;

import com.teamProject.syusyu.service.fos.product.FOS_CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FOSCategoryServiceImplTest {

    @Autowired
    FOS_CategoryService FOSFOSCategoryService;

    @Test
    public void getCategoryAllList() throws Exception {
//        Map<String, Object> allCategory = categoryService.getCategoryAllList();
//        LinkedHashMap<Integer, String> largeCategories = (LinkedHashMap<Integer, String>) allCategory.get("largeCategories");
//        System.out.println(allCategory);
//        System.out.println(largeCategories);
//
//        System.out.println("중분류 :"+largeCategories.get(1));
//        System.out.println(((LinkedHashMap<Integer, String>) allCategory.get("largeCategories")).values());

//        LinkedHashMap<Integer, String> largeCategories = new LinkedHashMap<>();
//        LinkedHashMap<Integer, String> middleCategories = new LinkedHashMap<>();
//        Map<Integer,Map<Integer,String>> smallCategories = new HashMap<>();
//
//        for (int i = 0; i < allCategory.size(); i++) {
//            largeCategories.put(allCategory.get(i).getLargeNo(), allCategory.get(i).getLargeNm());
//            middleCategories.put(allCategory.get(i).getMiddleNo(), allCategory.get(i).getMiddleNm());
//
//            if (!smallCategories.containsKey(allCategory.get(i).getMiddleNo())) {
//                smallCategories.put(allCategory.get(i).getMiddleNo(), new HashMap<>());
//            }
//
//            Map<Integer, String> smallMap = smallCategories.get(allCategory.get(i).getMiddleNo());
//            smallMap.put(allCategory.get(i).getSmallNo(), allCategory.get(i).getSmallNm());
//        }
//
//
//        System.out.println(largeCategories.entrySet());
//        System.out.println(middleCategories.entrySet());
//
//        for (Map.Entry<Integer, Map<Integer, String>> entry : smallCategories.entrySet()) {
//            int middleNo = entry.getKey();
//            Map<Integer, String> smallMap = entry.getValue();
//
//            System.out.println("Middle Category: " + middleCategories.get(middleNo));
//
//            for (Map.Entry<Integer, String> smallEntry : smallMap.entrySet()) {
//                int smallNo = smallEntry.getKey();
//                String smallNm = smallEntry.getValue();
//
//                System.out.println("Small Category: " + smallNo + " - " + smallNm);
//            }
//        }

    }
}