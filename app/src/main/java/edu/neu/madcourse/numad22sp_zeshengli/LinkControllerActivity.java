package edu.neu.madcourse.numad22sp_zeshengli;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class LinkControllerActivity extends AppCompatActivity {


    ArrayList<String> contentList = new ArrayList<String>();
    ArrayList<String> urls = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_controller);

        ListView linkList = (ListView) findViewById(R.id.LinkList);


        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, contentList);
        linkList.setAdapter(arrayAdapter);
        linkList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent openLink = new Intent(Intent.ACTION_VIEW, Uri.parse(urls.get(position)));
                startActivity(openLink);
            }
        });


        FloatingActionButton addLink = findViewById(R.id.addLinkButton);
        addLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEditTextDialogue();
            }
        });
    }

    private void showEditTextDialogue() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialogue;
        final View popupView = getLayoutInflater().inflate(R.layout.input_url, null);

        Button cancel_bt = (Button) popupView.findViewById(R.id.cancel);
        Button submit_bt = (Button) popupView.findViewById(R.id.submit);

        EditText name = (EditText) popupView.findViewById(R.id.name);
        EditText url = (EditText) popupView.findViewById(R.id.url);

        builder.setView(popupView);
        dialogue = builder.create();
        dialogue.show();

        cancel_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogue.dismiss();
            }
        });

        submit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitInfo(name.getText().toString(), url.getText().toString());
                dialogue.dismiss();

            }
        });
    }

    private void submitInfo(String name, String url) {
        // name cannot be empty
        if (name.isEmpty()) {
            Snackbar.make(getWindow().getDecorView().findViewById(R.id.LinkList),
                    "Fail: Name cannot be empty.", Snackbar.LENGTH_SHORT).show();
            return;
        }
        // check url valid.
        if (!URLUtil.isValidUrl(url)) {
            Snackbar.make(getWindow().getDecorView().findViewById(R.id.LinkList),
                    "Fail: Invalid URL.", Snackbar.LENGTH_SHORT).show();
            return;
        }

        // Otherwise, add to list.
        contentList.add(name);
        urls.add(url);
        String prompt = String.format("Success: Add %s.", name);
        Snackbar.make(getWindow().getDecorView().findViewById(R.id.LinkList),
                prompt, Snackbar.LENGTH_SHORT).show();
    }

}