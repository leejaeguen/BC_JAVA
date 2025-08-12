package section06;

public class StaticTest {
    private int nonStaticCount;
    private static int staticCount;

    // 기본 생성자
    public StaticTest() {
    }

    public static int getstaticCount() {
        return staticCount;
    }

    public static int increaseStaticCount() {
        return staticCount++;
    }


    public int increaseNonstaticCount() {
        return nonStaticCount;
    }

    public int getNonstaticCount() {
        return nonStaticCount;
    }
}
