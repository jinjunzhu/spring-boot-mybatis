package boot;

public class DeadLock {

    public static void test() {
        Object lockA = new Object();
        Object lockB = new Object();

        new Thread(() ->{
            synchronized (lockA){
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lockB){
                    System.out.println("thread 1");
                }
            }
        }).start();

        new Thread(() ->{
            synchronized (lockB){
                synchronized (lockA){
                    System.out.println("thread 2");
                }
            }
        }).start();
    }
}
