package com.ryml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2019/12/5 23:16
 */
@SpringBootApplication
@EnableScheduling
public class MyDemo2Applicaiton {

    public static void main(String[] args) {
        SpringApplication.run(MyDemo2Applicaiton.class,args);
    }

}
