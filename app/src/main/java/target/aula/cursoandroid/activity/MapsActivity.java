package target.aula.cursoandroid.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import target.aula.cursoandroid.R;

import static target.aula.cursoandroid.R.id.map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private LocationManager locationManager;
    private double latitude;
    private double longitude;

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    }

    public void getMyLocation() {
        List<String> providers = locationManager.getProviders(true);

        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        String provider_info = null;

        if (isNetworkEnabled) {
            provider_info = LocationManager.NETWORK_PROVIDER;
        }

        if (isGPSEnabled) {
            provider_info = LocationManager.GPS_PROVIDER;
        }

        if (provider_info != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            } else {
                locationManager.requestLocationUpdates(
                        provider_info,
                        MIN_TIME_BW_UPDATES,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES,
                        this
                );

                if (locationManager != null) {
                    location = locationManager.getLastKnownLocation(provider_info);
                    if (location != null) {
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    }
                    updateGPSCoordinates();
                }
            }

        }




    }

    private void updateGPSCoordinates() {
        LatLng sydney = new LatLng(latitude, longitude);
        if(mMap != null) {
            mMap.addMarker(new MarkerOptions().position(sydney).title("MEU LUGAR"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        getMyLocation();
        LatLng sydney = new LatLng(latitude, longitude);
        if(mMap != null) {
            mMap.addMarker(new MarkerOptions().position(sydney).title("MEU LUGAR"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(latitude, longitude);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onLocationChanged(Location location) {

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
}
