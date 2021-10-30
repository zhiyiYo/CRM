package com.zhiyiyo.crm.workbench.service.impl;

import com.zhiyiyo.crm.vo.PaginationVo;
import com.zhiyiyo.crm.workbench.dao.ActivityDao;
import com.zhiyiyo.crm.workbench.dao.ActivityRemarkDao;
import com.zhiyiyo.crm.workbench.entity.Activity;
import com.zhiyiyo.crm.workbench.entity.ActivityRemark;
import com.zhiyiyo.crm.workbench.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityDao activityDao;

    @Resource
    private ActivityRemarkDao activityRemarkDao;

    @Override
    public boolean addActivity(Activity activity) {
        return activityDao.insert(activity).equals(1);
    }

    @Override
    public boolean updateActivity(Activity activity) {
        return activityDao.update(activity).equals(1);
    }

    @Override
    public boolean deleteActivity(String[] ids) {
        Integer remarkCount = activityRemarkDao.queryRemarkCountByIds(ids);
        Integer deleteRemarkCount = activityRemarkDao.deleteRemarkByActivityIds(ids);
        Integer deleteActivityCount = activityDao.delete(ids);

        return deleteActivityCount.equals(ids.length) && remarkCount.equals(deleteRemarkCount);
    }

    @Override
    public PaginationVo<Activity> getActivitiesByCondition(Map<String, Object> condition) {

        PaginationVo<Activity> vo = new PaginationVo<>();
        vo.setCount(activityDao.queryActivityCountByCondition(condition));
        vo.setDataList(activityDao.queryActivitiesByCondition(condition));

        return vo;
    }

    @Override
    public Activity getActivity(String id) {
        return activityDao.queryActivity(id);
    }

    @Override
    public Activity getActivityById(String id) {
        return activityDao.queryActivityById(id);
    }

    @Override
    public List<ActivityRemark> getRemarksByAId(String id) {
        return activityRemarkDao.queryRemarksByAId(id);
    }

    @Override
    public boolean addRemark(ActivityRemark remark) {
        return activityRemarkDao.insertRemark(remark).equals(1);
    }

    @Override
    public boolean updateRemark(ActivityRemark remark) {
        return activityRemarkDao.updateRemark(remark).equals(1);
    }

    @Override
    public boolean deleteRemark(String id) {
        return activityRemarkDao.deleteRemark(id).equals(1);
    }


}
