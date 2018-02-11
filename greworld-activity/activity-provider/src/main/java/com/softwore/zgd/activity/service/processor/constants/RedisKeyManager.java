package com.softwore.zgd.activity.service.processor.constants;

import com.softwore.zgd.activity.dal.entitys.ActDrawAward;
import com.softwore.zgd.activity.draw.bean.ActivityTurntableDrawReq;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public class RedisKeyManager {
    /**
     * 正在抽奖的key
     * @param activityTurntableDrawReq
     * @return
     */
    public static String getDrawingRedisKey(ActivityTurntableDrawReq activityTurntableDrawReq) {
        return DrawContants.DRAWING_PREFIX+String.valueOf(activityTurntableDrawReq.getUid());
    }

    public static String getAwardRedisKey(ActDrawAward actDrawAward){
        return DrawContants.DRAW_AWARD+actDrawAward.getAwardType()+":"+actDrawAward.getId();
    }

}
