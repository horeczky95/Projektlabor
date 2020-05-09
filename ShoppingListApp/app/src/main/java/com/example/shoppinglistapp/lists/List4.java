package com.example.shoppinglistapp.lists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.shoppinglistapp.ListProduct;
import com.example.shoppinglistapp.ListsAdapter;
import com.example.shoppinglistapp.MainActivity;
import com.example.shoppinglistapp.database.List1DatabaseHelper;
import com.example.shoppinglistapp.database.List4DatabaseHelper;
import com.example.shoppinglistapp.item.DeleteItem;
import com.example.shoppinglistapp.item.ItemMod;
import com.example.shoppinglistapp.item.NewItem;
import com.example.shoppinglistapp.R;

import java.util.ArrayList;
import java.util.List;

public class List4 extends AppCompatActivity {

    private static final String TAG = "List1";

    List4DatabaseHelper list4DatabaseHelper;

    private ListView listView;
    private ListsAdapter adapter;
    private List<ListProduct> mItemProductList;

    private ListView allPriceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list4);

        list4DatabaseHelper = new List4DatabaseHelper(this);
        listView = (ListView) findViewById(R.id.listView);
        allPriceList = (ListView) findViewById(R.id.allPriceList);
        dataView();
        allPriceView();
    }

    public void dataView() {
        Cursor data = list4DatabaseHelper.getAllData();
        mItemProductList = new ArrayList<>();
        while(data.moveToNext()) {
            mItemProductList.add(new ListProduct(data.getString(0),data.getString(1),data.getString(2),data.getString(3)));
        }
        adapter = new ListsAdapter(getApplicationContext(), mItemProductList);
        listView.setAdapter(adapter);
    }

    private void allPriceView() {
        Cursor data = list4DatabaseHelper.getAllPrice();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(0) + "Ft");
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        allPriceList.setAdapter(adapter);
    }

    public void onClick(final android.view.View v) {
        switch (v.getId()) {
            case R.id.newItem:
                Intent lists = new Intent(List4.this, NewListItem.class);
                lists.putExtra("number", "4");
                startActivity(lists);
                break;
            case R.id.modButton:
                Intent items = new Intent(List4.this, ListItemMod.class);
                items.putExtra("number", "4");
                startActivity(items);
                break;
            case R.id.delButton:
                Intent itemDel = new Intent(List4.this, ListItemDelete.class);
                itemDel.putExtra("number", "4");
                startActivity(itemDel);
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
                Intent main = new Intent(List4.this, MainActivity.class);
                startActivity(main);
                break;
            case R.id.list1:
                Intent list1 = new Intent(List4.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(List4.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(List4.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(List4.this, List4.class);
                startActivity(list4);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(List4.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(List4.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(List4.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(List4.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemMod:
                Intent listItemMod = new Intent(List4.this, ListItemMod.class);
                startActivity(listItemMod);
                break;
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(List4.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
