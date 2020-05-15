package boot.oom;

import boot.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinjunzhu
 * @date 2020/5/14
 */
public class HeapSize {

    public static void test(){
        List<User> list = new ArrayList<>();
        User user = new User();
        while (true){
            list.add(user);
        }
    }


}
