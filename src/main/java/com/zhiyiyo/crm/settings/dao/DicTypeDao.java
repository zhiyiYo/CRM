package com.zhiyiyo.crm.settings.dao;


import java.util.List;

public interface DicTypeDao {
    /**
     * 获取所有的字典类型
     * @return 字典类型列表
     */
    List<String> queryTypeCodes();
}
