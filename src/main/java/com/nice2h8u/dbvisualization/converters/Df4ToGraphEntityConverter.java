package com.nice2h8u.dbvisualization.converters;



import com.nice2h8u.dbvisualization.firstdb.model.Df4;
import com.nice2h8u.dbvisualization.seconddb.model.Df4Second;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class Df4ToGraphEntityConverter  {


    public Df4ToGraphEntityConverter() {
    }

    public List<GraphEntityDto> convertAll (List <Df4> converted){
        ArrayList<GraphEntityDto> newEntityes = new ArrayList<>();
        if (converted.size()!=0){
          long firstValueTime =  converted.get(0).getTime().getTime();

            newEntityes.add(GraphEntityDto.builder()
                    .val(converted.get(0).getVal())
                    .mil(0f)
                    .build());
            for (int i=1;i<converted.size();i++){
                if (converted.get(i).getTruthlevel()==1)
                newEntityes.add(
                        GraphEntityDto.builder()
                                .val(converted.get(i).getVal())
                                .mil((converted.get(i).getTime().getTime()-firstValueTime)/1000f)
                                .build()

                );
            }

        }
        return newEntityes;

    }

    public List<GraphEntityDto> convertAllSecond (List <Df4Second> converted){
        ArrayList<GraphEntityDto> newEntityes = new ArrayList<>();
        if (converted.size()!=0){
            long firstValueTime =  converted.get(0).getTime().getTime();

            newEntityes.add(GraphEntityDto.builder()
                    .val(converted.get(0).getVal())
                    .mil(0f)
                    .build());
            for (int i=1;i<converted.size();i++){
                if (converted.get(i).getTruthlevel()==1)
                    newEntityes.add(
                            GraphEntityDto.builder()
                                    .val(converted.get(i).getVal())
                                    .mil((converted.get(i).getTime().getTime()-firstValueTime)/1000f)
                                    .build()

                    );
            }

        }
        return newEntityes;

    }





}
