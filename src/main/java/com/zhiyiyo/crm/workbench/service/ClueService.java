package com.zhiyiyo.crm.workbench.service;

import com.zhiyiyo.crm.workbench.exception.ConvertException;
import com.zhiyiyo.crm.workbench.entity.Activity;
import com.zhiyiyo.crm.workbench.entity.Clue;
import com.zhiyiyo.crm.workbench.entity.ClueRemark;
import com.zhiyiyo.crm.workbench.entity.Transaction;

import java.util.List;
import java.util.Map;

public interface ClueService {
    /**
     * 添加一条线索
     *
     * @param clue 线索
     * @return 添加是否成功
     */
    boolean addClue(Clue clue);

    /**
     * 根据条件查询线索
     *
     * @param condition 查询条件
     * @return 符合查询条件的线索列表
     */
    List<Clue> getCluesByCondition(Map<String, Object> condition);

    /**
     * 根据条件查询线索的总数量
     *
     * @param condition 查询条件
     * @return 符合查询条件的线索列表
     */
    Integer getClueCountByCondition(Map<String, Object> condition);

    /**
     * 根据线索的 id 查找线索
     *
     * @param id 线索的 id
     * @return 查找到的线索
     */
    Clue getClueById(String id);

    /**
     * 增加一条线索评论
     *
     * @param remark 评论
     * @return 添加是否成功
     */
    boolean addRemark(ClueRemark remark);

    /**
     * 通过线索的 id 获取评论列表
     *
     * @param id 线索 id
     * @return 评论列表
     */
    List<ClueRemark> getRemarksByCId(String id);

    /**
     * 更新线索评论
     *
     * @param remark 评论
     * @return 更新是否成功
     */
    boolean updateRemark(ClueRemark remark);

    /**
     * 删除一条线索的备注
     *
     * @param id 备注的 id
     * @return 删除是否成功
     */
    boolean deleteRemark(String id);

    /**
     * 获取所有与指定线索 id 绑定的市场活动
     *
     * @param id 线索 id
     * @return 市场活动列表
     */
    List<Activity> getBoundActivities(String id);

    /**
     * 将线索和市场活动解除关联
     *
     * @param ids 行 id 列表
     * @return 解除关联是否成功
     */
    boolean unbindActivities(String[] ids);

    /**
     * 获取还没和线索绑定的市场活动
     * @param map 市场活动名称和线索 id 组成的字典
     * @return 匹配名字的市场活动列表
     */
    List<Activity> getUnboundActivities(Map<String, String> map);

    /**
     * 关联市场活动和线索
     * @param clueId 线索 id
     * @param activityIds 市场活动 id 列表
     * @return 关联是否成功
     */
    boolean bindActivities(String clueId, String[] activityIds);

    /**
     * 更新线索
     * @param clue 线索
     * @return 更新是否成功
     */
    boolean updateClue(Clue clue);

    /**
     * 删除多条线索
     * @param ids 线索 id 列表
     * @return 删除是否成功
     */
    boolean deleteClues(String[] ids);

    /**
     * 转换线索
     * @param clueId 线索 id
     * @param createBy 创建者
     * @param tran 交易
     * @return 转换是否成功
     */
    boolean convert(String clueId, String createBy, Transaction tran) throws ConvertException;

}
