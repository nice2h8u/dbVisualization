package com.nice2h8u.dbvisualization.seconddb.repository;

import com.nice2h8u.dbvisualization.seconddb.model.Df4Second;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Df4RepositorySecond extends CrudRepository <Df4Second, Integer> {
    List<Df4Second> findByAdjsystems_NameContaining(String adjsystemName);
}
