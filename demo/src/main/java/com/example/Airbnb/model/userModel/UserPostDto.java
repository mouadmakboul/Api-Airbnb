package com.example.Airbnb.model.userModel;

import com.example.Airbnb.model.listingModel.ListingDto;
import com.example.Airbnb.model.reviewModel.ReviewDto;
import com.example.Airbnb.model.bookingModel.BookingDto;
import com.example.Airbnb.model.imageModel.ImageDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotEmpty;


import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserPostDto {
    private long id;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    private Set<Role> roles;
    private Boolean approved;

    private String firstName;
    private String lastName;
    private String email;
    private String number;

    private Date userSince;

    private ImageDto image;

    private List<ListingDto> myListings;
    private List<ReviewDto> reviews;
    private List<BookingDto> bookings;

}
