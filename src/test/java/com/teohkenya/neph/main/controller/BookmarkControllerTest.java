package com.teohkenya.neph.main.controller;

import com.teohkenya.neph.main.repository.BookmarkRepo;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @ Author NMuchiri
 * This class is for web integrations tests
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookmarkControllerTest {

    final MockMvc mockMvc;
    final BookmarkRepo bookmarkRepo;


    @Autowired
    BookmarkControllerTest(MockMvc mockMvc, BookmarkRepo bookmarkRepo) {
        this.mockMvc = mockMvc;
        this.bookmarkRepo = bookmarkRepo;
    }

    @BeforeEach
    void setUp(){
//        bookmarkRepo.deleteAllInBatch();
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