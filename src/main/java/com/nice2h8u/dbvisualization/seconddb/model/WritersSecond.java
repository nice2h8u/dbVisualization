package com.nice2h8u.dbvisualization.seconddb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "writers")
public class WritersSecond {

    @Id
    private Short id;

    private String name;

    @OneToMany(mappedBy = "writers")
    private Set<DTrSecond> d_trs = new HashSet<>();

    @OneToMany(mappedBy = "writers")
    private Set<DSSecond> d_s = new HashSet<>();

    @OneToMany(mappedBy = "writers")
    private Set<Di4Second> d_i4s = new HashSet<>();

    @OneToMany(mappedBy = "writers")
    private Set<Di2Second> d_i2s = new HashSet<>();

    @OneToMany(mappedBy = "writers")
    private Set<Df8Second> d_f8s = new HashSet<>();

    @OneToMany(mappedBy = "writers")
    private Set<Df4Second> d_f4s = new HashSet<>();

}
