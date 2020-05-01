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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shoppinglistapp.MainActivity;
import com.example.shoppinglistapp.Product;
import com.example.shoppinglistapp.ProductListAdapter;
import com.example.shoppinglistapp.R;
import com.example.shoppinglistapp.database.MainDBHelper;
import com.example.shoppinglistapp.lists.ListItemDelete;
import com.example.shoppinglistapp.lists.NewListItem;
import com.example.shoppinglistapp.lists.ListItemMod;
import com.example.shoppinglistapp.lists.List1;
import com.example.shoppinglistapp.lists.List2;
import com.example.shoppinglistapp.lists.List3;
import com.example.shoppinglistapp.lists.List4;
import com.example.shoppinglistapp.lists.List5;

import java.util.ArrayList;
import java.util.List;

public class DeleteItem extends AppCompatActivity {

    private static final String TAG = "DeleteItem";

    MainDBHelper mainDBHelper;

    private ListView listView;
    private ProductListAdapter adapter;
    private List<Product> mProductList;

    private EditText barCode;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);

        listView = (ListView) findViewById(R.id.listView);

        barCode = (EditText) findViewById(R.id.barCode);
        deleteButton = (Button) findViewById(R.id.deleteItemB);
        mainDBHelper = new MainDBHelper(this);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String barcode = barCode.getText().toString();
                if(barCode.length() != 0) {
                    mainDBHelper.deleteItem(barcode);
                    barCode.setText("");
                    toastMessage("Termék törölve az adatbázisból!");
                } else {
                    toastMessage("Nincs megadva vonalkód!");
                }
                dataView();
            }
        });
        dataView();
    }

    public void dataView() {
        Cursor data = mainDBHelper.viewData();
        mProductList = new ArrayList<>();
        while(data.moveToNext()) {
            mProductList.add(new Product(data.getInt(0),data.getString(1),data.getString(2),data.getString(3)));
        }
        adapter = new ProductListAdapter(getApplicationContext(), mProductList);
        listView.setAdapter(adapter);
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onClick(final android.view.View v) {
        switch (v.getId()) {
            case R.id.backButton:
                Intent list1 = new Intent(DeleteItem.this, Items.class);
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
                Intent main = new Intent(DeleteItem.this, MainActivity.class);
                startActivity(main);
                break;
            case R.id.list1:
                Intent list1 = new Intent(DeleteItem.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(DeleteItem.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(DeleteItem.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(DeleteItem.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(DeleteItem.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(DeleteItem.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(DeleteItem.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(DeleteItem.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemMod:
                Intent listItemMod = new Intent(DeleteItem.this, ListItemMod.class);
                startActivity(listItemMod);
                break;
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(DeleteItem.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
