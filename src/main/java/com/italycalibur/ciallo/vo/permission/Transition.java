package com.italycalibur.ciallo.vo.permission;

import lombok.Data;

/**
 * @author dhr
 * @version 1.0
 * @date 2024-12-18 22:36:26
 * @description: TODO
 */
@Data
public class Transition {
    // 当前页面动画，这里是第一种模式，比如 name: "fade" 更具体看后面链接 https://cn.vuejs.org/api/built-in-components.html#transition
    private String name;
    // 当前页面进场动画，这里是第二种模式，比如 enterTransition: "animate__fadeInLeft"
    private String enterTransition;
    // 当前页面离场动画，这里是第二种模式，比如 leaveTransition: "animate__fadeOutRight"
    private String leaveTransition;
}
