package com.example.shoppinglistapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ProductListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Product> mProductList;

    public ProductListAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.db_product_list, null);
        TextView barcode = (TextView) v.findViewById(R.id.barCode);
        TextView name = (TextView) v.findViewById(R.id.name);
        TextView price = (TextView) v.findViewById(R.id.price);

        barcode.setText("Vonalkód: " + mProductList.get(position).getBarCode());
        name.setText("Termék név: " + mProductList.get(position).getName());
        price.setText("Ár: " + mProductList.get(position).getPrice() + "Ft");

        v.setTag(mProductList.get(position).getID());
        return v;
    }
}
