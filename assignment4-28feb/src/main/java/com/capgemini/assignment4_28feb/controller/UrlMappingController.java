package com.capgemini.assignment4_28feb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.assignment4_28feb.dto.UrlRequestDto;
import com.capgemini.assignment4_28feb.dto.UrlResponseDto;
import com.capgemini.assignment4_28feb.service.UrlMappingService;

@RestController
@RequestMapping("/api")
public class UrlMappingController{

    @Autowired
    private UrlMappingService service;

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDto>
    create(@RequestBody UrlRequestDto request){

        return ResponseEntity.ok(
                service.createShortUrl(request));
    }

    @GetMapping("/{code}")
    public ResponseEntity<UrlResponseDto>
    get(@PathVariable String code){

        return ResponseEntity.ok(
                service.getUrl(code));
    }
}