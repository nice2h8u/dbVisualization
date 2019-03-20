package com.nice2h8u.dbvisualization.converters;

import lombok.Builder;

public class GraphEntityDto {

    private Double val;
    private Float mil;

    public GraphEntityDto() {
    }

    @Builder
    public GraphEntityDto(Double val, Float mil) {
        this.val = val;
        this.mil = mil;
    }

    public Double getVal() {
        return val;
    }

    public void setVal(Double val) {
        this.val = val;
    }

    public Float getMil() {
        return mil;
    }

    public void setMil(Float mil) {
        this.mil = mil;
    }
}
