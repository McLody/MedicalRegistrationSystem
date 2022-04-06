package com.mclody.mrs.msm.receiver;

import com.mclody.mrs.msm.service.MsmService;
import com.mclody.mrs.rabbit.service.config.MqConfig;
import com.mclody.mrs.vo.msm.MsmVo;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmsReceiver {
    @Autowired
    private MsmService msmService;
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MqConfig.QUEUE_MSM_ITEM, durable = "true"),
            exchange = @Exchange(value = MqConfig.EXCHANGE_DIRECT_MSM),
            key = {MqConfig.ROUTING_MSM_ITEM}
    ))
    public void send(MsmVo msmVo, Message message, Channel channel) {
        msmService.send(msmVo);
    }
}

