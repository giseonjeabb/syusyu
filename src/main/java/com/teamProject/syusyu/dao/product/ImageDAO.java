package com.teamProject.syusyu.dao.product;

import com.teamProject.syusyu.domain.product.ImageDTO;

import java.util.List;

public interface ImageDAO {
    List<ImageDTO> selectImageList(int prodId);

    int insertImage(ImageDTO imageDTO) throws Exception;
}
