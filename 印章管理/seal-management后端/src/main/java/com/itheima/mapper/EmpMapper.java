package com.itheima.mapper;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {



    //分页查询 员工插件查询
    //@Select("select * from emp")
    public List<Emp> list(String appPerson, Short gender, LocalDate begin, LocalDate end);


    /*批量删除员工*/
    void delete(List<Integer> ids);

    /*新增员工*/
    /*@Insert("insert into emp1 (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")*/
    @Insert("insert into emp1(appPerson, stampName, fileName, useTime) " +
            "values (#{appPerson},#{stampName},#{fileName},#{useTime})")
    void insert(Emp emp);
}
