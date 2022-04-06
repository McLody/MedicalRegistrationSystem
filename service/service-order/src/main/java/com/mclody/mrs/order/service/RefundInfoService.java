package com.mclody.mrs.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mclody.mrs.model.order.PaymentInfo;
import com.mclody.mrs.model.order.RefundInfo;

public interface RefundInfoService extends IService<RefundInfo> {
    /**
     * 保存退款记录
     * @param paymentInfo
     */
    RefundInfo saveRefundInfo(PaymentInfo paymentInfo);
}

