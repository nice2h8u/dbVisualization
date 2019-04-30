package com.nice2h8u.dbvisualization.converters;


import com.nice2h8u.dbvisualization.firstdb.model.Df4;
import com.nice2h8u.dbvisualization.seconddb.model.Df4Second;

import java.util.ArrayList;
import java.util.List;


public class Df4ToGraphEntityConverter {


    public Df4ToGraphEntityConverter() {
    }

    public List<GraphEntityDot> convertAll(List<Df4> converted) {
        ArrayList<GraphEntityDot> newEntityes = new ArrayList<>();
        if (converted.size() != 0) {
            long firstValueTime = converted.get(0).getTime().getTime();

            for (int i =0 ;i<converted.size();i++)
                if (firstValueTime>converted.get(i).getTime().getTime())
                    firstValueTime=converted.get(i).getTime().getTime();


            for (int i = 0; i < converted.size(); i++) {
                if (converted.get(i).getTruthlevel() == 1)
                    newEntityes.add(
                            GraphEntityDot.builder()
                                    .val(converted.get(i).getVal())
                                    .mil((converted.get(i).getTime().getTime() - firstValueTime) / 1000f)
                                    .build()

                    );
            }

        }
        return newEntityes;

    }

    public List<GraphEntityDot> convertAllSecond(List<Df4Second> converted) {
        ArrayList<GraphEntityDot> newEntityes = new ArrayList<>();
        if (converted.size() != 0) {
            long firstValueTime = converted.get(0).getTime().getTime();

            for (int i =0 ;i<converted.size();i++)
                if (firstValueTime>converted.get(i).getTime().getTime())
                    firstValueTime=converted.get(i).getTime().getTime();


            for (int i = 0; i < converted.size(); i++) {
                if (converted.get(i).getTruthlevel() == 1)
                    newEntityes.add(
                            GraphEntityDot.builder()
                                    .val(converted.get(i).getVal())
                                    .mil((converted.get(i).getTime().getTime() - firstValueTime) / 1000f)
                                    .build()

                    );
            }


        }
        return newEntityes;
    }


}
