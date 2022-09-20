package com.teohkenya.neph.main.dto;

import com.teohkenya.neph.main.model.Bookmark;
import org.springframework.stereotype.Component;

/**
 * @ Author NMuchiri
 **/
@Component
public class BookmarkMapper {

    public BookmarkDto toDto(Bookmark bookmark){

        BookmarkDto bookmarkDto = new BookmarkDto();

        // SET DTO VARIABLES TO THOSE OF THE ENTITY
        bookmarkDto.setId(bookmark.getId());
        bookmarkDto.setTitle(bookmark.getTitle());
        bookmarkDto.setUrl(bookmark.getUrl());
        bookmarkDto.setTimestamp(bookmark.getTimestamp());

        return bookmarkDto;
    }
}
