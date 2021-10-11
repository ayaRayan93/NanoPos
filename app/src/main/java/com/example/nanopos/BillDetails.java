package com.example.nanopos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import com.example.nanopos.json.Parser;
import com.example.nanopos.models.Bill;
import com.example.nanopos.models.BillDetail;
import com.example.nanopos.models.Payment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BillDetails extends AppCompatActivity {

    protected List<BillDetail> dataSet;
    protected List<Payment> dataSetpayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_details);
        dataSet=new ArrayList<>();
        dataSetpayment=new ArrayList<>();
        String f=getIntent().getStringExtra("invoid");
        initiateRefresh(f);
        initiateRefreshpayment(f);
    }

    public  void initiateRefresh(String invno)
    {
        String Url="http://palmera-residence.com/shefit/invoiceDetails.php?invno="+invno;

        RequestQueue queue = Volley.newRequestQueue(this);
        /////////////connection//////////
        StringRequest strReq = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(String response)
            {
                Log.d("response", response);
                Iterator iterator = Parser.parseStringToJsonBillDetails(response).iterator();
                while (iterator.hasNext()){
                    BillDetail bill = (BillDetail) iterator.next();
                    dataSet.add(bill);
                }

                TableLayout table = findViewById(R.id.tabledatadetails);
                TableRow row = new TableRow(getBaseContext());
                row.setBackground(getDrawable(R.drawable.rectanglebg2));

                TextView tv = new TextView(getBaseContext());
                tv.setText("م");
                tv.setTextSize(25);
                tv.setPadding(40,40,40,40);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv1 = new TextView(getBaseContext());
                tv1.setText("الصنف");
                tv1.setTextSize(25);
                tv1.setPadding(40,40,40,40);
                tv1.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv2 = new TextView(getBaseContext());
                tv2.setText("السعر");
                tv2.setTextSize(25);
                tv2.setPadding(40,40,40,40);
                tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv2.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv3 = new TextView(getBaseContext());
                tv3.setText("الكمية");
                tv3.setTextSize(25);
                tv3.setPadding(40,40,40,40);
                tv3.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv4 = new TextView(getBaseContext());
                tv4.setText("القيمة");
                tv4.setTextSize(25);
                tv4.setPadding(40,40,40,40);
                tv4.setBackground(getDrawable(R.drawable.rectanglebgcell));

                row.addView(tv);
                row.addView(tv1);
                row.addView(tv2);
                row.addView(tv3);
                row.addView(tv4);

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
                    tv1.setText(dataSet.get(i).getItemartitle());
                    tv1.setTextSize(20);
                    tv1.setPadding(4,4,4,4);
                    tv1.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv2 = new TextView(getBaseContext());
                    tv2.setText(dataSet.get(i).getPrice());
                    tv2.setTextSize(20);
                    tv2.setPadding(4,4,4,4);
                    tv2.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv3 = new TextView(getBaseContext());
                    tv3.setText(dataSet.get(i).getQty());
                    tv3.setTextSize(20);
                    tv3.setPadding(4,4,4,4);
                    tv3.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv4 = new TextView(getBaseContext());
                    tv4.setText(dataSet.get(i).getAmount());
                    tv4.setTextSize(20);
                    tv4.setPadding(4,4,4,4);
                    tv4.setBackground(getDrawable(R.drawable.rectanglebgcell2));

                    row.addView(tv);
                    row.addView(tv1);
                    row.addView(tv2);
                    row.addView(tv3);
                    row.addView(tv4);
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
    public  void initiateRefreshpayment(String invno)
    {
        String Url="http://palmera-residence.com/shefit/paymentinvoice.php?invno="+invno;

        RequestQueue queue = Volley.newRequestQueue(this);
        /////////////connection//////////
        StringRequest strReq = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(String response)
            {
                Log.d("response", response);
                Iterator iterator = Parser.parseStringToJsonBillPayment(response).iterator();
                while (iterator.hasNext()){
                    Payment bill = (Payment) iterator.next();
                    dataSetpayment.add(bill);
                }

                TableLayout table = findViewById(R.id.tabledatapayment2);
                TableRow row = new TableRow(getBaseContext());

                TextView tv = new TextView(getBaseContext());
                tv.setText("البند");
                tv.setTextSize(25);
                tv.setPadding(40,40,40,40);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setBackground(getDrawable(R.drawable.rectanglebgcell));
                TextView tv1 = new TextView(getBaseContext());
                tv1.setText("القيمة");
                tv1.setTextSize(25);
                tv1.setPadding(40,40,40,40);
                tv1.setBackground(getDrawable(R.drawable.rectanglebgcell));

                row.addView(tv);
                row.addView(tv1);
                table.addView(row);
                for(int i=0; i<dataSetpayment.size(); i++) {
                    row = new TableRow(getBaseContext());

                    tv = new TextView(getBaseContext());
                    tv.setText(dataSetpayment.get(i).getPayarname());
                    tv.setTextSize(20);
                    tv.setPadding(4,4,4,4);
                    tv.setBackground(getDrawable(R.drawable.rectanglebgcell2));
                    tv1 = new TextView(getBaseContext());
                    tv1.setText(dataSetpayment.get(i).getTotal());
                    tv1.setTextSize(20);
                    tv1.setPadding(4,4,4,4);
                    tv1.setBackground(getDrawable(R.drawable.rectanglebgcell2));


                    row.addView(tv);
                    row.addView(tv1);
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
}