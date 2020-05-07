package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jinjunzhu
 * @date 2020/1/9
 */
@SpringBootApplication(scanBasePackages = {"boot"})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
