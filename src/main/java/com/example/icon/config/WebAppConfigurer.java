package com.example.icon.config;

import com.example.icon.config.intercepter.SysInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
    // 👇 新增这个方法，解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 这里写你前端的 Vercel 域名
                .allowedOrigins("https://progress-bar-five-ivory.vercel.app")
                // 允许所有请求方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 允许所有请求头
                .allowedHeaders("*")
                // 允许携带 Cookie
                .allowCredentials(true)
                // 预检请求缓存时间
                .maxAge(3600);
    }
    @Bean
    public SysInterceptor sysInterceptor(){
        return new SysInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        String[] patterns = new String[]{
                "/image/iconPicture/**",  // 放行所有图片请求
                "/icontype",
                "/icon/getIcons/**"
        };
        registry.addInterceptor(sysInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }
}
