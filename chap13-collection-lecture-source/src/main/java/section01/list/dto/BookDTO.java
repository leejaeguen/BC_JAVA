package section01.list.dto;

import java.io.Serializable;
import java.util.Objects;

public class BookDTO implements Comparable<BookDTO> {
    private int number;
    private String title;
    private String author;
    private int price;

    public BookDTO(){
    }

    public BookDTO(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(BookDTO o) {
        
        /* 설명. 가격에 대한 오름차순 */
        // int result = this.price - o.price;
        // return result;
        
        /* 설명. 가격에 대한 내림차순 */
        // return -(this.price - o.price);
        // return o.price - this.price;

        /* 설명. 채 제목에 대한 오름차순 */
        // return this.title.compareTo(o.title);       // String의 오름차순 기준으로 정의 된 CompareTo() 메소드 활용
        
        /* 설명. 책 제목에 대한 내림차순 */
        // return -this.title.compareTo(o.title);
        return o.title.compareTo(this.title);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return number == bookDTO.number && price == bookDTO.price && Objects.equals(title, bookDTO.title) && Objects.equals(author, bookDTO.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, title, author, price);
    }
}
