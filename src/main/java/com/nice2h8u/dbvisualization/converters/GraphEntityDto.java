package com.nice2h8u.dbvisualization.converters;

import lombok.Builder;

public class GraphEntityDto {

    private Double val;
    private Long mil;

    public GraphEntityDto() {
    }

    @Builder
    public GraphEntityDto(Double val, Long mil) {
        this.val = val;
        this.mil = mil;
    }

    public Double getVal() {
        return val;
    }

    public void setVal(Double val) {
        this.val = val;
    }

    public Long getMil() {
        return mil;
    }

    public void setMil(Long mil) {
        this.mil = mil;
    }
}
