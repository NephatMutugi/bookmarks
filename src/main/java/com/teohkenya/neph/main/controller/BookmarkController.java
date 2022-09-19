package com.teohkenya.neph.main.controller;

import com.teohkenya.neph.main.model.Bookmark;
import com.teohkenya.neph.main.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@RestController
@RequestMapping("api/v1/bookmarks/")
@Slf4j
public class BookmarkController {
/*-------------------------GLOBAL VARIABLES-----------------------*/
final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<Bookmark>> getAllBookmarks(){
        return bookmarkService.getAllBookmarks();
    }
}
