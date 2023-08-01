package com.example.Airbnb.service;

import com.example.Airbnb.model.bookingModel.BookingDto;
import com.example.Airbnb.model.bookingModel.BookingPost;

import java.util.List;

public interface BookingService {

    BookingDto findById(Long id) throws Exception;
    List<BookingDto> findAll();
    List<BookingDto> returnMyBookings(long id);
    List<BookingDto> returnListingBookings(long id);

    List<BookingDto> newBooking(BookingPost bookingPost);
    BookingDto save(BookingDto bookingDto);

    void deleteById(Long id);
}
