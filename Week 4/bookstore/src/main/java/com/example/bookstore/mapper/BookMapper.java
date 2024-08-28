package com.example.bookstore.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.model.Book;
@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toBookDTO(Book book);
    Book toBook(BookDTO bookDTO);
}
