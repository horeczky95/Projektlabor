package com.example.masodik_proba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String items[] = new String[] {"Lista1", "Lista2", "Lista3", "Lista4", "Lista5"};
        ListView listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    Intent intent = new Intent(MainActivity.this, Lista1.class);
                    startActivity(intent);
                }
                if (position==1)
                {
                    Intent intent = new Intent(MainActivity.this, Lista_2.class);
                    startActivity(intent);
                }
                if (position==2)
                {
                    Intent intent = new Intent(MainActivity.this, Lista_3.class);
                    startActivity(intent);
                }
                if (position==3)
                {
                    Intent intent = new Intent(MainActivity.this, Lista_4.class);
                    startActivity(intent);
                }
                if (position==4)
                {
                    Intent intent = new Intent(MainActivity.this, Lista_5.class);
                    startActivity(intent);
                }

            }
        });
    }


}




