package edu.neu.madcourse.numad22sp_zeshengli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Server extends AppCompatActivity {

    private static final String TAG = "WebServiceActivity";

    private TextView content;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        content = (TextView) findViewById(R.id.showText);
        btn = (Button) findViewById(R.id.server);
    }

    public void callWebserviceButtonHandler(View v) {
        PingWebServiceTask task = new PingWebServiceTask();
        task.execute();
    }

    private class PingWebServiceTask extends AsyncTask<String, Integer, String[]> {

        @Override
        protected void onProgressUpdate(Integer... value) {
            Log.i(TAG, "Making progress...");
        }

        @Override
        protected String[] doInBackground(String... params) {

            String[] results = new String[2];
            URL url = null;

            try {
                url = new URL("https://www.metaweather.com/api/location/search/?query=london");
                //url = new URL(params[0]);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setDoInput(true);

                conn.connect();

                // read response.
                InputStream inputStream = conn.getInputStream();
                final String resp = inputStream.toString();

                JSONObject jObject = new JSONObject(resp);
                String jTitle = jObject.getString("title");
                String jBody = jObject.getString("location_type");
                results[0] = jTitle;
                results[1] = jBody;
                return results;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return results;
        }

        @Override
        protected void onPostExecute(String... s) {
            super.onPostExecute(s);
            TextView result_view = (TextView) findViewById(R.id)
        }
    }

    private String convertStreamToString(InputStream in) {
        Scanner s = new Scanner(in).useDelimiter("\\A");
        return s.hasNext() ? s.next().replace(",", ",\n") : "";
    }




}