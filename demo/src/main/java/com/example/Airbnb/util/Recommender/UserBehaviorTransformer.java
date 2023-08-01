package com.example.Airbnb.util.Recommender;

import com.example.Airbnb.model.listingModel.Listing;
import com.example.Airbnb.model.reviewModel.Review;
import com.example.Airbnb.model.userModel.User;
import com.example.Airbnb.repository.ListingRepository;
import com.example.Airbnb.repository.ReviewRepository;
import com.example.Airbnb.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Data
public class UserBehaviorTransformer {

    // -- For DB --
    @Autowired
    UserRepository userRepository;
    @Autowired
    ListingRepository listingRepository;
    @Autowired
    ReviewRepository reviewRepository;

    public UserBehaviorTransformer(){}

    public UserListingRatingsTable getUserListingRatingsTable(){
        UserListingRatingsTable table = new UserListingRatingsTable();

        table.userIndexToId = userRepository.findAll().stream().map(User::getId).collect(Collectors.toList());
        table.listingIndexToId = listingRepository.findAll().stream().map(Listing::getId).collect(Collectors.toList());

        for (Long userId : table.userIndexToId) {
            table.users.add(new UserListingRatings(userId, table.listingIndexToId.size()));
        }

        List<Review> reviewList = reviewRepository.findAll();

        for (Review review : reviewList) {
            int userIndex = table.userIndexToId.indexOf(review.getUser().getId());
            int listingIndex = table.listingIndexToId.indexOf(review.getListing().getId());

            table.users.get(userIndex).listingRatings[listingIndex] = Double.valueOf(review.getRating());
        }

        return table;
    }

}
