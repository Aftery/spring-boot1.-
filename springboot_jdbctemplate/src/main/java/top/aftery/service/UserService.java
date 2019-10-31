package top.aftery.service;

import top.aftery.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    int add(User user);

    int update(User user);

    int deleteById(Integer id);

    List<Map<String, Object>> queryUserList();

    User queryUserById(Integer id);
}
