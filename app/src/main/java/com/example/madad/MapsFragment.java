package com.example.madad;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    float lat,lon;
    String marker;
    SharedPreferences prefs;


    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng location = new LatLng(23.3753, 85.311);
            googleMap.addMarker(new MarkerOptions().position(location).title(marker));
            float zoomLevel = 12.0f;
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, zoomLevel));
            googleMap.getUiSettings().setAllGesturesEnabled(false);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=   inflater.inflate(R.layout.fragment_maps, container, false);

        prefs = getActivity().getSharedPreferences("Map", Context.MODE_PRIVATE);
        lat = prefs.getFloat("lat", (float) 23.3753);
        lon = prefs.getFloat("lon", (float) 85.311);
        marker = prefs.getString("marker","");


        return  view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}