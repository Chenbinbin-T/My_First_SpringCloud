package com.example.springclouddept8004;

import com.example.springclouddept8004.dao.DeptMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pojo.Dept;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringCloudDept8002ApplicationTests {
    @Resource
    DeptMapper deptMapper;

    @Test
    void contextLoads(){
        List<Dept> list = deptMapper.queryAll();
        for (Dept dept : list) {
            System.out.println(dept);
        }
    }

}
