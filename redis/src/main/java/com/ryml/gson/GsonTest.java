package com.ryml.gson;

import com.alibaba.cs.shaded.com.alibaba.cs.shaded.com.alibaba.configserver.google.gson.Gson;
import com.alibaba.fastjson.JSONObject;
import com.ryml.bean.MyGsonBean;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2020/6/10 16:18
 */
public class GsonTest {

    public static void main(String[] args) {
        MyGsonBean build = MyGsonBean.builder().age(1).description("你猜").id(1).name("测试").build();
        String s = new Gson().toJson(build);
        System.out.println(s);
        String s1 = JSONObject.toJSONString(build);
        System.out.println(s1);
    }

}
