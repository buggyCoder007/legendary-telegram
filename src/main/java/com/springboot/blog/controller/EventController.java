package com.springboot.blog.controller;

import com.springboot.blog.payload.*;
import com.springboot.blog.service.EventService;
import com.springboot.blog.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @Operation(
            summary = "Get All Events REST API",
            description = "Get All Events REST API is used to fetch all the events which are happening from the db"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    // get all posts rest api
    @GetMapping
    public EventResponse getAllEvents(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return eventService.getAllEvents(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/events/{userId}")
    public List<EventDto> getRegisteredEventsByUserId(@PathVariable(value = "userId") Long userId) {
        return eventService.getRegisteredEventsByUserId(userId);
    }

    @PostMapping("/events/{eventId}/user/{userId}")
    public ResponseEntity<CommentDto> registerUserForEvent(@PathVariable(value = "eventId") Long eventId,
                                                    @PathVariable(value = "userId") Long userId,
                                                    @Valid @RequestBody RegisterUserDto registerUserDto){
        CommentDto updatedComment = eventService.registerUserForEvent(eventId, userId, registerUserDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/events/{eventId}/user/{userId}")
    public ResponseEntity<String> unregisterUserForEvent(@PathVariable(value = "eventId") Long eventId,
                                                @PathVariable(value = "userId") Long userId){
        eventService.unregisterUserForEvent(eventId, userId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
