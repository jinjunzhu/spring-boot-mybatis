package boot.lombok;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EqualsAndHashCodeExample {
    private transient int transientVar = 10;
    private String name;
    private double score;
    @EqualsAndHashCode.Exclude private Square shape = new Square(5, 10);
    private String[] tags;
    @EqualsAndHashCode.Exclude private int id;

    public String getName() {
        return this.name;
    }

    @EqualsAndHashCode()
    public static class Square {
        private final int width, height;

        public Square(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
