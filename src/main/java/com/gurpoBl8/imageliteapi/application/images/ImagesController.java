package com.gurpoBl8.imageliteapi.application.images;

import com.gurpoBl8.imageliteapi.ImageliteapiApplication;
import com.gurpoBl8.imageliteapi.domain.entity.Image;
import com.gurpoBl8.imageliteapi.domain.enums.ImageExtension;
import com.gurpoBl8.imageliteapi.domain.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/images")
@Slf4j
@RequiredArgsConstructor
public class ImagesController {
    private final ImageService imageService;
    private final ImagesMapper imagesMapper;

    @PostMapping
    public ResponseEntity<Image> save(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags")List<String> tags
            ) throws IOException {

        log.info("Imagem recebida: name:{}, size:{}", file.getOriginalFilename(), file.getSize());

       Image image = imagesMapper.mapToimage(file,name,tags);
       Image savedImage = imageService.save(image);

       URI imageURI = buidImageURI(savedImage);

       return ResponseEntity.created(imageURI).build();
    }

    private URI buidImageURI(Image image){
        String imagePaht = "/" + image.getId();
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(imagePaht)
                .build().toUri();
    }
}
