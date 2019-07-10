package top.vabook.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class Application {
    private static final Logger logger = Logger.getLogger("");
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //访问地址localhost:8080/swagger-ui.html
        logger.info("项目启动");
    }
}
