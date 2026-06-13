package com.example.icon.config;

import com.example.icon.config.intercepter.SysInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* web项目配置类*/
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/iconPicture/**").addResourceLocations("file:./iconPicture/");
    }
    @Bean
    public SysInterceptor sysInterceptor(){
        return new SysInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        String[] patterns=new String[]{};
        registry.addInterceptor(sysInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }

}
