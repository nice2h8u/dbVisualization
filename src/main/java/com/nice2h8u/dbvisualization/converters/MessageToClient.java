package com.nice2h8u.dbvisualization.converters;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

public class MessageToClient {
    private String nameOfMode;
    private List<List<OneGraphDto>> listOfParameters;
    @Builder

    public MessageToClient(String nameOfMode, List<List<OneGraphDto>> listOfParameters) {
        this.nameOfMode = nameOfMode;
        this.listOfParameters = listOfParameters;
    }
}
