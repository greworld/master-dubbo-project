package com.sorfwore.zgd.dubbo.order;

import com.sorfwore.zgd.dubbo.order.dto.DoOrderRequest;
import com.sorfwore.zgd.dubbo.order.dto.DoOrderResponse;

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
