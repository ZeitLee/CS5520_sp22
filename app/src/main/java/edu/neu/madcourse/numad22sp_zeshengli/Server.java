package edu.neu.madcourse.numad22sp_zeshengli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends AppCompatActivity {

    private static final String TAG = "WebServiceActivity";

    private TextView content;
    private Button btn;
    private ProgressBar load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        content = (TextView) findViewById(R.id.showText);
        btn = (Button) findViewById(R.id.getInfo);
        load = (ProgressBar) findViewById(R.id.progressBar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callWebserviceButtonHandler(v);
            }
        });
    }

    public void callWebserviceButtonHandler(View v) {
        ExecutorService task = Executors.newSingleThreadExecutor();

        task.execute(new Runnable() {
            @Override
            public void run() {


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        load.setVisibility(View.VISIBLE);
                        Log.i(TAG, "Making progress...");
                    }
                });

                String[] results = new String[2];
                URL url = null;

                try {
                    SystemClock.sleep(2000);
                    url = new URL("https://www.metaweather.com/api/location/search/?query=london");


                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);


                    conn.connect();

                    // read response.
                    InputStream inputStream = conn.getInputStream();
                    final String resp = convertStreamToString(inputStream);

                    JSONObject jObject = new JSONArray(resp).getJSONObject(0);
                    String jTitle = jObject.getString("title");
                    String jBody = jObject.getString("location_type");
                    results[0] = jTitle;
                    results[1] = resp;

                    Log.i(TAG, resp);
                    Log.i(TAG, jBody);
                    Log.i(TAG, jTitle);



                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }



                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        load.setVisibility(View.INVISIBLE);
                        TextView result_view = (TextView)findViewById(R.id.showText);
                        result_view.setText(results[0]);
                    }
                });

            }

        });

    }

    private String convertStreamToString(InputStream in) {
        Scanner s = new Scanner(in).useDelimiter("\\A");
        return s.hasNext() ? s.next().replace(",", ",\n") : "";
    }




}