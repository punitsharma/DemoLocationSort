package com.psharma.demolocationsort.ui.activities;

import android.location.Location;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.psharma.demolocationsort.api.servicemanager.model.Datum;

import java.util.Comparator;

/**
 * Created by punitsharma on 12/2/15.
 */
public class SortPlaces implements Comparator<Datum> {

    double mLatitude, mLongitude;

    public SortPlaces(double latitude, double longitude) {
        mLatitude = latitude;
        mLongitude = longitude;
    }

    @Override
    public int compare(final Datum place1, final Datum place2) {
        double lat1 = Double.parseDouble(place1.getLatitude());
        double lon1 = Double.parseDouble(place1.getLongitude());
        double lat2 = Double.parseDouble(place2.getLatitude());
        double lon2 = Double.parseDouble(place2.getLongitude());

        Location mylocation = new Location("MyLocation");

        mylocation.setLatitude(mLatitude);
        mylocation.setLongitude(mLongitude);

        Location locationOne = new Location("place1");

        locationOne.setLatitude(lat1);
        locationOne.setLongitude(lon1);

        Location locationTwo = new Location("place2");

        locationTwo.setLatitude(lat2);
        locationTwo.setLongitude(lon2);

        float distanceToPlace1 = mylocation.distanceTo(locationOne);
        place1.setDistance(((double) distanceToPlace1)/1000);
        float distanceToPlace2 = mylocation.distanceTo(locationTwo);
        place2.setDistance(((double) distanceToPlace2)/1000);



        return (int) (distanceToPlace1 - distanceToPlace2);
    }
}