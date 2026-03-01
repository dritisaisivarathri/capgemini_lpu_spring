package com.capgemini.assignment4_28feb.dto;

import java.time.LocalDateTime;

public class UrlResponseDto {

    private String originalUrl;
    private String shortCode;
    private Long clickCount;
    private LocalDateTime createdAt;

    public UrlResponseDto(){}

    public UrlResponseDto(String originalUrl,String shortCode,
                          Long clickCount,LocalDateTime createdAt){

        this.originalUrl=originalUrl;
        this.shortCode=shortCode;
        this.clickCount=clickCount;
        this.createdAt=createdAt;
    }

    public String getOriginalUrl(){return originalUrl;}

    public String getShortCode(){return shortCode;}

    public Long getClickCount(){return clickCount;}

    public LocalDateTime getCreatedAt(){return createdAt;}
}
