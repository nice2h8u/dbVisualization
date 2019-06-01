package com.nice2h8u.dbvisualization.controller;

import com.nice2h8u.dbvisualization.converters.Df4ToGraphEntityConverter;
import com.nice2h8u.dbvisualization.converters.GraphEntityDot;
import com.nice2h8u.dbvisualization.converters.MessageToClient;
import com.nice2h8u.dbvisualization.converters.OneGraphDto;
import com.nice2h8u.dbvisualization.firstdb.service.interfaces.Df4Service;
import com.nice2h8u.dbvisualization.seconddb.service.Df4ServiceSecond;
import com.nice2h8u.dbvisualization.statistic.StatisticSearcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rrgraphs/")
public class RestGraphController {
    private final Df4Service df4Service;
    private final Df4ServiceSecond df4ServiceSecond;
    @Value("classpath:userProfile.txt")
    private Resource res;

    public RestGraphController(Df4Service df4Service, Df4ServiceSecond df4ServiceSecond) {
        this.df4Service = df4Service;
        this.df4ServiceSecond = df4ServiceSecond;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<MessageToClient> browse() throws IOException {


        String[] nameOfGraph = {"ТРМ1а_2", "ТРМ2а_2", "ТРМ3а_2", "ТРМ4а_2", "ТРМ1б_2", "ТРМ2б_2", "ТРМ1в_2", "ТРМ2в_2"
                , "ТРМ1г_2", "ТРМ2г_2", "ТРМ1д_2", "ТРМ2д_2", "ТРМ3б_2", "ТРМ3в_2", "ТРМ3г_2", "ТРМ3д_2",
                "ДВБа", "ДВБб", "ДВБв", "ДВБг", "ДВБд", "ДБАа", "ДБАб", "ДБАв", "ДБАг", "ДБАд", "ДБОа", "ДБОб", "ДБОв", "ДБОг", "ДБОд"
                , "ДБОи", "ДБГа", "ДБГб", "ДБГв", "ДБГг", "ДБГд", "ДБГи", "ДБПа", "ДБПб", "ДБПв", "ДБПг", "ДБПд"};


        return generateMessageForClient();

    }

    private List<MessageToClient> generateMessageForClient() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(res.getURI()), StandardCharsets.UTF_8);
        List<List<OneGraphDto>> listOfGraphEntities;

        List<String> nameOfGraphs = new ArrayList<>();

        String nameOfMessage = null;
        List<MessageToClient> listOfMessages = new ArrayList<>();

        if (lines.size() > 0) {
            for (String line : lines)
                if (line.charAt(line.length() - 1) == ':') {
                    if (nameOfMessage != null) {

                        listOfGraphEntities = new ArrayList<>();

                        for (String name : nameOfGraphs)
                            listOfGraphEntities.add(addByName(name));

                        nameOfGraphs = new ArrayList<>();

                        listOfMessages.add(MessageToClient.builder().nameOfMode(nameOfMessage)
                                .listOfParameters(listOfGraphEntities).build());


                    }
                    nameOfMessage = line;
                } else {
                    nameOfGraphs.add(line);
                }
            listOfGraphEntities = new ArrayList<>();

            for (String name : nameOfGraphs)
                listOfGraphEntities.add(addByName(name));



            listOfMessages.add(MessageToClient.builder().nameOfMode(nameOfMessage)
                    .listOfParameters(listOfGraphEntities).build());
        }
        return listOfMessages;
    }

    private List<OneGraphDto> addByName(String name) {

        Df4ToGraphEntityConverter converter = new Df4ToGraphEntityConverter();
        StatisticSearcher searcher = new StatisticSearcher();

        List<OneGraphDto> oneGraphDtos = new ArrayList<>();


        List<GraphEntityDot> firstListOfDots = converter.convertAll(df4Service.findByAdjsystemName(name));
        List<GraphEntityDot> secondListOfDots = converter.convertAllSecond(df4ServiceSecond.findByAdjsystemName(name));


        searcher.zoomTheGraphs(firstListOfDots, secondListOfDots);

        oneGraphDtos.add(OneGraphDto.builder()
                .graph(firstListOfDots)
                .name(name)
                .dispersion(searcher.findDispersion(firstListOfDots))
                .matWaiting(searcher.findMatWaiting(firstListOfDots))
                .max(searcher.findMax(firstListOfDots))
                .min(searcher.findMin(firstListOfDots))
                .build()
        );

        oneGraphDtos.add(OneGraphDto.builder()
                .graph(secondListOfDots)
                .name(name)
                .dispersion(searcher.findDispersion(secondListOfDots))
                .matWaiting(searcher.findMatWaiting(secondListOfDots))
                .max(searcher.findMax(secondListOfDots))
                .min(searcher.findMin(secondListOfDots))
                .build()
        );


        return oneGraphDtos;
    }
}
