package com.nice2h8u.dbvisualization.seconddb.service;

import com.nice2h8u.dbvisualization.firstdb.model.Df4;
import com.nice2h8u.dbvisualization.seconddb.model.Df4Second;

import java.util.List;


public interface Df4ServiceSecond {
    List<Df4Second> findByAdjsystemName(String name);
}
