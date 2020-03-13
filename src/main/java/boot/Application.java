package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author jinjunzhu
 * @date 2020/1/9
 */
@SpringBootApplication(scanBasePackages = {"boot"})
public class Application {

    public static void main(String[] args){
        ConfigurableApplicationContext application = SpringApplication.run(Application.class);
        System.out.println(application.getBean("firstTransactionManager"));
        System.out.println(application.getBean("secondTransactionManager"));
    }
}
