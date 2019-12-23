package com.ryml.Controller;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2019/12/23 17:07
 */
public class MyTestController {

    public static Integer lock1 = 1;

    public static Integer lock2 = 2;

    public static Integer test(){
        synchronized (lock1){
            System.out.println("我执行了test LOCK1");
            synchronized (lock2){
                System.out.println("我执行了test lock2");
            }
        }
        return 1;
    }

    public static Integer test2(){
        synchronized (lock2){
            System.out.println("我执行了test2 LOCK2");
            synchronized (lock1){
                System.out.println("我执行了test2 lock1");
            }
        }
        return 2;
    }

    public static void main(String[] args) {
        new Thread(() -> test()).start();
        new Thread(() -> test2()).start();
    }
}
