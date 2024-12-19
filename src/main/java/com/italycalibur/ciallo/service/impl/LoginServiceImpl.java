package com.italycalibur.ciallo.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.italycalibur.ciallo.domain.Menu;
import com.italycalibur.ciallo.domain.Role;
import com.italycalibur.ciallo.domain.User;
import com.italycalibur.ciallo.dto.RefreshDTO;
import com.italycalibur.ciallo.dto.RegisterDTO;
import com.italycalibur.ciallo.repository.MenuDao;
import com.italycalibur.ciallo.repository.RoleDao;
import com.italycalibur.ciallo.repository.UserDao;
import com.italycalibur.ciallo.service.LoginService;
import com.italycalibur.ciallo.vo.permission.Meta;
import com.italycalibur.ciallo.vo.RefreshVO;
import com.italycalibur.ciallo.vo.permission.RouterVO;
import com.italycalibur.ciallo.vo.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: TODO 
 * @author dhr
 * @date 2024-12-13 下午5:52:24
 * @version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserDao userDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private MenuDao menuDao;

    @Override
    public UserInfo login(String username, String password) {
        String decodedPwd = DigestUtil.md5Hex(password);
        User user = userDao.findUserByUsernameAndPassword(username, decodedPwd);
        if (user != null) {
            StpUtil.login(user.getId());
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(user.getUsername());
            userInfo.setNickname(user.getNickname());
            userInfo.setAvatar(user.getAvatar());

            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            userInfo.setAccessToken(tokenInfo.getTokenValue());
            Date now = new Date();
            long nowMs = now.getTime();
            nowMs += tokenInfo.getTokenTimeout() * 1000;
            Date expireTime = new Date(nowMs);
            userInfo.setExpires(expireTime);

            List<String> roles = roleDao.findRolesByUserId(user.getId()).stream().map(Role::getCode).toList();
            if (!roles.isEmpty()) {
                userInfo.setRoles(roles);
            }
            return userInfo;
        }
        return null;
    }

    @Override
    public User register(RegisterDTO params) {
        User existed = userDao.findUserByUsername(params.getUsername());
        if (existed == null) {
            User user = new User();
            String decodedPwd = DigestUtil.md5Hex(params.getPassword());
            params.setPassword(decodedPwd);
            BeanUtils.copyProperties(params, user);
            return userDao.save(user);
        }
        return null;
    }

    @Override
    public RefreshVO refreshToken(RefreshDTO params) {
        if (params.getRefreshToken() != null) {
            //写入假参数
            RefreshVO vo = new RefreshVO();
            vo.setAccessToken("eyJhbGciOiJIUzUxMiJ9.newAdmin");
            vo.setRefreshToken("eyJhbGciOiJIUzUxMiJ9.newAdminRefresh");
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try {
                Date parse = format.parse("2030/10/30 23:59:59");
                vo.setExpires(parse);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            return vo;
        }
        return null;
    }

    @Override
    public List<RouterVO> getAsyncRoutes() {
        List<RouterVO> list = generateFakePermission(new ArrayList<>());
        Object loginId = StpUtil.getLoginId();
        Long userId = Long.parseLong(loginId.toString());
        User user = userDao.findById(userId).orElse(null);
        if (user == null) {
            return list;
        }
        List<Long> roleIds = roleDao.findRolesByUserId(user.getId()).stream().map(Role::getId).toList();
        for (Long roleId : roleIds) {
            List<Menu> menus = menuDao.findTopMenusByRole(roleId);
            for (Menu menu : menus) {
                list.add(generateRouter(menu));
            }
        }
        return list;
    }

    private RouterVO generateRouter(Menu menu) {
        RouterVO router = new RouterVO();
        router.setPath(menu.getPath());
        router.setName(menu.getName());
        Meta meta = new Meta();
        meta.setTitle(menu.getTitle());
        meta.setIcon(menu.getIcon());
        router.setMeta(meta);
        List<Menu> childMenus = menuDao.findChildren(menu.getId());
        if (childMenus != null && !childMenus.isEmpty()) {
            List<RouterVO> children = new ArrayList<>();
            for (Menu childMenu : childMenus) {
                children.add(generateRouter(childMenu));
            }
            router.setChildren(children);
        }
        return router;
    }

    private List<RouterVO> generateFakePermission(List<RouterVO> list) {
        //写入假数据
        RouterVO router = new RouterVO();
        router.setPath("/permission");
        Meta meta = new Meta();
        meta.setTitle("权限管理");
        meta.setIcon("ep:lollipop");
        meta.setRank(10);
        router.setMeta(meta);

        List<RouterVO> children = new ArrayList<>();

        RouterVO childA = new RouterVO();
        childA.setPath("/permission/page/index");
        childA.setName("PermissionPage");
        Meta metaA = new Meta();
        metaA.setTitle("页面权限");
        metaA.setRoles(new String[]{"admin", "common"});
        childA.setMeta(metaA);
        children.add(childA);

        RouterVO childB = new RouterVO();
        childB.setPath("/permission/button");
        Meta metaB = new Meta();
        metaB.setTitle("按钮权限");
        metaB.setRoles(new String[]{"admin", "common"});
        childB.setMeta(metaB);

        List<RouterVO> childrenB = new ArrayList<>();

        RouterVO childC = new RouterVO();
        childC.setPath("/permission/button/router");
        childC.setComponent("/permission/button/index");
        childC.setName("PermissionButtonRouter");
        Meta metaC = new Meta();
        metaC.setTitle("路由返回按钮权限");
        metaC.setAuths(new String[]{"permission:btn:add", "permission:btn:edit", "permission:btn:delete"});
        childC.setMeta(metaC);
        childrenB.add(childC);

        RouterVO childD = new RouterVO();
        childD.setPath("/permission/button/login");
        childD.setComponent("permission/button/perms");
        childD.setName("PermissionButtonLogin");
        Meta metaD = new Meta();
        metaD.setTitle("登录接口返回按钮权限");
        childD.setMeta(metaD);
        childrenB.add(childD);

        childB.setChildren(childrenB);

        children.add(childB);

        router.setChildren(children);

        list.add(router);

        return list;
    }
}
