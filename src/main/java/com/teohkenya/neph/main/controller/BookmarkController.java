package com.teohkenya.neph.main.controller;

import com.teohkenya.neph.main.model.Bookmark;
import com.teohkenya.neph.main.dto.BookmarksPagingDto;
import com.teohkenya.neph.main.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@RestController
@RequestMapping("/api/v1/bookmarks/")
@Slf4j
public class BookmarkController {
    /*-------------------------GLOBAL VARIABLES-----------------------*/
    final BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<Bookmark>> getAllBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return bookmarkService.getAllBookmarks(page);
    }

    @GetMapping(value = "paged")
    public ResponseEntity<BookmarksPagingDto> getPagedBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return bookmarkService.findAllBookmarks(page);
    }

}
