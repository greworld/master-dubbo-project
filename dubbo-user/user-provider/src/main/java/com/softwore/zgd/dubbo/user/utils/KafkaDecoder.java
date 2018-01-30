package com.softwore.zgd.dubbo.user.utils;

import kafka.serializer.Decoder;

/**
 * @author 风骚的GRE
 * @date 2018/1/19.
 */
public class KafkaDecoder implements Decoder<Object>{

    public Object fromBytes(byte[] bytes) {
        return null;
    }
}
