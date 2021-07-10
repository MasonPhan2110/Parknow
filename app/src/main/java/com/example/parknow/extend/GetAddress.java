package com.example.parknow.extend;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import com.example.parknow.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.RankBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetAddress {
    LatLng latLng;
    Context mcontext;
    public GetAddress(LatLng latLng,Context mcontext){
        this.latLng = latLng;
        this.mcontext = mcontext;
    }
    public List<Address> run(){
        Geocoder geocoder = new Geocoder(mcontext, Locale.getDefault());
        List<Address> list = new ArrayList<>();
        try {
            list = geocoder.getFromLocation(latLng.latitude,latLng.longitude,1);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return list;
        }
    }
}
