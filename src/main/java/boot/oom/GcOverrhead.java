package boot.oom;

import java.util.Map;
import java.util.Random;

/**
 * @author jinjunzhu
 * @date 2020/5/14
 */
public class GcOverrhead {
    public static void test(){
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
        }
    }
}
