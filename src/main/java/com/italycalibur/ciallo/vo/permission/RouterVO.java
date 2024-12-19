package com.italycalibur.ciallo.vo.permission;

import lombok.Data;

import java.util.List;

/**
 * @author dhr
 * @version 1.0
 * @date 2024-12-18 21:56:33
 * @description: TODO
 */
@Data
public class RouterVO {
    // 路由路径
    private String path;
    // 路由名称（必须保持唯一）
    private String name;
    // 路由重定向（默认跳转地址）
    private String redirect;
    // 按需加载需要展示的页面
    private String component;
    // 路由元信息，通俗来说就是路由上的额外信息 https://router.vuejs.org/zh/guide/advanced/meta.html#%E8%B7%AF%E7%94%B1%E5%85%83%E4%BF%A1%E6%81%AF
    private Meta meta;
    // 子路由配置项
    private List<RouterVO> children;
}
