package com.wangyao.company.delivery.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wy
 * @date 2019/9/24 0024
 * @description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${image.path}")
    private String imageDiskPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + imageDiskPath);
    }
}
