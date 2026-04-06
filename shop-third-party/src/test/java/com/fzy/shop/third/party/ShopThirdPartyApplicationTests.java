package com.fzy.shop.third.party;

import com.aliyun.oss.OSS;
import com.fzy.shop.third.party.component.SmsComponent;
import com.fzy.shop.third.party.util.HttpUtils;
import jakarta.annotation.Resource;
import org.apache.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ShopThirdPartyApplicationTests {
    @Autowired
    private OSS ossClient;

    @Resource
    private SmsComponent smsComponent;

    @Test
    public void sendSmsCode() {
        smsComponent.sendCode("18842313280", "134531");
    }

    @Test
    void testOss() {
        // 如果不报错且打印出对象，说明 Nacos 配置读取并创建 Bean 成功
        System.out.println(ossClient);
    }

    @Test
    void testSms(){
        String host = "https://gyytz.market.alicloudapi.com";
        String path = "/sms/smsSend";
        String method = "POST";
        String appcode = "3d1f87a6b29e4b79a685971d4f6e9cfc";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", "18842313280");
        querys.put("param", "**code**:12345,**minute**:5");

//smsSignId（短信前缀）和templateId（短信模板），可登录国阳云控制台自助申请。参考文档：http://help.guoyangyun.com/Problem/Qm.html

        querys.put("smsSignId", "2e65b1bb3d054466b82f0c9d125465e2");
        querys.put("templateId", "908e94ccf08b4476ba6c876d13f084ad");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void testUpload2() throws FileNotFoundException {
        // 上传文件流。
        InputStream inputStream = new FileInputStream("E:\\study\\尚硅谷\\课件和文档\\基础篇\\资料\\pics\\0d40c24b264aa511.jpg");
        ossClient.putObject("fzyshop", "hahaha.jpg", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
        System.out.println("上传完成");

    }
}
