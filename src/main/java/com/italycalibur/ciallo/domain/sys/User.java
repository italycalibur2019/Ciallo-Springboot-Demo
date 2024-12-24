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
@Table(name = "td_user", schema = "sys")
public class User extends BaseEntity {

    /**
     * 用户名
     */
    @Column(name = "username", length = 50)
    private String username;

    /**
     * 密码
     */
    @Column(name = "password", length = 200)
    private String password;

    /**
     * 昵称
     */
    @Column(name = "nickname", length = 50)
    private String nickname;

    /**
     * 头像
     */
    @Column(name = "avatar", length = 1000)
    private String avatar;

}