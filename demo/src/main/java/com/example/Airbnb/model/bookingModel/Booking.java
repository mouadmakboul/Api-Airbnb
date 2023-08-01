package com.example.Airbnb.model.bookingModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.Airbnb.model.userModel.User;
import com.example.Airbnb.model.listingModel.Listing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
// c est l entite d une reservation liée a chaque utilisateur


import java.util.Date;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //jackson
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private long id;

    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="listing_id", nullable = false)
    private Listing listing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id", nullable = false)
    private User user;




    public Booking() {
    }
}