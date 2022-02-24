package com.tts.api;

import com.tts.api.workplat.utils.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TtsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(TtsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TtsApplication.class);
        ConfigurableApplicationContext context = application.run(args);
        SpringContextUtil.setApplicationContext(context);
    }



}
