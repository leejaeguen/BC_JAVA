package section02;

import section02.exception.MoneyNegativeException;
import section02.exception.NotEnoughMoneyException;
import section02.exception.PriceNegativeException;

public class Ex01 {
    public static void main(String[] args) {

        /* 수업목표. 사용자 정의형 예외 클래스 정의 후 발생한 사용자 예외들을 처리할 수 있다. */
        /* 설명.
         *  catch 블럭은 이어서 여러개를 쓸 수 있다.
         *  (try 블럭 안에서 발생하는 예외 타입의 종류만큼 가능, 각 상황별로 예외 처리를 달리 할 수 있다.)
         *  try 블럭 안에서 예외가 발생하면 이후 try 블럭을 건너뛰고 catch 블럭을 순차적으로 체크하며,
         *  발생한 예외 타입과 일치하는 catch 블럭이 동작함
         *  (자식 타입의 예외 타입을 가진 catch 블럭일수록 위쪽에 작성, 부모타입일수록 아래쪽에 작성
        * */
        ExceptionTest et = new ExceptionTest();

        try {
            et.checkEnoughMoney(1000, 1000);
            et.checkEnoughMoney(-1000, 1000);
            et.checkEnoughMoney(1000, -1000);
        }
        catch (PriceNegativeException e) {
            System.out.println("가격이 음수?");
        } catch (MoneyNegativeException e) {
            System.out.println("돈 없냐?");
        } catch (NotEnoughMoneyException e) {
            System.out.println("더 내라");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
