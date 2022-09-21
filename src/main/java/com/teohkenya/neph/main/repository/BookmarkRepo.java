package com.teohkenya.neph.main.repository;

import com.teohkenya.neph.main.dto.BookmarkDto;
import com.teohkenya.neph.main.model.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ Author NMuchiri
 **/
@Service
public interface BookmarkRepo extends JpaRepository<Bookmark, Integer> {

    List<Bookmark> findAll();

    @Query("select new com.teohkenya.neph.main.dto.BookmarkDto(b.id, b.title, b.url, b.timestamp) from Bookmark  b")
    Page<BookmarkDto> findBookmarks(Pageable page);

    Optional<Bookmark> findAllById(Long id);

    Bookmark findBookmarksByTitle(String  title);

    Bookmark findBookmarksByUrl(String url);
}
