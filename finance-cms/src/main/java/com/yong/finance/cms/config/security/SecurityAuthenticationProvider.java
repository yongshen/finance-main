package com.yong.finance.cms.config.security;

import com.yong.finance.common.utils.CoreUtil;
import com.yong.finance.common.utils.PasswordUtil;
import com.yong.finance.constants.Constants;
import com.yong.finance.cms.config.utils.ApplicationContextUtil;
import com.yong.finance.persistence.dao.generate.UserEntityMapper;
import com.yong.finance.persistence.entity.UserEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UserEntityMapper userEntityMapper = ApplicationContextUtil.getBean(UserEntityMapper.class);
        Example example = new Example(UserEntity.class);
        example.createCriteria().andEqualTo("account", authentication.getName());
        UserEntity userEntity = CoreUtil.firstOne(userEntityMapper.selectByExample(example));
        if(userEntity == null){
        	throw new BadCredentialsException("用户不存在");
        }
        if (!PasswordUtil.validatePassword((String) authentication.getCredentials(), userEntity.getPassword())){
            throw new BadCredentialsException("账号密码错误");
        }
        if(userEntity.getState()== Constants.USER_STATE_FORBIDDEN){
        	 throw new BadCredentialsException("您的账号已被禁用	请联系管理员!");
        }
        if(userEntity.getState()== Constants.USER_STATE_CANCEL){
            throw new BadCredentialsException("您的账号已被注销	请重新注册!");
        }
        Map<String, String> permMap = new HashMap<>();
        Map<String, String> roleMap = new HashMap<>();
        String permContent = "";
//        if (accountEntity.getIsSpec().intValue() == Constants.True){
//            //  独立权限
//            permContent = accountEntity.getPremContent();
//        }else {
//            //  角色权限
//            RoleRepository roleRepository = ApplicationContextUtil.getBean(RoleRepository.class);
//            RoleEntity roleEntity = roleRepository.selectByPrimaryKey(accountEntity.getRoleId());
//            permContent = roleEntity.getPremContent();
//            roleMap.put(roleEntity.getId().toString(), roleEntity.getId().toString());
//        }

//        PermRepository permRepository = ApplicationContextUtil.getBean(PermRepository.class);
//        List<Integer> permIdList = CoreUtil.toIntegerList(StringUtils.splitByWholeSeparatorPreserveAllTokens(permContent, ","));
//        BaseExample permExample = new BaseExample(PermEntity.class);
//        if(accountEntity.getRoleId().equals(Constants.True)){
//        	permExample.createCriteria().andEqualTo("isDelete", Constants.False).andEqualTo("isPublish",Constants.True);
//        }else{
//        	permExample.createCriteria().andIn("id", permIdList).andEqualTo("isDelete", Constants.False).andEqualTo("isPublish",Constants.True);
//        }
//        List<PermEntity> permEntityList = permRepository.selectByExample(permExample);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        if (CollectionUtils.isNotEmpty(permEntityList)){
//            for (PermEntity permEntity : permEntityList){
//                grantedAuthorityList.add(new SimpleGrantedAuthority(permEntity.getId().toString()));
//                if (StringUtils.isNotEmpty(permEntity.getCode()))
//                    permMap.put(permEntity.getCode().toUpperCase(), permEntity.getCode());
//            }
//        }
        SecurityPrincipal securityPrincipal = new SecurityPrincipal(userEntity, permMap);
        securityPrincipal.setRoleMap(roleMap);
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                securityPrincipal, authentication.getCredentials(), grantedAuthorityList);
        return result;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
