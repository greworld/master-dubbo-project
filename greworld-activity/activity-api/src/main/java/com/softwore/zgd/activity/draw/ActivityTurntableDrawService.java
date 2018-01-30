package com.softwore.zgd.activity.draw;

import com.softwore.zgd.activity.common.ResultResp;
import com.softwore.zgd.activity.draw.bean.ActivityTurntableDrawReq;
import com.softwore.zgd.activity.draw.bean.AwardDrawRecordBean;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public interface ActivityTurntableDrawService {
    /**
     * 转盘抽奖
     *
     * @param activityTurntableDrawReq
     * @return
     */
    ResultResp<AwardDrawRecordBean> doDraw(ActivityTurntableDrawReq activityTurntableDrawReq);


    /**
     * 查询用户剩余抽奖次数
     * @param activityTurntableDrawReq
     * @return
     */
    Integer queryRemainDrawCount(ActivityTurntableDrawReq activityTurntableDrawReq);

}
