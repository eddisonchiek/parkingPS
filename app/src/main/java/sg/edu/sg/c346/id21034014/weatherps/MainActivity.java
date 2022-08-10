package sg.edu.sg.c346.id21034014.weatherps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvCarpark;
    AsyncHttpClient client;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCarpark = findViewById(R.id.lvParking);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Parking> alCarpark = new ArrayList<Parking>();


        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            String total_lots;
            String lot_type;
            String lots_available;
            String carpark_number;
            String carpark_datetime;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrCarparkData = firstObj.getJSONArray("carpark_data");


                    for (int i = 0; i < jsonArrCarparkData.length(); i++) {
                        JSONObject jsonObjCarparkData = jsonArrCarparkData.getJSONObject(i);
                        JSONArray jsonArrCarparkInfo = jsonObjCarparkData.getJSONArray("carpark_info");
                        JSONObject jsonObjCarparkData1 = jsonArrCarparkInfo.getJSONObject(0);

                        carpark_number = jsonObjCarparkData.getString("carpark_number");
                        carpark_datetime = jsonObjCarparkData.getString("update_datetime");
                        total_lots = jsonObjCarparkData1.getString("total_lots");
                        lot_type = jsonObjCarparkData1.getString("lot_type");
                        lots_available = jsonObjCarparkData1.getString("lots_available");



                        Parking parking = new Parking(carpark_number, carpark_datetime, lot_type, lots_available,total_lots);
                        alCarpark.add(parking);
                    }
                } catch (JSONException e) {
                    Log.d("Exception", e.toString());

                }

                //POINT X – Code to display List View

                ArrayAdapter<Parking> adapter = new ArrayAdapter<Parking>(MainActivity.this,android.R.layout.simple_list_item_1,alCarpark);
                lvCarpark.setAdapter((adapter));


            }//end onSuccess
        });
    }//end onResume
}