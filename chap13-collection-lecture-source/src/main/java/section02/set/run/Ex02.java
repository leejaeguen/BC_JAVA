package section02.set.run;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex02 {
    public static void main(String[] args) {

        /* 수업목표. LinkedHashSet에 대해 이해하고 활용할 수 있다. */
        Set<String> lset = new LinkedHashSet<>();
        lset.add("ramen");
        lset.add("pork");
        lset.add("kimchi");
        lset.add("firedEgg");
        lset.add("soup");
        lset.add("soup");
        System.out.println("lset: " + lset);

        /* 설명. 저장한 순서를 기억하는 LinkedHashSet 확인 */
        Iterator<String> iter = lset.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
