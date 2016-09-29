package com.bignerdranch.android.customermanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by jamila on 9/26/2016.
 */

public class CustomerListAdapter extends ArrayAdapter {

    List list = new ArrayList<>();
    InformationList informationList;
    public CustomerListAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView  firstName, lastName, sessions;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listRow = convertView;
        LayoutHandler layoutHandler;
        if(listRow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listRow = layoutInflater.inflate(R.layout.row_info, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.firstName = (TextView) listRow.findViewById(R.id.first);
            layoutHandler.lastName = (TextView) listRow.findViewById(R.id.last);
            layoutHandler.sessions = (TextView) listRow.findViewById(R.id.session);
            listRow.setTag(layoutHandler);
        }
        else
            {
                layoutHandler = (LayoutHandler)listRow.getTag();

            }
        InformationList informationList = (InformationList) this.getItem(position);
        layoutHandler.firstName.setText(informationList.getFname());
        layoutHandler.firstName.setText(informationList.getLname());
        layoutHandler.firstName.setText(informationList.getSession());



        return listRow;
    }
}
