package com.psharma.demolocationsort.ui.activities;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.psharma.demolocationsort.R;
import com.psharma.demolocationsort.api.apilistener.DataLoadListener;
import com.psharma.demolocationsort.api.servicemanager.ApiManager;
import com.psharma.demolocationsort.api.servicemanager.model.Datum;
import com.psharma.demolocationsort.api.servicemanager.model.PlaceInformation;
import com.psharma.demolocationsort.ui.AppConstant;
import com.psharma.demolocationsort.ui.adaptors.PlaceInfoAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider;

public class MainActivity extends BaseActivity {

    PlaceInfoAdapter mAdapter;
    List<Datum> mPlaceDatalist;
    Location mMyLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null) {
            mMyLocation = getIntent().getParcelableExtra(AppConstant.LOCATION);
        }
        mPlaceDatalist = new ArrayList<>();
        mAdapter = new PlaceInfoAdapter(this, mPlaceDatalist);
        setListAdapter(mAdapter);
        showProgresDialog();
        getPlaceInformation();
    }

    private void getPlaceInformation() {
        ApiManager.getInstance().getPlaceServices().getPlaceInformation(new DataLoadListener<PlaceInformation, VolleyError>() {
            @Override
            public void onDataLoad(PlaceInformation result) {
                dismissProgresDialog();

                ArrayList<Datum> places = (ArrayList<Datum>) result.getData();

                for (Datum p: places){
                    Log.i("Places before sorting", "Place: " + p.getOutletName());
                }

                //sort the list, give the Comparator the current location
                Collections.sort(places, new SortPlaces(mMyLocation.getLatitude(),mMyLocation.getLongitude()));

                for (Datum p: places){
                    Log.i("Places after sorting", "Place: " + p.getOutletName());
                }


                mAdapter.notifyDataSetChanged(places);
            }

            @Override
            public void onError(VolleyError errorMessage) {
                Toast.makeText(getApplicationContext(), errorMessage.getMessage(), Toast.LENGTH_LONG).show();
            }
        }, null);

    }
}
