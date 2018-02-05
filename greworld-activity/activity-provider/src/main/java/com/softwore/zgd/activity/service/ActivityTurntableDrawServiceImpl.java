package com.softwore.zgd.activity.service;

import com.softwore.zgd.activity.common.ResultResp;
import com.softwore.zgd.activity.dal.persistence.ActDrawAwardItemMapper;
import com.softwore.zgd.activity.dal.persistence.ActDrawAwardMapper;
import com.softwore.zgd.activity.draw.ActivityTurntableDrawService;
import com.softwore.zgd.activity.draw.bean.ActivityTurntableDrawReq;
import com.softwore.zgd.activity.draw.bean.AwardDrawRecordBean;
import com.softwore.zgd.activity.service.processor.ActivityTurntableDrawProxy;
import com.softwore.zgd.dubbo.user.IUserQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
@Service("activityTurntableDrawService")
public class ActivityTurntableDrawServiceImpl implements ActivityTurntableDrawService{
    private static final Logger logger = LoggerFactory.getLogger(ActivityTurntableDrawServiceImpl.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    ActDrawAwardItemMapper actDrawAwardItemMapper;

    @Autowired
    ActDrawAwardMapper actDrawAwardMapper;

    @Autowired
    ActivityTurntableDrawProxy activityTurntableDrawProxy;

    @Autowired
    IUserQueryService userQueryService;

    @Override
    public ResultResp<AwardDrawRecordBean> doDraw(ActivityTurntableDrawReq activityTurntableDrawReq) {
        return null;
    }

    @Override
    public Integer queryRemainDrawCount(ActivityTurntableDrawReq activityTurntableDrawReq) {
        return null;
    }
}
