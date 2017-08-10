package com.yong.finance.cms.config.freemarker;

import com.yong.finance.cms.config.freemarker.tags.AuthTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by weitong on 17/4/5.
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private AuthTag authTag;

    @PostConstruct
    public void setSharedVariable() {
        configuration.setSharedVariable("wtAuth", authTag);
    }
}
