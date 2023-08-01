package com.example.Airbnb.model.messageModel;
import com.example.Airbnb.model.userModel.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.Airbnb.model.listingModel.Listing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id", nullable = false)
    private long id;

    private String text;

    @CreationTimestamp
    private Date sendDate;

    private boolean seen;

    private boolean way;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="listing_id", nullable = false)
    private Listing listing;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id", nullable = false)
    private User guest;


    public Message(){
    }
}
