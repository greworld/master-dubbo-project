package com.softwore.zgd.dubbo.user.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author 风骚的GRE
 * @Description 注册队列消息监听器
 * @date 2018/1/30.
 */
@Component
public class RegisterQueueMessageListener implements MessageListener {
    Logger logger= LoggerFactory.getLogger(RegisterQueueMessageListener.class);

    public void onMessage(Message message) {
        TextMessage message1=(TextMessage) message;
        try {
            logger.info(message1.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
