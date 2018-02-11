package com.softwore.zgd.activity.service.processor.reward;

import com.softwore.zgd.activity.service.processor.AbstractRewardProcessor;
import com.softwore.zgd.activity.service.processor.ActivityDrawContext;
import com.softwore.zgd.activity.service.processor.constants.DrawContants;
import org.springframework.stereotype.Service;

/**
 * @author 风骚的GRE
 * @date 2018/2/4.
 */
@Service("noneRewardProcessor")
public class NoneRewardProcessor extends AbstractRewardProcessor{
    protected void processor(ActivityDrawContext activityDrawContext) {
        logger.info("用户:{},获得奖项:{}",activityDrawContext.getActivityTurntableDrawReq().getUid(),activityDrawContext.getActDrawAwardItem().getItemName());
        modifyAwardRecord(activityDrawContext); //保存记录
    }

    protected void afterProcessor(ActivityDrawContext activityDrawContext) {

    }

    protected int getAwardType() {
        return DrawContants.AWARD_TYPE_ENUM.NONE.getValue();
    }
}
