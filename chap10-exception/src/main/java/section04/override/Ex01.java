package section04.override;

import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {

        SuperClass superClass = new SuperClass();
        try {
            superClass.method();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
