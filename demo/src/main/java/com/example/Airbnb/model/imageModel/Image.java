package com.example.Airbnb.model.imageModel;
import com.example.Airbnb.model.userModel.User;
import com.example.Airbnb.model.listingModel.Listing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private long id;

    private String name;
    private String type;

    @Column(length = 100000000, columnDefinition = "mediumblob")
    private byte[] picByte;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id", nullable = true)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="listing_id", nullable = true)
    private Listing listing;




    public Image() {
    }

    public Image(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
}
