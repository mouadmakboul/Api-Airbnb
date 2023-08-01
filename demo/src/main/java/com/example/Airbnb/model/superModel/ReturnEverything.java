package com.example.Airbnb.model.superModel;

import com.example.Airbnb.model.userModel.UserPostDto;
import com.example.Airbnb.model.listingModel.ListingDto;
import com.example.Airbnb.model.bookingModel.BookingDto;
import com.example.Airbnb.model.reviewModel.ReviewDto;
import com.example.Airbnb.model.messageModel.MessageDto;
import com.example.Airbnb.model.imageModel.ImageDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReturnEverything {
    List<UserPostDto> usersList;
    List<ListingDto> listingsList;
    List<BookingDto> bookingsList;
    List<ReviewDto> reviewsList;
    List<MessageDto> messagesList;
    List<ImageDto> imagesList;
}
