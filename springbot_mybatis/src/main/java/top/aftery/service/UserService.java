package top.aftery.service;

import top.aftery.entity.User;

import java.util.List;

public interface UserService {

    int add(User user);

    int update(User user);


    int deleteById(Integer id);

    User queryUserById(Integer id);

    List<User> queryUserList();

}
