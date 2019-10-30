package top.aftery.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.aftery.entity.User;
import top.aftery.service.impl.UserServiceImpl;

import java.util.List;

@Slf4j
@RestController
@SuppressWarnings("all")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @RequestMapping( value = "/querystudent", method = RequestMethod.GET)
    public User queryStudentBySno(Integer sno) {
        return this.service.queryUserById(sno);
    }

    @RequestMapping("/userlist")
    public List<User> queryUserList(){
        return  service.queryUserList();
    }

    @RequestMapping("/add")
    public int add(){
        User user=null;
        int count = 0;
        for (int i=1;i<200;i++){
            user=new User();
            user.setName(RandomUtil.randomString(8));
            user.setPassword(RandomUtil.randomNumbers(12));
             service.add(user);
            count++;
        }

        return  count;

    }

}
