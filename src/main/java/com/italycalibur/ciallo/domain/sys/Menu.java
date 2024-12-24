package com.italycalibur.ciallo.domain.sys;

import com.italycalibur.ciallo.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@Entity
@Table(name = "td_menu", schema = "sys")
public class Menu extends BaseEntity {

    @Column(name = "path", length = 100)
    private String path;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "title", length = 100)
    private String title;

    @ColumnDefault("0")
    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "icon", length = 50)
    private String icon;

    @Column(name = "component", length = 100)
    private String component;

}