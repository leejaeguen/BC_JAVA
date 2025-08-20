package section04;

import section04.aggregate.BloodType;
import section04.aggregate.Member;
import section04.service.MemberService;

import java.util.Scanner;

public class Ex01 {

    private static final MemberService ms = new MemberService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 모든 회원 정보 보기");
            System.out.println("2. 회원 찾기");
            System.out.println("3. 회원 가입");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 탈퇴");
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴를 선택해 주세요");

            int input = sc.nextInt();

            /* 설명.
             *  조회: find
             *  추가: regist
             *  수정: modify
             *  삭제: remove
            * */
            switch (input){
                case 1: ms.findAllMembers(); break;
                case 2: ms.findMemberBy(chooseMemN0()); break;
                case 3: ms.registMember(signup()); break;
                case 4:
                    /* 설명. 회원 조회(조회가 되었다고 가정) */
                    Member selectMember = ms.findMemberForMod(chooseMemN0()); // 기존 회원 사본 객체 반환 받기

                    /* 설명. 수정을 위해 입력된 내용을 바탕으로 회원 수정 */
                    ms.modifyMember(reform(selectMember));      // 수정된 내용을 담은 기존 회원은 사본 객체 넘기기
                    break;
                case 5:
                    /* 설명. soft delete 할 예정 */
                    ms.removeMember(chooseMemN0());
                    break;

                case 9:
                    System.out.println("프로그램을 종료하겠습니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    private static Member reform(Member modifyMember) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("===== 회원 정보 수정 서브 메뉴 =====");
            System.out.println("1. 패스워드");
            System.out.println("2. 나이");
            System.out.println("3. 취미");
            System.out.println("4. 혈액형");
            System.out.println("9. 메인 메뉴로 돌아가기");
            System.out.print("수정할 번호를 입력하세요: ");
            int chooseNo = sc.nextInt();
            sc.nextLine();      //버퍼 제거
            switch (chooseNo) {
                case 1:
                    System.out.print("수정 할 패스워드를 입력하세요: ");
                    modifyMember.setPwd(sc.nextLine());
                    break;
                case 2:
                    System.out.print("수정할 나이를 입력하세요: ");
                    modifyMember.setAge(sc.nextInt());
                    break;
                case 3:
                    System.out.print("수정할 취미를 입력하새요: ");
                    modifyMember.setHobbies(resetHobbies());                // 배열은 단순 Scanner 입력 불가
                    break;
                case 4:
                    System.out.println("수정할 혈액형을 입력해주세요(A, AB, B, O): ");
                    modifyMember.setBloodType(resetBloodType());            // enum은 단순 Scanner 입력 불가
                    break;
                case 9:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    flag = false;
                    break;
                default:
                    System.out.println("번호를 제대로 입력해 주세요!");
            }
        }
        return modifyMember;
    }

    private static BloodType resetBloodType() {
        Scanner sc = new Scanner(System.in);
        String bloodType = sc.nextLine();
        BloodType bt = null;
        switch (bloodType) {
            case "A": bt = BloodType.A; break;
            case "AB": bt = BloodType.AB; break;
            case "B": bt = BloodType.B; break;
            case "O": bt = BloodType.O; break;
        }

        return bt;
    }

    private static String[] resetHobbies() {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 개의 취미를 입력하시겠습니까? ");
        String[] hobbies = new  String[sc.nextInt()];
        sc.nextLine();  // 버퍼 제거
        for (int i = 0; i < hobbies.length; i++) {
            System.out.print((i + 1) + "번째 취미를 입력하세요: ");
            hobbies[i] = sc.nextLine();
        }
        return hobbies;
    }

    private static int chooseMemN0() {
        Scanner sc = new Scanner(System.in);
        System.out.println("해당 회원의 번호를 입력하세요: ");
        return sc.nextInt();
    }

    private static Member signup() {
        Member member = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력해주세요: ");
        String id = sc.nextLine();

        System.out.print("패스워드를 입력해주세요: ");
        String password = sc.nextLine();

        System.out.print("나이를 입력해주세요: ");
        int age = sc.nextInt();

        System.out.print("입력할 취미의 갯수를 입력하세요(숫자는 1이상): ");
        int length = sc.nextInt();
        sc.nextLine();

        String[] hobbies =  new String[length];
        for (int i = 0; i < length; i++) {
            System.out.print((i + 1) + "번째 취미를 입력하세요: ");
            hobbies[i] = sc.nextLine();
        }

        System.out.print("혈액형을 입력해주세요: ");
        String bType= sc.next();
        BloodType bt = null;
        switch (bType) {
            case "A": bt = BloodType.A; break;
            case "AB": bt = BloodType.AB; break;
            case "B": bt = BloodType.B; break;
            case "O": bt = BloodType.O; break;
        }

        member = new Member(id, password, age, hobbies, bt);

        return member;
    }
}
