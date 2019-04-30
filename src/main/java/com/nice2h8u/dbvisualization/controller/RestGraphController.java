package com.nice2h8u.dbvisualization.controller;

import com.nice2h8u.dbvisualization.converters.Df4ToGraphEntityConverter;
import com.nice2h8u.dbvisualization.converters.GraphEntityDot;
import com.nice2h8u.dbvisualization.converters.OneGraphDto;
import com.nice2h8u.dbvisualization.firstdb.service.interfaces.Df4Service;
import com.nice2h8u.dbvisualization.seconddb.service.Df4ServiceSecond;
import com.nice2h8u.dbvisualization.statistic.StatisticSearcher;
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
    public List<List<OneGraphDto>> browse() {

        List<List<OneGraphDto>> listOfGraphEntityes = new ArrayList<>();

        String[] nameOfGraph = {"ТРМ1а_2", "ТРМ2а_2", "ТРМ3а_2", "ТРМ4а_2", "ТРМ1б_2", "ТРМ2б_2", "ТРМ1в_2", "ТРМ2в_2"
                , "ТРМ1г_2", "ТРМ2г_2", "ТРМ1д_2", "ТРМ2д_2", "ТРМ3б_2", "ТРМ3в_2", "ТРМ3г_2", "ТРМ3д_2"};


        for (String name : nameOfGraph)
            listOfGraphEntityes.add(addByName(name));


        return listOfGraphEntityes;

    }

    public List<OneGraphDto> addByName(String name) {

        Df4ToGraphEntityConverter converter = new Df4ToGraphEntityConverter();
        StatisticSearcher searcher = new StatisticSearcher();

        List<OneGraphDto> oneGraphDtos = new ArrayList<>();


        List<GraphEntityDot> firstListOfDots = converter.convertAll(df4Service.findByAdjsystemName(name));
        List<GraphEntityDot> secondListOfDots = converter.convertAllSecond(df4ServiceSecond.findByAdjsystemName(name));







        oneGraphDtos.add(OneGraphDto.builder()
                .graph(firstListOfDots)
                .dispersion(searcher.findDispersion(firstListOfDots))
                .matWaiting(searcher.findMatWaiting(firstListOfDots))
                .max(searcher.findMax(firstListOfDots))
                .min(searcher.findMin(firstListOfDots))
                .build()
        );

        oneGraphDtos.add(OneGraphDto.builder()
                .graph(secondListOfDots)
                .dispersion(searcher.findDispersion(secondListOfDots))
                .matWaiting(searcher.findMatWaiting(secondListOfDots))
                .max(searcher.findMax(secondListOfDots))
                .min(searcher.findMin(secondListOfDots))
                .build()
        );


        return oneGraphDtos;
    }
}
