package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 部门实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id; //ID
    private String appPerson; //人名称
    private String stampName;
    private String fileName;
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime useTime; //修改时间
}
