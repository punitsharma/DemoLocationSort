package com.psharma.demolocationsort.api.servicemanager;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.psharma.demolocationsort.api.apilistener.DataLoadListener;
import com.psharma.demolocationsort.api.servicemanager.apiservices.PlaceInformationServices;
import com.psharma.demolocationsort.api.servicemanager.model.PlaceInformation;

import javax.net.ssl.SSLContext;

import customvolley.JacksonObjectRequest;
import customvolley.MobHttpVolley;
import customvolley.ParseCacheHeaders;

/**
 * Created by Punit Sharma on 8/26/2015.
 * MobiquityInc
 */
public class PlaceInformationServiceImpl implements PlaceInformationServices {

    private static final String TAG = "PlaceInformationServiceImpl";
    private static SSLContext mSslContext;
    private String baseUrl;
    private Context mContext;


    public PlaceInformationServiceImpl(String baseUrl, final Context mContext) {
        this.baseUrl = baseUrl;
        this.mContext = mContext;
    }


    @Override
    public void getPlaceInformation(final DataLoadListener listener, ParseCacheHeaders parseCacheHeaders) {
        MobHttpVolley.getInstance(mContext, getSslContext()).addToRequestQueue(new JacksonObjectRequest<PlaceInformation>(mContext, baseUrl, "", PlaceInformation.class, null, new Response.Listener<PlaceInformation>() {
            @Override
            public void onResponse(PlaceInformation response) {

                listener.onDataLoad(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error);
            }
        }, null));
    }

    private SSLContext getSslContext() {
        return mSslContext;
    }
}
