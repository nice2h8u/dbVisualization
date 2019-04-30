package com.nice2h8u.dbvisualization.converters;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphEntityDot {

    private Double val;
    private Float mil;



    @Builder
    public GraphEntityDot(Double val, Float mil) {
        this.val = val;
        this.mil = mil;
    }

    public GraphEntityDot(GraphEntityDot dot) {
        val = dot.getVal();
        mil = dot.getMil();
    }
}
