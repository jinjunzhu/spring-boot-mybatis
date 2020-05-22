package boot.lombok;


import lombok.NonNull;

public class NonNullExample {

    private String name;

    public NonNullExample(@NonNull String name) {
        this.name = name;
    }

    public static void main(String[] args){
        NonNullExample nonNullExample = new NonNullExample(null);
    }
}
