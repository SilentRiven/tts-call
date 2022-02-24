package com.tts.api.workplat.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;


public class SpringContextUtil {

    /**
     * Spring应用上下文环境
     */
    private static ConfigurableApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     */
    public static void setApplicationContext(ConfigurableApplicationContext applicationContext)throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ConfigurableApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     *  根据beanId返回Spring中的实例
     * @Date 2019-08-07 17:36
     * @param
     * @return
     **/
    public static Object getBean(String beanId) throws BeansException {
        return applicationContext.getBean(beanId);
    }
}
