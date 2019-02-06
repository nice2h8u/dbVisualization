package com.nice2h8u.dbvisualization.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "d_i4")
public  class Di4 {

    @Id
    private Integer num;

    @Temporal(TemporalType.DATE)
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
