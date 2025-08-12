package parameter;

import java.util.Arrays;

public class ParameterTest {
    public void testPrimitiveTypeParameter(int num) {
        num += 1;
        System.out.println("메소드 안 num" + num);
    }

    public void testPrimitiveArrayTypeParameter(int[] iArr) {
        iArr[0] = 10;
        System.out.println("메소드 안 iArr" + Arrays.toString(iArr));
    }

    public void testClassTypeParameter(Rectangle r) {
        r.calRound();
        r.calArea();
    }

    public void testVariableLengArrayParameter(String... str) {
        System.out.println("넘어온 인자 출력: " + Arrays.toString(str));
    }
}
