package com.psharma.demolocationsort.ui.adaptors;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.psharma.demolocationsort.R;
import com.psharma.demolocationsort.api.servicemanager.model.Datum;
import com.psharma.demolocationsort.api.servicemanager.model.PlaceInformation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import customvolley.MobHttpVolley;

/**
 * Created by Punit Sharma on 10/1/2015.
 * MobiquityInc
 */
public class PlaceInfoAdapter extends BaseAdapter {

    private List<Datum> mPlaceList;
    private Context mContext;
    private LayoutInflater mInflator;


    public PlaceInfoAdapter(Context context, List<Datum> PlaceList) {
        mInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;
        mPlaceList = PlaceList;
    }

    @Override
    public int getCount() {
        return mPlaceList.size();
    }

    @Override
    public Object getItem(int i) {
        return mPlaceList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        // General ListView optimization code.
        if (view == null) {
            view = mInflator.inflate(R.layout.listitem_place, null);
            viewHolder = new ViewHolder();
            viewHolder.mPlaceTitle = (TextView) view.findViewById(R.id.place_title);
            viewHolder.mPlaceOffer = (TextView) view.findViewById(R.id.place_offers);
            viewHolder.mPlacefoodtype = (TextView) view.findViewById(R.id.foodtype_text);
            viewHolder.mPlaceDistance = (TextView) view.findViewById(R.id.distance);
            viewHolder.mPlaceImage = (NetworkImageView) view.findViewById(R.id.place_image);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        if (mPlaceList.get(i).getOutletName() != null) {
            viewHolder.mPlaceTitle.setText(mPlaceList.get(i).getOutletName());
        }

        viewHolder.mPlaceOffer.setText(mPlaceList.get(i).getNumCoupons() + " " + "Offers");

        if (mPlaceList.get(i).getCategories() != null) {
            StringBuffer foodOption = new StringBuffer("Cuisine: ");

            for (int j = 0; j < mPlaceList.get(i).getCategories().size() - 1; j++) {
                if (mPlaceList.get(i).getCategories().get(j).getCategoryType().equalsIgnoreCase("Cuisine")) {
                    foodOption = foodOption.append(" "+ mPlaceList.get(i).getCategories().get(j).getName()+",");
                }
            }
            viewHolder.mPlacefoodtype.setText(foodOption);
        }


        viewHolder.mPlaceDistance.setText(new DecimalFormat("##.##").format(mPlaceList.get(i).getDistance())+" "+"Km");

        if (mPlaceList.get(i).getLogoURL() != null) {
            viewHolder.mPlaceImage.setImageUrl(mPlaceList.get(i).getLogoURL(), MobHttpVolley.getImageLoader(mContext));
        }

        return view;
    }


    static class ViewHolder {

        TextView mPlaceTitle, mPlaceOffer, mPlacefoodtype, mPlaceDistance;
        NetworkImageView mPlaceImage;
    }


    public void notifyDataSetChanged(List<Datum> PlaceList) {
        if (PlaceList != null) {
            mPlaceList = PlaceList;
        }
        notifyDataSetChanged();
    }
}
