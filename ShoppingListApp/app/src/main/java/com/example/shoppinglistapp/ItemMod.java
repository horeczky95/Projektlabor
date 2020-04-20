package com.example.shoppinglistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ItemMod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_mod);
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
            case R.id.list1:
                Intent list1 = new Intent(ItemMod.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(ItemMod.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(ItemMod.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(ItemMod.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(ItemMod.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(ItemMod.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(ItemMod.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(ItemMod.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemMod:
                Intent listItemMod = new Intent(ItemMod.this, ListItemMod.class);
                startActivity(listItemMod);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
