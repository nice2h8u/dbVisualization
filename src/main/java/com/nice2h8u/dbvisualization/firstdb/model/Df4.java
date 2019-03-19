package com.nice2h8u.dbvisualization.firstdb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "d_f4")
public  class Df4 {

    @Id
    private Integer num;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    private Double val;

    private Short truthlevel;


    @ManyToOne(targetEntity = AdjSystems.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "parid")
    private AdjSystems adjsystems;

    @ManyToOne(targetEntity = Writers.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Writers writers;

}
