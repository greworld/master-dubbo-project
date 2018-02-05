package com.softwore.zgd.dubbo.order.service;

import com.softwore.zgd.dubbo.order.OrderService;
import com.softwore.zgd.dubbo.order.dal.persistence.OrderMapper;
import com.softwore.zgd.dubbo.order.dto.DoOrderRequest;
import com.softwore.zgd.dubbo.order.dto.DoOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * @author 风骚的GRE
 * @date 2018/1/18.
 */
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
   /* @Autowired
    private JtaTransactionManager springTransactionManager;*/
    /*@Autowired
    private OrderMapper orderMapper;*/
    public DoOrderResponse doOrder(DoOrderRequest request) {
        DoOrderResponse response=new DoOrderResponse();
        response.setCode("000000");
        return response;
    }
}
