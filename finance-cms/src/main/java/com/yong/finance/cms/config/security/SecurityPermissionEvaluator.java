package com.yong.finance.cms.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 * Created by sgy on 17/7/30.
 */
@Configuration
public class SecurityPermissionEvaluator implements PermissionEvaluator {

    protected Logger _logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean hasPermission(Authentication authentication, Object object, Object permissionObj) {
        SecurityPrincipal securityPrincipal = (SecurityPrincipal) authentication.getPrincipal();
        return securityPrincipal.getPermMap().containsKey(String.valueOf(permissionObj).toUpperCase());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
