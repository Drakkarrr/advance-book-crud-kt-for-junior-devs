package com.store.mapper;

import com.store.book.domain.Book;
import com.store.dto.BookRequest;
import com.store.dto.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookRequest request);
    void updateEntity(BookRequest request, @MappingTarget Book book);
    BookResponse toResponse(Book book);
}
