package com.circularizationlettercore.controller.filter;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class PageableResponseFilter<T> implements Serializable {

    private transient List<T> content;
    private int page;
    private int size;
    private int totalPages;
    private int totalSize;
    private long totalItems;
    private String next;
    private String prev;
    private transient Filter filters;

    public PageableResponseFilter(Page<T> page, Filter filter){
        buildResponse(page, page.getContent(), filter);
    }

    public PageableResponseFilter(Page<T> page, List<T> c, Filter filter){
        buildResponse(page, c, filter);
    }

    private void buildResponse(Page<T> page, List<T> c, Filter filter) {
        setContent(c);
        setPage(page.getNumber() + 1);
        setSize(10);
        setTotalPages(page.getTotalPages());
        setTotalSize(page.getNumberOfElements());
        setTotalItems(page.getTotalElements());
        setFilters(filter);
    }
}
