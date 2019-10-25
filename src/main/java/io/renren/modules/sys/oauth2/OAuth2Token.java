/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.modules.sys.oauth2;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 * 重写AuthenticationToken 使得 Principal 变成token
 * 1、OAuth2Realm 中 supports 判断token是否为自定义token
 * 2、OAuth2Realm 中 doGetAuthenticationInfo 中 根据传进来的uuid token获取当前登录用户
 * @author Mark sunlightcs@gmail.com
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
