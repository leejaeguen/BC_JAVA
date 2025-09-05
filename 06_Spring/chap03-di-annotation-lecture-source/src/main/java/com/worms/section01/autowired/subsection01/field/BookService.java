package com.worms.section01.autowired.subsection01.field;

import com.worms.section01.common.BookDAO;
import com.worms.section01.common.BookDAOImpl;
import com.worms.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    /* 설명.
     *  필드에 @Autowired를 추가하면 필드를 통한 의존성 객체 주입(bean 주입)으로 필드 주입이라고 한다.
     * */
    @Autowired
//    private BookDAO bookDAO = new BookDAOImpl();
    private BookDAO bookDAO;

    public List<BookDTO> findAllBook() {
        return bookDAO.findAllBook();
    }

    public BookDTO findBookBySequenceOf(int sequence) {
        return bookDAO.findBookBySequenceOf(sequence);
    }
}


