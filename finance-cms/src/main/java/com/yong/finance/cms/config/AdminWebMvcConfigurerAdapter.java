package com.yong.finance.cms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by sgy on 17/7/30.
 */
@Configuration
public class AdminWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    protected Logger _logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
    }

}
