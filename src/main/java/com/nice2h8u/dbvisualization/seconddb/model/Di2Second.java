package com.nice2h8u.dbvisualization.seconddb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "d_i2")
public  class Di2Second {

    @Id
    private Integer num;

    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    private Double val;

    private Short truthlevel;


    @ManyToOne(targetEntity = AdjSystemsSecond.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "parid")
    private AdjSystemsSecond adjsystems;

    @ManyToOne(targetEntity = WritersSecond.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private WritersSecond writers;

}
