package com.example.nanopos.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nanopos.MainActivity;
import com.example.nanopos.R;
import com.example.nanopos.models.Shifts;

import java.io.Serializable;
import java.util.List;

public class ShiftAdapter extends RecyclerView.Adapter<ShiftAdapter.ViewHolder>{
    private List<Shifts> DataSet;
    private static Context context;

    public ShiftAdapter(Context cont, List<Shifts> dataSet)
    {
        context=cont;
        DataSet = dataSet;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView login;
        TextView startdate;
        TextView enddate;
        TextView serial;
        TextView sartitle;
        TextView shiftdate;
        TextView partitle;

        public ViewHolder(View v)
        {
            super(v);
            login=v.findViewById(R.id.login);
            startdate=v.findViewById(R.id.startdate);
            enddate=v.findViewById(R.id.enddate);
            serial=v.findViewById(R.id.serial);
            sartitle=v.findViewById(R.id.sartitle);
            shiftdate=v.findViewById(R.id.shiftdate);
            partitle=v.findViewById(R.id.partitle);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

          //          Context context2 = v.getContext();
        //            Intent intent = new Intent(context2, MainActivity.class);
//                    intent.putExtra("Photographer", (Serializable) DataSet.get(getPosition()));
       //             context2.startActivity(intent);

                }
            });

        }

        public TextView getLogin() {
            return login;
        }

        public void setLogin(TextView login) {
            this.login = login;
        }

        public TextView getStartdate() {
            return startdate;
        }

        public void setStartdate(TextView startdate) {
            this.startdate = startdate;
        }

        public TextView getEnddate() {
            return enddate;
        }

        public void setEnddate(TextView enddate) {
            this.enddate = enddate;
        }

        public TextView getSerial() {
            return serial;
        }

        public void setSerial(TextView serial) {
            this.serial = serial;
        }

        public TextView getSartitle() {
            return sartitle;
        }

        public void setSartitle(TextView sartitle) {
            this.sartitle = sartitle;
        }

        public TextView getShiftdate() {
            return shiftdate;
        }

        public void setShiftdate(TextView shiftdate) {
            this.shiftdate = shiftdate;
        }

        public TextView getPartitle() {
            return partitle;
        }

        public void setPartitle(TextView partitle) {
            this.partitle = partitle;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shiftcard, parent, false);

        return  new ShiftAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        if (DataSet.get(position) != null)
        {

            holder.getLogin().setText(DataSet.get(position).getLogin());
            holder.getEnddate().setText(DataSet.get(position).getEnddate());
            holder.getPartitle().setText(DataSet.get(position).getPartitle());
            holder.getSartitle().setText(DataSet.get(position).getEnddate());
            holder.getShiftdate().setText(DataSet.get(position).getShiftdate());
            holder.getSerial().setText(DataSet.get(position).getSerial());
            holder.getStartdate().setText(DataSet.get(position).getStartdate());
        }
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }
}
