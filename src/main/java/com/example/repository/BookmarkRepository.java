package com.example.repository;

import com.example.BookmarkVM;
import com.example.domain.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {


    @Query("""
        SELECT 
            b.id as id, 
            b.title as title, 
            b.url as url, 
            b.createdAt as createdAt 
        FROM Bookmark b
        ORDER BY b.createdAt DESC
        """)
    Page<BookmarkVM> findBookmarks(Pageable pageable);

    @Query("""
        SELECT 
            b.id as id, 
            b.title as title, 
            b.url as url, 
            b.createdAt as createdAt 
        FROM Bookmark b 
        WHERE lower(b.title) LIKE lower(concat('%', :query, '%'))
        ORDER BY b.createdAt DESC
        """)
    Page<BookmarkVM> searchBookmarks(@Param("query") String query, Pageable pageable);


    Page<BookmarkVM> findByTitleContainsIgnoreCase(String query, Pageable pageable);


}

