package com.tts.api.workplat.utils;


import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.util.LinkedHashMap;
import java.util.Map;


public class TtsUtils {
    private Map<String, String[]> mVoiceMap = new LinkedHashMap();
    private Boolean flag = false;

    public TtsUtils() {
    }


    public static void broadcast(String content) {
        ActiveXComponent ac = new ActiveXComponent("Sapi.SpVoice");
        Dispatch dispatch = ac.getObject();
        try {
            ac.setProperty("volume", new Variant(100));
            ac.setProperty("Rate", new Variant(-3));
            Dispatch.call(dispatch, "Speak", new Object[]{content});
        } catch (Exception var7) {
            var7.printStackTrace();
        } finally {
            dispatch.safeRelease();
            ac.safeRelease();
        }

    }

    public static String setContent(String content) {
        String result = "";

        for(int i = 0; i < content.length(); ++i) {
            result = result + content.charAt(i) + " ";
        }

        return result;
    }


    private static class DefaultValue {
        public static final String ENG_TYPE = "cloud";
        public static final String VOICE = "xiaoyan";
        public static final String BG_SOUND = "0";
        public static final String SPEED = "40";
        public static final String PITCH = "50";
        public static final String VOLUME = "50";
        public static final String SAVE = "0";

        private DefaultValue() {
        }
    }
}
