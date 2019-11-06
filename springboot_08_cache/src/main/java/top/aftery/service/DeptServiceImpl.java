package top.aftery.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;
import top.aftery.bean.Department;
import top.aftery.mapper.DeptmentMapper;

@Slf4j
@Service
public class DeptServiceImpl {

    @Autowired
    private DeptmentMapper deptmentMapper;

    @Qualifier("deptCacheManager")
    @Autowired
    private RedisCacheManager deptCacheManager;


//    @Cacheable(value = "dept", cacheManager = "deptCacheManager")
//    public Department getDeptById(Integer id) {
//        return deptmentMapper.getDeptById(id);
//    }

    public Department getDeptById(Integer id) {
        log.info("查询{}",id);
        Cache dept = deptCacheManager.getCache("dept");
        Department deptById = deptmentMapper.getDeptById(id);
        dept.put("dept",deptById);
        return deptById;
    }
}
