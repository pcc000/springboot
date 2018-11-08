package com.blackfish.springboot.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/10/31 17:48
 * @Description:
 */
public class User implements UserDetails {

    private String userName;

    private String passWord;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //授予READER权限
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;//不加锁
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;//不过期
    }

    @Override
    public boolean isEnabled() {
        return false;//不禁用
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
