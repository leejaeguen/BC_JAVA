package section05;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ex02 {
    public static void main(String[] args) {

        /* 수업목표. java.util.Calendar 클래스 사용법에 대해 이해할 수 있다. */
        /* 설명.
         *  java.util.Date 대비 개선점
         *  1. TimeZone과 관련된 기능이 추가됨
         *  2. 윤년 관련 기능이 내부적으로 추가됨
         *  3. 날짜 및 시간을 필드 개념으로 바꿔서 불필요한 메소드 갯수를 줄임
        * */

        java.util.Date today = new java.util.Date();
        java.util.Calendar calendar = java.util.Calendar.getInstance();

        System.out.println("today: " + today);
        System.out.println("calendar: " + calendar);

        int year = 2001;
        int month = 4 - 1;
        int dayOfMonth = 21;
        int hour = 8;
        int minute = 0;
        int second = 0;

        Calendar birthday = new GregorianCalendar(year, month, dayOfMonth, hour, minute, second);

        System.out.println("태어난 해: " + birthday.get(Calendar.YEAR));
        System.out.println("태어난 해: " + birthday.get(1));
        System.out.println("태어난 월: " +  (birthday.get(Calendar.MONTH) + 1));
        System.out.println("태어난 일: "  +  birthday.get(Calendar.DAY_OF_MONTH));
        System.out.println("태어난 요일: " + birthday.get(Calendar.DAY_OF_WEEK));        // 1부터(월요일부터) 7까지
        System.out.println("태어난 시: " + birthday.get(Calendar.HOUR_OF_DAY));         // 24시간 체제
        System.out.println("태어난 시: " + birthday.get(Calendar.HOUR));                // 12시간 체제
        System.out.println("태어난 분: " +  birthday.get(Calendar.MINUTE));
        System.out.println("태어난 초: " +   birthday.get(Calendar.SECOND));
        System.out.println("오전/오후: " + birthday.get(Calendar.AM_PM));               // 0은 오전, 1은 오후
    
        /* 설명.  Calendar -> java.util.Date로 바꿔서 SimpleDateFormat 적용해 보기 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초 E요일");
        String birthdayString = sdf.format(new java.util.Date(birthday.getTimeInMillis()));
        System.out.println("birthdayString = " + birthdayString);
    }
}
