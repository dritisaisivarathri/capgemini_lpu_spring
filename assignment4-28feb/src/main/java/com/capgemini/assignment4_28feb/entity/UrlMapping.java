package com.capgemini.assignment4_28feb.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="url_mapping")
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length=1000)
    private String originalUrl;

    @Column(nullable=false,unique=true)
    private String shortCode;

    @Column(nullable=false)
    private Long clickCount=0L;

    private LocalDateTime createdAt=LocalDateTime.now();

    private LocalDateTime updatedAt=LocalDateTime.now();

    public UrlMapping() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getOriginalUrl() { return originalUrl; }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortCode() { return shortCode; }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public Long getClickCount() { return clickCount; }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
