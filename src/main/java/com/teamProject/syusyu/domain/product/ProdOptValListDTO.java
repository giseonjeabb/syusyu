package com.teamProject.syusyu.domain.product;

import java.util.List;
import java.util.Objects;

public class ProdOptValListDTO {
    private List<ProdOptDTO> optList;

    public List<ProdOptDTO> getOptList() {
        return optList;
    }

    public void setOptList(List<ProdOptDTO> optList) {
        this.optList = optList;
    }

    @Override
    public String toString() {
        return "ProdOptValListDTO{" +
                "optList=" + optList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdOptValListDTO that = (ProdOptValListDTO) o;
        return Objects.equals(optList, that.optList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optList);
    }
}
