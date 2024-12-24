package com.italycalibur.ciallo.domain.basedata;

import com.italycalibur.ciallo.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "td_driver", schema = "basedata")
public class Driver extends BaseEntity {

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "code")
    private Integer code;

    @Column(name = "country", length = 100)
    private String country;

}