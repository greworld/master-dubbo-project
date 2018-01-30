package com.softwore.zgd.activity.service.processor;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public interface RewardProcessor<T> {
    /**
     * 领奖
     * @param activityDrawContext
     */
    T doReword(T activityDrawContext);

}
