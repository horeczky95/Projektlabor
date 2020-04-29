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

import com.example.shoppinglistapp.MainActivity;
import com.example.shoppinglistapp.database.List1DBHelper;
import com.example.shoppinglistapp.database.List1DatabaseHelper;
import com.example.shoppinglistapp.item.DeleteItem;
import com.example.shoppinglistapp.item.ItemMod;
import com.example.shoppinglistapp.R;
import com.example.shoppinglistapp.item.NewItem;

import java.util.ArrayList;

public class ListItemMod extends AppCompatActivity {

    private static final String TAG = "ListItemMod";

    List1DatabaseHelper list1DBHelper;

    private ListView idList;
    private ListView nameList;
    private ListView priceList;
    private ListView pieceList;

    private EditText id;
    private EditText name;
    private EditText price;
    private EditText piece;
    private EditText listNumber;

    private Button modButton;
    private Button nameModButton;
    private Button priceModButton;
    private Button pieceModButton;
    private Button listViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item_mod);

        idList = (ListView) findViewById(R.id.idList);
        nameList = (ListView) findViewById(R.id.nameList);
        priceList = (ListView) findViewById(R.id.priceList);
        pieceList = (ListView) findViewById(R.id.pieceList);

        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        price = (EditText) findViewById(R.id.price);
        piece = (EditText) findViewById(R.id.piece);
        listNumber = (EditText) findViewById(R.id.listNum);

        modButton = (Button) findViewById(R.id.modItemButton);
        nameModButton = (Button) findViewById(R.id.nameModButton);
        priceModButton = (Button) findViewById(R.id.priceModButton);
        pieceModButton = (Button) findViewById(R.id.pieceModButton);
        listViewer = (Button) findViewById(R.id.listViewer);

        list1DBHelper = new List1DatabaseHelper(this);

        listViewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idView();
                nameView();
                priceView();
                pieceView();
            }
        });

        updateItem();
        updateName();
        updatePrice();
        updatePiece();
    }

    public void updateItem() {
            modButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String num = listNumber.getText().toString();
                        if (id.length() != 0 && name.length() != 0 && price.length() != 0 && piece.length() != 0) {
                            if (num.equals("1")) {
                                boolean isUpdate = list1DBHelper.updateItem(id.getText().toString(), name.getText().toString(),
                                    price.getText().toString(), piece.getText().toString());
                                if (isUpdate == true) {
                                    toastMessage("Termék módosítva!");
                                } else {
                                    toastMessage("Sikertelen módosítás!");
                                }
                        } else {
                            toastMessage("Hiányzó adat!");
                        }
                        idView();
                        nameView();
                        priceView();
                        pieceView();
                    } else {
                        toastMessage("Hiba!");
                    }
                }
            });
    }
    public void updateName() {
        nameModButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = listNumber.getText().toString();
                if (id.length() != 0 && name.length() != 0) {
                    if(num.equals("1")) {
                        boolean isUpdate = list1DBHelper.updateName(id.getText().toString(), name.getText().toString());
                        if (isUpdate == true) {
                            toastMessage("Név módosítva!");
                        } else {
                            toastMessage("Sikertelen módosítás");
                        }
                    }
                    idView();
                    nameView();
                    priceView();
                    pieceView();
                } else {
                    toastMessage("Hiányzó adat!");
                }
            }
        });
    }
    public void updatePrice() {
        priceModButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = listNumber.getText().toString();
                if (id.length() != 0 && price.length() != 0) {
                    if(num.equals("1")) {
                        boolean isUpdate = list1DBHelper.updatePrice(id.getText().toString(), price.getText().toString());
                        if (isUpdate == true) {
                            toastMessage("Ár módosítva!");
                        } else {
                            toastMessage("Sikertelen módosítás");
                        }
                    }
                    idView();
                    nameView();
                    priceView();
                    pieceView();
                } else {
                    toastMessage("Hiányzó adat!");
                }
            }
        });
    }
    public void updatePiece() {
        pieceModButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = listNumber.getText().toString();
                if (id.length() != 0 && piece.length() != 0) {
                    if(num.equals("1")) {
                        boolean isUpdate = list1DBHelper.updatePiece(id.getText().toString(), piece.getText().toString());
                        if (isUpdate == true) {
                            toastMessage("Darab szám módosítva!");
                        } else {
                            toastMessage("Sikertelen módosítás");
                        }
                    }
                    idView();
                    nameView();
                    priceView();
                    pieceView();
                } else {
                    toastMessage("Hiányzó adat!");
                }
            }
        });
    }


    private void idView() {
        Cursor data = list1DBHelper.getAllData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(0));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        idList.setAdapter(adapter);
    }
    private void nameView() {
        Cursor data = list1DBHelper.getAllData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        nameList.setAdapter(adapter);
    }
    private void priceView() {
        Cursor data = list1DBHelper.getAllData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(2));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        priceList.setAdapter(adapter);
    }
    private void pieceView() {
        Cursor data = list1DBHelper.getAllData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(3));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        pieceList.setAdapter(adapter);
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onClick(final android.view.View v) {
        String num = listNumber.getText().toString();
        switch (v.getId()) {
            case R.id.backButton:
                    Intent list1 = new Intent(ListItemMod.this, Lists.class);
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
                Intent main = new Intent(ListItemMod.this, MainActivity.class);
                startActivity(main);
                break;
            case R.id.list1:
                Intent list1 = new Intent(ListItemMod.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(ListItemMod.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(ListItemMod.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(ListItemMod.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(ListItemMod.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(ListItemMod.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(ListItemMod.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(ListItemMod.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(ListItemMod.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(ListItemMod.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
