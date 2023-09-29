package com.springboot.blog.entity;

import jakarta.persistence.*;

import java.util.Date;

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(nullable = false)
    private Date startTime;
    @Column(nullable = false)
    private Date endTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
