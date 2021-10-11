package com.example.nanopos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nanopos.R;
import com.example.nanopos.models.Shifts;

import java.util.ArrayList;

public class ShiftAdapter2 extends ArrayAdapter {

    ArrayList<Shifts> DataSet;

    public ShiftAdapter2(Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);
        DataSet = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.shiftcard, null);
        TextView login=v.findViewById(R.id.login);
        TextView startdate=v.findViewById(R.id.startdate);
        TextView enddate=v.findViewById(R.id.enddate);
        TextView serial=v.findViewById(R.id.serial);
        TextView sartitle=v.findViewById(R.id.sartitle);
        TextView shiftdate=v.findViewById(R.id.shiftdate);
        TextView partitle=v.findViewById(R.id.partitle);
        login.setText(DataSet.get(position).getLogin());
        startdate.setText(DataSet.get(position).getEnddate());
        enddate.setText(DataSet.get(position).getPartitle());
        serial.setText(DataSet.get(position).getEnddate());
        sartitle.setText(DataSet.get(position).getShiftdate());
        shiftdate.setText(DataSet.get(position).getSerial());
        partitle.setText(DataSet.get(position).getStartdate());
        return v;

    }

}
