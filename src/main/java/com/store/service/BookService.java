package com.store.service;

import com.store.dto.BookRequest;
import com.store.dto.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse create(BookRequest request);
    BookResponse getById(Long id);
    List<BookResponse> getAll();
    BookResponse update(Long id, BookRequest request);
    void delete(Long id);
}
