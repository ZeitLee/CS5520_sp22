package edu.neu.madcourse.numad22sp_zeshengli;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class LinkControllerActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_controller);

        ListView linkList = (ListView) findViewById(R.id.LinkList);

        ArrayList<String> contentList = new ArrayList<String>();
        contentList.add("test");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, contentList);
        linkList.setAdapter(arrayAdapter);


        FloatingActionButton addLink = findViewById(R.id.addLinkButton);
        addLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEditTextDialogue();

                Snackbar.make(view, "Add a new link", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void showEditTextDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialogue;
        final View popupView = getLayoutInflater().inflate(R.layout.input_url, null);

        builder.setView(popupView);
        dialogue = builder.create();
        dialogue.show();




    }

}