package boot.lombok;

import boot.domain.User;
import lombok.*;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConstructorExample<T> {
    private int x, y;
    @NonNull
    private T description;

    @NoArgsConstructor
    public static class NoArgsExample {
        @NonNull private String field;
    }

    public static void main(String[] args){
        ConstructorExample<User> constructorExample1 = new ConstructorExample<User>(1, 1, new User());
        ConstructorExample<User> constructorExample2 = ConstructorExample.of(new User());
    }
}
