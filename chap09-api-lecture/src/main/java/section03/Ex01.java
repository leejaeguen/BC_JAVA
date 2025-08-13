package section03;

public class Ex01 {
    public static void main(String[] args) {

        /* 수업목표. String과 StringBuilder(또는 StringBuffer)와의 차이점에 대해 이해하고 사용할 수 있다. */
        /* 설명.
         *  String은 불변객체(immutable object), StringBuilder(또는 StringBuffer)는 가변객체(mutable object)
        * */
        String testStr = "java";
        // String sb = "Kotlin";
        StringBuilder testSb = new StringBuilder("Kotlin");

        for (int i = 0; i < 20; i++) {
            testStr += i;
            testSb.append(i);

            System.out.println("String의 경우: " + System.identityHashCode(testStr));
            System.out.println("StringBuilder의 경우: " +  System.identityHashCode(testSb));
        }

        System.out.println("testStr: " + testStr);
        System.out.println("testSb = " + testSb);

        /* 설명. StringBuilder가 가변인 이유 */
        StringBuilder testSb2 = new StringBuilder();
        System.out.println("StringBuilder의 초기 용량: " + testSb2.capacity());

        StringBuilder testSb3 = new StringBuilder("java");
        System.out.println("StringBuilder의 초기 용량(\"java\"): " + testSb3.capacity());

        for (int i = 0; i < 30; i++) {
            System.out.println(testSb3);
            testSb3.append(i);
            System.out.println(testSb3.capacity());
        }
    }
}
