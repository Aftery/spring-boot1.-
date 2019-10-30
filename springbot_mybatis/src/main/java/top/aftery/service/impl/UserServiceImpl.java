package top.aftery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.aftery.Mapper.UserMapper;
import top.aftery.entity.User;
import top.aftery.service.UserService;

import java.util.List;

@Service
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public int add(User user) {

        return mapper.add(user);
    }

    @Override
    public int update(User user) {
        return mapper.update(user);
    }

    @Override
    public int deleteById(Integer id) {
        return mapper.deleteById(id);
    }

    @Override
    public User queryUserById(Integer id) {
        return mapper.queryUserById(id);
    }

    @Override
    public List<User> queryUserList() {
        return mapper.queryUserList();
    }
}
