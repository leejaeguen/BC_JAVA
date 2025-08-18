package section03.map;

import section01.list.dto.BookDTO;

import java.util.HashMap;
import java.util.Map;

public class Ex01 {
    public static void main(String[] args) {

        /* 수업목표. Map의 자료구조에 대해 이해하고 HashMap을 이용할 수 있다. */
        Map<Object, Object> hMap = new HashMap<>();
        hMap.put(new String("one"), new java.util.Date());
        hMap.put(12, "red apple");
        hMap.put(33, 123.0);
        
        /* 설명. key로 쓰인 객체는 e,h를 통해 동등함이 판별되면 같은 key로 취급(feat. e,h 반드시 둘 다 오버라이딩 되어야 함 */
        System.out.println("키가 \"one\"인 String으로 value를 추출한다면: " + hMap.get(new String("one")));

        System.out.println("hMap: " + hMap);

        /* 설명. key값은 결국 동등 객체면 같은 key값으로 보고 같은 key를 가진 이후에 들어간 Entry(K + Y)가 이전 것을 덮어씌움 */
        hMap.put(new BookDTO(1, "홍길동전", "허균", 50000), 10);
        hMap.put(new BookDTO(2, "홍길동전", "허균", 50000), 20); // 중복된 키면 덮어씌우니 주의
        System.out.println("hMap: " + hMap);
        System.out.println("20 꺼내보기: " + hMap.get(new BookDTO(2, "홍길동전", "허균", 50000)));
    
        /* 설명. 2. value가 중복되는 경우 */
        hMap.put(44, 123.0);
        System.out.println("value가 중복되는 경우 : " + hMap);
    }
}
