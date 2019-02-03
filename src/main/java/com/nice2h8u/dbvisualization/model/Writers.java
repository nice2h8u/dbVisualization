package com.nice2h8u.dbvisualization.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "writers")
public class Writers {

    @Id
    private Integer id;

    private String name;

}
