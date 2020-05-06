package com.example.shoppinglistapp.lists;

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

import com.example.shoppinglistapp.DataBaseListAdapter;
import com.example.shoppinglistapp.DataBaseProduct;
import com.example.shoppinglistapp.MainActivity;
import com.example.shoppinglistapp.database.List1DatabaseHelper;
import com.example.shoppinglistapp.database.List2DatabaseHelper;
import com.example.shoppinglistapp.database.List3DatabaseHelper;
import com.example.shoppinglistapp.database.List4DatabaseHelper;
import com.example.shoppinglistapp.database.List5DatabaseHelper;
import com.example.shoppinglistapp.item.DeleteItem;
import com.example.shoppinglistapp.item.ItemMod;
import com.example.shoppinglistapp.item.NewItem;
import com.example.shoppinglistapp.R;
import com.example.shoppinglistapp.database.MainDBHelper;

import java.util.ArrayList;
import java.util.List;

public class NewListItem extends AppCompatActivity {

    private static final String TAG = "NewListItem";

    MainDBHelper mainDBHelper;
    List1DatabaseHelper list1DatabaseHelper;
    List2DatabaseHelper list2DatabaseHelper;
    List3DatabaseHelper list3DatabaseHelper;
    List4DatabaseHelper list4DatabaseHelper;
    List5DatabaseHelper list5DatabaseHelper;

    private ListView listView;
    private DataBaseListAdapter adapter;
    private List<DataBaseProduct> mDataBaseProductList;

    private EditText name;
    private EditText price;
    private EditText piece;
    private EditText listNumber;

    private Button addList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_itemto_list);

        name = (EditText) findViewById(R.id.name);
        price = (EditText) findViewById(R.id.price);
        piece = (EditText) findViewById(R.id.piece);
        listNumber = (EditText) findViewById(R.id.listNum);

        addList = (Button) findViewById(R.id.addList);

        listView = (ListView) findViewById(R.id.listView);

        mainDBHelper = new MainDBHelper(this);
        list1DatabaseHelper = new List1DatabaseHelper(this);
        list2DatabaseHelper = new List2DatabaseHelper(this);
        list3DatabaseHelper = new List3DatabaseHelper(this);
        list4DatabaseHelper = new List4DatabaseHelper(this);
        list5DatabaseHelper = new List5DatabaseHelper(this);

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = name.getText().toString();
                String newPrice = price.getText().toString();
                String newPiece = piece.getText().toString();
                String num = listNumber.getText().toString();
                if(name.length() != 0 && piece.length() != 0) {
                    if(newPrice.equals("")) {
                        newPrice = "0";
                        addDatatoList(newName, newPrice, newPiece);
                    } else {
                        newPrice = price.getText().toString();
                        addDatatoList(newName, newPrice, newPiece);
                    }
                } else {
                    toastMessage("Hiányzó adat");
                }
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

    public void addDatatoList(String name, String price, String piece) {
        String num = listNumber.getText().toString();
        if(num.equals("1")) {
            boolean insertData = list1DatabaseHelper.addData(name, price, piece);
            if (insertData) {
                toastMessage("Hozzáadás megtörtént!");
            } else {
                toastMessage("Hiba!");
            }
        } else if(num.equals("2")) {
            boolean insertData = list2DatabaseHelper.addData(name, price, piece);
            if (insertData) {
                toastMessage("Hozzáadás megtörtént!");
            } else {
                toastMessage("Hiba!");
            }
        } else if(num.equals("3")) {
            boolean insertData = list3DatabaseHelper.addData(name, price, piece);
            if (insertData) {
                toastMessage("Hozzáadás megtörtént!");
            } else {
                toastMessage("Hiba!");
            }
        } else if(num.equals("4")) {
            boolean insertData = list4DatabaseHelper.addData(name, price, piece);
            if (insertData) {
                toastMessage("Hozzáadás megtörtént!");
            } else {
                toastMessage("Hiba!");
            }
        } else if(num.equals("5")) {
            boolean insertData = list5DatabaseHelper.addData(name, price, piece);
            if (insertData) {
                toastMessage("Hozzáadás megtörtént!");
            } else {
                toastMessage("Hiba!");
            }
        } else {
            toastMessage("Hibás lista kód!");
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onClick(final android.view.View v) {
        String num = listNumber.getText().toString();
        switch (v.getId()) {
            case R.id.backButton:
                Intent list1 = new Intent(NewListItem.this, Lists.class);
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
                Intent main = new Intent(NewListItem.this, MainActivity.class);
                startActivity(main);
                break;
            case R.id.list1:
                Intent list1 = new Intent(NewListItem.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(NewListItem.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(NewListItem.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(NewListItem.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(NewListItem.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(NewListItem.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(NewListItem.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(NewListItem.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.listItemMod:
                Intent listItemMod = new Intent(NewListItem.this, ListItemMod.class);
                startActivity(listItemMod);
                break;
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(NewListItem.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}