package com.example.pubsync.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @CreatedDate
    @Column(name = "created_date",updatable = false)
    private Instant createdTime= Instant.now();

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "active")
    private boolean active;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "quit_date")
    private String quitDate;

    @Column(name = "pid")
    private String pid;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getStartDate() {return startDate; }

    public void setStartDate(String startDate) {this.startDate = startDate; }

    public String getQuitDate() {return quitDate; }

    public void setQuitDate(String quitDate) {this.quitDate = quitDate; }

    public String getPid() {return pid; }

    public void setPid(String pid) {this.pid = pid; }
}