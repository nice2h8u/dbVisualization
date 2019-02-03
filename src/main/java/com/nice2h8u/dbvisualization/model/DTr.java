package com.nice2h8u.dbvisualization.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "d_tr")
public  class DTr {

    @Temporal(TemporalType.DATE)
    private Date time;

}
