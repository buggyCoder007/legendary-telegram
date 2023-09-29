package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class EventDto {
    private long id;

    @Schema(description = "Event Name")
    // event name should not be null or empty
    @NotEmpty
    private String name;


    @Schema(description = "Event Category")
    private Long categoryId;

    @Schema(description = "Event Description")
    // post description should be not null or empty
    // post description should have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Event description should have at least 10 characters")
    private String description;

    @Schema(description = "Event Start Time")
    // post content should not be null or empty
    @NotEmpty
    private Date startTime;

    @Schema(description = "Event End Time")
    // post content should not be null or empty
    @NotEmpty
    private Date endTime;
}
