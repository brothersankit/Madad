package com.example.madad;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private Button buttonHotel, buttonHospital, buttonMarket;
    float longitude, latitude;

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private Marker mMarker;
    private LocationRequest mLocationRequest;
    GoogleApiService mGoogleApiService;
    private static final int LOCATION_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragment_main);
            mapFragment.getMapAsync(this);


        //latitude = getIntent().getFloatExtra("lat", 0);
        //longitude = getIntent().getFloatExtra("lon", 0);


       // SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        //        .findFragmentById(R.id.map_activity);
        // mapFragment.getMapAsync(this);

        // Init service

        //mGoogleApiService = Common.getGoogleApiService();
            mGoogleApiService=Common.getGoogleApiService();
        nearbyPlaces("atm");

        // Request runtime permission
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            checkLocationPermission();
//        }

       /* buttonHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nearbyPlaces("restaurant");
                Toast.makeText(MapsActivity.this, "Searching for nearby Restaurants", Toast.LENGTH_SHORT).show();
            }
        });
        buttonHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nearbyPlaces("hospital");
                Toast.makeText(MapsActivity.this, "Searching for nearby Hospitals", Toast.LENGTH_SHORT).show();
            }
        });
        buttonMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nearbyPlaces("school");
                Toast.makeText(MapsActivity.this, "Searching for nearby Schools", Toast.LENGTH_SHORT).show();
            }
        });  */
        FindLocation();
    }

private synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
        .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .addApi(LocationServices.API)
        .build();
        mGoogleApiClient.connect();

        }

public void FindLocation() {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        boolean network_enabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        Location location;

        if (network_enabled) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        // TODO: Consider calling
        //    ActivityCompat#requestPermissions
        // here to request the missing permissions, and then overriding
        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
        //                                          int[] grantResults)
        // to handle the case where the user grants the permission. See the documentation
        // for ActivityCompat#requestPermissions for more details.
        return;
        }
        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (location != null) {
        mLastLocation = location;
//                longitude = location.getLongitude();
//                latitude = location.getLatitude();
//                Toast.makeText(
//                        getApplicationContext(),
//                        String.valueOf(location.getLatitude()) + "\n" + String.valueOf(location.getLongitude()), Toast.LENGTH_SHORT)
//                        .show();
        }
        }
        }
private void nearbyPlaces(final String placeType) {
        //mMap.clear();

        String url = getUrl(22.8053, 86.2738, placeType);

        mGoogleApiService.getNearByPlaces(url)
        .enqueue(new Callback<MyPlaces>() {
@Override
public void onResponse(Call<MyPlaces> call, Response<MyPlaces> response) {
        if (response.isSuccessful()) {
        for (int i = 0; i < response.body().getResults().size(); i++) {
        MarkerOptions markerOptions = new MarkerOptions();
        Result googlePlace = response.body().getResults().get(i);
        System.out.println(response.body());
        double lat = Double.parseDouble(googlePlace.getGeometry().getLocation().getLat());
        double lng = Double.parseDouble(googlePlace.getGeometry().getLocation().getLng());
        String placeName = googlePlace.getName();
        String vicinity = googlePlace.getVicinity();
        LatLng latLng = new LatLng(lat, lng);
        markerOptions.position(latLng);
        markerOptions.title(placeName);
        if (placeType.equals("hospital")) {
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        } else if (placeType.equals("atm")) {
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        } else if (placeType.equals("restaurant")) {
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        } else {
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        }
        // add marker to map
        mMap.addMarker(markerOptions);
        // move camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        }
        }
        }

@Override
public void onFailure(Call<MyPlaces> call, Throwable t) {

        }
        });
        }

/*private String getUrl(double latitude, double longitude, String placeType) {
        StringBuilder builder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        builder.append("location=" + latitude + "," + longitude);
        builder.append("&radius=1500");
        builder.append("&type="+placeType);
        builder.append("&key=AIzaSyAfJZfYTph71lkW3w_Ri6NYPPdmabUUdtk");
        Log.d("APIURL", builder.toString());
        return builder.toString();
        }*/
private String getUrl(double latitude, double longitude, String placeType) {
        StringBuilder builder = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        builder.append("location=" + latitude + "," + longitude);
        builder.append("&radius=1500");
        builder.append("&type="+placeType);
        builder.append("&key=" + getResources().getString(R.string.google_maps_key));
        Log.d("APIURL", builder.toString());
        return builder.toString();
}

@Override
public void onLocationChanged(Location location) {
        mLastLocation = location;
        if (mMarker != null) {
        mMarker.remove();
        }

//        latitude = location.getLatitude();
//        longitude = location.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        MarkerOptions options = new MarkerOptions()
        .position(latLng)
        .title("Your position")
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mMarker = mMap.addMarker(options);

        // move camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        if (mGoogleApiClient != null) {
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, (com.google.android.gms.location.LocationListener) this);
        }
        }

@Override
public void onStatusChanged(String provider, int status, Bundle extras) {

        }

@Override
public void onProviderEnabled(String provider) {

        }

@Override
public void onProviderDisabled(String provider) {

        }

@Override
public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, (com.google.android.gms.location.LocationListener) this);
        }
        }

@Override
public void onConnectionSuspended(int i) {

        }

@Override
public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        }

@Override
public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        onLocationChanged(mLastLocation);
        float zoomLevel = 12.0f;
        LatLng location = new LatLng(23.3753, 85.311);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, zoomLevel));

//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        buildGoogleApiClient();
        mMap.setMyLocationEnabled(true);
        }
        } else {
        buildGoogleApiClient();
        mMap.setMyLocationEnabled(true);
        }
        }
@Override
protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null)
        mGoogleApiClient.connect();
        }

@Override
protected void onStop() {
//        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, (com.google.android.gms.location.LocationListener) this);
        if (mGoogleApiClient != null)
        mGoogleApiClient.disconnect();
        super.onStop();
        }

@Override
public void onBackPressed() {
        super.onBackPressed();
        }
        }
