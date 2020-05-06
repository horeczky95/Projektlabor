package com.example.shoppinglistapp.item;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shoppinglistapp.MainActivity;
import com.example.shoppinglistapp.DataBaseProduct;
import com.example.shoppinglistapp.DataBaseListAdapter;
import com.example.shoppinglistapp.lists.ListItemDelete;
import com.example.shoppinglistapp.lists.ListItemMod;
import com.example.shoppinglistapp.R;
import com.example.shoppinglistapp.database.MainDBHelper;
import com.example.shoppinglistapp.lists.NewListItem;
import com.example.shoppinglistapp.lists.List1;
import com.example.shoppinglistapp.lists.List2;
import com.example.shoppinglistapp.lists.List3;
import com.example.shoppinglistapp.lists.List4;
import com.example.shoppinglistapp.lists.List5;
import com.example.shoppinglistapp.responsivity.ResponsiveAlg;

import java.util.ArrayList;
import java.util.List;

public class NewItem extends AppCompatActivity {

    private static final String TAG = "NewItem";

    MainDBHelper mainDBHelper;

    private ListView listView;
    private DataBaseListAdapter adapter;
    private List<DataBaseProduct> mDataBaseProductList;

    private EditText barCode;
    private EditText name;
    private EditText price;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        mainDBHelper = new MainDBHelper(this);

        listView = (ListView) findViewById(R.id.listView);
        barCode = (EditText) findViewById(R.id.barCode);
        ResponsiveAlg.responsive(getWindowManager(),barCode,0.1,0);
        name = (EditText) findViewById(R.id.name);
        ResponsiveAlg.responsive(getWindowManager(),name,0.1,0);
        price = (EditText) findViewById(R.id.price);
        ResponsiveAlg.responsive(getWindowManager(),price,0.1,0);


        addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newBarcode = barCode.getText().toString();
                String newName = name.getText().toString();
                String newPrice = price.getText().toString();
                if(barCode.length() != 0 && name.length() != 0 && price.length() != 0) {
                    addData(newBarcode, newName, newPrice);
                    barCode.setText("");
                    name.setText("");
                    price.setText("");
                    toastMessage("A termék be került az adatbázisba.");
                } else {
                    toastMessage("Kihagytál egy adatot!");
                }
                dataView();
            }
        });

        dataView();
    }

    public void dataView() {
        Cursor data = mainDBHelper.viewData();
        mDataBaseProductList = new ArrayList<>();
        while(data.moveToNext()) {
            mDataBaseProductList.add(new DataBaseProduct(data.getInt(0),data.getString(1),data.getString(2),data.getString(3)));
        }
        adapter = new DataBaseListAdapter(getApplicationContext(), mDataBaseProductList);
        listView.setAdapter(adapter);
    }

    public void addData(String barcode, String name, String price) {
        boolean insertData = mainDBHelper.addData(barcode, name, price);

        if(insertData) {
            toastMessage("Hozzáadás megtörtént!");
        } else {
            toastMessage("Valamit elrontottál!");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onClick(final android.view.View v) {
        switch (v.getId()) {
            case R.id.backButton:
                Intent list1 = new Intent(NewItem.this, Items.class);
                startActivity(list1);
                break;
        }
    }

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main:
                Intent main = new Intent(NewItem.this, MainActivity.class);
                startActivity(main);
                break;
            case R.id.list1:
                Intent list1 = new Intent(NewItem.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(NewItem.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(NewItem.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(NewItem.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(NewItem.this, List5.class);
                startActivity(list5);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(NewItem.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(NewItem.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(NewItem.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemMod:
                Intent listItemMod = new Intent(NewItem.this, ListItemMod.class);
                startActivity(listItemMod);
                break;
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(NewItem.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



