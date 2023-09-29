package com.springboot.blog.entity;

import jakarta.persistence.*;

import java.util.Date;

public class RegisterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event eventId;

    @Column(nullable = false)
    private Date registrationTime;

}
