package section04.repository;

import section04.aggregate.AccountStatus;
import section04.aggregate.BloodType;
import section04.aggregate.Member;
import section04.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

/* 설명. 데이터베이스(현재는 파일) 개념과 입출력을 위해 만들어진 계층이며 성공 데이터 또는 성공/실패 여부를 반환
 *      (지금과 같이 주로 컬렉션으로 데이터를 관리함)
* */
public class MemberRepository {

    /* 설명. 초기에 Member 파일이 없다면 만들어 더미데이터(dummy data)를 쌓는다. */
    private final ArrayList<Member> memberList = new ArrayList<>();
    private final File file =
            new File("src/main/java/section04/db/memberDB.dat");

    public MemberRepository() {
        if(!file.exists()){
            ArrayList<Member> defaultMemberList = new ArrayList<>();
            defaultMemberList.add(new Member(1,"user01","pass01",20,new String[]{"발레","수영"}, BloodType.A, AccountStatus.ACTIVE));
            defaultMemberList.add(new Member(2,"user02","pass02",10,new String[]{"게임","영화감상"}, BloodType.B, AccountStatus.ACTIVE));
            defaultMemberList.add(new Member(3,"user03","pass03",30,new String[]{"음악감상","독서","명상"}, BloodType.AB, AccountStatus.ACTIVE));
            saveMembers(defaultMemberList);
        }

        loadMembers();
    }

    /* 설명. ArrayList<Member>를 받으면 파일로 컬렉션에 담긴 회원들을 출력하는 메소드(feat. 덮어씌우는 기능) */
    private void saveMembers(ArrayList<Member> members) {
            ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

            for(Member member: members) {
                oos.writeObject(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (true) {
                memberList.add((Member) ois.readObject());
            }
        } catch (EOFException e){
            System.out.println("회원 정보 읽어오기 완료");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Member> finaAllMembers() {
        ArrayList<Member> returnList = new ArrayList<>();
        for (Member member : memberList) {
            if(member.getAccountStatus() == AccountStatus.ACTIVE) {
                returnList.add(member);
            }
        }
        return returnList;
    }

    public Member findMemberBy(int memNo) {
        for (Member member : memberList) {
            if (member.getMemNo() == memNo && member.getAccountStatus() == AccountStatus.ACTIVE) {
                return member;
            }
        }
        return null;
    }

    public int findLastMemberNo() {
        return memberList.get(memberList.size()-1).getMemNo();

    }

    public int registMember(Member registMember) {
        MyObjectOutput moo = null;
        int result = 0;

        try {
            moo = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream(file, true)));
            moo.writeObject(registMember);
            moo.flush();
            
            /* 설명. 컬렉션에 담긴 기존 회원을 지우고 다시 파일의 정보를 토대로 컬렉션이 회원으로 채워지도록 작성 */
            memberList.clear();
            loadMembers();
            
            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }

    public int modifyMember(Member reformedMember) {
        /* 설명. 1. Repositor가 가진 컬렉션의 회원부터 수정 */
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemNo() == reformedMember.getMemNo()) {
                memberList.set(i, reformedMember);      // i번째(수정할) 회원을 교체
                saveMembers(memberList);                // 교체 할 회원이 포함된 전체 회원으로 파일을 다시 덮어씌움
                return 1;
            }
        }
        return 0;
    }

    public int removeMember(int memNo) {
        int result = 0;

        for (Member member : memberList) {
            if (member.getMemNo() == memNo) {
                member.setAccountStatus(AccountStatus.DEACTIVE);

                saveMembers(memberList);

                result = 1;
                return result;
            }
        }
        return result;
    }
}
