package com.example.supplyteacherapp;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.TravelMode;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DistanceMatrix {

    private static final GeoApiContext distCalcer = new GeoApiContext.setApiKey("AIzaSyCa_ypXvwRIal-mCdCJtztYO-DyvuXSc-U");
//    private static final GeoApiContext context = new GeoApiContext().setApiKey();

    private static final String Api_Key = "AIzaSyCa_ypXvwRIal-mCdCJtztYO-DyvuXSc-U";
    private static final GeoApiContext context = new GeoApiContext().setApiKey(Api_Key);

}
