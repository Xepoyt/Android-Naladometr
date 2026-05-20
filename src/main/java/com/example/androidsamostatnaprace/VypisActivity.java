package com.example.androidsamostatnaprace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VypisActivity extends AppCompatActivity {

    ListView seznam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vypis);

        ArrayList<String> data = new ArrayList<String>();
        ArrayList<String> poddata = new ArrayList<String>();
        ArrayList<String> datumy = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader((new InputStreamReader(openFileInput("data.txt"))));
            String r;
            while((r = br.readLine()) != null) {
                r = r.replace("<br>", "\n");
                System.out.println(r);
                data.add(r.split("<>")[0]);
                poddata.add(r.split("<>")[1]);
                datumy.add(r.split("<>")[2]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        seznam = findViewById(R.id.seznam);
        seznam.setAdapter(new CustomListAdapter(this, data.toArray(new String[0]), poddata.toArray(new String[0]), datumy.toArray(new String[0])));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vypis, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuOptVypis){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}