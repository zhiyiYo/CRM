package com.zhiyiyo.crm.workbench.service.impl;

import com.zhiyiyo.crm.utils.DateTimeUtil;
import com.zhiyiyo.crm.utils.UUIDUtil;
import com.zhiyiyo.crm.workbench.exception.ConvertException;
import com.zhiyiyo.crm.workbench.dao.*;
import com.zhiyiyo.crm.workbench.entity.*;
import com.zhiyiyo.crm.workbench.service.ClueService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ClueServiceImpl implements ClueService {
    @Resource
    private ClueDao clueDao;

    @Resource
    private ActivityDao activityDao;

    @Resource
    private ClueRemarkDao clueRemarkDao;

    @Resource
    private ClueActivityRelationDao clueActivityRelationDao;

    @Resource
    private ContactsDao contactsDao;

    @Resource
    private ContactsRemarkDao contactsRemarkDao;

    @Resource
    private ContactsActivityRelationDao contactsActivityRelationDao;

    @Resource
    private CustomerDao customerDao;

    @Resource
    private CustomerRemarkDao customerRemarkDao;

    @Resource
    private TransactionDao transactionDao;

    @Resource
    private TransactionHistoryDao transactionHistoryDao;

    @Override
    public boolean addClue(Clue clue) {
        return clueDao.insertClue(clue).equals(1);
    }

    @Override
    public List<Clue> getCluesByCondition(Map<String, Object> condition) {
        return clueDao.queryCluesByCondition(condition);
    }

    @Override
    public Integer getClueCountByCondition(Map<String, Object> condition) {
        return clueDao.queryClueCountByCondition(condition);
    }

    @Override
    public Clue getClueById(String id) {
        return clueDao.queryClueById(id);
    }

    @Override
    public boolean addRemark(ClueRemark remark) {
        return clueRemarkDao.insertRemark(remark).equals(1);
    }

    @Override
    public List<ClueRemark> getRemarksByCId(String id) {
        return clueRemarkDao.queryRemarksByCId(id);
    }

    @Override
    public boolean updateRemark(ClueRemark remark) {
        return clueRemarkDao.updateRemark(remark).equals(1);
    }

    @Override
    public boolean deleteRemark(String id) {
        return clueRemarkDao.deleteRemark(id).equals(1);
    }

    @Override
    public List<Activity> getBoundActivities(String id) {
        return activityDao.queryActivitiesByClueId(id);
    }

    @Override
    public boolean unbindActivities(String[] ids) {
        return clueActivityRelationDao.deleteByIds(ids).equals(ids.length);
    }

    @Override
    public List<Activity> getUnboundActivities(Map<String, String> map) {
        return activityDao.queryUnboundClueActivities(map);
    }

    @Override
    public boolean bindActivities(String clueId, String[] activityIds) {
        List<ClueActivityRelation> relations = new ArrayList<>();

        for (String activityId : activityIds) {
            ClueActivityRelation relation = new ClueActivityRelation();
            relation.setId(UUIDUtil.getUUID());
            relation.setClueId(clueId);
            relation.setActivityId(activityId);
            relations.add(relation);
        }

        return clueActivityRelationDao.insertRelations(relations).equals(relations.size());
    }

    @Override
    public boolean updateClue(Clue clue) {
        return clueDao.updateClue(clue).equals(1);
    }

    @Override
    public boolean deleteClues(String[] ids) {
        Integer remarkCount = clueRemarkDao.queryRemarkCountByCIds(ids);
        Integer deletedRemarkCount = clueRemarkDao.deleteRemarkByCIds(ids);
        Integer relationCount = clueActivityRelationDao.queryCountByClueIds(ids);
        Integer deletedRelationCount = clueActivityRelationDao.deleteByClueIds(ids);
        Integer deletedClueCount = clueDao.deleteClues(ids);

        return remarkCount.equals(deletedRemarkCount)
                && relationCount.equals(deletedRelationCount)
                && deletedClueCount.equals(ids.length);
    }

    @Override
    @Transactional(rollbackFor = ConvertException.class)
    public boolean convert(String clueId, String createBy, Transaction tran) throws ConvertException {
        boolean success = true;

        // ???????????????
        Clue clue = clueDao.queryClue(clueId);

        // ????????????
        String createTime = DateTimeUtil.getSysTime();

        // ??????????????????????????????????????????????????????
        Customer customer = customerDao.queryCustomerByName(clue.getCompany());
        if (customer == null) {
            customer = new Customer();
            BeanUtils.copyProperties(clue, customer, "editBy", "editTime");
            customer.setId(UUIDUtil.getUUID());
            customer.setCreateTime(createTime);
            customer.setCreateBy(createBy);
            customer.setName(clue.getCompany());
            success &= customerDao.insert(customer).equals(1);
        }


        // ?????????????????????
        Contacts contacts = new Contacts();
        BeanUtils.copyProperties(clue, contacts, "editBy", "editTime", "fullname");
        contacts.setId(UUIDUtil.getUUID());
        contacts.setFullname(clue.getFullname());
        contacts.setCreateTime(createTime);
        contacts.setCreateBy(createBy);
        contacts.setCustomerId(customer.getId());
        success &= contactsDao.insert(contacts).equals(1);

        // ?????????????????????
        List<ClueRemark> clueRemarks = clueRemarkDao.queryRemarksByCId(clueId);
        List<ContactsRemark> contactsRemarks = new ArrayList<>();
        List<CustomerRemark> customerRemarks = new ArrayList<>();
        int remarkCount = clueRemarks.size();

        // ??????????????????????????????????????????????????????
        for (ClueRemark clueRemark : clueRemarks) {
            ContactsRemark contactsRemark = new ContactsRemark();
            BeanUtils.copyProperties(clueRemark, contactsRemark);
            contactsRemark.setId(UUIDUtil.getUUID());
            contactsRemark.setContactsId(contacts.getId());
            contactsRemarks.add(contactsRemark);

            CustomerRemark customerRemark = new CustomerRemark();
            BeanUtils.copyProperties(clueRemark, customerRemark);
            customerRemark.setId(UUIDUtil.getUUID());
            customerRemark.setCustomerId(customer.getId());
            customerRemarks.add(customerRemark);
        }

        if (remarkCount > 0) {
            success &= contactsRemarkDao.insertRemarks(contactsRemarks).equals(remarkCount);
            success &= customerRemarkDao.insertRemarks(customerRemarks).equals(remarkCount);
        }

        // ???????????????????????????????????????????????????????????????????????????
        List<ClueActivityRelation> clueActivityRelations = clueActivityRelationDao.queryRelationsByClueId(clueId);
        List<ContactsActivityRelation> contactsActivityRelations = new ArrayList<>();
        int relationCount = clueActivityRelations.size();

        for (ClueActivityRelation clueActivityRelation : clueActivityRelations) {
            ContactsActivityRelation contactsActivityRelation = new ContactsActivityRelation();
            contactsActivityRelation.setId(UUIDUtil.getUUID());
            contactsActivityRelation.setContactsId(contacts.getId());
            contactsActivityRelation.setActivityId(clueActivityRelation.getActivityId());
            contactsActivityRelations.add(contactsActivityRelation);
        }

        if (relationCount > 0) {
            success &= contactsActivityRelationDao.insertRelations(contactsActivityRelations).equals(relationCount);
        }

        // ???????????????????????????
        if (tran != null) {
            BeanUtils.copyProperties(clue, tran, "editTime", "editBy", "id", "name");
            tran.setId(UUIDUtil.getUUID());
            tran.setCreateBy(createBy);
            tran.setCreateTime(createTime);
            tran.setContactsId(contacts.getId());
            tran.setCustomerId(customer.getId());
            success &= transactionDao.insert(tran).equals(1);

            TransactionHistory history = new TransactionHistory();
            BeanUtils.copyProperties(tran, history);
            history.setId(UUIDUtil.getUUID());
            history.setTranId(tran.getId());
            success &= transactionHistoryDao.insert(history).equals(1);
        }

        // ??????????????????????????????????????????
        success &= clueActivityRelationDao.deleteByClueId(clueId).equals(relationCount);

        // ??????????????????
        success &= clueRemarkDao.deleteRemarkByCId(clueId).equals(remarkCount);

        // ????????????
        success &= clueDao.deleteClue(clueId).equals(1);

        if (!success) {
            throw new ConvertException("??????????????????");
        }

        return true;
    }


}



























