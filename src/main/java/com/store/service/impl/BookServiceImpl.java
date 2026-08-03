package com.store.service.impl;

import com.store.book.domain.Book;
import com.store.dto.BookRequest;
import com.store.dto.BookResponse;
import com.store.exception.BookNotFoundException;
import com.store.mapper.BookMapper;
import com.store.repository.BookRepository;
import com.store.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public BookResponse create(BookRequest request){
        Book book = bookMapper.toEntity(request);
        Book saved = bookRepository.save(book);
        return bookMapper.toResponse(saved);
    }

    @Override
    public BookResponse getById(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toResponse(book);
    }

    @Override
    public List<BookResponse> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public BookResponse update(Long id, BookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookMapper.updateEntity(request, book);
        Book updated = bookRepository.save(book);
        return bookMapper.toResponse(updated);
    }

    @Override
    @Transactional
    public  void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }
}
