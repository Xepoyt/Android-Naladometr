package com.example.androidsamostatnaprace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    SeekBar slider;
    EditText poznamka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slider = findViewById(R.id.slider);
        poznamka = findViewById(R.id.poznamka);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.zapis, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuOptZapis){
            Intent intent = new Intent(this, VypisActivity.class);
            startActivity(intent);
        }
        return true;
    }

    public void uloz(View view) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput("data.txt", MODE_APPEND));
            int n = slider.getProgress();
            String p = poznamka.getText().toString();

            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yyyy");
            String d = sdf.format(c.getTime());


            p = p.replace("<br>", " ").replace("\n", "<br>").replace("<>", " ");
            osw.write(n + "<>" + p + "<>" + d + "\n");
            osw.close();
        }catch (IOException e) {
            e.printStackTrace();
            Toast bublina = Toast.makeText(this, "Při ukládání se něco nepovedlo :(", Toast.LENGTH_SHORT);
            bublina.show();
            return;
        }
        Toast bublina = Toast.makeText(this, "Úspěšně uloženo!!", Toast.LENGTH_SHORT);
        bublina.show();
    }
}