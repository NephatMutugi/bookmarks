package com.teohkenya.neph.main.service;

import com.teohkenya.neph.main.model.Bookmark;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
public interface BookmarkService {

    ResponseEntity<List<Bookmark>> getAllBookmarks();
}
