package top.aftery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aftery.entity.BlogProperties;
import top.aftery.entity.configBean;

@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;

    @Autowired
private configBean  configBean;

    @RequestMapping("/")
    public  String index(){
        return blogProperties.getName()+"<---->"+blogProperties.getTitle();
    }


    @RequestMapping("/blog")
    public  String Blog(){
        return  configBean.getName()+"<------>"+configBean.getTitle();
    }
}
