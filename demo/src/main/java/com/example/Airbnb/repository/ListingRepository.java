package com.example.Airbnb.repository;

import com.example.Airbnb.model.listingModel.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findAllByHostId(Long id);
    List<Listing> findAllByCountryAndCityAndStartDateBeforeAndEndDateAfterAndMaxGuestsIsGreaterThanEqualOrderByMinCost(String country, String city, Date startDate, Date endDate, int guests);
}
