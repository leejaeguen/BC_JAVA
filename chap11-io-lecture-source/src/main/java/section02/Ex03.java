package section02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) {

        /* 수업목표. FileReader를 이해하고 활용할 수 있다. */
        FileReader fr = null;
        try {
            fr = new FileReader("src/main/java/section02/testReader.txt");
           // int readChar = fr.read();
           // System.out.println((char) readChar);
           // System.out.println((char)fr.read());

            int readChar = 0;
            while ((readChar = fr.read()) != -1) {
                System.out.print((char) readChar);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null )fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
