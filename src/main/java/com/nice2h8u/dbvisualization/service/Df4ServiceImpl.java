package com.nice2h8u.dbvisualization.service;

import com.nice2h8u.dbvisualization.model.Df4;
import com.nice2h8u.dbvisualization.repository.Df4Repository;
import com.nice2h8u.dbvisualization.service.interfaces.Df4Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class Df4ServiceImpl implements Df4Service {


    Df4Repository df4Repository;

    public Df4ServiceImpl(Df4Repository df4Repository) {
        this.df4Repository = df4Repository;
    }

    public Df4 findById(Integer id) {

        Optional<Df4> df4Optional = df4Repository.findById(id);
        if (!df4Optional.isPresent()){
            log.error("No df4 with such id " + id);
            return new Df4();
        }
        return df4Optional.get();
    }
}
