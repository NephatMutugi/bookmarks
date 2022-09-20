package com.teohkenya.neph.main.service.impl;

import com.teohkenya.neph.main.model.Bookmark;
import com.teohkenya.neph.main.model.BookmarksDto;
import com.teohkenya.neph.main.repository.BookmarkRepo;
import com.teohkenya.neph.main.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@Service
@Transactional
@Slf4j
public class BookmarkServiceImpl implements BookmarkService {

    /*----------------GLOBAL VARIABLES----------------*/

    final BookmarkRepo bookmarkRepo;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepo bookmarkRepo) {
        this.bookmarkRepo = bookmarkRepo;
    }


    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<List<Bookmark>> getAllBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {

        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.ASC, "timestamp");

        List<Bookmark> bookmarkList = bookmarkRepo.findAll(pageable).getContent();


        return new ResponseEntity<>(bookmarkList, HttpStatus.OK);
    }


    // GET WITH DTO
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<BookmarksDto> getBookmarksPageable(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.ASC, "timestamp");
        BookmarksDto bookmarksDto = new BookmarksDto(bookmarkRepo.findAll(pageable));


        return new ResponseEntity<>(bookmarksDto, HttpStatus.OK);
    }
}
