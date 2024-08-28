package com.raks.BookstoreAPI.mapper;

import com.raks.BookstoreAPI.dto.BookDTO;
import com.raks.BookstoreAPI.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO bookDTO);
}
