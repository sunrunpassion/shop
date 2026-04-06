package com.fzy.shop.third.party.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope // 支持 Nacos 动态刷新
public class OssConfig {

    @Value("${alibaba.cloud.access-key}")
    private String accessKey;

    @Value("${alibaba.cloud.secret-key}")
    private String secretKey;

    @Value("${alibaba.cloud.oss.endpoint}")
    private String endpoint;

    @Bean
    public OSS ossClient() {
        // 这样 Spring 容器中就有了 ossClient，你可以随时 @Autowired 注入使用
        return new OSSClientBuilder().build(endpoint, accessKey, secretKey);
    }
}