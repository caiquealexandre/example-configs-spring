package com.circularizationlettercore.controller.filter;


import org.springframework.data.domain.PageRequest;

public class PageableFilter {

    private final int page;
    private static final int SIZE = 10;

    public PageableFilter(int page) throws IllegalArgumentException{
        if (page <= 0) {
            throw new IllegalArgumentException("The page number should be greater than 0");
        }
        this.page = --page;
    }

    public org.springframework.data.domain.Pageable build() {
        return PageRequest.of(page, SIZE);
    }
}
