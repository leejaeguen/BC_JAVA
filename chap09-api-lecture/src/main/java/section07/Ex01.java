package section07;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex01 {
    public static void main(String[] args) {

        /* 수업목표. time 패키지의 클래스들에 포메팅을 적용하여 출력할 수 있다. */
        /* 설명. 자동 인식 가능한 형태의 문자열을 활용하여 Time 패키지의 자료형으로 변환할 시 */
        /* 설명. 1. 자동 인식이 될 경우 */
        String timeNow = "15:10:10";
        String dateNow = "2025-08-13";

        LocalTime localTime = LocalTime.parse(timeNow);
        LocalDate localDate = LocalDate.parse(dateNow);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        System.out.println("LocalTime: " + localTime);
        System.out.println("LocalDate: " + localDate);
        System.out.println("LocalDateTime: " + localDateTime);

        /* 설명. 2. 수동적으로 패턴을 인식시켜 줘야할 경우 */
        String timeNow2 = "15-14-14";
        String dateNow2 = "250205";

        LocalTime localTime2 = LocalTime.parse(timeNow2, DateTimeFormatter.ofPattern("HH-mm-ss"));
        LocalDate localDate2 = LocalDate.parse(dateNow2, DateTimeFormatter.ofPattern("yyMMdd"));

        System.out.println("LocalTime2: " + localTime2);
        System.out.println("LocalDate2: " + localDate2);
        
        /* 설명. time 패키지에서 인식한 날짜 및 시간을 원하는 패턴의 문자열로 변환하기 */
        String timeFormat = localTime2.format(DateTimeFormatter.ofPattern("HH시 mm분"));
        String dateFormat = localDate2.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        System.out.println("timeFormat: " + timeFormat);
        System.out.println("dateFormat: " + dateFormat);
    }
}
