package com.example.Airbnb.service;

import com.example.Airbnb.converter.ImageConverter;
import com.example.Airbnb.converter.UserPostConverter;
import com.example.Airbnb.model.superModel.ReturnEverything;
import com.example.Airbnb.repository.ImageRepository;
import com.example.Airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SuperServiceImpl implements com.uoa.AirBnB.service.SuperService {
    @Autowired
    BookingService bookingService;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ListingService listingService;
    @Autowired
    MessageService messageService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    UserRepository userRepository;


    @Override
    public ReturnEverything returnEverything() {
        ReturnEverything returnEverything = new ReturnEverything();

        returnEverything.setUsersList(userRepository.findAll()
                .stream()
                .map(UserPostConverter::convertToDto)
                .collect(Collectors.toList()));

        returnEverything.setListingsList(listingService.findAll());
        returnEverything.setBookingsList(bookingService.findAll());
        returnEverything.setReviewsList(reviewService.findAll());
        returnEverything.setMessagesList(messageService.findAll());
        returnEverything.setImagesList(imageRepository.findAll().stream()
                .map(ImageConverter::convertToDto)
                .collect(Collectors.toList()));

        return returnEverything;
    }
}
