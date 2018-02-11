package com.softwore.zgd.dubbo.order.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public class SpringJmsReceiver {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext(
                        "classpath:META-INF/spring/service-jms.xml");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*JmsTemplate jmsTemplate=(JmsTemplate) context.getBean("jmsTemplate");

        String msg=(String)jmsTemplate.receiveAndConvert();

        System.out.println(msg);*/
    }

}
