package com.mclody.mrs.task.scheduled;

import com.mclody.mrs.rabbit.service.RabbitService;
import com.mclody.mrs.rabbit.service.config.MqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@EnableScheduling
public class ScheduledTask {

    @Resource
    private RabbitService rabbitService;

    /**
     * 每天8点执行 提醒就诊
     */
    //@Scheduled(cron = "0 0 1 * * ?")
    @Scheduled(cron = "0/30 * * * * ?")
    public void task1() {
        rabbitService.sendMessage(MqConfig.EXCHANGE_DIRECT_TASK, MqConfig.ROUTING_TASK_8, "");
    }
}
