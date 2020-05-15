package boot.oom;


/**
 * @author jinjunzhu
 * @date 2020/5/14
 */
public class CreateNativeThreads {
    private static int a = 0;

    public static void test() {

        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                    }
                }
            }).start();
        }
    }
}
