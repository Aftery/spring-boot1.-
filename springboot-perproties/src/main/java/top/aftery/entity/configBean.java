package top.aftery.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
@ConfigurationProperties(prefix = "top.aftery")
public class configBean {
    private  String name;

    private  String title;

}
