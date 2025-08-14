package section02;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
            
        /* 수업목표. FileInputStream을 이해할 수 있다.(feat. 한글 안됨) */
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/java/section02/testInputStream.txt");
        //    System.out.println((char)fis.read());
        //    System.out.println((char)fis.read());
        //    System.out.println((char)fis.read());
        //    System.out.println((char)fis.read());
            int input = 0;
            while((input = fis.read()) != -1){          //read()에 대한 EOF(End Of File) 처리
                System.out.println((char)input);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없거나 경로가 잘못됨");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
