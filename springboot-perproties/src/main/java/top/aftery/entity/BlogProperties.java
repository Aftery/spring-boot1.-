package top.aftery.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BlogProperties {

    @Value("${top.aftery.name}")
    private  String name;

    @Value("${top.aftery.title}")
    private  String title;

}
