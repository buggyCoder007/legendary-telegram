package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Event;
import com.springboot.blog.payload.EventDto;
import com.springboot.blog.payload.EventResponse;
import com.springboot.blog.repository.CategoryRepository;
import com.springboot.blog.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class EventServiceImpl {

    private final EventRepository eventRepository;

    private final ModelMapper mapper;

    private final CategoryRepository categoryRepository;

    public EventServiceImpl(EventRepository eventRepository, ModelMapper mapper, CategoryRepository categoryRepository) {
        this.eventRepository = eventRepository;
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public EventResponse getAllEvents(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Event> events = eventRepository.findAll(pageable);

        // get content for page object
        List<Event> listOfEvents = events.getContent();

        List<EventDto> content = listOfEvents.stream().map(event -> mapToDTO(event)).collect(Collectors.toList());

        EventResponse eventResponse = new EventResponse();
        eventResponse.setPageNo(events.getNumber());
        eventResponse.setPageSize(events.getSize());
        eventResponse.setTotalElements(events.getTotalElements());
        eventResponse.setTotalPages(events.getTotalPages());
        eventResponse.setLast(events.isLast());

        return eventResponse;
    }



    // convert Entity into DTO
    private EventDto mapToDTO(Event event) {
        EventDto eventDto = mapper.map(event, EventDto.class);
        return eventDto;
    }


}
