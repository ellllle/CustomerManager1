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

/**
 * Created by jamila on 9/28/2016.
 */

public class ListDataAdappter extends ArrayAdapter {

    List list = new ArrayList();
    public ListDataAdappter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHnadler{
        TextView first_name, last_name, sessions;
    }

    public void add(Object object){
        super.add(object);
        list.add(object);

    }
    public int getCount(){
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
        View row = convertView;
        LayoutHnadler layoutHnadler;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.rowinfo, parent, false );
            layoutHnadler = new LayoutHnadler();
            layoutHnadler.first_name = (TextView) row.findViewById(R.id.displayFirst);
            layoutHnadler.last_name = (TextView) row.findViewById(R.id.displaySecond);
            layoutHnadler.sessions = (TextView) row.findViewById(R.id.displaySession);
            row.setTag(layoutHnadler);
        }
        else
        {
            layoutHnadler = (LayoutHnadler)row.getTag();

        }

        DataProvider dataProvider = (DataProvider) this.getItem(position);
        layoutHnadler.first_name.setText(dataProvider.getFirst());
        layoutHnadler.last_name.setText(dataProvider.getLast());
        layoutHnadler.sessions.setText(dataProvider.getSession());

        return row;
    }


}
