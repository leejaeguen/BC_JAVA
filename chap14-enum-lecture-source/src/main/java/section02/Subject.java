package section02;

public enum Subject {
    JAVA,
    MARIADB,
    JDBC,
    HTML,
    CSS,
    JAVASCRIPT;         // enum 타입에 추가적인 코드가 있을 경우 ;을 빼면 안됨

    Subject() {
        System.out.println("기본 생성자 호출됨...");
    }

    @Override
    public String toString() {
        return "@@@" + this.name() + "@@@";
    }
}
