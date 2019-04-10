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
    public List<List<List<GraphEntityDto>>> browse() {

        List<List<List<GraphEntityDto>>> listOfGrapthEntityes = new ArrayList<>();


        listOfGrapthEntityes.add(addByName("ТРМ1а_2"));
        listOfGrapthEntityes.add(addByName("ТРМ2а_2"));
        listOfGrapthEntityes.add(addByName("ТРМ3а_2"));
        listOfGrapthEntityes.add(addByName("ТРМ4а_2"));
        listOfGrapthEntityes.add(addByName("ТРМ1б_2"));
        listOfGrapthEntityes.add(addByName("ТРМ2б_2"));
        listOfGrapthEntityes.add(addByName("ТРМ1в_2"));
        listOfGrapthEntityes.add(addByName("ТРМ2в_2"));
        listOfGrapthEntityes.add(addByName("ТРМ1г_2"));
        listOfGrapthEntityes.add(addByName("ТРМ2г_2"));
        listOfGrapthEntityes.add(addByName("ТРМ1д_2"));
        listOfGrapthEntityes.add(addByName("ТРМ2д_2"));
        listOfGrapthEntityes.add(addByName("ТРМ3б_2"));
        listOfGrapthEntityes.add(addByName("ТРМ3в_2"));
        listOfGrapthEntityes.add(addByName("ТРМ3г_2"));
        listOfGrapthEntityes.add(addByName("ТРМ3д_2"));

        return listOfGrapthEntityes;

    }

    public List<List<GraphEntityDto>> addByName(String name) {

        Df4ToGraphEntityConverter converter = new Df4ToGraphEntityConverter();
        List<List<GraphEntityDto>> graphEntityDtos = new ArrayList<>();

        List<GraphEntityDto> entityDto = new ArrayList<>(converter.convertAll(df4Service.findByAdjsystemName(name)));
        graphEntityDtos.add(entityDto);

        entityDto = new ArrayList<>(converter.convertAllSecond(df4ServiceSecond.findByAdjsystemName(name)));
        graphEntityDtos.add(entityDto);

        return graphEntityDtos;
    }
}
