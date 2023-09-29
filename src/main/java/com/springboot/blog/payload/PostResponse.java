package com.springboot.blog.payload;

import java.util.List;

public class PostResponse {
    private List<EventDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
