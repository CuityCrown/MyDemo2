package com.ryml.controller;

import com.ryml.entity.SocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:
 *
 * @author 刘一博
 * @version V1.0
 * @date 2019/12/5 23:28
 */
@Controller
public class WebSocketController {

    /**
     * websochet消息发送对象
     */
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 跳转到测试页面
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "test";
    }

    /**
     * 测试页面显示后台消息推送次数
     */
    private int count=0;

    /**
     * **@MessageMapping接收浏览器消息路径设置
     * **@SendTo服务端向浏览器推送地址设置
     * @param message
     * @return SocketMessage
     */
    @MessageMapping("/send")
    @SendTo("/topic/send")
    public SocketMessage send(SocketMessage message){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setMessage("浏览器消息") ;
        message.setDate(df.format(new Date()));
        System.out.println(message);
        return message;
    }

    /**
     * **@SendTo 由后台发送到浏览器服务
     * **@Scheduled(cron="0/5 * * * * ?")定时5秒给页面推一次数据
     * @return
     * @throws Exception
     */
    @SendTo("/topic/callback")
    @Scheduled(cron="0/5 * * * * ?")
    public Object callback() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("推送消息了"+df.format(new Date()));
        //向页面这个地址推送消息
        messagingTemplate.convertAndSend("/topic/callback","客户端消息"+count );
        count++;
        return null;
    }

}
