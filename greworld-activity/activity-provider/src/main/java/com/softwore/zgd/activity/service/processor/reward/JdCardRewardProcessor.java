package com.softwore.zgd.activity.service.processor.reward;

import com.softwore.zgd.activity.service.processor.AbstractRewardProcessor;
import com.softwore.zgd.activity.service.processor.ActivityDrawContext;
import com.softwore.zgd.activity.service.processor.constants.DrawContants;
import org.springframework.stereotype.Service;

/**
 * @author 风骚的GRE
 * @date 2018/2/4.
 */
@Service("jdCardRewardProcessor")
public class JdCardRewardProcessor extends AbstractRewardProcessor{
    protected void processor(ActivityDrawContext activityDrawContext) {
        logger.info("用户:{},获得奖项:{}",activityDrawContext.getActivityTurntableDrawReq().getUid(),activityDrawContext.getActDrawAwardItem().getItemName());
        //发放奖品
        //redisTemplate.opsForList.rpop(); //从队列中弹出奖品
        modifyAwardRecord(activityDrawContext); //保存记录
    }

    protected void afterProcessor(ActivityDrawContext activityDrawContext) {
        //发送短信
        System.out.println("发送短信...");
    }

    protected int getAwardType() {
        return DrawContants.AWARD_TYPE_ENUM.JD_CARD.getValue();
    }
}
