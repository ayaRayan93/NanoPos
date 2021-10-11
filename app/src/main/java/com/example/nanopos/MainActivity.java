package com.example.nanopos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nanopos.adapter.ShiftAdapter;
import com.example.nanopos.adapter.ShiftAdapter2;
import com.example.nanopos.json.Parser;
import com.example.nanopos.models.Shifts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected List<Shifts> dataSet;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datagridviewshifts);
        dataSet=new ArrayList<>();
        initiateRefresh();

        EditText d1=(EditText) findViewById(R.id.editTextDate);
        EditText d2=(EditText) findViewById(R.id.editTextDate2);
        DatePicker datePicker1=(DatePicker)findViewById(R.id.date1);
        DatePicker datePicker2=(DatePicker)findViewById(R.id.date2);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( datePicker1.getVisibility()==View.VISIBLE)
                    datePicker1.setVisibility(View.GONE);
                else
                    datePicker1.setVisibility(View.VISIBLE);
                datePicker2.setVisibility(View.GONE);
            }
        });
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( datePicker2.getVisibility()==View.VISIBLE)
                    datePicker2.setVisibility(View.GONE);
                else
                    datePicker2.setVisibility(View.VISIBLE);
                datePicker1.setVisibility(View.GONE);
            }
        });
       /* datePicker1.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear+=1;
                String m=""+monthOfYear,d=""+dayOfMonth;
                if(monthOfYear<10)
                    m="0"+monthOfYear;
                if(dayOfMonth<10)
                    d="0"+dayOfMonth;
                d1.setText(year+"-"+m+"-"+d);
            }
        });
        datePicker2.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear+=1;
                String m=""+monthOfYear,d=""+dayOfMonth;
                if(monthOfYear<10)
                    m="0"+monthOfYear;
                if(dayOfMonth<10)
                    d="0"+dayOfMonth;
                d2.setText(year+"-"+m+"-"+d);
            }
        });
        Button btn=(Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiateRefresh(d1.getText().toString(),d2.getText().toString());
            }
        });*/
    }

    public  void initiateRefresh()
    {
        String Url="http://palmera-residence.com/shefit/shifts.php";


        RequestQueue queue = Volley.newRequestQueue(this);
        /////////////connection//////////
        StringRequest strReq = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(String response)
            {
                Log.d("response", response);
                Iterator iterator = Parser.parseStringToJson(response).iterator();
                while (iterator.hasNext()){
                    Shifts photographer = (Shifts) iterator.next();
                    dataSet.add(photographer);
                }

                TableLayout table = findViewById(R.id.tabledata);
                TableRow row = new TableRow(getBaseContext());
                row.setBackground(getDrawable(R.drawable.rectanglebg2));

                TextView tv = new TextView(getBaseContext());
                tv.setText("م");
                tv.setTextSize(25);
                tv.setPadding(40,40,40,40);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv1 = new TextView(getBaseContext());
                tv1.setText("الكاشير");
                tv1.setTextSize(25);
                tv1.setPadding(40,40,40,40);
                tv1.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv2 = new TextView(getBaseContext());
                tv2.setText("بداية الوردية");
                tv2.setTextSize(25);
                tv2.setPadding(40,40,40,40);
                tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv2.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv3 = new TextView(getBaseContext());
                tv3.setText("نهاية الوردية");
                tv3.setTextSize(25);
                tv3.setPadding(40,40,40,40);
                tv3.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv4 = new TextView(getBaseContext());
                tv4.setText("مسلسل الوردية");
                tv4.setTextSize(25);
                tv4.setPadding(40,40,40,40);
                tv4.setBackground(getDrawable(R.drawable.rectanglebgcell));

                TextView tv5 = new TextView(getBaseContext());
                tv5.setText("اسم الوردية");
                tv5.setTextSize(25);
                tv5.setPadding(40,40,40,40);
                tv5.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv6 = new TextView(getBaseContext());
                tv6.setText("تاريخ الوردية");
                tv6.setTextSize(25);
                tv6.setPadding(40,40,40,40);
                tv6.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv7 = new TextView(getBaseContext());
                tv7.setText("نقطة البيع");
                tv7.setTextSize(25);
                tv7.setPadding(40,40,40,40);
                tv7.setBackground(getDrawable(R.drawable.rectanglebgcell));
                row.addView(tv);
                row.addView(tv1);
                row.addView(tv2);
                row.addView(tv3);
                row.addView(tv4);
                row.addView(tv5);
                row.addView(tv6);
                row.addView(tv7);
                table.addView(row);
                for(int i=0; i<dataSet.size(); i++) {
                    row = new TableRow(getBaseContext());
                    row.setBackground(getDrawable(R.drawable.rectanglebg));

                    tv = new TextView(getBaseContext());
                    tv.setText(i+1+"");
                    tv.setTextSize(20);
                    tv.setPadding(4,4,4,4);
                    tv.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv1 = new TextView(getBaseContext());
                    tv1.setText(dataSet.get(i).getLogin());
                    tv1.setTextSize(20);
                    tv1.setPadding(4,4,4,4);
                    tv1.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv2 = new TextView(getBaseContext());
                    tv2.setText(dataSet.get(i).getStartdate());
                    tv2.setTextSize(20);
                    tv2.setPadding(4,4,4,4);
                    tv2.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv3 = new TextView(getBaseContext());
                    tv3.setText(dataSet.get(i).getEnddate());
                    tv3.setTextSize(20);
                    tv3.setPadding(4,4,4,4);
                    tv3.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv4 = new TextView(getBaseContext());
                    tv4.setText(dataSet.get(i).getSerial());
                    tv4.setTextSize(20);
                    tv4.setPadding(4,4,4,4);
                    tv4.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Context context2 = v.getContext();
                            TextView t=(TextView)v;
                            String d=t.getText().toString();
                            Intent intent = new Intent(context2, Bills.class);
                            intent.putExtra("serial",d);
                            context2.startActivity(intent);
                        }
                    });
                    tv5 = new TextView(getBaseContext());
                    tv5.setText(dataSet.get(i).getSartitle());
                    tv5.setTextSize(20);
                    tv5.setPadding(4,4,4,4);
                    tv5.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv6 = new TextView(getBaseContext());
                    tv6.setText(dataSet.get(i).getShiftdate());
                    tv6.setTextSize(20);
                    tv6.setPadding(4,4,4,4);
                    tv6.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv7 = new TextView(getBaseContext());
                    tv7.setText(dataSet.get(i).getPartitle());
                    tv7.setTextSize(20);
                    tv7.setPadding(4,4,4,4);
                    tv7.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    row.addView(tv);
                    row.addView(tv1);
                    row.addView(tv2);
                    row.addView(tv3);
                    row.addView(tv4);
                    row.addView(tv5);
                    row.addView(tv6);
                    row.addView(tv7);
                    table.addView(row);
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // Stop the refreshing indicator
                Log.d("response", error.toString());
            }
        });
        strReq.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Adding request to volley request queue
        queue.add(strReq);

    }
    public  void initiateRefresh(String from,String to)
    {
        String Url="http://palmera-residence.com/shefit/shiftsbydate.php?From='"+from+"'&To='"+to+"'";


        RequestQueue queue = Volley.newRequestQueue(this);
        /////////////connection//////////
        StringRequest strReq = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(String response)
            {
                Log.d("response", response);
                dataSet.clear();
                Iterator iterator = Parser.parseStringToJson(response).iterator();
                while (iterator.hasNext()){
                    Shifts photographer = (Shifts) iterator.next();
                    dataSet.add(photographer);
                }

                TableLayout table = findViewById(R.id.tabledata);
                table.removeAllViews();
                if(dataSet.size()>0) {
                    TableRow row = new TableRow(getBaseContext());

                    TextView tv = new TextView(getBaseContext());
                    tv.setText("م");
                    tv.setTextSize(25);
                    tv.setPadding(40, 40, 40, 40);
                    tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    tv.setBackground(getDrawable(R.drawable.rectanglebgcell));
                    TextView tv1 = new TextView(getBaseContext());
                    tv1.setText("الكاشير");
                    tv1.setTextSize(25);
                    tv1.setPadding(40, 40, 40, 40);
                    tv1.setBackground(getDrawable(R.drawable.rectanglebgcell));
                    TextView tv2 = new TextView(getBaseContext());
                    tv2.setText("بداية الوردية");
                    tv2.setTextSize(25);
                    tv2.setPadding(40, 40, 40, 40);
                    tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    tv2.setBackground(getDrawable(R.drawable.rectanglebgcell));
                    TextView tv3 = new TextView(getBaseContext());
                    tv3.setText("نهاية الوردية");
                    tv3.setTextSize(25);
                    tv3.setPadding(40, 40, 40, 40);
                    tv3.setBackground(getDrawable(R.drawable.rectanglebgcell));
                    TextView tv4 = new TextView(getBaseContext());
                    tv4.setText("مسلسل الوردية");
                    tv4.setTextSize(25);
                    tv4.setPadding(40, 40, 40, 40);
                    tv4.setBackground(getDrawable(R.drawable.rectanglebgcell));
                    TextView tv5 = new TextView(getBaseContext());
                    tv5.setText("اسم الوردية");
                    tv5.setTextSize(25);
                    tv5.setPadding(40, 40, 40, 40);
                    tv5.setBackground(getDrawable(R.drawable.rectanglebgcell));
                    TextView tv6 = new TextView(getBaseContext());
                    tv6.setText("تاريخ الوردية");
                    tv6.setTextSize(25);
                    tv6.setPadding(40, 40, 40, 40);
                    tv6.setBackground(getDrawable(R.drawable.rectanglebgcell));
                    TextView tv7 = new TextView(getBaseContext());
                    tv7.setText("نقطة البيع");
                    tv7.setTextSize(25);
                    tv7.setPadding(40, 40, 40, 40);
                    tv7.setBackground(getDrawable(R.drawable.rectanglebgcell));
                    row.addView(tv);
                    row.addView(tv1);
                    row.addView(tv2);
                    row.addView(tv3);
                    row.addView(tv4);
                    row.addView(tv5);
                    row.addView(tv6);
                    row.addView(tv7);
                    table.addView(row);
                    for (int i = 0; i < dataSet.size(); i++) {
                        row = new TableRow(getBaseContext());


                        tv = new TextView(getBaseContext());
                        tv.setText(i + 1 + "");
                        tv.setTextSize(20);
                        tv.setPadding(4, 4, 4, 4);
                        tv.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                        tv1 = new TextView(getBaseContext());
                        tv1.setText(dataSet.get(i).getLogin());
                        tv1.setTextSize(20);
                        tv1.setPadding(4, 4, 4, 4);
                        tv1.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                        tv2 = new TextView(getBaseContext());
                        tv2.setText(dataSet.get(i).getStartdate());
                        tv2.setTextSize(20);
                        tv2.setPadding(4, 4, 4, 4);
                        tv2.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                        tv3 = new TextView(getBaseContext());
                        tv3.setText(dataSet.get(i).getEnddate());
                        tv3.setTextSize(20);
                        tv3.setPadding(4, 4, 4, 4);
                        tv3.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                        tv4 = new TextView(getBaseContext());
                        tv4.setText(dataSet.get(i).getSerial());
                        tv4.setTextSize(20);
                        tv4.setPadding(4, 4, 4, 4);
                        tv4.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                        tv4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Context context2 = v.getContext();
                                TextView t=(TextView)v;
                                String d=t.getText().toString();
                                Intent intent = new Intent(context2, Bills.class);
                                intent.putExtra("serial",d);
                                context2.startActivity(intent);
                            }
                        });
                        tv5 = new TextView(getBaseContext());
                        tv5.setText(dataSet.get(i).getSartitle());
                        tv5.setTextSize(20);
                        tv5.setPadding(4, 4, 4, 4);
                        tv5.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                        tv6 = new TextView(getBaseContext());
                        tv6.setText(dataSet.get(i).getShiftdate());
                        tv6.setTextSize(20);
                        tv6.setPadding(4, 4, 4, 4);
                        tv6.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                        tv7 = new TextView(getBaseContext());
                        tv7.setText(dataSet.get(i).getPartitle());
                        tv7.setTextSize(20);
                        tv7.setPadding(4, 4, 4, 4);
                        tv7.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                        row.addView(tv);
                        row.addView(tv1);
                        row.addView(tv2);
                        row.addView(tv3);
                        row.addView(tv4);
                        row.addView(tv5);
                        row.addView(tv6);
                        row.addView(tv7);
                        table.addView(row);
                    }
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // Stop the refreshing indicator
                Log.d("response", error.toString());
            }
        });
        strReq.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Adding request to volley request queue
        queue.add(strReq);

    }
}