package com.italycalibur.ciallo.domain.basedata;

import com.italycalibur.ciallo.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "td_team", schema = "basedata")
public class Team extends BaseEntity {

    @Column(name = "team_name", length = 100)
    private String teamName;

    @Column(name = "engine_supplier", length = 100)
    private String engineSupplier;

    @Column(name = "leader", length = 100)
    private String leader;
}