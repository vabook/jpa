package top.vabook.demo.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.DocumentType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.text.Document;

/**
 * @Author: vabook
 * @Date: 2019/7/10 10:46
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("JPA测试").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("top.vabook.demo.web")).paths(PathSelectors.any()).build();
    }


    // 预览地址:swagger-ui.html
    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder().title("Spring 中使用Swagger2构建文档").termsOfServiceUrl("https://blog.52itstyle.com")
                .contact(new Contact("vabook","https://www.vabook.top","vabook@163.com")).version("1.1").build();
    }
}
