package com.italycalibur.ciallo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "td_role", schema = "public")
public class Role extends BaseEntity {

    /**
     * 角色名
     */
    @Column(name = "name", length = 50)
    private String name;

    /**
     * 角色描述
     */
    @Column(name = "description", length = 500)
    private String description;

    /**
     * 角色编号
     */
    @Column(name = "code", length = 50)
    private String code;

}