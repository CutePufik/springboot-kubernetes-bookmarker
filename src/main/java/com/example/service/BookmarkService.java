package com.example.service;


import com.example.*;
import com.example.domain.Bookmark;
import com.example.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
public class BookmarkService {

    private final BookmarkRepository repository;

    private final BookmarkMapper bookmarkMapper;


    @Autowired
    public BookmarkService(BookmarkRepository repository, BookmarkMapper bookmarkMapper) {
        this.repository = repository;
        this.bookmarkMapper = bookmarkMapper;
    }


    @Transactional(readOnly = true)
    public BookmarksDTO getBookmarks(Integer page){
        int pageNo = page < 1 ? 0 : page -1 ;
        Pageable pageable = PageRequest.of(pageNo,10, Sort.Direction.DESC,"createdAt");
        Page<BookmarkVM> bookmarkVMPage = repository.findBookmarks(pageable);
        return new BookmarksDTO(bookmarkVMPage);
    }


    @Transactional(readOnly = true)
    public BookmarksDTO searchBookmarks(Integer page, String query) {
        int pageNo = page < 1 ? 0 : page -1 ;
        Pageable pageable = PageRequest.of(pageNo,10, Sort.Direction.DESC,"createdAt");
        Page<BookmarkVM> bookmarkVMPage = repository.findByTitleContainsIgnoreCase(query,pageable);
        return new BookmarksDTO(bookmarkVMPage);
    }



    public BookmarkDTO createBookmark(CreateBookmarkRequest request) {
        Bookmark bookmark = new Bookmark(null,request.getTitle(),request.getUrl(), Instant.now());
        Bookmark saved = repository.save(bookmark);
        return bookmarkMapper.toDTO(saved);
    }
}
