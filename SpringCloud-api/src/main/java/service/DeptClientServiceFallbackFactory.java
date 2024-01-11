package service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import pojo.Dept;

import java.util.List;

// 服务主动降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    //实现一个类
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(int id) {
                return new Dept().setId(id).setName("").setDb_source("没有数据");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
