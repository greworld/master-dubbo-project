package com.softwore.zgd.activity.dal.persistence;

import com.softwore.zgd.activity.dal.entitys.ActDrawAward;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public interface ActDrawAwardMapper {
    /**
     * 根据id获取奖品
     * @param id
     * @return
     */
    ActDrawAward queryAwardById(Integer id);

}
