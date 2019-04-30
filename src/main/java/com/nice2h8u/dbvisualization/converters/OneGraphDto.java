package com.nice2h8u.dbvisualization.converters;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OneGraphDto {

    private Float max;
    private Float min;
    private Float matWaiting;
    private Float dispersion;
    private List<GraphEntityDot> graph;

    @Builder
    public OneGraphDto(Float max, Float min, Float matWaiting, Float dispersion, List<GraphEntityDot> graph) {
        this.max = max;
        this.min = min;
        this.matWaiting = matWaiting;
        this.dispersion = dispersion;
        this.graph = graph;
    }
}
