package section02;

public class Ex04 {
    public static void main(String[] args) {

        /* 수업목표. 이스케이프(escape) 문자 활용 및 printf를 활용할 수 있다. */
        /* 설명.
         *  이스케이프 문자
         *   문자열 혹은 문자 내에서 사용할 수 있는 특수 기능을 위한 문자
         *   (반대로 기능이 있는 문자를 단순 문자열로 인식 시키는 개념도 있음)
         *
         * 설명.
         *  \n: 개행
         *  \t: 탭
         *  \': 작은 따옴표(문자)
         *  \": 큰 따옴표(문자)
         *  \\: 역 슬래쉬(문자)
        * */

        System.out.println("안녕하세요. \n저는 홍길동입니다.");
        System.out.println("안녕하세요. \t저는 홍길동입니다.");
        System.out.println("안녕하세요. 저는 '홍길동\"입니다.");
        System.out.println('\'');
        System.out.println("역슬래쉬(\\)입니다.");

        /* 설명. 이스케이프 문자 외에도 printf관련 문법도 있으니 참고하자. */
        System.out.printf("원주율은 %.2f입니다. 우린 %d로 하죠", 3.145636, 3);

    }
}
