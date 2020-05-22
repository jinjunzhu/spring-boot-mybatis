package boot.lombok;

import lombok.Builder;
import lombok.Singular;

import java.util.Set;

@Builder
public class BuilderExample {
    @Builder.Default
    private long created = System.currentTimeMillis();
    private String name;
    private int age;
    @Singular
    private Set<String> occupations;

    public static void main(String args){
        BuilderExample.builder().created(System.currentTimeMillis()).age(30).name("jinjunzhu");
    }
}
