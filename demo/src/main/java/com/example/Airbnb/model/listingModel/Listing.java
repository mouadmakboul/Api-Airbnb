package com.example.Airbnb.model.listingModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.Airbnb.model.userModel.User;
import com.example.Airbnb.model.bookingModel.Booking;
import com.example.Airbnb.model.imageModel.Image;
import com.example.Airbnb.model.reviewModel.Review;
import com.example.Airbnb.model.messageModel.Message;
//l'annonce


import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listing_id", nullable = false)
    private long id;
    private String title;

    // -- Space --
    @Enumerated(EnumType.STRING)
    private RoomType type;
    private int numOfBeds;
    private int numOfWc;
    private int numOfRooms;
    private boolean livingRoom;
    private double squareFootage;

    @Column(length = 2048)
    private String description;

    // -- Rules --
    private boolean smoking;
    private boolean animals;
    private boolean parties;
    private int minRentDays;
    private int maxGuests;

    // -- Location --
    private double latitude;
    private double longitude;
    private String country;
    private String city;
    private String neighborhood;
    private String address;
    private String postalCode;
    @Column(length = 2048)
    private String transportation;

    // -- Cost --
    private double minCost;
    private double costPerExtraGuest;

    // -- Facilities --
    private boolean wifi;
    private boolean ac;
    private boolean heating;
    private boolean kitchen;
    private boolean tv;
    private boolean parking;
    private boolean elevator;

    // -- Availability Days --
    private Date startDate;
    private Date endDate;

    // -- Reviews --
    private int numOfReviews;
    private double averageRating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id", nullable = false)
    private User host;

    @OneToMany(mappedBy = "listing", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    @OneToMany(mappedBy = "listing", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "listing" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Image> images;

    @OneToMany(mappedBy = "listing" ,fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Message> messages;





    public Listing() {

    }

}