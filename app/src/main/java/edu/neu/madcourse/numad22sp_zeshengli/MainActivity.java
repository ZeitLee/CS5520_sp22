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

    TextView clickTxt;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button linkController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickTxt = (TextView) findViewById(R.id.textView2);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        bt4 = (Button) findViewById(R.id.button4);
        bt5 = (Button) findViewById(R.id.button5);
        bt6 = (Button) findViewById(R.id.button6);
        bt7 = (Button) findViewById(R.id.button7);
        linkController = (Button) findViewById(R.id.linkController);

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

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickTxt.setText("Pressed: A");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickTxt.setText("Pressed: B");
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickTxt.setText("Pressed: C");
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickTxt.setText("Pressed: D");
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickTxt.setText("Pressed: E");
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickTxt.setText("Pressed: F");
            }
        });
        linkController.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListOfLinkActivity();
            }
        });
    }

    /**
     * This is a helper function to open the link controller activity.
     */
    public void openListOfLinkActivity() {
        Intent intent = new Intent(this, LinkControllerActivity.class);
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