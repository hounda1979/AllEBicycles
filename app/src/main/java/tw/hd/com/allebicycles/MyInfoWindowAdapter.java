package tw.hd.com.allebicycles;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import static android.content.ContentValues.TAG;

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter ,GoogleMap.OnInfoWindowClickListener{
    private Activity context;
    private Sno bicylc;

    public MyInfoWindowAdapter(Activity context){
        this.context = context;
    }
    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(final Marker marker) {
        View view = context.getLayoutInflater().inflate(R.layout.marker_windows,null);
        TextView st_stationName = view.findViewById(R.id.station_name);
        TextView st_sbi = view.findViewById(R.id.sbi_number);
        TextView st_bemp = view.findViewById(R.id.bemp_number);
        TextView st_total = view.findViewById(R.id.total_number);
        TextView st_uptime = view.findViewById(R.id.uptime_number);
        ImageView g_bike = view.findViewById(R.id.imageView_sbi);
        g_bike.setImageResource(R.drawable.g_bike32);
        ImageView r_bike = view.findViewById(R.id.imageView_bmpe);
        r_bike.setImageResource(R.drawable.parking);


        bicylc = (Sno)marker.getTag();

        st_stationName.setText(marker.getTitle());
        st_sbi.setText(bicylc.getSbi()+"");
        st_bemp.setText(bicylc.getBemp()+"");
        st_total.setText(bicylc.getTot()+"");
        st_uptime.setText(bicylc.getMday());
//        String[] temp = marker.getSnippet().split(",");
//        if(temp.length > 3) {
//            st_sbi.setText(String.valueOf(temp[0]));
//            st_bemp.setText(String.valueOf(temp[1]));
//            st_total.setText(String.valueOf(temp[2]));
//            st_uptime.setText(temp[3]);
//        }else{
//            Log.d(TAG, "temp.length:    分割後數量沒有大於3" );
//        }


        return view;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Log.d(TAG, "onInfoWindowClick: 手機位置 : "+marker.getSnippet()+" , 站點位置 : "+ bicylc.getLat()+","+bicylc.getLng());

    }
}
