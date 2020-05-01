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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shoppinglistapp.ListProduct;
import com.example.shoppinglistapp.ListsAdapter;
import com.example.shoppinglistapp.MainActivity;
import com.example.shoppinglistapp.R;
import com.example.shoppinglistapp.database.List1DBHelper;
import com.example.shoppinglistapp.database.List1DatabaseHelper;
import com.example.shoppinglistapp.item.DeleteItem;
import com.example.shoppinglistapp.item.ItemMod;
import com.example.shoppinglistapp.item.NewItem;

import java.util.ArrayList;
import java.util.List;

public class ListItemDelete extends AppCompatActivity {

    private static final String TAG = "ListItemDelete";

    List1DatabaseHelper list1DatabaseHelper;

    private ListView listView;
    private ListsAdapter adapter;
    private List<ListProduct> mItemProductList;

    private EditText listNumber;
    private EditText id;

    private Button delItemButton;
    private Button listViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item_delete);

        listView = (ListView) findViewById(R.id.listView);

        listNumber = (EditText) findViewById(R.id.listNum);
        id = (EditText) findViewById(R.id.id);

        listViewer = (Button) findViewById(R.id.listViewer);
        delItemButton = (Button) findViewById(R.id.delItemButton);

        list1DatabaseHelper = new List1DatabaseHelper(this);

        listViewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataView();
            }
        });

        delItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = listNumber.getText().toString();
                String barcode = id.getText().toString();
                if(num.equals("1")){
                    if(id.length() != 0) {
                        list1DatabaseHelper.deleteItem(barcode);
                        id.setText("");
                        toastMessage("Termék törölve a táblából!");
                    } else {
                        toastMessage("Nincs megadva vonalkód!");
                    }

                } else {
                    toastMessage("Hiba!");
                }
                dataView();
            }
        });
    }

    public void dataView() {
        String num = listNumber.getText().toString();
        if(num.equals("1")){
            Cursor data = list1DatabaseHelper.getAllData();
            mItemProductList = new ArrayList<>();
            while(data.moveToNext()) {
                mItemProductList.add(new ListProduct(data.getInt(0),data.getString(1),data.getString(2),data.getString(3)));
            }
            adapter = new ListsAdapter(getApplicationContext(), mItemProductList);
            listView.setAdapter(adapter);
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
                Intent list1 = new Intent(ListItemDelete.this, Lists.class);
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
                Intent main = new Intent(ListItemDelete.this, MainActivity.class);
                startActivity(main);
                break;
            case R.id.list1:
                Intent list1 = new Intent(ListItemDelete.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(ListItemDelete.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(ListItemDelete.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(ListItemDelete.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(ListItemDelete.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(ListItemDelete.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(ListItemDelete.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(ListItemDelete.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(ListItemDelete.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemMod:
                Intent listItemDelete = new Intent(ListItemDelete.this, ListItemMod.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}