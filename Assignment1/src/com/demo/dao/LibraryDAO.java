package com.demo.dao;

import com.demo.beans.Book;
import com.demo.beans.Member;
import java.util.List;
import java.util.Map;

public interface LibraryDAO {
    void saveLibraryData(List<Book> books, Map<Long, Member> members);
    void loadLibraryData(List<Book> books, Map<Long, Member> members);
}
