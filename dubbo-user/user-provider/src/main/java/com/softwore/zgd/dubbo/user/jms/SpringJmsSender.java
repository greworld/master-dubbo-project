package com.softwore.zgd.dubbo.user.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author 风骚的GRE
 * @Description JMS发送端代码
 * @date 2018/1/30.
 */
public class SpringJmsSender {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext(
                        "classpath:META-INF/spring/service-jms.xml");

        JmsTemplate jmsTemplate=(JmsTemplate) context.getBean("jmsTemplate");

        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage message=session.createTextMessage();
                message.setText("Hello,风骚的GRE");
                return message;
            }
        });
    }
}

