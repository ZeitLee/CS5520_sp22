package edu.neu.madcourse.numad22sp_zeshengli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class LinkControllerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_controller);

        FloatingActionButton addLink = findViewById(R.id.addLinkButton);
        addLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add a new link", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

}