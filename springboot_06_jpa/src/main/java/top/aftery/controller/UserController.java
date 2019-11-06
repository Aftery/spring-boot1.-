package top.aftery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aftery.entity.User;
import top.aftery.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/user/{id}")
    public User queryUser(@PathVariable("id") Integer id) {

        return repository.findOne(id);
    }

    @RequestMapping("/save")
    public User saveUser(User user) {
        return repository.save(user);
    }
}
