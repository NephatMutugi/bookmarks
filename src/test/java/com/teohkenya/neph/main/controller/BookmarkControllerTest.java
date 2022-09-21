package com.teohkenya.neph.main.controller;

import com.teohkenya.neph.main.model.Bookmark;
import com.teohkenya.neph.main.repository.BookmarkRepo;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @ Author NMuchiri
 * This class is for web integrations tests
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        properties = "spring.datasource.url=jdbc:tc:mysql:8.0.30:///bookmarks"
)
class BookmarkControllerTest {

    final MockMvc mockMvc;
    final BookmarkRepo bookmarkRepo;


    @Autowired
    BookmarkControllerTest(MockMvc mockMvc, BookmarkRepo bookmarkRepo) {
        this.mockMvc = mockMvc;
        this.bookmarkRepo = bookmarkRepo;
    }

    @BeforeEach
    void setUp() {
        bookmarkRepo.deleteAllInBatch();

        List<Bookmark> bookmarks = new ArrayList<>();

        bookmarks.add(new Bookmark(null, "SivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarks.add(new Bookmark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarks.add(new Bookmark(null, "Quarkus", "https://quarkus.io/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Micronaut", "https://micronaut.io/", Instant.now()));
        bookmarks.add(new Bookmark(null, "JOOQ", "https://www.jooq.org/", Instant.now()));
        bookmarks.add(new Bookmark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "DZone", "https://dzone.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "DevOpsBookmarks", "http://www.devopsbookmarks.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Expressjs", "https://expressjs.com/", Instant.now()));
        bookmarks.add(new Bookmark(null, "Marcobehler", "https://www.marcobehler.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "devglan", "https://www.devglan.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "linuxize", "https://linuxize.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Fantasy PL", "https://fpl.com", Instant.now()));

        bookmarkRepo.saveAll(bookmarks);
    }


    @Test
    void getAllBookmarks() {
        try {
            // Get api call and expect status 200
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/bookmarks/paged"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(16)))
                    .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(2)))
                    .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(1)));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    void getPagedBookmarks() {
//    }
}