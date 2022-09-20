package com.teohkenya.neph.main.service.impl;

import com.teohkenya.neph.main.dto.BookmarkDto;
import com.teohkenya.neph.main.dto.BookmarkMapper;
import com.teohkenya.neph.main.model.Bookmark;
import com.teohkenya.neph.main.dto.BookmarksPagingDto;
import com.teohkenya.neph.main.repository.BookmarkRepo;
import com.teohkenya.neph.main.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    final BookmarkMapper bookmarkMapper;


    @Autowired
    public BookmarkServiceImpl(BookmarkRepo bookmarkRepo, BookmarkMapper bookmarkMapper) {
        this.bookmarkRepo = bookmarkRepo;
        this.bookmarkMapper = bookmarkMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<List<Bookmark>> getAllBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {

        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.ASC, "timestamp");

        List<Bookmark> bookmarkList = bookmarkRepo.findAll(pageable).getContent();


        return new ResponseEntity<>(bookmarkList, HttpStatus.OK);
    }


    // GET WITH MAPPING DTO
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<BookmarksPagingDto> getBookmarksPageable(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.ASC, "timestamp");
        Page<BookmarkDto> bookmarkPage = bookmarkRepo.findAll(pageable).map(bookmarkMapper::toDto);
        BookmarksPagingDto bookmarksPagingDto = new BookmarksPagingDto(bookmarkPage);

        return new ResponseEntity<>(bookmarksPagingDto, HttpStatus.OK);
    }

    // USING WITHOUT MAPPING
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<BookmarksPagingDto> findAllBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.ASC, "timestamp");

        Page<BookmarkDto> bookmarkPage = bookmarkRepo.findBookmarks(pageable);
        BookmarksPagingDto bookmarksPagingDto = new BookmarksPagingDto(bookmarkPage);

        return new ResponseEntity<>(bookmarksPagingDto, HttpStatus.OK);
    }
}
