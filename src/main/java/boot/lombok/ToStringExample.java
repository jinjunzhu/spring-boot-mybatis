package boot.lombok;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class ToStringExample {

    private static final int STATIC_VAR = 10;
    /**姓名**/
    private String name;
    private Square square = new Square(5, 10);
    private String[] tags;
    @ToString.Include(rank = 1)
    private static String password = "123456";
    @ToString.Exclude
    private int id;

    public String getName() {
        return this.name;
    }

    @ToString(callSuper=true)
    public static class Square {
        private final int width, height;

        public Square(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    public static void main(String[] args){
        ToStringExample toStringExample = new ToStringExample();
        toStringExample.setName("jinjunzhu");
        toStringExample.setTags(new String[]{"123", "234"});
        System.out.println(toStringExample.toString());
    }
}
