package com.gurpoBl8.imageliteapi.domain.service;

import com.gurpoBl8.imageliteapi.domain.entity.Image;
import org.springframework.stereotype.Service;

@Service
public interface ImageService {
    Image save(Image image);
}
