package com.capgemini.assignment4_28feb.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.assignment4_28feb.dto.UrlRequestDto;
import com.capgemini.assignment4_28feb.dto.UrlResponseDto;
import com.capgemini.assignment4_28feb.entity.UrlMapping;
import com.capgemini.assignment4_28feb.exception.ShortCodeNotFoundException;
import com.capgemini.assignment4_28feb.repository.UrlMappingRepository;
import com.capgemini.assignment4_28feb.service.UrlMappingService;

@Service
public class UrlMappingServiceImpl
        implements UrlMappingService{

    @Autowired
    private UrlMappingRepository repository;

    @Override
    public UrlResponseDto createShortUrl(
            UrlRequestDto request){

        String code=
                UUID.randomUUID()
                .toString()
                .substring(0,6);

        UrlMapping entity=new UrlMapping();

        entity.setOriginalUrl(
                request.getOriginalUrl());

        entity.setShortCode(code);

        repository.save(entity);

        return new UrlResponseDto(
                entity.getOriginalUrl(),
                entity.getShortCode(),
                entity.getClickCount(),
                entity.getCreatedAt());
    }

    @Override
    public UrlResponseDto getUrl(String code){

        UrlMapping entity=
                repository.findByShortCode(code)
                .orElseThrow(()->new
                        ShortCodeNotFoundException(
                                "Code not found"));

        entity.setClickCount(
                entity.getClickCount()+1);

        repository.save(entity);

        return new UrlResponseDto(
                entity.getOriginalUrl(),
                entity.getShortCode(),
                entity.getClickCount(),
                entity.getCreatedAt());
    }
}
