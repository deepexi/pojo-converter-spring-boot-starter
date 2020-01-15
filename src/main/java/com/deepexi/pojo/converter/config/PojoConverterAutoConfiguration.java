package com.deepexi.pojo.converter.config;

import com.deepexi.pojo.converter.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(PojoConverterProperties.class)
public class PojoConverterAutoConfiguration {

    @Autowired
    private ConversionService conversionService;

    @PostConstruct
    public void init() {
        ConverterUtils.setConversionService(conversionService);
    }

}
