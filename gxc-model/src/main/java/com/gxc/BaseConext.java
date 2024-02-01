package com.gxc.grace.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * @author Green写代码
 * @date 2024-01-31 04:16
 */

public class BaseConext {
    public static ThreadLocal<>threadLocal = new ThreadLocal<>();

    public static ThreadLocal getThreadLocal() {
        threadLocal.get();
    }

    public static void setThreadLocal(ThreadLocal<String> threadLocal) {

    }
}
