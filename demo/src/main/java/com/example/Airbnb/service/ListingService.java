package com.example.Airbnb.service;

import com.example.Airbnb.model.listingModel.Listing;
import com.example.Airbnb.model.listingModel.ListingDto;
import com.example.Airbnb.model.listingModel.ListingParameters;

import java.util.Date;
import java.util.List;

public interface ListingService {

    ListingDto findDtoById(Long id) throws Exception;
    List<ListingDto> findAll();
    List<ListingDto> findByHost(Long id);
    List<Listing> findWithParametersBasic(String country, String city, Date startDate, Date endDate, int guests);
    List<ListingDto> findWithParameters(ListingParameters listingParameters);

    Listing findById(Long id);
    ListingDto save(ListingDto listingDto) throws Exception;

    void deleteById(Long id);
}
