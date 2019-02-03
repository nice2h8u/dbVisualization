package com.nice2h8u.dbvisualization.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "adjsystems")
@Entity
public class AdjSystems {

    @Id
    private Integer parid;

    private String name;
    private Integer typeval;
    private String unit;
    private String commentar;
    private Integer bdb_id;
    private Integer prizn;
    private Float min_ok;
    private Float max_ok;


}
