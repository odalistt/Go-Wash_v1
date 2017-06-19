package info.androidhive.firebase;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    Button siguiente;
    TextView messageTextView, ubicacionTextView, mesageTextView;
    EditText locationSearch;
    private GoogleMap mMap;
    private Marker marcador, marcador1, marcador2, marcador3, marcador4, marcador5, marcador6,
            marcador7, marcador8, marcador9, marcador10, marcador11;
    double lat = 0.0;
    double lng = 0.0;
    Geocoder geocoder;
    List<Address> addresses;
    String fullAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    @Override
    protected void onResume() {
        super.onResume();
        siguiente = (Button) findViewById(R.id.button_next_services);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent(MapsActivity.this, SelectServicesActivity.class);
                siguiente.putExtra("KEY", fullAddress);
                //siguiente.putExtra("LOCATION_KEY", fullAddress);
                //siguiente.putExtra("LocationKey", fullAddress);
                //String fullAddress = ubicacionTextView.getText().toString();
                //Bundle locationUser = new Bundle();
                //if(locationUser != null) {
                    //String fullAddress = locationUser.getString("LocationKey");
                    //ubicacionTextView.setText(fullAddress);}
                //locationUser.putString("LocationKey", fullAddress);
                //siguiente.putExtras(locationUser);
                startActivityForResult(siguiente,0);
            }
        });
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
        miUbicacion();

        //Add a marker in MercadoAdelita and move the camera
        //LatLng mercadoAdelita = new LatLng(19.60, -98.98);
        //mMap.addMarker(new MarkerOptions().position(mercadoAdelita).title("Washer Disponible"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(mercadoAdelita));

    }

    private void agregarMarcador(double lat, double lng) {
        LatLng coordenadas = new LatLng(lat, lng);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 16);
        if (marcador != null) marcador.remove();
        marcador = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .draggable(true)
                .title("Mi posición actual")
                .snippet("Tu ubicación es: " + fullAddress)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.animateCamera(miUbicacion);

        LatLng lugar1 = new LatLng(19.2886892, -98.9412734);
        marcador1 = mMap.addMarker(new MarkerOptions()
                .position(lugar1)
                .draggable(false)
                .title("Washer Disponible")
                .snippet("Disponible")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        LatLng lugar2 = new LatLng(19.288453, -98.942302);
        marcador2 = mMap.addMarker(new MarkerOptions()
                .position(lugar2)
                .draggable(false)
                .title("Washer Disponible")
                .snippet("Disponible")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        LatLng lugar3 = new LatLng(19.289926, -98.943209);
        marcador3 = mMap.addMarker(new MarkerOptions()
                .position(lugar3)
                .draggable(false)
                .title("Washer Disponible")
                .snippet("Disponible")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        LatLng lugar4 = new LatLng(19.290923, -98.940607);
        marcador4 = mMap.addMarker(new MarkerOptions()
                .position(lugar4)
                .draggable(false)
                .title("Washer Disponible")
                .snippet("Disponible")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        LatLng lugar5 = new LatLng(19.289622, -98.939180);
        marcador5 = mMap.addMarker(new MarkerOptions()
                .position(lugar5)
                .draggable(false)
                .title("Washer Disponible")
                .snippet("Disponible")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        //upiicsa

        LatLng lugar10 = new LatLng(19.396608, -99.095768);
        marcador10 = mMap.addMarker(new MarkerOptions()
                .position(lugar10)
                .draggable(false)
                .title("Washer Disponible")
                .snippet("Disponible")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        LatLng lugar6 = new LatLng(19.397357, -99.094824);
        marcador6 = mMap.addMarker(new MarkerOptions()
                .position(lugar6)
                .draggable(false)
                .title("Washer Disponible")
                .snippet("Disponible")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        LatLng lugar7 = new LatLng(19.397043, -99.092249);
        marcador7 = mMap.addMarker(new MarkerOptions()
                .position(lugar7)
                .draggable(false)
                .title("Washer Disponible")
                .snippet("Disponible")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        LatLng lugar8 = new LatLng(19.394665, -99.091519);
        marcador8 = mMap.addMarker(new MarkerOptions()
                .position(lugar8)
                .draggable(false)
                .title("Washer Disponible")
                .snippet("Disponible")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

        LatLng lugar9 = new LatLng(19.395120, -99.089244);
        marcador9 = mMap.addMarker(new MarkerOptions()
                .position(lugar9)
                .draggable(false)
                .title("Washer Disponible")
                .snippet("Disponible")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

    }

    private void actualizarUbicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            agregarMarcador(lat, lng);
            TextView mesageTextView = (TextView) findViewById(R.id.messageTextView);
            mesageTextView.setText("Tus coordenadas son:" + lat + "--" + lng);


            TextView ubicacionTextView = (TextView) findViewById(R.id.ubicacionTextView);

            geocoder = new Geocoder(this, Locale.getDefault());

            try {
                addresses = geocoder.getFromLocation(lat, lng, 1);
                String address = addresses.get(0).getAddressLine(0);
                String area = addresses.get(0).getLocality();
                String city = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalcode = addresses.get(0).getPostalCode();

                fullAddress = address+", "+area+", "+city+", "+country+", "+postalcode;
                ubicacionTextView.setText("Tu dirección es: " +fullAddress);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }






    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);

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
    };

    private void miUbicacion() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER,15000,0,locationListener);

    }

    public void onMapSearch(View view) {
        EditText locationSearch = (EditText) findViewById(R.id.editText);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Mi ubicacion-Solicitar servicio aqui"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }
}

