package com.example.parknow.extend;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.location.Address;
import android.location.Geocoder;

import com.example.parknow.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GetDistance {
    LatLng latLngend;
    Context mcontext;
    public GetDistance(LatLng latLngend,Context mcontext){
        this.latLngend = latLngend;
        this.mcontext = mcontext;
    }
    public List<Address> run() {
        Geocoder geocoder = new Geocoder(mcontext, Locale.getDefault());
        List<Address> list = null;
        try {
            list = geocoder.getFromLocation(latLngend.latitude,latLngend.longitude,1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
