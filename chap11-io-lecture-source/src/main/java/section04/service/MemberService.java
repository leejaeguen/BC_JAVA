package section04.service;

import section04.aggregate.AccountStatus;
import section04.aggregate.Member;
import section04.repository.MemberRepository;

import java.util.ArrayList;

/* 설명. 트랜잭션 처리(DB와의 CRUD 이후 성공 및 실패 여부 처리) 및 비지니스 로직 담당 및 유효성 검사 */
public class MemberService {

    // private final MemberRepository memberRepository = new MemberRepository();
    private final MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public void findAllMembers() {
        ArrayList<Member> result = new ArrayList<>();
        result = memberRepository.finaAllMembers();
        if(!result.isEmpty()){
            System.out.println("Service에서 조회 확인: ");
            for(Member member : result) {
                System.out.println("member: " + member);
            }
        } else{
            System.out.println("회원 없음");
        }

    }

    public void findMemberBy(int memNo) {
        Member findMember = memberRepository.findMemberBy(memNo);
        if(findMember != null){  // 회원이 조회 되는 경우
            System.out.println("회원 조회 성공: " +  findMember);
        } else {                 // 안되는 경우
            System.out.println(memNo + "번호의 회원은 존재하지 않습니다.");
        }
    }

    public void registMember(Member registMember) {
        /* 설명. 회원가입에서 입력받은 값을 제외하고도 2개의 데이터 추가 */
        // 1. 회원 번호 생성
        int lastNo = memberRepository.findLastMemberNo();
        registMember.setMemNo(lastNo + 1);

        // 2. 회원 활성화 상태 추가
        registMember.setAccountStatus(AccountStatus.ACTIVE);

        /* 설명. DML의 성공 여부는 int 값으로 돌아옴 */
        int result = memberRepository.registMember(registMember);
        if (result == 1) {
            System.out.println(registMember.getId() + " 회원님 환영합니다!");
        } else {
            System.out.println("회원 가입 실패");
        }
    }

    public Member findMemberForMod(int memNo) {
        Member selectedMember = memberRepository.findMemberBy(memNo);

        Member cooyMember = null;

        if(selectedMember != null){
            /* 설명. 프론트로 반환하기 전에 사본 만들어 Repository가 가진 회원 객체 대신 사본을 반환함(feat. 오염 방지) */
            cooyMember = new Member();
            cooyMember.setMemNo(selectedMember.getMemNo());
            cooyMember.setId(selectedMember.getId());
            cooyMember.setPwd(selectedMember.getPwd());
            cooyMember.setAge(selectedMember.getAge());

            /* 설명. 취미의 경우는 배열이므로 깊은 복사를 해 주어야 한다. */
            String[] copiedHobbies = selectedMember.getHobbies().clone();
            cooyMember.setHobbies(copiedHobbies);
            cooyMember.setBloodType(selectedMember.getBloodType());
            cooyMember.setAccountStatus(selectedMember.getAccountStatus());
        } else {
            System.out.println("그런 회원은 없네여");
        }

        return cooyMember;

    }

    public void modifyMember(Member reformedMember) {
        int result = memberRepository.modifyMember(reformedMember);

        if (result > 0) {
            System.out.println(reformedMember.getId() + "회원님의 정보 수정에 성공하였습니다.");
        } else {
            System.out.println("회원 정보 수정에 실패하였습니다.");
        }
    }

    public void removeMember(int memNo) {
        int result = memberRepository.removeMember(memNo);

        if (result > 0) {
            System.out.println("바이");
        } else {
            System.out.println("못나가");
        }
    }
}
