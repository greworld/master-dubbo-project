package com.softwore.zgd.activity.dal.persistence;

import com.softwore.zgd.activity.dal.entitys.ActDrawAwardItem;

import java.util.List;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/30.
 */
public interface ActDrawAwardItemMapper {
    /**
     * 查询所有奖项
     * @return
     */
    List<ActDrawAwardItem> queryAwardItem();

}
