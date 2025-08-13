package section06;

import java.time.*;

public class Ex01 {
    public static void main(String[] args) {
        /* 수업 목표. time 패키지에서 제공하는 클래스들의 사용방법을 이해할 수 있다. */
        LocalTime timeNow = LocalTime.now();
        LocalTime timeNow2 = LocalTime.of(14, 33, 20);
        System.out.println("timeNow = " + timeNow);
        System.out.println("timeNow2 = " + timeNow2);

        LocalDate dateNow = LocalDate.now();
        LocalDate dateOf = LocalDate.of(2025, 8, 13);   // month - 1 안해도 됨
        System.out.println("dateNow = " + dateNow);
        System.out.println("dateOf = " + dateOf);

        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime dateTimeOF =
                LocalDateTime.of(2025, 8, 13, 14, 33, 20);
        System.out.println("dateTimeNow = " + dateTimeNow);
        System.out.println("dateTimeOF = " + dateTimeOF);

        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
        ZonedDateTime zonedDateTimeOf =
                ZonedDateTime.of(dateOf, timeNow2, ZoneId.of("Asia/Seoul"));
        System.out.println("zonedDateTimeNow = " + zonedDateTimeNow);
        System.out.println("zonedDateTimeOf = " + zonedDateTimeOf);
    }
}
