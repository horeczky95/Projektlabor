package com.example.shoppinglistapp.item;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shoppinglistapp.MainActivity;
import com.example.shoppinglistapp.DataBaseProduct;
import com.example.shoppinglistapp.DataBaseListAdapter;
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
import com.example.shoppinglistapp.responsivity.ResponsiveAlg;

import java.util.ArrayList;
import java.util.List;

public class ItemMod extends AppCompatActivity {

    private static final String TAG = "ItemMod";

    MainDBHelper mainDBHelper;

    private ListView listView;
    private DataBaseListAdapter adapter;
    private List<DataBaseProduct> mDataBaseProductList;

    private EditText barCode;
    private EditText name;
    private EditText price;
    private Button modButton;
    private Button nameModButton;
    private Button priceModButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_mod);

        listView = (ListView) findViewById(R.id.listView);
        barCode = (EditText) findViewById(R.id.barCode);
        ResponsiveAlg.responsive(getWindowManager(),barCode,0.1,0);
        name = (EditText) findViewById(R.id.name);
        ResponsiveAlg.responsive(getWindowManager(),name,0.1,0);
        price = (EditText) findViewById(R.id.price);
        ResponsiveAlg.responsive(getWindowManager(),price,0.1,0);
        modButton = (Button) findViewById(R.id.modButton);
        ResponsiveAlg.responsive(getWindowManager(),modButton,0.7,0);
        nameModButton = (Button) findViewById(R.id.nameModButton);
        ResponsiveAlg.responsive(getWindowManager(),nameModButton,0.7,0);
        priceModButton = (Button) findViewById(R.id.priceModButton);
        ResponsiveAlg.responsive(getWindowManager(),priceModButton,0.7,0);
        mainDBHelper = new MainDBHelper(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Cursor data = mainDBHelper.viewData();
                mDataBaseProductList = new ArrayList<>();
                int itemID = position;
                while (data.moveToNext()) {
                    mDataBaseProductList.add(new DataBaseProduct(data.getInt(0),data.getString(1),data.getString(2),data.getString(3)));
                }
                if(itemID == position) {
                    barCode.setText(mDataBaseProductList.get(itemID).getBarCode());
                }
            }
        });


        updateItem();
        updateName();
        updatePrice();

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

    public void updateItem() {
        modButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (barCode.length() != 0 && name.length() != 0 && price.length() != 0) {
                    boolean isUpdate = mainDBHelper.updateItem(barCode.getText().toString(), name.getText().toString(),
                            price.getText().toString());
                    if (isUpdate == true) {
                        toastMessage("Termék módosítva!");
                    } else {
                        toastMessage("Sikertelen módosítás");
                    }
                    dataView();
                } else {
                    toastMessage("Hiányzó adat!");
                }
            }
        });
    }

    public void updateName() {
        nameModButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (barCode.length() != 0 && name.length() != 0) {
                    boolean isUpdate = mainDBHelper.updateName(barCode.getText().toString(), name.getText().toString());
                    if (isUpdate == true) {
                        toastMessage("Név módosítva!");
                    } else {
                        toastMessage("Sikertelen módosítás");
                    }
                    dataView();
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
                if (barCode.length() != 0 && price.length() != 0) {
                    boolean isUpdate = mainDBHelper.updatePrice(barCode.getText().toString(), price.getText().toString());
                    if (isUpdate == true) {
                        toastMessage("Ár módosítva!");
                    } else {
                        toastMessage("Sikertelen módosítás");
                    }
                    dataView();
                }else {
                    toastMessage("Hiányzó adat!");
                }
            }
        });
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onClick(final android.view.View v) {
        switch (v.getId()) {
            case R.id.backButton:
                Intent list1 = new Intent(ItemMod.this, Items.class);
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
                Intent main = new Intent(ItemMod.this, MainActivity.class);
                startActivity(main);
                break;
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
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(ItemMod.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
