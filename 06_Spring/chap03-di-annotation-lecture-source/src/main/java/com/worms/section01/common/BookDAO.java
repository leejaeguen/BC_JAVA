package com.worms.section01.common;

import java.util.List;

public interface BookDAO {
    List<BookDTO> findAllBook();

    BookDTO findBookBySequenceOf(int sequence);
}
