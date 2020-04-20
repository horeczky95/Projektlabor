package com.example.shoppinglistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DeleteItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //Menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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
        }
        return super.onOptionsItemSelected(item);
    }
}
