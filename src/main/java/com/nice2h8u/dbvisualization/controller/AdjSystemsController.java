package com.nice2h8u.dbvisualization.controller;


import com.nice2h8u.dbvisualization.service.interfaces.AdjSystemsService;
import com.nice2h8u.dbvisualization.service.interfaces.Df4Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdjSystemsController {


    private final AdjSystemsService adjSystemsService;
    private final Df4Service df4Service;

    public AdjSystemsController(AdjSystemsService adjSystemsService, Df4Service df4Service) {
        this.adjSystemsService = adjSystemsService;
        this.df4Service = df4Service;
    }

    @GetMapping("")
    public String getSome(){
        System.out.println(df4Service.findById(1208).getTime());
        //System.out.println(adjSystemsService.findById(1).getMax_ok());
        return "index";
    }
}
