package section01.list.comparator;

import section01.list.dto.BookDTO;

import java.util.Comparator;

public class desendingAuthor implements Comparator<BookDTO> {

    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
