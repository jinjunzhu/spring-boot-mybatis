package boot.oom;


/**
 * @author jinjunzhu
 * @date 2020/5/14
 */
public class CreateNativeThreads {

    public static void test() {
        for (int i = 0; i < 20; i ++){
            System.out.println(Thread.currentThread());
            new Thread(() -> crateSlowThread()).start();
        }
    }

    private static void crateSlowThread(){
        try {
            System.out.println(Thread.currentThread());
            Thread.currentThread().sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test1() {
        while (true){
            new Thread(() -> crateSlowThread()).start();
        }
    }



}
