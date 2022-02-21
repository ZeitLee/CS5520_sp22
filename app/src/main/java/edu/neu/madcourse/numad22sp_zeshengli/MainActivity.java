package edu.neu.madcourse.numad22sp_zeshengli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button clicky;
    Button linkController;
    Button locator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clicky = (Button) findViewById(R.id.clicky);
        linkController = (Button) findViewById(R.id.linkController);
        locator = (Button) findViewById(R.id.locator);

        //This is about me button
        Button about_me_btn = (Button) findViewById(R.id.aboutMe);
        about_me_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("AboutMeMessage", "Name:Zesheng Li\nemail: li.zes@husky.neu.edu.");
                //not using toast after Assignment 4
                //Toast.makeText(getApplicationContext(), "Name:Zesheng Li\nemail: li.zes@husky" +
                //        ".neu.edu.", Toast.LENGTH_SHORT).show();
                openAboutMe();
            }
        });

        clicky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClicky();
            }
        });


        linkController.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListOfLinkActivity();
            }
        });

        locator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocatorActivity();
            }
        });
    }

    /**
     * This is a helper function to open the clicky activity.
     */
    public void openClicky() {
        Intent intent = new Intent(this, Clicky.class);
        startActivity(intent);
    }

    /**
     * This is a helper function to open the link controller activity.
     */
    public void openListOfLinkActivity() {
        Intent intent = new Intent(this, LinkControllerActivity.class);
        startActivity(intent);
    }

    /**
     * This is a helper function to open the location activity.
     */
    public void openLocatorActivity() {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }

    /**
     * This is a helper function to open the link controller activity.
     */
    public void openAboutMe() {
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }
}