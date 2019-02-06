package com.nice2h8u.dbvisualization.service;

import com.nice2h8u.dbvisualization.model.AdjSystems;
import com.nice2h8u.dbvisualization.repository.AdjSystemsRepository;
import com.nice2h8u.dbvisualization.service.interfaces.AdjSystemsService;
import org.springframework.stereotype.Service;

@Service
public class AdjSystemsServiceImpl implements AdjSystemsService {

    private final AdjSystemsRepository adjSystemsRepository;

    public AdjSystemsServiceImpl(AdjSystemsRepository adjSystemsRepository) {
        this.adjSystemsRepository = adjSystemsRepository;
    }

    public AdjSystems findById(Integer id) {

         return adjSystemsRepository.findById(id).orElse(null);
    }
}
