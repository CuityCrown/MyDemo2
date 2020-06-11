package com.demo.bean;

import java.lang.instrument.Instrumentation;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2020/6/11 14:54
 */
public class Agent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("测试");
        System.out.println(agentArgs);
        System.out.println(instrumentation);
    }

    public static void main(String[] args) {
        System.out.println("主程序执行");
    }

}
