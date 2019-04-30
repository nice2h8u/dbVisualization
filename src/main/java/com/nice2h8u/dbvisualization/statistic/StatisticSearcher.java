package com.nice2h8u.dbvisualization.statistic;

import com.nice2h8u.dbvisualization.converters.GraphEntityDot;
import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StatisticSearcher {


    public float findMax(List<GraphEntityDot> listOfDots) {
        double val= listOfDots.stream()
                .max(Comparator.comparing(GraphEntityDot::getVal))
                .get().getVal();
        return Math.round(val * 100.0) / 100.0f;
    }

    public float findMin(List<GraphEntityDot> listOfDots) {
        double val =
                listOfDots.stream().
                        min(Comparator.comparing(GraphEntityDot::getVal))
                        .get().getVal();

        return  Math.round(val* 100.0) / 100.0f;

    }


    public float findMatWaiting(List<GraphEntityDot> listOfDots) {
        float t = 0;
        for (GraphEntityDot temp : listOfDots)
            t += temp.getVal();

        return Math.round((t /  listOfDots.size()) * 100.0) / 100.0f;
    }

    public float findDispersion(List<GraphEntityDot> listOfDots) {
        List<GraphEntityDot> tempDots = new ArrayList<>();

        for (GraphEntityDot tempDot: listOfDots)
            tempDots.add(new GraphEntityDot(tempDot));

        float secondValue = findMatWaiting(tempDots);
        tempDots.forEach(dot -> dot.setVal(Math.pow(dot.getVal(), 2)));

        float firstValue = findMatWaiting(tempDots);

        tempDots = null;
        return Math.round((firstValue - secondValue) * 100.0f) / 100.0f;

    }
}
