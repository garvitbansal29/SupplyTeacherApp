package com.example.supplyteacherapp;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;

import java.io.IOException;

public class DistanceCalculator {

//    private static final GeoApiContext distCalcer = new GeoApiContext.setApiKey("AIzaSyCa_ypXvwRIal-mCdCJtztYO-DyvuXSc-U");
//    private static final GeoApiContext context = new GeoApiContext().setApiKey();

//    private static final String Api_Key = "AIzaSyCa_ypXvwRIal-mCdCJtztYO-DyvuXSc-U";
//    private static final GeoApiContext context = new GeoApiContext().setApiKey(Api_Key);

     GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyCU-cOACPpn6q_pc0NZok-HVCcLN3rZ6tw")
            .build();



    public  double getDrivingDist(String postcode1, String postcode2) throws ApiException, IOException,InterruptedException
    {

        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);
        DistanceMatrix result = req.origins(postcode1)
                .destinations(postcode2)
                .mode(TravelMode.DRIVING)
                .language("en-US")
                .await();

        double distApart = result.rows[0].elements[0].distance.inMeters;

        distApart = getMiles(distApart);
        return distApart;

    }
    private double getMiles (double distanceInMeters)
    {
        return distanceInMeters*0.000621371192;
    }
}
