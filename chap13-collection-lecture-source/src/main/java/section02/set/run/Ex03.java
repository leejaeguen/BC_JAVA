package section02.set.run;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex03 {
    public static void main(String[] args) {

        /* 수업목표. TreeSet에 대해 이해하고 활용할 수 있다. */
        Set<String> tset = new TreeSet<>();
        tset.add("ramen");
        tset.add("pork");
        tset.add("kimchi");
        tset.add("firedEgg");
        tset.add("soup");
        tset.add("soup");

        Iterator<String> iter = tset.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        
        /* 설명.
         *  로또 번호 발생기(feat.보너스 번호 추출 제외)
         *  (1부터 45까지 중복되지 않고 오름차순 정렬된 6개의 번호 발생하기)
        * */
         Set<Integer> lotto = new TreeSet<>();
         while(lotto.size() < 6){
             lotto.add((int)(Math.random() * 45) + 1);
         }
         System.out.println("lotto = " + lotto);

        /* 설명. 배열을 활용해서 같은 로또 번호 발생기를 만들어 보자.(feat. 정렬 빼고) */
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 45) + 1;
            if(i > 0){
                for(int j = 0; j < i; j++){
                    if(arr[j] == arr[i]){
                        i--;
                        break;
                    }
                }
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
