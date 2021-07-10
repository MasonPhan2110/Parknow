package com.example.parknow.extend;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Region;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.example.parknow.R;
import com.google.android.libraries.places.api.model.Place;
import com.google.maps.DirectionsApi;
import com.google.maps.FindPlaceFromTextRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.FindPlaceFromText;
import com.google.maps.model.GeocodedWaypoint;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.RankBy;

import org.intellij.lang.annotations.Language;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

public class NearbySearch {
    Context mcontext;

    public NearbySearch(Context mcontext) {
        this.mcontext = mcontext;

    }

    public PlacesSearchResponse run(LatLng location) {

        PlacesSearchResponse request = new PlacesSearchResponse();
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(mcontext.getResources().getString(R.string.google_maps_key))
                .build();
        try {
            request = PlacesApi.nearbySearchQuery(context, location)
                    .radius(12000)
                    .keyword("Bãi đỗ xe")
                    .language("vi")
                    .type(PlaceType.PARKING)
                    .await();
        } catch (ApiException | IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            return request;
        }
    }

    public List<GeocodingResult> getLatlng(String address) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(mcontext.getResources().getString(R.string.google_maps_key))
                .build();
        List<GeocodingResult> result = new ArrayList<>();
        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, address)
                    .language("vi")
                    .await();
            for (int i = 0; i < results.length; i++) {
                result.add(results[i]);
            }
        } catch (ApiException | IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    public PlaceDetails name(String placeID) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(mcontext.getResources().getString(R.string.google_maps_key))
                .build();
        PlaceDetails placeDetails = null;
        try {
            placeDetails = PlacesApi.placeDetails(context, placeID).language("vi").await();
        } catch (ApiException | IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            return placeDetails;
        }
    }
}
