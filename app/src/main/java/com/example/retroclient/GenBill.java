package com.example.retroclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenBill extends AppCompatActivity {

    LoginService loginService;
    EditText edtBillSD;
   // EditText edtBillED;
    EditText edtFreq;
    Button btnGenBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_bill);


        edtBillSD = (EditText) findViewById(R.id.edtBillSD);
       // edtBillED = (EditText) findViewById(R.id.edtBillED);
        edtFreq = (EditText) findViewById(R.id.edtFreq);
        btnGenBill = (Button) findViewById(R.id.btnGenBill);

        loginService = ServiceGenerator.createService(LoginService.class);

        btnGenBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BillGen bg = new BillGen();

               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                try {

                 //   Date edate = sdf.parse(edtBillED.getText().toString()+"T00:00:00");
                    Date sdate = sdf.parse(edtBillSD.getText().toString().trim()+"T00:00:00");

                   // String edate1 = sdf.format(edate);
                    String sdate1 = sdf.format(sdate);
                   // bg.setBillgenend(edtBillED.getText().toString()+"T00:00:00");
                    bg.setBillgenstart(edtBillSD.getText().toString().trim()+"T00:00:00");
                    bg.setBillfreq(Integer.parseInt(edtFreq.getText().toString()));
                    //bg.setBillgenend(edate1);
                    //bg.setBillgenstart(sdate1);
                    bg.setId(0);

                   // System.out.println(edate1);
                    System.out.println("............Bill Freq....."+Integer.parseInt(edtFreq.getText().toString()));

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Call<BillGen> call =  loginService.generateBill(bg);
                call.enqueue(new Callback<BillGen>() {
                    @Override
                    public void onResponse(Call<BillGen> call, Response<BillGen> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(GenBill.this, "Bills Generated", Toast.LENGTH_SHORT).show();
                            Log.d("Bills generated ", response.body().toString());
                            startActivity(new Intent(getApplicationContext(), OwnerDisplay.class));
                            // user object available
                        } else {
                            // error response, no access to resource?
                            Toast.makeText(getApplicationContext(), "Cannot Generate Bills ", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BillGen> call, Throwable t) {

                    }
                });
            }
        });




    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GenBill.this, Options.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
