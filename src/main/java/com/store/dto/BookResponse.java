package com.store.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer publishYear;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
