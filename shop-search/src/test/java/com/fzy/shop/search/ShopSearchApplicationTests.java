package com.fzy.shop.search;

import com.alibaba.fastjson.JSON;
import com.fzy.shop.search.config.FzyshopElasticSearchConfig;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ShopSearchApplicationTests {

    @Resource
    private RestHighLevelClient client;

    @Test
    void contextLoads() {
        System.out.println(client);
    }

    @Getter
    @Setter
    class User {
        private String userName;
        private String gender;
        private Integer age;
    }
    /**
     * 测试ES数据
     * 更新也可以
     */
    @Test
    public void indexData() throws IOException {

        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1");   //数据的id

        // indexRequest.source("userName","zhangsan","age",18,"gender","男");

        User user = new User();
        user.setUserName("zhangsan");
        user.setAge(18);
        user.setGender("男");

        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON);  //要保存的内容

        //执行操作
        IndexResponse index = client.index(indexRequest, FzyshopElasticSearchConfig.COMMON_OPTIONS);

        //提取有用的响应数据
        System.out.println(index);

    }
}
