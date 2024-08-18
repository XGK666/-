package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {

    //查询全部数据
    List<Dept> list();

    /*删除*/
    void delete(Integer id);

    /*新增*/
    void add(Dept dept);
    /*根据id查询*/
    Dept getById(Integer id);
}
