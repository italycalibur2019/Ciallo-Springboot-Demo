package com.italycalibur.ciallo.vo.permission;

import lombok.Data;

/**
 * @author dhr
 * @version 1.0
 * @date 2024-12-18 22:24:11
 * @description: 前端路由元信息
 */
@Data
public class Meta {
    // 菜单名称（兼容国际化、非国际化，如果用国际化的写法就必须在根目录的locales文件夹下对应添加）
    private String title;
    // 菜单名称右侧的额外图标
    private String extraIcon;
    // 菜单图标
    private String icon;
    // 是否在菜单中显示
    private Boolean showLink;
    // 是否显示父级菜单
    private Boolean showParent;
    // 页面级别权限设置
    private String[] roles;
    // 按钮级别权限设置
    private String[] auths;
    // 是否缓存该路由页面（开启后，会保存该页面的整体状态，刷新后会清空状态）
    private Boolean keepAlive;
    // 需要内嵌的iframe链接地址
    private String frameSrc;
    // 内嵌的iframe页面是否开启首次加载动画
    private Boolean frameLoading;
    // 页面加载动画（两种模式，第二种权重更高，第一种直接采用vue内置的transitions动画，第二种是使用animate.css编写进、离场动画，平台更推荐使用第二种模式，已经内置了animate.css，直接写对应的动画名即可）
    private Transition transition;
    // 当前菜单名称或自定义信息禁止添加到标签页
    private Boolean hiddenTag;
    // 显示在标签页的最大数量，需满足后面的条件：不显示在菜单中的路由并且是通过query或params传参模式打开的页面。在完整版全局搜dynamicLevel即可查看代码演示
    private Integer dynamicLevel;
    // 将某个菜单激活（主要用于通过query或params传参的路由，当它们通过配置showLink: false后不在菜单中显示，就不会有任何菜单高亮，而通过设置activePath指定激活菜单即可获得高亮，activePath为指定激活菜单的path）
    private String activePath;
    // 菜单排序，值越高排的越后（只针对顶级路由）
    private Integer rank;
}
