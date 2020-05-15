package boot.oom;

/**
 * @author jinjunzhu
 * @date 2020/5/14
 */
public class ArraySizeExceeds {
    public static void test(){
        //int[] arr = new int[Integer.MAX_VALUE - 1];
        for (int i = 3; i >= 0; i--) {
            try {
                int[] arr = new int[Integer.MAX_VALUE-i];
                System.out.format("Successfully initialized an array with %,d elements.\n", Integer.MAX_VALUE-i);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
