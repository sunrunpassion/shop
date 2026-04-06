package com.fzy.shop.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@EnableCaching
@EnableFeignClients(basePackages = "com.fzy.shop.product.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class ShopProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopProductApplication.class, args);
	}

}
