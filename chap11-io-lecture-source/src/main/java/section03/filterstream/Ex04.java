package section03.filterstream;

import section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Ex04 {
    public static void main(String[] args) {

        MemberDTO[] members = new MemberDTO[3];
        members[0] = new MemberDTO("user01", "pass01", "홍길동", "hong123@gmail.com", 25, '남');
        members[1] = new MemberDTO("user02", "pass02", "유관순", "korea31@gmail.com", 16, '여');
        members[2] = new MemberDTO("user03", "pass03", "강감찬", "kang1@gmail.com", 38, '남');

        String path = "src/main/java/section03/filterstream/testObject.txt";
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    path
                            )
                    )
            );
            for (int i = 0; i < members.length; i++) {
                oos.writeObject(members[i]);
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }

        MemberDTO[] newMembers = new MemberDTO[members.length];
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
            int index = 0;
            while(true){
                newMembers[index] = (MemberDTO)ois.readObject();
                index++;
            }
        } catch (EOFException e){
            System.out.println("회원 읽기 끝!");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }

        System.out.println("===== 읽어드린 회원들 =====");
        for (MemberDTO member : newMembers) {
            System.out.println(member);
        }
    }
}
