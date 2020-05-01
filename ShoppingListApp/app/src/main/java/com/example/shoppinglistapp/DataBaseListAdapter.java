package com.example.shoppinglistapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DataBaseListAdapter extends BaseAdapter {

    private Context mContext;
    private List<DataBaseProduct> mDataBaseProductList;

    public DataBaseListAdapter(Context mContext, List<DataBaseProduct> mDataBaseProductList) {
        this.mContext = mContext;
        this.mDataBaseProductList = mDataBaseProductList;
    }

    @Override
    public int getCount() {
        return mDataBaseProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataBaseProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.db_product_list, null);
        TextView barcode = (TextView) v.findViewById(R.id.data2);
        TextView name = (TextView) v.findViewById(R.id.data1);
        TextView price = (TextView) v.findViewById(R.id.data3);

        barcode.setText("Vonalkód: " + mDataBaseProductList.get(position).getBarCode());
        name.setText("Termék név: " + mDataBaseProductList.get(position).getName());
        price.setText("Ár: " + mDataBaseProductList.get(position).getPrice() + "Ft");

        v.setTag(mDataBaseProductList.get(position).getID());
        return v;
    }
}
