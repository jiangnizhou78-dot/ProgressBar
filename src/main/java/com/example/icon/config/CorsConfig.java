package com.example.icon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();

        // 1. 明确指定允许的域名，绝对不能用*！
        configuration.setAllowedOrigins(Arrays.asList(
                "http://localhost:8080", // 本地开发环境
                "https://progressbar-five.vercel.app" // 你的Vercel前端正式域名
        ));

        // 2. 允许所有常用请求方法
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // 3. 允许所有请求头
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // 4. 允许携带凭证
        configuration.setAllowCredentials(true);

        // 5. 预检请求缓存1小时，减少重复请求
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }
}
