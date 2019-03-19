package com.nice2h8u.dbvisualization.seconddb.model;


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
public class AdjSystemsSecond {

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
    private Set<DTrSecond> d_trs = new HashSet<>();

    @OneToMany(mappedBy = "adjsystems")
    private Set<DSSecond> d_s = new HashSet<>();

    @OneToMany(mappedBy = "adjsystems")
    private Set<Di4Second> d_i4s = new HashSet<>();

    @OneToMany(mappedBy = "adjsystems")
    private Set<Di2Second> d_i2s = new HashSet<>();

    @OneToMany(mappedBy = "adjsystems")
    private Set<Df8Second> d_f8s = new HashSet<>();

    @OneToMany(mappedBy = "adjsystems")
    private Set<Df4Second> d_f4s = new HashSet<>();
}
