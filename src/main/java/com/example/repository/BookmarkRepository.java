package com.example.repository;

import com.example.BookmarkDTO;
import com.example.domain.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {


    @Query(
            value = "SELECT new com.example.BookmarkDTO(b.id, b.title, b.url, b.createdAt) FROM Bookmark b",
            countQuery = "SELECT count(b) FROM Bookmark b"
    )
    Page<BookmarkDTO> findBookmarks(Pageable pageable);

}
