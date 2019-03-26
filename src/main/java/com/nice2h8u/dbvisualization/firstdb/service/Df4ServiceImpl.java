package com.nice2h8u.dbvisualization.firstdb.service;

import com.nice2h8u.dbvisualization.firstdb.model.Df4;
import com.nice2h8u.dbvisualization.firstdb.repository.Df4Repository;
import com.nice2h8u.dbvisualization.firstdb.service.interfaces.Df4Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class Df4ServiceImpl implements Df4Service {


    Df4Repository df4Repository;

    public Df4ServiceImpl(Df4Repository df4Repository) {
        this.df4Repository = df4Repository;
    }


    public List <Df4> findByAdjsystemName(String name){
        List <Df4> result = df4Repository.findByAdjsystems_NameContaining(name);

       result= result.stream().sorted(Comparator.comparing(Df4::getTime)).collect(Collectors.toList());

        return result;
    }


}
