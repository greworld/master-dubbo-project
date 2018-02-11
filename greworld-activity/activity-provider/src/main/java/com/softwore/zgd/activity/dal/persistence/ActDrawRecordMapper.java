package com.softwore.zgd.activity.dal.persistence;

import com.softwore.zgd.activity.dal.entitys.ActDrawRecord;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public interface ActDrawRecordMapper {
    /**
     * 添加抽奖记录
     * */
    int addActDrawRecord(ActDrawRecord actDrawRecord);

}
