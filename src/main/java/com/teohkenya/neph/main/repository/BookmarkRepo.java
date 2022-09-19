package com.teohkenya.neph.main.repository;

import com.teohkenya.neph.main.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * @ Author NMuchiri
 **/

public interface BookmarkRepo extends JpaRepository<Bookmark, Integer> {

    List<Bookmark> findAll();
//    @RequestParam(name = "page", defaultValue = "1") Integer page

    Optional<Bookmark> findAllById(Integer id);

    Bookmark findBookmarksByTitle(String  title);

    Bookmark findBookmarksByUrl(String url);
}
