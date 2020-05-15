package boot.support;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jinjunzhu
 * @date 2020/5/14
 */
public class LocalThreadPool {

    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 20L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(Integer.MAX_VALUE));
    public static void run(Runnable runnable){
        executor.submit(runnable);
    }
}
