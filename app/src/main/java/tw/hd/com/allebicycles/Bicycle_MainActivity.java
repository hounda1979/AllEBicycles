package tw.hd.com.allebicycles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Bicycle_MainActivity extends AppCompatActivity {
    private String responeJson;
    private List<Sno> getBicycleList;
    private String TAG = Bicycle_MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicycle__main);

//        https://data.tycg.gov.tw/api/v1/rest/dataset/5ca2bfc7-9ace-4719-88ae-4034b9a5a55c?format=json
//        getData();

//        System.out.println(getBicycleList.get(0).getAr());
    }

    private void getData() {
        OkHttpClient client = new OkHttpClient();
        String url = "https://data.tycg.gov.tw/opendata/datalist/datasetMeta/download?id=5ca2bfc7-9ace-4719-88ae-4034b9a5a55c&rid=a1b4714b-3b75-4ff8-a8f2-cc377e4eaa0f";
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {



            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                responeJson = response.body().string();
//                System.out.println(responeJson);
                toGson();

            }
        });
    }

    public void gotonext(View view){
        Intent intent = new Intent(this,BicyclesMapsActivity.class);
        startActivity(intent);
    }

    private void toGson() {
        Gson gson = new Gson();
        BicyclesData bicyclesData1 = gson.fromJson(responeJson,BicyclesData.class);
        getBicycleList = new ArrayList<>();
        for (String key : bicyclesData1.getRetVal().keySet()) {
            getBicycleList.add(bicyclesData1.getRetVal().get(key));

        }
        Log.d(TAG,"getBicycleList Size is = "+getBicycleList.size());

    }
}
