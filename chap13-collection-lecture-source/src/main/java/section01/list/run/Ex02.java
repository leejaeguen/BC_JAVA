package section01.list.run;

import section01.list.comparator.desendingAuthor;
import section01.list.dto.BookDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {

        List<BookDTO> booklist = new ArrayList<>();
        booklist.add(new BookDTO(1, "홍길동전", "허균", 50000));
        booklist.add(new BookDTO(2, "목민심서", "정약용", 30000));
        booklist.add(new BookDTO(3, "동의보감", "허준", 40000));
        booklist.add(new BookDTO(4, "삼국사기", "김부식", 46000));
        booklist.add(new BookDTO(5, "삼국유사", "일연", 58000));

        System.out.println("====== 정렬 전 ======");

        // System.out.println("booklist: " +  booklist);
        for (int i = 0; i < booklist.size(); i++) {
            System.out.println(booklist.get(i));
        }

        /* 설명. Comparable 인터페이스를 구현한 해당 클래스 기준 정렬 외에도 Comparator를 구현한 별도의 정렬 기준도 가능 */
        // Collections.sort(booklist);
        Collections.sort(booklist, new desendingAuthor());

        /* 설명. list 계열도 sort 메소드를 사용할 수 있으며 Comparator를 구현한 인스턴스 여부만 판단하면 된다. */
        booklist.sort(null);
        booklist.sort(new desendingAuthor());

        System.out.println("====== 정렬 후 ======");
        for (int i = 0; i < booklist.size(); i++) {
            System.out.println(booklist.get(i));
        }
    }
}
