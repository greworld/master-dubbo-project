package com.softwore.zgd.activity.service.processor;

import com.softwore.zgd.activity.dal.entitys.ActDrawAward;
import com.softwore.zgd.activity.dal.entitys.ActDrawAwardItem;
import com.softwore.zgd.activity.draw.bean.ActivityTurntableDrawReq;
import com.softwore.zgd.dubbo.user.dto.UserQueryResponse;


/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public class ActivityDrawContext {
    private ActivityTurntableDrawReq activityTurntableDrawReq;

    private ActDrawAwardItem actDrawAwardItem;

    private ActDrawAward actDrawAward;

    private UserQueryResponse currentUser;

    public ActivityTurntableDrawReq getActivityTurntableDrawReq() {
        return activityTurntableDrawReq;
    }

    public void setActivityTurntableDrawReq(ActivityTurntableDrawReq activityTurntableDrawReq) {
        this.activityTurntableDrawReq = activityTurntableDrawReq;
    }

    public ActDrawAwardItem getActDrawAwardItem() {
        return actDrawAwardItem;
    }

    public void setActDrawAwardItem(ActDrawAwardItem actDrawAwardItem) {
        this.actDrawAwardItem = actDrawAwardItem;
    }

    public UserQueryResponse getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserQueryResponse currentUser) {
        this.currentUser = currentUser;
    }

    public ActDrawAward getActDrawAward() {
        return actDrawAward;
    }

    public void setActDrawAward(ActDrawAward actDrawAward) {
        this.actDrawAward = actDrawAward;
    }
}
