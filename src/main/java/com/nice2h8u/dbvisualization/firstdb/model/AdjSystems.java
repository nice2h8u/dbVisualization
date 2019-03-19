package com.nice2h8u.dbvisualization.firstdb.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

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
    private Short prizn;
    private Float min_ok;
    private Float max_ok;

    @OneToMany(mappedBy = "adjsystems")
    private Set<DTr> d_trs = new HashSet<>();

    @OneToMany(mappedBy = "adjsystems")
    private Set<DS> d_s = new HashSet<>();

    @OneToMany(mappedBy = "adjsystems")
    private Set<Di4> d_i4s = new HashSet<>();

    @OneToMany(mappedBy = "adjsystems")
    private Set<Di2> d_i2s = new HashSet<>();

    @OneToMany(mappedBy = "adjsystems")
    private Set<Df8> d_f8s = new HashSet<>();

    @OneToMany(mappedBy = "adjsystems")
    private Set<Df4> d_f4s = new HashSet<>();
}
