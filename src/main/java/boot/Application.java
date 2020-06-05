package boot;

import org.apache.ibatis.executor.*;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

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
