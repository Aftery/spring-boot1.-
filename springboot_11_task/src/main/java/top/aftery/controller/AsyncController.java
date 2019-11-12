package top.aftery.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aftery.service.AsyncService;

@RestController
@AllArgsConstructor
public class AsyncController {

    private AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "hello";
    }
}
