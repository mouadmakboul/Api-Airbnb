package com.example.Airbnb.service;

import com.example.Airbnb.model.imageModel.Image;
import com.example.Airbnb.model.imageModel.ImageDto;

import java.util.Optional;

public interface ImageService {
    ImageDto uploadImage(ImageDto imageDto);
    ImageDto findByName(String imageName) throws Exception;
    ImageDto findDtoById(Long id) throws Exception;
    Optional<Image> findByUserId(Long id);
    Image findById(Long id) throws Exception;
    void deleteById(Long id);
}
