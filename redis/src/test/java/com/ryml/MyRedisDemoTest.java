package com.ryml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

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
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {
        System.out.println(stringRedisTemplate.keys("card*"));
    }


    @Test
    public void testExpire(){
        Boolean expire = stringRedisTemplate.expire("", 2000, TimeUnit.MINUTES);
        System.out.println(expire);
    }


}
