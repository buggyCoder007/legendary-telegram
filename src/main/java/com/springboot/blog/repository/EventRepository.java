package com.springboot.blog.repository;

import com.springboot.blog.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long>{

//    List<Event> findBy(userId);



    //feature extensibility : Events can be filtered based on categories
}
