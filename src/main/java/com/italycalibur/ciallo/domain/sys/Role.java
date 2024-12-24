package com.italycalibur.ciallo.domain.sys;

import com.italycalibur.ciallo.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "td_role", schema = "sys")
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