package top.aftery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.aftery.dao.impl.UserDaoImpl;
import top.aftery.entity.User;
import top.aftery.service.UserService;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Override
    public int add(User user) {
        return this.userDao.add(user);
    }

    @Override
    public int update(User user) {
        return this.userDao.update(user);
    }

    @Override
    public int deleteById(Integer id) {
        return this.userDao.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> queryUserList() {
        return this.userDao.queryUserList();
    }

    @Override
    public User queryUserById(Integer id) {
        return this.userDao.queryUserById(id);
    }
}
