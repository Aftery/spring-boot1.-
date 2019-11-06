package top.aftery;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import top.aftery.bean.Employee;
import top.aftery.mapper.EmployeeMapper;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@SuppressWarnings("all")
public class Springboot08CacheApplicationTests {

    @Autowired
    EmployeeMapper mapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
  public   void contextLoads() {
        Employee employee = mapper.queryEmpById(1);
        log.info("\n{}", employee);
    }

    @Test
    public  void  saveEmp(){
        Employee employee;
        for (int i = 0; i <5 ; i++) {
            employee=new Employee();
            employee.setDId(1);
            employee.setGender(i   );
            employee.setLastName("zhangsan"+i);
            employee.setEmail(i+"****@gmail.com");
            log.debug("\n [{}]",employee);
            mapper.saveEmp(employee);
        }
    }

    @Test
    public void redisTest(){
        stringRedisTemplate.opsForValue().set("msg","hello");

        String msg = stringRedisTemplate.opsForValue().get("msg");
        log.info("{}",msg);

        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
    }

}
