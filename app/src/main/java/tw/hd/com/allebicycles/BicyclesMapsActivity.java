package tw.hd.com.allebicycles;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BicyclesMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = BicyclesMapsActivity.class.getSimpleName();
    private static final int REQUEST_LOCATION = 90;
    private GoogleMap mMap;
    private static Gson gson;
    private String jsondata;
    private List<Sno> bicyclesList;
    private Location location;
    private MarkerOptions markerOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicycles_maps);
        getJsondata();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        setupMap();


    }

    private void getJsondata() {

//        OkHttpClient client = new OkHttpClient();
//        String Url  = "https://ptx.transportdata.tw/MOTC/v2/Bike/Availability/Taoyuan?$top=200&$format=JSON";
//        Request request = new Request.Builder()
//                .url(Url)
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                jsondata = response.body().string();
//                System.out.println(jsondata);
//
//            }
//        });
        InputStream inputStream = getResources().openRawResource(R.raw.tempjsondata);
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        bicyclesList = new ArrayList<>();
        BicyclesData bicyclesData = buildGson().fromJson(stringBuffer.toString(), BicyclesData.class);
        for (String key : bicyclesData.getRetVal().keySet()) {
            bicyclesList.add(bicyclesData.getRetVal().get(key));
        }
        Log.d(TAG, "getJsondata:  " + bicyclesList.size());


    }

    private void setupMap() {
        //24.9895908,121.3114627 桃園市火車站
        MyInfoWindowAdapter adapter = new MyInfoWindowAdapter(this);
        mMap.setInfoWindowAdapter(adapter);
        mMap.setOnInfoWindowClickListener(adapter);
        LatLng tayuan = new LatLng(24.9895908,121.3114627);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tayuan,16));
        setallmarker();


    }

    private void setallmarker() {
        markerOptions = new MarkerOptions();
        for (int i = 0; i < bicyclesList.size(); i++) {
            markerOptions.position(new LatLng(bicyclesList.get(i).getLat(),bicyclesList.get(i).getLng()))
            .title(bicyclesList.get(i).getAr());

//            .snippet(bicyclesList.get(i).getSbi()+","+bicyclesList.get(i).getBemp()+","+bicyclesList.get(i).getTot()+","+bicyclesList.get(i).getMday());
            Marker m = mMap.addMarker(markerOptions);
            m.setTag(bicyclesList.get(i));

            m.showInfoWindow();



        }
    }

    private static Gson buildGson(){

        if(gson == null){
            gson = new GsonBuilder()
                    .registerTypeAdapter(Integer.class,new IntegerDefault0Adapter())
                    .registerTypeAdapter(int.class,new IntegerDefault0Adapter())
                    .registerTypeAdapter(Double.class,new DoubleDefault0Adapter())
                    .registerTypeAdapter(double.class,new DoubleDefault0Adapter())
                    .registerTypeAdapter(Long.class,new LongDefault0Adapter())
                    .registerTypeAdapter(long.class,new LongDefault0Adapter())
                    .create();
        }
        return gson;
    }
}
