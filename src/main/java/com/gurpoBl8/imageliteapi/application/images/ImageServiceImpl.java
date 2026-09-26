package com.gurpoBl8.imageliteapi.application.images;

import com.gurpoBl8.imageliteapi.domain.entity.Image;
import com.gurpoBl8.imageliteapi.domain.service.ImageService;
import com.gurpoBl8.imageliteapi.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    @Transactional
    public Image save(Image image) {
        return imageRepository.save(image);
    }
}
