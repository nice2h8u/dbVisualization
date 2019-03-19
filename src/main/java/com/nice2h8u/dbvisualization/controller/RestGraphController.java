package com.nice2h8u.dbvisualization.controller;

import com.nice2h8u.dbvisualization.converters.Df4ToGraphEntityConverter;
import com.nice2h8u.dbvisualization.converters.GraphEntityDto;
import com.nice2h8u.dbvisualization.firstdb.service.interfaces.Df4Service;
import com.nice2h8u.dbvisualization.seconddb.service.Df4ServiceSecond;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rrgraphs/")
public class RestGraphController {
    private final Df4Service df4Service;
    private final Df4ServiceSecond df4ServiceSecond;

    public RestGraphController(Df4Service df4Service, Df4ServiceSecond df4ServiceSecond) {
        this.df4Service = df4Service;
        this.df4ServiceSecond = df4ServiceSecond;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<GraphEntityDto> browse() {
        Df4ToGraphEntityConverter converter = new Df4ToGraphEntityConverter();
            List<GraphEntityDto> graphEntityDtos = new ArrayList<>();

         graphEntityDtos.addAll(converter.convertAll(df4Service.findByAdjsystemName("ТРМ1а_2")));
         graphEntityDtos.forEach(item-> System.out.println(item.getMil()));
        return graphEntityDtos;
    }
}
