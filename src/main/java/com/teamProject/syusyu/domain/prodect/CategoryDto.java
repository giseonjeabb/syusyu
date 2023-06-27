package com.teamProject.syusyu.domain.prodect;

import java.time.LocalDateTime;
import java.util.Objects;

public class CategoryDto {
    private int categoryId;
    private String largeCategory;
    private int largeCategoryNo;
    private String middleCategory;
    private int middleCategoryNo;
    private String smallCategory;
    private int smallCategoryNo;private int cateId;
    private boolean displayYN;
    private String registeredId;
    private LocalDateTime registrationDateTime;
    private String updatedId;
    private LocalDateTime updateDateTime;
    private LocalDateTime deletionDateTime;
    private String deletedId;
    private boolean deletionYN;

    public CategoryDto() {
    }


    public CategoryDto(int categoryId, String largeCategory, int largeCategoryNo, String middleCategory, int middleCategoryNo, String smallCategory, int smallCategoryNo, int cateId, boolean displayYN, String registeredId, LocalDateTime registrationDateTime, String updatedId, LocalDateTime updateDateTime, LocalDateTime deletionDateTime, String deletedId, boolean deletionYN) {
        this.categoryId = categoryId;
        this.largeCategory = largeCategory;
        this.largeCategoryNo = largeCategoryNo;
        this.middleCategory = middleCategory;
        this.middleCategoryNo = middleCategoryNo;
        this.smallCategory = smallCategory;
        this.smallCategoryNo = smallCategoryNo;
        this.cateId = cateId;
        this.displayYN = displayYN;
        this.registeredId = registeredId;
        this.registrationDateTime = registrationDateTime;
        this.updatedId = updatedId;
        this.updateDateTime = updateDateTime;
        this.deletionDateTime = deletionDateTime;
        this.deletedId = deletedId;
        this.deletionYN = deletionYN;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getLargeCategory() {
        return largeCategory;
    }

    public void setLargeCategory(String largeCategory) {
        this.largeCategory = largeCategory;
    }

    public int getLargeCategoryNo() {
        return largeCategoryNo;
    }

    public void setLargeCategoryNo(int largeCategoryNo) {
        this.largeCategoryNo = largeCategoryNo;
    }

    public String getMiddleCategory() {
        return middleCategory;
    }

    public void setMiddleCategory(String middleCategory) {
        this.middleCategory = middleCategory;
    }

    public int getMiddleCategoryNo() {
        return middleCategoryNo;
    }

    public void setMiddleCategoryNo(int middleCategoryNo) {
        this.middleCategoryNo = middleCategoryNo;
    }

    public String getSmallCategory() {
        return smallCategory;
    }

    public void setSmallCategory(String smallCategory) {
        this.smallCategory = smallCategory;
    }

    public int getSmallCategoryNo() {
        return smallCategoryNo;
    }

    public void setSmallCategoryNo(int smallCategoryNo) {
        this.smallCategoryNo = smallCategoryNo;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public boolean isDisplayYN() {
        return displayYN;
    }

    public void setDisplayYN(boolean displayYN) {
        this.displayYN = displayYN;
    }

    public String getRegisteredId() {
        return registeredId;
    }

    public void setRegisteredId(String registeredId) {
        this.registeredId = registeredId;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    public String getUpdatedId() {
        return updatedId;
    }

    public void setUpdatedId(String updatedId) {
        this.updatedId = updatedId;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public LocalDateTime getDeletionDateTime() {
        return deletionDateTime;
    }

    public void setDeletionDateTime(LocalDateTime deletionDateTime) {
        this.deletionDateTime = deletionDateTime;
    }

    public String getDeletedId() {
        return deletedId;
    }

    public void setDeletedId(String deletedId) {
        this.deletedId = deletedId;
    }

    public boolean isDeletionYN() {
        return deletionYN;
    }

    public void setDeletionYN(boolean deletionYN) {
        this.deletionYN = deletionYN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto that = (CategoryDto) o;
        return categoryId == that.categoryId && largeCategoryNo == that.largeCategoryNo && middleCategoryNo == that.middleCategoryNo && smallCategoryNo == that.smallCategoryNo && cateId == that.cateId && displayYN == that.displayYN && deletionYN == that.deletionYN && Objects.equals(largeCategory, that.largeCategory) && Objects.equals(middleCategory, that.middleCategory) && Objects.equals(smallCategory, that.smallCategory) && Objects.equals(registeredId, that.registeredId) && Objects.equals(registrationDateTime, that.registrationDateTime) && Objects.equals(updatedId, that.updatedId) && Objects.equals(updateDateTime, that.updateDateTime) && Objects.equals(deletionDateTime, that.deletionDateTime) && Objects.equals(deletedId, that.deletedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, largeCategory, largeCategoryNo, middleCategory, middleCategoryNo, smallCategory, smallCategoryNo, cateId, displayYN, registeredId, registrationDateTime, updatedId, updateDateTime, deletionDateTime, deletedId, deletionYN);
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryId=" + categoryId +
                ", largeCategory='" + largeCategory + '\'' +
                ", largeCategoryNo=" + largeCategoryNo +
                ", middleCategory='" + middleCategory + '\'' +
                ", middleCategoryNo=" + middleCategoryNo +
                ", smallCategory='" + smallCategory + '\'' +
                ", smallCategoryNo=" + smallCategoryNo +
                ", cateId=" + cateId +
                ", displayYN=" + displayYN +
                ", registeredId='" + registeredId + '\'' +
                ", registrationDateTime=" + registrationDateTime +
                ", updatedId='" + updatedId + '\'' +
                ", updateDateTime=" + updateDateTime +
                ", deletionDateTime=" + deletionDateTime +
                ", deletedId='" + deletedId + '\'' +
                ", deletionYN=" + deletionYN +
                '}';
    }
}
