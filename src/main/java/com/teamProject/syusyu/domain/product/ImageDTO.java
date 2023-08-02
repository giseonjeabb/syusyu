package com.teamProject.syusyu.domain.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImageDTO {
    private int prodId;
    private String imagePath;
    private int regrId;

    public ImageDTO(){}

    public ImageDTO(String imagePath) {
        this.imagePath = imagePath;
    }

    public ImageDTO(int prodId, String imagePath, int regrId) {
        this.prodId = prodId;
        this.imagePath = imagePath;
        this.regrId = regrId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getRegrId() {
        return regrId;
    }

    public void setRegrId(int regrId) {
        this.regrId = regrId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageDTO imageDTO = (ImageDTO) o;
        return prodId == imageDTO.prodId && regrId == imageDTO.regrId && Objects.equals(imagePath, imageDTO.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, imagePath, regrId);
    }

    @Override
    public String toString() {
        return "ImageDTO{" +
                "prodId=" + prodId +
                ", imagePath='" + imagePath + '\'' +
                ", regrId=" + regrId +
                '}';
    }
}
