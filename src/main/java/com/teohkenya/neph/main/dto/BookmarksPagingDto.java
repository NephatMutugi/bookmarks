package com.teohkenya.neph.main.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@Getter
@Setter
public class BookmarksPagingDto {

    // List of all bookmarks
    private List<BookmarkDto> data;

    // Total number of available bookmarks
    private long totalElements;

    // Total number of pages
    private int totalPages;

    // Current bookmark page
    private int currentPage;

    // Returns true if current page is the first page
    @JsonProperty("isFirst")
    private boolean isFirst;

    @JsonProperty("isLast")
    // Returns true if current page is the last page
    private boolean isLast;

    // Returns true if there is a next page
    private boolean hasNext;

    // Returns true if there is a previous page
    private boolean hasPrevious;

    public BookmarksPagingDto(Page<BookmarkDto> bookmarkPage){
        this.setData(bookmarkPage.getContent());
        this.setTotalElements(bookmarkPage.getTotalElements());
        this.setTotalPages(bookmarkPage.getTotalPages());
        this.setCurrentPage(bookmarkPage.getNumber() + 1);
        this.setFirst(bookmarkPage.isFirst());
        this.setLast(bookmarkPage.isLast());
        this.setHasNext(bookmarkPage.hasNext());
        this.setHasPrevious(bookmarkPage.hasPrevious());
    }

}
