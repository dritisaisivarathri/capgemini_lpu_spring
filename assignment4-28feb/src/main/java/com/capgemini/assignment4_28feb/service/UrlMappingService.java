package com.capgemini.assignment4_28feb.service;

import com.capgemini.assignment4_28feb.dto.UrlRequestDto;
import com.capgemini.assignment4_28feb.dto.UrlResponseDto;

public interface UrlMappingService{

    UrlResponseDto createShortUrl(
            UrlRequestDto request);

    UrlResponseDto getUrl(String code);
}
