package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

import java.util.List;

public class BookmarksDTO {

    private List<BookmarkVM> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    private boolean isFirst;
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public BookmarksDTO(Page<BookmarkVM> bookmarkPage) {
        this.data = bookmarkPage.getContent();
        this.totalElements = bookmarkPage.getTotalElements();
        this.totalPages = bookmarkPage.getTotalPages();
        this.currentPage = bookmarkPage.getNumber() + 1;
        this.isFirst = bookmarkPage.isFirst();
        this.isLast = bookmarkPage.isLast();
        this.hasNext = bookmarkPage.hasNext();
        this.hasPrevious = bookmarkPage.hasPrevious();
    }

    public List<BookmarkVM> getData() { return data; }
    public long getTotalElements() { return totalElements; }
    public int getTotalPages() { return totalPages; }
    public int getCurrentPage() { return currentPage; }

    @JsonProperty("isFirst")
    public boolean isFirst() { return isFirst; }

    @JsonProperty("isLast")
    public boolean isLast() { return isLast; }

    public boolean isHasNext() { return hasNext; }
    public boolean isHasPrevious() { return hasPrevious; }
}