package com.psharma.demolocationsort.api.servicemanager.apiservices;

import com.psharma.demolocationsort.api.apilistener.DataLoadListener;

import customvolley.ParseCacheHeaders;

/**
 * Created by Punit Sharma on 8/26/2015.
 * MobiquityInc
 */
public interface PlaceInformationServices {

    void getPlaceInformation(final DataLoadListener listener, ParseCacheHeaders parseCacheHeaders);


}
