package com.example.Airbnb.util.Recommender;

import com.example.Airbnb.repository.ListingRepository;
import com.example.Airbnb.repository.ReviewRepository;
import com.example.Airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatrixFactorization {

    // -- Properties --

    private UserListingRatingsTable ratings;
    private SvdResult svd;
    // Den xreiazetai! private IRater rater;

    private int numUsers;
    private int numListings;

    private int numFeatures;
    private int learningIterations;

    // -- For DB --
    @Autowired
    UserRepository userRepository;
    @Autowired
    ListingRepository listingRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserBehaviorTransformer userBehaviorTransformer;

    // -- Constructors --

    public MatrixFactorization(){
        this(20);
    }

    public MatrixFactorization(int features){
        numFeatures=features;
        learningIterations=100;
    }


    // -- Functions --
    public void Train(){
        ratings = userBehaviorTransformer.getUserListingRatingsTable();

        SingularValueDecomposition factorizer = new SingularValueDecomposition(numFeatures, learningIterations);
        svd = factorizer.factorizeMatrix(ratings);

        numUsers= ratings.userIndexToId.size();
        numListings= ratings.listingIndexToId.size();

        //System.out.println(numUsers + " " + numListings);
    }



}
