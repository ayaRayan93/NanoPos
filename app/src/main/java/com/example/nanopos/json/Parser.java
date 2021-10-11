package com.example.nanopos.json;

import com.example.nanopos.models.Bill;
import com.example.nanopos.models.BillDetail;
import com.example.nanopos.models.Payment;
import com.example.nanopos.models.Shifts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Shifts> parseStringToJson(String data) {
        List<Shifts> mShifts;

        try {
            JSONArray jsonArray =new JSONArray(data);
            mShifts = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject mShiftsJsonObject = jsonArray.getJSONObject(i);
                String login = mShiftsJsonObject.optString("login");
                String startdate = mShiftsJsonObject.optString("startdate");
                String enddate =  mShiftsJsonObject.optString("enddate");
                String serial = mShiftsJsonObject.optString("serial");
                String sartitle = mShiftsJsonObject.optString("sartitle");
                String shiftdate = mShiftsJsonObject.optString("shiftdate");
                String partitle = mShiftsJsonObject.optString("partitle");



                Shifts shifts = new Shifts();
                shifts.setLogin(login);
                shifts.setStartdate(startdate);
                shifts.setEnddate(enddate);
                shifts.setSerial(serial);
                shifts.setSartitle(sartitle);
                shifts.setShiftdate(shiftdate);
                shifts.setPartitle(partitle);

                mShifts.add(shifts);


            }

            return mShifts;

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
    public static List<Bill> parseStringToJsonBill(String data) {
        List<Bill> mShifts;

        try {
            JSONArray jsonArray =new JSONArray(data);
            mShifts = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject mShiftsJsonObject = jsonArray.getJSONObject(i);
                String invno = mShiftsJsonObject.optString("invno");
                String startdate = mShiftsJsonObject.optString("startdate");
                String enddate =  mShiftsJsonObject.optString("enddate");
                String total = mShiftsJsonObject.optString("total");
                String tableno = mShiftsJsonObject.optString("tableno");
                String description = mShiftsJsonObject.optString("description");



                Bill bill = new Bill();
                bill.setInvno(invno);
                bill.setStartdate(startdate);
                bill.setEnddate(enddate);
                bill.setTotal(total);
                bill.setTableno(tableno);
                bill.setDescription(description);

                mShifts.add(bill);


            }

            return mShifts;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static List<BillDetail> parseStringToJsonBillDetails(String data) {
        List<BillDetail> mShifts;

        try {
            JSONArray jsonArray =new JSONArray(data);
            mShifts = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject mShiftsJsonObject = jsonArray.getJSONObject(i);
                String itemartitle = mShiftsJsonObject.optString("itemartitle");
                String price = mShiftsJsonObject.optString("price");
                String qty =  mShiftsJsonObject.optString("qty");
                String amount = mShiftsJsonObject.optString("amount");

                BillDetail bill = new BillDetail();
                bill.setItemartitle(itemartitle);
                bill.setPrice(price);
                bill.setQty(qty);
                bill.setAmount(amount);

                mShifts.add(bill);

            }

            return mShifts;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Payment> parseStringToJsonBillPayment(String data) {
        List<Payment> mShifts;

        try {
            JSONArray jsonArray =new JSONArray(data);
            mShifts = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject mShiftsJsonObject = jsonArray.getJSONObject(i);
                String total = mShiftsJsonObject.optString("total");
                String payarname = mShiftsJsonObject.optString("payarname");



                Payment bill = new Payment();
                bill.setTotal(total);
                bill.setPayarname(payarname);

                mShifts.add(bill);


            }

            return mShifts;

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
