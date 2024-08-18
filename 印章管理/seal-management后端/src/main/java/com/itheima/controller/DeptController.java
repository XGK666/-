package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 申请管理Controller
 */
@Slf4j
@RequestMapping("/search")
@RestController
public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;
    /*查询申请数据
    *
    *
    * */
    /*@GetMapping*/
    @PostMapping("/getAll")
    public Result list(){
        log.info("查询全部申请数据");
        //调用service查询数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);

    }

    /*删除申请
    *
    *
    * */
    /*@DeleteMapping("/{id}")*/
    @PostMapping("delById/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除申请}",id);
        deptService.delete(id);
        return Result.success();
    }

    /*
    *
    * 新增部门
    * */
    /*@PostMapping*/
    @PostMapping("addApp")
    public Result add(@RequestBody Dept dept){
        log.info("新增部门{}",dept);
        //调用service新增部门
        deptService.add(dept);
        return Result.success();
    }

    /*
    * 数据回显
    * */
    /*@GetMapping("/{id}")*/
    @PostMapping("{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询信息，id：{}",id);
        Dept dept =  deptService.getById(id);
        return Result.success(dept);
    }
}
