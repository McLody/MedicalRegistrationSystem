package com.mclody.mrs.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mclody.mrs.model.order.OrderInfo;
import com.mclody.mrs.vo.order.OrderCountQueryVo;
import com.mclody.mrs.vo.order.OrderQueryVo;

import java.util.Map;

public interface OrderService extends IService<OrderInfo> {
    //保存订单
    Long saveOrder(String scheduleId, Long patientId);


    IPage<OrderInfo> selectPage(Page<OrderInfo> pageParam, OrderQueryVo orderQueryVo);

    OrderInfo getOrder(String orderId);

    Map<String,Object> show(Long id);

    /**
     * 取消订单
     * @param orderId
     */
    Boolean cancelOrder(Long orderId);

    void patientTips();

    Map<String, Object> getCountMap(OrderCountQueryVo orderCountQueryVo);

}
