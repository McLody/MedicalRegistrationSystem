package com.mclody.mrs.hosp.receiver;

import com.mclody.mrs.hosp.service.ScheduleService;
import com.mclody.mrs.model.hosp.Schedule;
import com.mclody.mrs.rabbit.service.RabbitService;
import com.mclody.mrs.rabbit.service.config.MqConfig;
import com.mclody.mrs.vo.msm.MsmVo;
import com.mclody.mrs.vo.order.OrderMqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

@Component
public class HospitalReceiver {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private RabbitService rabbitService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MqConfig.QUEUE_ORDER, durable = "true"),
            exchange = @Exchange(value = MqConfig.EXCHANGE_DIRECT_ORDER),
            key = {MqConfig.ROUTING_ORDER}
    ))
    public void receiver(OrderMqVo orderMqVo, Message message, Channel channel) throws IOException {
        if(null != orderMqVo.getAvailableNumber()) {
            //下单成功更新预约数
            Schedule schedule = scheduleService.getById(orderMqVo.getScheduleId());
            schedule.setReservedNumber(orderMqVo.getReservedNumber());
            schedule.setAvailableNumber(orderMqVo.getAvailableNumber());
            scheduleService.update(schedule);
        } else {
            //取消预约更新预约数
            Schedule schedule = scheduleService.getById(orderMqVo.getScheduleId());
            int availableNumber = schedule.getAvailableNumber().intValue() + 1;
            schedule.setAvailableNumber(availableNumber);
            scheduleService.update(schedule);
        }
        //发送短信
        MsmVo msmVo = orderMqVo.getMsmVo();
        if(null != msmVo) {
            rabbitService.sendMessage(MqConfig.EXCHANGE_DIRECT_MSM, MqConfig.ROUTING_MSM_ITEM, msmVo);
        }
    }

}
