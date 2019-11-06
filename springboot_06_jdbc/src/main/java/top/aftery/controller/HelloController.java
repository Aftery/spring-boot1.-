package top.aftery.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@SuppressWarnings("all")
@RestController
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/queryone")
    public Map<String,Object> query(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select  * from  user ");
        maps.forEach(m->log.info("m{}",m));
        return maps.get(0);
    }
}
