package top.aftery.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.aftery.entity.User;
import top.aftery.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Map;
@Slf4j
@SuppressWarnings("all")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/queryuser", method = RequestMethod.GET)
    public User queryUserById(int id) {
        return this.userService.queryUserById(id);

    }

    @RequestMapping(value = "/queryuserlist")
    public List<Map<String, Object>> queryUserList() {
        return this.userService.queryUserList();
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public int addUser(String name, String password) {
        log.info("\n{} \n{}",name,password);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return this.userService.add(user);
    }

    @RequestMapping(value = "deleteuser", method = RequestMethod.GET)
    public int deleteUserById(int id) {
        return this.userService.deleteById(id);
    }

}
