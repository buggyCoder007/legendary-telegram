package com.springboot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class RegisterUserDto {
    private long id;

    @Schema(description = "User Id")
    private Long userId;

    @Schema(description = "Event Id")
    private Long eventId;

    @Schema(description = "Registration Time")
    // post content should not be null or empty
    @NotEmpty
    private Date registrationTime;

}
