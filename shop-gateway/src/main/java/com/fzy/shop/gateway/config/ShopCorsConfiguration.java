package com.fzy.shop.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

@Configuration
public class ShopCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // 1. 允许所有的请求头
        corsConfiguration.addAllowedHeader("*");
        // 2. 允许所有的请求方法 (GET, POST, OPTIONS, etc.)
        corsConfiguration.addAllowedMethod("*");

        // 3. 核心修改：使用 AllowedOriginPattern 代替 AllowedOrigin
        // 或者指定具体的域名，如 corsConfiguration.addAllowedOrigin("http://localhost:8080");
        corsConfiguration.addAllowedOriginPattern("*");

        // 4. 允许携带 Cookie
        corsConfiguration.setAllowCredentials(true);

        // 5. 核心修改：注册路径改为 "/**" 以递归匹配所有路径
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsWebFilter(source);
    }
}