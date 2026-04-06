package com.fzy.shop.third.party;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration; // 导入这个类
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class ShopThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopThirdPartyApplication.class, args);
    }

}
