package com.example.Airbnb.model.reviewModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.Airbnb.model.listingModel.Listing;
import com.example.Airbnb.model.userModel.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private long id;

    private String comment;

    @CreationTimestamp
    private Date date;

    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="listing_id", nullable = false)
    private Listing listing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id", nullable = false)
    private User user;

    public Review(){
    }
}
