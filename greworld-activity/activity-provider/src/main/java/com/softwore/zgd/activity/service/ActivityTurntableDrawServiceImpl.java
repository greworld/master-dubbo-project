package com.softwore.zgd.activity.service;

import com.softwore.zgd.activity.common.ResultResp;
import com.softwore.zgd.activity.common.ReturnCodeEnum;
import com.softwore.zgd.activity.dal.entitys.ActDrawAward;
import com.softwore.zgd.activity.dal.entitys.ActDrawAwardItem;
import com.softwore.zgd.activity.dal.persistence.ActDrawAwardItemMapper;
import com.softwore.zgd.activity.dal.persistence.ActDrawAwardMapper;
import com.softwore.zgd.activity.draw.ActivityTurntableDrawService;
import com.softwore.zgd.activity.draw.bean.ActivityTurntableDrawReq;
import com.softwore.zgd.activity.draw.bean.AwardDrawRecordBean;
import com.softwore.zgd.activity.service.processor.ActivityDrawContext;
import com.softwore.zgd.activity.service.processor.ActivityTurntableDrawProxy;
import com.softwore.zgd.activity.service.processor.constants.DrawContants;
import com.softwore.zgd.activity.service.processor.constants.RedisKeyManager;
import com.softwore.zgd.activity.service.processor.exception.RewardException;
import com.softwore.zgd.dubbo.user.IUserQueryService;
import com.softwore.zgd.dubbo.user.dto.UserQueryRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @PostConstruct
    public void initDrawData() throws Exception {
        logger.info("开始初始化奖品数据");
        //获得所有奖项：一等奖、二等奖、三等奖..
        List<ActDrawAwardItem> awardItems=this.actDrawAwardItemMapper.queryAwardItem();
        if(awardItems==null||awardItems.isEmpty()){
            throw new Exception("奖品数据未创建，初始化失败");
        }
        redisTemplate.opsForValue().set(DrawContants.DRAW_ITEM,awardItems);
        redisTemplate.expire(DrawContants.DRAW_ITEM,DrawContants.EXPIRE_TIME, TimeUnit.DAYS);
        for(ActDrawAwardItem awardItem:awardItems){//遍历所有奖项获得每个奖项对应的奖品
            ActDrawAward actDrawAward=actDrawAwardMapper.queryAwardById(awardItem.getAwardId());
            redisTemplate.opsForValue().set(RedisKeyManager.getAwardRedisKey(actDrawAward),actDrawAward);
            redisTemplate.expire(RedisKeyManager.getAwardRedisKey(actDrawAward),DrawContants.EXPIRE_TIME,TimeUnit.DAYS);
            //TODO 如果奖品是有数量限制的，比如京东券 ，那么针对这类的奖品需要放到队列中
//            redisTemplate.opsForList().leftPush()
        }
    }

    public ResultResp<AwardDrawRecordBean> doDraw(ActivityTurntableDrawReq activityTurntableDrawReq) {
        ResultResp<AwardDrawRecordBean> recordBeanResultResp = new ResultResp<AwardDrawRecordBean>();
        try{
            checkDrawParams(activityTurntableDrawReq);//检查请求参数

            ActivityDrawContext activityDrawContext=new ActivityDrawContext();
            activityDrawContext.setActivityTurntableDrawReq(activityTurntableDrawReq);
            UserQueryRequest userQueryRequest=new UserQueryRequest();
            userQueryRequest.setUid(activityTurntableDrawReq.getUid());
            activityDrawContext.setCurrentUser(userQueryService.getUserById(userQueryRequest));

            activityTurntableDrawProxy.doDrawForProxy(activityDrawContext);

            AwardDrawRecordBean awardDrawRecordBean=new AwardDrawRecordBean();
            awardDrawRecordBean.setLevel(activityDrawContext.getActDrawAwardItem().getLevel());
            awardDrawRecordBean.setName(activityDrawContext.getCurrentUser().getRealName());
            awardDrawRecordBean.setUid(activityDrawContext.getActivityTurntableDrawReq().getUid());
            recordBeanResultResp.setResult(awardDrawRecordBean);
            //设置返回的信息
            recordBeanResultResp.setReturnCodeEnum(ReturnCodeEnum.SUCCESS);

        }catch (Exception e) {
            logger.error("抽奖失败!", e);
            recordBeanResultResp.setReturnCodeEnum(ReturnCodeEnum.SYSTEM_ERROR);
        } finally {
            logger.info("抽奖请求{},响应{}", activityTurntableDrawReq, recordBeanResultResp);
            //清除正在抽奖标志cache
            cleanRedisCache(activityTurntableDrawReq);
        }
        return recordBeanResultResp;
    }

    public Integer queryRemainDrawCount(ActivityTurntableDrawReq activityTurntableDrawReq) {
        //TODO 后续接入到业务流程以后再编写
        return null;
    }

    private void checkDrawParams(ActivityTurntableDrawReq activityTurntableDrawReq){
        if ((null == activityTurntableDrawReq.getUid())) {
            throw new RewardException("uid不能为空");
        }
        Object value=redisTemplate.opsForValue().get(RedisKeyManager.getDrawingRedisKey(activityTurntableDrawReq));
        if(value!=null&&DrawContants.ISEXIST.EXIST.getValue().equals(value)){
            throw new RewardException("上一次抽奖还未结束");
        }
        //设置正在抽奖
        redisTemplate.opsForValue().set(RedisKeyManager.getDrawingRedisKey(activityTurntableDrawReq),DrawContants.ISEXIST.EXIST.getValue());
        redisTemplate.expire(RedisKeyManager.getDrawingRedisKey(activityTurntableDrawReq),DrawContants.EXPIRE_TIME,TimeUnit.DAYS);
    }

    private void cleanRedisCache(ActivityTurntableDrawReq activityTurntableDrawReq) {
        try {
            redisTemplate.delete(RedisKeyManager.getDrawingRedisKey(activityTurntableDrawReq));
        } catch (Exception e) {
            logger.error("清除key[" +RedisKeyManager.getDrawingRedisKey(activityTurntableDrawReq)+ "]异常", e);
        }
    }

}
