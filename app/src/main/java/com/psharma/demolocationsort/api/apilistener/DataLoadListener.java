package com.psharma.demolocationsort.api.apilistener;

/**
 * Created by Punit Sharma on 6/4/2015.
 * MobiquityInc
 */
public interface DataLoadListener<T, U> {
    void onDataLoad(T result);
    void onError(U errorMessage);
}
