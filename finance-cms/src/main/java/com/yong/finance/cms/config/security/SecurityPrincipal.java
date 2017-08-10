package com.yong.finance.cms.config.security;

import com.yong.finance.persistence.entity.UserEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/5 0005.
 */
public class SecurityPrincipal {

    private UserEntity userEntity;
    private Map<String, String> permMap;
    private Map<String, String> roleMap;

    public SecurityPrincipal() {
        this.permMap = new HashMap<>();
        this.roleMap = new HashMap<>();
    }

    public SecurityPrincipal(UserEntity userEntity) {
        this.userEntity = userEntity;
        this.permMap = new HashMap<>();
        this.roleMap = new HashMap<>();
    }

    public SecurityPrincipal(UserEntity userEntity, Map<String, String> permMap) {
        this.userEntity = userEntity;
        this.permMap = permMap;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setAccountEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Map<String, String> getPermMap() {
        return permMap;
    }

    public void setPermMap(Map<String, String> permMap) {
        this.permMap = permMap;
    }

    public Map<String, String> getRoleMap() {
        return roleMap;
    }

    public void setRoleMap(Map<String, String> roleMap) {
        this.roleMap = roleMap;
    }

    public boolean hashRole(String role){
        return permMap.containsKey(role.toUpperCase());
    }

    public boolean hashPerm(String perm){
        return permMap.containsKey(perm.toUpperCase());
    }

}
