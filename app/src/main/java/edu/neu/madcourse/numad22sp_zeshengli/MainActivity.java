package edu.neu.madcourse.numad22sp_zeshengli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is about me button
        Button about_me_btn = (Button) findViewById(R.id.aboutMe);
        about_me_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("AboutMeMessage", "Name:Zesheng Li\nemail: li.zes@husky.neu.edu.");
                Toast.makeText(getApplicationContext(), "Name:Zesheng Li\nemail: li.zes@husky" +
                        ".neu.edu.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}