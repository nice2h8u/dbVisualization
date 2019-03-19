package com.nice2h8u.dbvisualization.firstdb.repository;

import com.nice2h8u.dbvisualization.firstdb.model.Df4;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface Df4Repository extends CrudRepository <Df4, Integer> {

    List<Df4> findByAdjsystems_NameContaining(String adjsystemName);
}
