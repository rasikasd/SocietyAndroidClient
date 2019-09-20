package com.example.retroclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddReceipt extends AppCompatActivity {

    LoginService loginService;
    EditText edtOid;
    EditText edtBid;
    EditText edtAmount;
    EditText edtPaymentType;
    EditText edtPaymentDet;

    Button btnAddPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_receipt);

        edtOid = (EditText) findViewById(R.id.edtOid);
        edtBid = (EditText) findViewById(R.id.edtBid);
        edtAmount = (EditText) findViewById(R.id.edtAmount);
        edtPaymentType = (EditText) findViewById(R.id.edtPaymentType);
        edtPaymentDet = (EditText) findViewById(R.id.edtPaymentDet);
        btnAddPayment = (Button) findViewById(R.id.btnAddPayment);

        loginService = ServiceGenerator.createService(LoginService.class);


        btnAddPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Receipt r = new Receipt();
                Owner o = new Owner();
                Bill b = new Bill(); // add later

                Integer ownerid=Integer.parseInt(edtOid.getText().toString());
                Integer billid=Integer.parseInt(edtBid.getText().toString());

                r.setPaidamt(Float.parseFloat(edtAmount.getText().toString()));
                r.setPaymentdetail(edtPaymentDet.getText().toString());
                r.setPaymenttype(edtPaymentType.getText().toString());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                Date rcpdt = new Date();

                r.setRcptdate(sdf.format(rcpdt));
                System.out.println("Receipt date : "+r);
                Call<Receipt> call = loginService.addReceipt(ownerid,billid,r);
                call.enqueue(new Callback<Receipt>() {
                    @Override
                    public void onResponse(Call<Receipt> call, Response<Receipt> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(AddReceipt.this, "Receipt Generated ", Toast.LENGTH_SHORT).show();
                            Log.d("Receipt generated", response.body().toString());
                            startActivity(new Intent(getApplicationContext(), OwnerDisplay.class));
                            // user object available
                        } else {
                            // error response, no access to resource?
                            Toast.makeText(getApplicationContext(), "Cannot Generate Receipt ", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Receipt> call, Throwable t) {

                    }
                });


            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddReceipt.this, OwnerDisplay.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
