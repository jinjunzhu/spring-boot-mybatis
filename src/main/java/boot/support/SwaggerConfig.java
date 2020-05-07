package boot.support;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Profile(value = {"dev"})
//@ConditionalOnProperty(prefix="swagger", value={"enable"}, havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //需要生成api接口的目录，一般是存放controller的目录
                .apis(RequestHandlerSelectors.basePackage("boot.web"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 定义ApiInfo生成函数
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("SpringBoot使用Swagger2维护api文档")
                //联系人信息
                .contact(new Contact("jinjunzhu", "https://blog.csdn.net/zjj2006", "zjj2006forever@163.com"))
                .version("1.0")
                .description("API 描述")
                .build();
    }
}
