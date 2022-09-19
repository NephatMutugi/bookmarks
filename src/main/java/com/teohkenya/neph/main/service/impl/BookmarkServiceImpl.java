package com.teohkenya.neph.main.service.impl;

import com.teohkenya.neph.main.model.Bookmark;
import com.teohkenya.neph.main.repository.BookmarkRepo;
import com.teohkenya.neph.main.service.BookmarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public ResponseEntity<List<Bookmark>> getAllBookmarks() {
        List<Bookmark> bookmarkList = bookmarkRepo.findAll();

        return new ResponseEntity<>(bookmarkList, HttpStatus.OK);
    }
}
