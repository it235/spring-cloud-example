package com.it235.cloud.example.notifier;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @description:
 * @package: com.it235.cloud.example.notifier
 * @author: jianjun.ren
 * @date: Created in 2020/10/17 0:11
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
@Slf4j
public class DingtalkUtils {

    public static void main(String[] args) {
        pushInfoToDingding("测试消息通知", "b240b227f5add0fsdfdfsdf5aca64450e71e54721bf08d7ee17114");
    }

    public static Boolean pushInfoToDingding(String textMsg, String dingURL) {

        HashMap<String, Object> resultMap = new HashMap<>(8);
        resultMap.put("msgtype", "text");

        HashMap<String, String> textItems = new HashMap<>(8);
        textItems.put("content", textMsg);
        resultMap.put("text", textItems);

        HashMap<String, Object> atItems = new HashMap<>(8);
        atItems.put("atMobiles", null);
        atItems.put("isAtAll", false);
        resultMap.put("at", atItems);



//        StringBuilder textMsgBuilder = new StringBuilder(
//                "{ \"msgtype\":\"markdown\",\"markdown\":{\"title\":\"告警通知\",\"text\":\"");
//        textMsgBuilder.append(textMsg);
//        textMsgBuilder.append("\"},\"at\":{\"atMobiles\":[],\"isAtAll\":false}}");
//        System.out.println(textMsgBuilder);
        dingURL = "https://oapi.dingtalk.com/robot/send?access_token=" + dingURL;
        try {
            HttpClient httpClient = HttpClients.createDefault();
            StringEntity stringEntity = new StringEntity(JSON.toJSONString(resultMap), "utf-8");

            HttpPost httpPost = createConnectivity(dingURL);
            httpPost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(result);
                log.info("执行结果：{}" , result);
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }


    static HttpPost createConnectivity(String restUrl) {
        HttpPost post = new HttpPost(restUrl);
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");
        post.setHeader("X-Stream", "true");
        return post;
    }
}
