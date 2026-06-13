package com.example.icon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    // 预检请求缓存时间：1天
    private static final long MAX_AGE = 24 * 60 * 60;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 1. 只允许你的 Vercel 前端域名跨域
        corsConfiguration.addAllowedOrigin("https://progress-bar-five-ivory.vercel.app");
        // 2. 允许携带凭证（Cookie/Header）
        corsConfiguration.setAllowCredentials(true);
        // 3. 允许所有请求头
        corsConfiguration.addAllowedHeader("*");
        // 4. 允许所有请求方法（含 OPTIONS 预检请求）
        corsConfiguration.addAllowedMethod("*");
        // 5. 预检请求缓存时间
        corsConfiguration.setMaxAge(MAX_AGE);

        // 对所有接口生效
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}