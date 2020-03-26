package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button kiszamolas, uj_activity;
    EditText elsoSzam, masodikSzam;
    TextView eredmenyek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Használandó dolgok megadása
        kiszamolas = (Button) findViewById(R.id.button1);
        uj_activity = (Button) findViewById(R.id.new_act_butt);
        elsoSzam = (EditText) findViewById(R.id.editText1);
        masodikSzam = (EditText) findViewById(R.id.editText2);
        eredmenyek = (TextView) findViewById(R.id.textView3);
        kiszamolas.setOnClickListener(this);

        Button osszeadas = (Button) findViewById(R.id.button1);
        osszeadas.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Bolti költés próbakód", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1:
                Toast.makeText(this, "Bálint Klaudia\nHoreczky Tünde\nZsók Bianka", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem2:
                Toast.makeText(this, "EHURW0\nCNN9J1\nC72OML", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                int ertek1 = Integer.parseInt(elsoSzam.getText().toString());
                int ertek2 = Integer.parseInt(masodikSzam.getText().toString());
                int eredmeny = ertek1 + ertek2;
                Toast.makeText(this, "Összeadás eredménye: " + String.valueOf(eredmeny), Toast.LENGTH_LONG).show();
                eredmenyek.setText("Az összeadás eredménye: " + Double.toString(eredmeny));
                break;
            case R.id.new_act_butt:
                Intent UJ_ACTIVITY = new Intent(MainActivity.this, Activity2.class);
                startActivity(UJ_ACTIVITY);
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Alkalmazás leállt!", Toast.LENGTH_LONG).show();
    }
}
