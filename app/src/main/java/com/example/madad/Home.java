package com.example.madad;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Home extends AppCompatActivity {
    ImageButton atm;
    //ImageButton em;
    //ImageButton res;
    //ImageButton ho;
    //ImageButton sc;
    //ImageButton co;
    //ImageButton mai;
    //ImageButton cine;
    ImageButton feed;
    ImageButton SignOut;
    GoogleSignInClient mGoogleSignInClient;

    //CardView atm;
    CardView em;
    CardView res;
    CardView ho;
    CardView sc;
    CardView co;
    CardView mai;
    CardView cine;
    CardView covid;
    CardView trans;
    CardView park;
    CardView gym;
    CardView market;
   // CardView feed;
    CardView hote;
    Button pop;

    private FusedLocationProviderClient mFusedLocationClient;
    LocationManager lm;
    LocationManager locationManager;
    private LocationListener locationListener;
    private double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (ContextCompat.checkSelfPermission(Home.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Home.this, new String[]{ Manifest.permission.ACCESS_FINE_LOCATION }, 100); }



        locationService();

        if (latitude != 0 && longitude != 0) {

            getAddress();

        }



       /* sc = (ImageButton)findViewById(R.id.school);

        sc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, School.class);
                startActivity(i);
            }
        });  */

        /* co = (ImageButton)findViewById(R.id.college);

        co.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, College.class);
                startActivity(i);
            }
        });  */

        /* ho = (ImageButton)findViewById(R.id.hospital);

        ho.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Hospital.class);
                startActivity(i);
            }
        });  */

        /* res = (ImageButton)findViewById(R.id.restaurant);

        res.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Restaurant.class);
                startActivity(i);
            }
        });  */

       /* em = (ImageButton)findViewById(R.id.emergence);

        em.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Emergency.class);
                startActivity(i);
            }
        });  */

        atm = (ImageButton)findViewById(R.id.atm);

        atm.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, MapsActivity.class);
                startActivity(i);
            }
        });

        /* mai = (ImageButton)findViewById(R.id.maintain);

        mai.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Maintainance.class);
                startActivity(i);
            }
        }); */

        /* cine = (ImageButton)findViewById(R.id.cinema);

        cine.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Cinema.class);
                startActivity(i);
            }
        });  */

        feed=(ImageButton)findViewById((R.id.imageView3));
        feed.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String phonexyz= getIntent().getStringExtra("phonexyz");
                String namexyz= getIntent().getStringExtra("namexyz");
                Intent i = new Intent (Home.this, Feed.class);
                i.putExtra("phonexyz",phonexyz);
                i.putExtra("namexyz",namexyz);
                startActivity(i);
            }
        });
        SignOut = (ImageButton)findViewById(R.id.SignOut);
        SignOut.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                signOut();

            }
        });




        pop = (Button)findViewById(R.id.pop);

        pop.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, pop.class);
                startActivity(i);
            }
        });

        ho = (CardView) findViewById(R.id.hotel);

        ho.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Hotel.class);
                startActivity(i);
            }
        });

        sc = (CardView)findViewById(R.id.school);

        sc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, School.class);
                startActivity(i);
            }
        });

        cine = (CardView)findViewById(R.id.cinema);

        cine.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Cinema.class);
                startActivity(i);
            }
        });

        co = (CardView)findViewById(R.id.college);

        co.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, College.class);
                startActivity(i);
            }
        });

        ho = (CardView)findViewById(R.id.hospital);

        ho.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Hospital.class);
                startActivity(i);
            }
        });

        res = (CardView)findViewById(R.id.restaurant);

        res.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Restaurant.class);
                startActivity(i);
            }
        });



        trans = (CardView)findViewById(R.id.trans);

        trans.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Transportation.class);
                startActivity(i);
            }
        });

        park = (CardView)findViewById(R.id.park);

        park.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Park.class);
                startActivity(i);
            }
        });

        gym = (CardView)findViewById(R.id.gym);

        gym.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Gym.class);
                startActivity(i);
            }
        });

        market = (CardView) findViewById(R.id.vendor);

        market.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Market.class);
                startActivity(i);
            }
        });

        mai = (CardView) findViewById(R.id.maintain);

        mai.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent (Home.this, Maintainance.class);
                startActivity(i);
            }
        });



    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                    }
                });
    }

    private void locationService() {
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

    if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER) || lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
        // progressDialog = new ProgressDialog(this);// progressDialog.setMessage("Please wait while fetching data from GPS .......");
        // progressDialog.setCancelable(false);// progressDialog.show();
         locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
         locationListener = new Home.MyLocationListener();
         if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { } mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
         mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
             @Override public void onSuccess(Location location) {
                 if (location != null) {
                     latitude = location.getLatitude();
         longitude = location.getLongitude();
        // textViewLatitude.setText(String.valueOf(lat));
        // textViewLongitude.setText(String.valueOf(lng));
         getAddress(); } else { if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) { if (ActivityCompat.checkSelfPermission(Home.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Home.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { return; } locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
         } else if (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) { locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 10, locationListener); } } } }); } else {
        //checkGpsStatus();
        Toast.makeText(Home.this, "GPS off", Toast.LENGTH_SHORT).show(); } }




    private class MyLocationListener implements LocationListener {
        @Override public void onLocationChanged(Location loc) {
            latitude = loc.getLatitude();
            longitude = loc.getLongitude();
        } @Override public void onProviderDisabled(String provider) { }
        @Override public void onProviderEnabled(String provider) { }
        @Override public void onStatusChanged(String provider, int status, Bundle extras) { } }




    private void getAddress() {
        String city = null;
        String address = null;
        String subCity = null;
        String postalCode = null;
        String division = null;
        String country = null;
        String countryCode = null;
        Geocoder gcd = new Geocoder(Home.this, Locale.getDefault());
        List<Address> addresses; try { addresses = gcd.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                city = addresses.get(0).getLocality();
                address = addresses.get(0).getSubAdminArea();
                subCity = addresses.get(0).getSubLocality();
                postalCode = addresses.get(0).getPostalCode();
                division = addresses.get(0).getAdminArea();
                country = addresses.get(0).getCountryName();
                countryCode = addresses.get(0).getCountryCode();
                //textView.setText("You are in " + address); Toast.LENGTH_SHORT).show(); Log.d("LocationFragment", addresses.get(0).toString());
            } } catch (IOException e) { e.printStackTrace(); } }
}