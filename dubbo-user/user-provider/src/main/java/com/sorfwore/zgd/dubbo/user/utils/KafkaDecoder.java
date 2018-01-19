package com.sorfwore.zgd.dubbo.user.utils;

import kafka.serializer.Decoder;

/**
 * @author 风骚的GRE
 * @date 2018/1/19.
 */
public class KafkaDecoder implements Decoder<Object>{

    @Override
    public Object fromBytes(byte[] bytes) {
        return null;
    }
}
