package com.teohkenya.neph.main.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/**
 * @ Author NMuchiri
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkDto {

    private Long id;
    private String title;
    private String url;

    @JsonIgnore
    private Instant timestamp;

    public BookmarkDto(Long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }
}
