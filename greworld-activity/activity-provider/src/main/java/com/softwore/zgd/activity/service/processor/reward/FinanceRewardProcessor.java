package com.softwore.zgd.activity.service.processor.reward;

import com.softwore.zgd.activity.service.processor.AbstractRewardProcessor;
import com.softwore.zgd.activity.service.processor.ActivityDrawContext;
import com.softwore.zgd.activity.service.processor.constants.DrawContants;
import org.springframework.stereotype.Service;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
@Service("financeRewardProcessor")
public class FinanceRewardProcessor extends AbstractRewardProcessor {
    protected void processor(ActivityDrawContext activityDrawContext) {
        logger.info("用户:{},获得奖项:{}",activityDrawContext.getActivityTurntableDrawReq().getUid(),activityDrawContext.getActDrawAwardItem().getItemName());
        //TODO 发放奖品
        modifyAwardRecord(activityDrawContext); //保存记录
    }

    protected void afterProcessor(ActivityDrawContext activityDrawContext) {
        //发送短信
    }

    protected int getAwardType() {
        return DrawContants.AWARD_TYPE_ENUM.FINANCE.getValue();
    }
}
