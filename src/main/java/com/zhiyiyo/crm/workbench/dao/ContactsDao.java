package com.zhiyiyo.crm.workbench.dao;

import com.zhiyiyo.crm.workbench.entity.Contacts;
import com.zhiyiyo.crm.workbench.entity.ContactsRemark;

import java.util.List;
import java.util.Map;

public interface ContactsDao {
    List<Contacts> queryContactsByCondition(Map<String, Object> condition);

    Integer queryContactsCountByCondition(Map<String, Object> condition);

    /**
     * 插入一个联系人
     * @param contacts 联系人
     * @return 受影响的行数
     */
    Integer insert(Contacts contacts);

    /**
     * 通过联系人 id 获取联系人信息，其中 <code>customerId</code> 是客户名字而非 UUID
     * @param id 联系人 id
     * @return 联系人
     */
    Contacts queryContactsById(String id);

    /**
     * 通过联系人 id 获取联系人信息，其中 <code>customerId</code> 是 UUID
     * @param id 联系人 id
     * @return 联系人
     */
    Contacts queryContacts(String id);

    /**
     * 通过客户 id 获取联系人信息
     * @param customerId 客户 id
     * @return 联系人
     */
    List<Contacts> queryContactsByCustomerId(String customerId);

    /**
     * 通过联系人的名字模糊查询所有匹配联系人
     * @param name 联系人名字
     * @return 联系人列表
     */
    List<Contacts> queryContactsByName(String name);

    Integer update(Contacts contacts);

    Integer deleteByIds(String[] ids);

    Integer queryCountByCustomerIds(String[] ids);

    Integer deleteByCustomerIds(String[] ids);
}
