package section03.filterstream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyOutput extends ObjectOutputStream {
    public MyOutput(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {

        /* 설명. 객체를 파일로 출력할 시 헤더의 개념이 추가되지 않도록 기능 제거 */
    }
}
