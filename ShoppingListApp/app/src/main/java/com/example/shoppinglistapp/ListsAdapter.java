package com.example.shoppinglistapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListsAdapter extends BaseAdapter {
    private Context mContext;
    private List<ListProduct> mItemProductList;

    public ListsAdapter(Context mContext, List<ListProduct> mItemProductList) {
        this.mContext = mContext;
        this.mItemProductList = mItemProductList;
    }

    @Override
    public int getCount() {
        return mItemProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.list_product_list, null);
        TextView id = (TextView) v.findViewById(R.id.data1);
        TextView name = (TextView) v.findViewById(R.id.data2);
        TextView price = (TextView) v.findViewById(R.id.data3);
        TextView piece = (TextView) v.findViewById(R.id.data4);

        id.setText("Azonosító: " + mItemProductList.get(position).getID());
        name.setText("Termék név: " + mItemProductList.get(position).getName());
        price.setText("Ár: " + mItemProductList.get(position).getPrice() + "Ft");
        piece.setText("Mennyiség: " + mItemProductList.get(position).getPiece());

        v.setTag(mItemProductList.get(position).getID());
        return v;
    }
}
