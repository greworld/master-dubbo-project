package com.softwore.zgd.dubbo.order;

import com.softwore.zgd.dubbo.order.dto.DoOrderResponse;
import com.softwore.zgd.dubbo.order.dto.DoOrderRequest;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
public interface OrderService {
    /*
     * 下单操作
     */
    public DoOrderResponse doOrder(DoOrderRequest request);
}
