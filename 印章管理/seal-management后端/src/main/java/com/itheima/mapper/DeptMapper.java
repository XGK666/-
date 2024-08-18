package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 申请管理
 */
@Mapper
public interface DeptMapper {

    //根据id查询
    @Select("select * from emp1 where id = #{id}")
    Dept getById(Integer id);

    //查询全部
    @Select("select * from emp1")
    List<Dept> list();
    /*
    *
    * 根据id删除*/
    @Delete("delete from emp1 where id = #{id}")
    void deleteById(Integer id);

    /*
        插入
    * */
    /*@Insert("insert into emp1(name, entrydate, update_time) values (#{name},#{entryDate},#{updateTime})")*/
    @Insert("insert into emp1(appPerson, stampName, fileName, useTime) " +
            "values (#{appPerson},#{stampName},#{fileName},#{useTime})")
    void insert(Dept dept);

    /*
    * */
}