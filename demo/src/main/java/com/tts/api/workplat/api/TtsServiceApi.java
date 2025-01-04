package com.tts.api.workplat.api;


import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson2.JSONObject;
import com.tts.api.workplat.utils.TtsUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/tts")
@CrossOrigin
public class TtsServiceApi {
    public TtsServiceApi() {
    }

    @PostMapping("/invoke")
    public void invoke(@RequestBody JSONObject jsonParam, HttpServletRequest request) {
        String content = jsonParam.getString("content");
        int count = jsonParam.getInteger("count");
//        String speed = request.getParameter("speed");
//        Long sleep = Long.parseLong(request.getParameter("sleep"));
        try {
            for(int i = 0; i < count - 1; ++i) {
                content = content +"," + content;
            }
            content = this.setContent(content);
            TtsUtils.broadcast(content);
//            TtsUtils.xunfei(this.setContent(content), speed, sleep);
        } catch (Exception var10) {
            try {
                content = this.setContent(content);
                for(int i = 0; i < count; ++i) {
                    TtsUtils.broadcast(content);
                    Thread.sleep(1000L);
                }
            } catch (Exception var9) {
                var9.printStackTrace();
            }
        }

    }

    private String setContent(String content) {
        String result = "";

        for(int i = 0; i < content.length(); ++i) {
            if (content.charAt(i) < 'z' && content.charAt(i) > 'a' || content.charAt(i) < 'Z' && content.charAt(i) > 'A') {
                result = result + content.charAt(i) + " ";
            } else {
                result = result + content.charAt(i);
            }
        }

        return result;
    }
}