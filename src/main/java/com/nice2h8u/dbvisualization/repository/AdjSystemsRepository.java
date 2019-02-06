package com.nice2h8u.dbvisualization.repository;

import com.nice2h8u.dbvisualization.model.AdjSystems;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdjSystemsRepository extends CrudRepository <AdjSystems, Integer> {

    Optional<AdjSystems> findById(Integer integer);
}
