package com.nice2h8u.dbvisualization.firstdb.service.interfaces;

import com.nice2h8u.dbvisualization.firstdb.model.Df4;

import java.util.List;


public interface Df4Service {
    List<Df4> findByAdjsystemName(String name);
}
