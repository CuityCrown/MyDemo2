package com.demo.bean;

import java.lang.instrument.Instrumentation;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2020/6/11 14:54
 */
public class PinpointMainStrap {

    public static void agentmain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("agentmain开始运行");
        premain(agentArgs, instrumentation);
    }

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("premain开始运行");
    }

}
