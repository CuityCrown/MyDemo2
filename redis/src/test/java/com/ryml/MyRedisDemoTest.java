package com.ryml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2019/12/11 17:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyRedisDemoTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test() {
        System.out.println(redisTemplate.keys("card"));
    }


}
