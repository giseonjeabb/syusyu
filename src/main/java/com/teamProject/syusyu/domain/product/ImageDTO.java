package com.teamProject.syusyu.domain.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImageDTO {
    //상품이미지들
    private String imagePath;

    ImageDTO(){}

    public ImageDTO(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "ImageDTO{" +
                "imagePath='" + imagePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageDTO imageDTO = (ImageDTO) o;
        return Objects.equals(imagePath, imageDTO.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imagePath);
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
