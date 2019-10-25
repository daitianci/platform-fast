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
 * 3、ShiroConfig 中 连接器链要配置 OAuth2Filter 拦截器
 *    拦截器链增加oauth过滤,拦截所有请求，判断请求里是否有token，没有的话直接返回401，并且不继续处理，登录失败则返回错误信息，拦截到请求里有token信息，再进入登录验证
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
