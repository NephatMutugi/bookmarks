package com.teohkenya.neph.main.utils;

import com.teohkenya.neph.main.model.Bookmark;
import com.teohkenya.neph.main.repository.BookmarkRepo;
import org.springframework.boot.CommandLineRunner;

import java.time.Instant;

/**
 * @ Author NMuchiri
 **/
//@Component
public class DataInitializer implements CommandLineRunner {

    /*---------------GLOBAL VARIABLES-------------------*/

    private final BookmarkRepo bookmarkRepo;
    private final Utils utils;

    public DataInitializer(BookmarkRepo bookmarkRepo, Utils utils) {
        this.bookmarkRepo = bookmarkRepo;
        this.utils = utils;
    }


    // We'll use this method to save several bookmarks into our database
    @Override
    public void run(String... args) throws Exception {
        bookmarkRepo.save(new Bookmark(null, "SivaLabs", "https://sivalabs.in", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "Quarkus", "https://quarkus.io/", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "Micronaut", "https://micronaut.io/", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "JOOQ", "https://www.jooq.org/", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "DZone", "https://dzone.com/", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "DevOpsBookmarks", "http://www.devopsbookmarks.com/", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "Expressjs", "https://expressjs.com/", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "Marcobehler", "https://www.marcobehler.com", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "devglan", "https://www.devglan.com", Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "linuxize", "https://linuxize.com", Instant.now()));
    }




}
