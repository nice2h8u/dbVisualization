package com.nice2h8u.dbvisualization.seconddb.service;

import com.nice2h8u.dbvisualization.firstdb.model.Df4;
import com.nice2h8u.dbvisualization.firstdb.repository.Df4Repository;
import com.nice2h8u.dbvisualization.seconddb.model.Df4Second;
import com.nice2h8u.dbvisualization.seconddb.repository.Df4RepositorySecond;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class Df4ServiceSecondImpl implements Df4ServiceSecond {


    Df4RepositorySecond df4Repository;

    public Df4ServiceSecondImpl(Df4RepositorySecond df4Repository) {
        this.df4Repository = df4Repository;
    }


    public List <Df4Second> findByAdjsystemName(String name){
        List <Df4Second> result = df4Repository.findByAdjsystems_NameContaining(name);

        result= result.stream().sorted(Comparator.comparing(Df4Second::getTime)).collect(Collectors.toList());
        return result;
    }


}
