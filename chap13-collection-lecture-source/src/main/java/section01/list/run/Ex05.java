package section01.list.run;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ex05 {
    public static void main(String[] args) {
        
        /* 수업목표. Queue에 대해 이해하고 활용할 수 있다. */
        // Queue que = new Queue(); // 인터페이스라 구현하는 하위 타입으로 객체를 생성해서 써야 함
        Queue<String> que = new LinkedList<>();

        que.offer("first");
        que.offer("second");
        que.offer("third");
        que.offer("fourth");
        que.offer("fifth");
        System.out.println("que: " + que);

        System.out.println("peek: " + que.peek());
        System.out.println("que: " + que);

        System.out.println("poll: " + que.poll());
        System.out.println("poll: " + que.poll());
        System.out.println("poll: " + que.poll());
        System.out.println("poll: " + que.poll());
        System.out.println("poll: " + que.poll());
        System.out.println("que: " + que);

        /* 설명. priorityQueue를 활용하면 정렬된 상태를 활용할 수 있다. */
        Queue<Integer> priorityQue =  new PriorityQueue<>();
        priorityQue.offer(1);
        priorityQue.offer(5);
        priorityQue.offer(3);
        priorityQue.offer(4);
        priorityQue.offer(2);
        System.out.println("priorityQue: " + priorityQue);



    }
}
