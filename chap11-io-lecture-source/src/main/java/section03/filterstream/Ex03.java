package section03.filterstream;

import java.io.*;

public class Ex03 {
    public static void main(String[] args) {
        
        /* 수업목표. 데이터 타입 입출력 보조 스트림을 이해하고 활용할 수 있다. */
        DataOutputStream dos = null;
        try{
            dos = new DataOutputStream(
                    new FileOutputStream(
                            "src/main/java/section03/filterstream/testData.txt"
                    )
            );
            dos.writeUTF("홍길동");
            dos.writeInt(20);
            dos.writeChar('A');

            dos.writeUTF("유관순");
            dos.writeInt(16);
            dos.writeChar('B');

            dos.writeUTF("강감찬");
            dos.writeInt(38);
            dos.writeChar('C');


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dos != null) dos.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(
                    "src/main/java/section03/filterstream/testData.txt"));
            while(true){
                System.out.println(dis.readUTF());
                System.out.println(dis.readInt());
                System.out.println(dis.readChar());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("파일 읽기 완료");
        } finally {
            try {
                if (dis != null) dis.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
