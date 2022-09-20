package com.teohkenya.neph.main.service;

import com.teohkenya.neph.main.model.Bookmark;
import com.teohkenya.neph.main.dto.BookmarksPagingDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
public interface BookmarkService {

    ResponseEntity<List<Bookmark>> getAllBookmarks(Integer page);

    ResponseEntity<BookmarksPagingDto> getBookmarksPageable(Integer page);
    ResponseEntity<BookmarksPagingDto> findAllBookmarks(Integer page);
}
