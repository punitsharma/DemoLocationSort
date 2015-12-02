package com.psharma.demolocationsort.api.servicemanager;

import android.content.Context;
import android.content.SharedPreferences;
import com.psharma.demolocationsort.api.servicemanager.apiservices.PlaceInformationServices;

import javax.net.ssl.SSLContext;


/**
 * Created by Punit Sharma on 6/4/2015.
 * MobiquityInc
 * Manager level class ,All calls to api must be redirected through its instance
 */
public class ApiManager {

    private static ApiManager instance;
    private static Context mContext;
    private SSLContext sslContext;
    private PlaceInformationServices placeService;

    private ApiManager(String baseUrl, final Context mContext) {

        this.mContext = mContext;
        setMobBaseUrl(mContext, baseUrl);
        placeService = new PlaceInformationServiceImpl(baseUrl,mContext);
    }


  public static ApiManager getInstance() {
        return instance;
    }

    public static void demoInitializer(String baseUrl, final Context mContext) {
        instance = new ApiManager(baseUrl, mContext);
    }

    public PlaceInformationServices getPlaceServices() {
        return placeService;
    }

    public static void setMobBaseUrl(Context ctx, String URL) {
        SharedPreferences prefs = ctx.getSharedPreferences("URL", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("BASE_URL", URL);
        editor.apply();
    }

    public static String getMobBaseUrl(Context ctx) {
        SharedPreferences pref = ctx.getSharedPreferences("URL", Context.MODE_PRIVATE);
        return pref.getString("BASE_URL", null);
    }
}
