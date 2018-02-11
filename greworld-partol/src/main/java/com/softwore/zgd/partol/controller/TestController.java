package com.softwore.zgd.partol.controller;

import com.softwore.zgd.partol.controller.annotations.Anonymous;
import com.softwore.zgd.partol.controller.support.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 风骚的GRE
 * @Descriptions TODO
 * @date 2018/2/4.
 */
@Controller
public class TestController  extends BaseController {
    private final String TOPIC="test-topic";

    @Autowired
    @Qualifier("kafkaProducerChannel")
    private MessageChannel messageChannel;

    @Anonymous
    @RequestMapping(value = "/send",method = RequestMethod.GET)
    @ResponseBody
    public String sendMsg(){
        //注册用户
        //如果注册成功,则发送邮件通知
        messageChannel.send(MessageBuilder.withPayload("test").setHeader(KafkaHeaders.TOPIC,TOPIC).build());
        return "success";
    }

}
