package com.example.masodik_proba;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Lista_3 extends AppCompatActivity {
    DatabaseHelper_3 db;

    Button add_data;
    EditText add_food;

    ListView foodlist;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista2);

        db = new DatabaseHelper_3(this);

        listItem = new ArrayList<>();

        add_data = findViewById(R.id.add_data);
        add_food = findViewById(R.id.add_food);
        foodlist = findViewById(R.id.food_list);

        viewData();

        foodlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = foodlist.getItemAtPosition(position).toString();
                Toast.makeText(Lista_3.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = add_food.getText().toString();
                if(!name.equals("") && db.insertData(name)){
                    Toast.makeText(Lista_3.this, "Data added", Toast.LENGTH_SHORT).show();
                    add_food.setText("");
                    listItem.clear();
                    viewData();
                } else {
                    Toast.makeText(Lista_3.this, "Data not added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void viewData() {
        Cursor cursor = db.viewData();

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1));
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            foodlist.setAdapter(adapter);
        }
    }
}
