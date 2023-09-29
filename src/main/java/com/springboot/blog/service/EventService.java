package com.springboot.blog.service;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.payload.EventDto;
import com.springboot.blog.payload.EventResponse;
import com.springboot.blog.payload.RegisterUserDto;

import java.util.List;

public interface EventService {

    EventResponse getAllEvents(int pageNo, int pageSize, String sortBy, String sortDir);


    List<EventDto> getRegisteredEventsByUserId(long userId);

    RegisterUserDto registerUserForEvent(Long eventId, long userId, RegisterUserDto registerUserDto);

    void unregisterUserForEvent(Long eventId, Long userId);
}
