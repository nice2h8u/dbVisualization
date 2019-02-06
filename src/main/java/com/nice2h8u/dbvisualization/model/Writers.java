package com.nice2h8u.dbvisualization.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "writers")
public class Writers {

    @Id
    private Short id;

    private String name;

    @OneToMany(mappedBy = "writers")
    private Set<DTr> d_trs = new HashSet<>();

    @OneToMany(mappedBy = "writers")
    private Set<DS> d_s = new HashSet<>();

    @OneToMany(mappedBy = "writers")
    private Set<Di4> d_i4s = new HashSet<>();

    @OneToMany(mappedBy = "writers")
    private Set<Di2> d_i2s = new HashSet<>();

    @OneToMany(mappedBy = "writers")
    private Set<Df8> d_f8s = new HashSet<>();

    @OneToMany(mappedBy = "writers")
    private Set<Df4> d_f4s = new HashSet<>();

}
