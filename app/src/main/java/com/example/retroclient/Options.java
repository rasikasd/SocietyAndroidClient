package com.example.retroclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Options extends AppCompatActivity implements View.OnClickListener {

    public CardView auser,gbill,grec,conu,allres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        auser = (CardView)findViewById(R.id.add_user);
        gbill = (CardView)findViewById(R.id.get_bill);
        grec = (CardView)findViewById(R.id.get_rec);
        conu = (CardView)findViewById(R.id.get_us);
        allres = (CardView)findViewById(R.id.get_user);



        auser.setOnClickListener(this);
        gbill.setOnClickListener(this);
        grec.setOnClickListener(this);
        conu.setOnClickListener(this);
        allres.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){

            case R.id.get_user : i = new Intent(this,OwnerDisplay.class);startActivity(i);break;

            case R.id.add_user : i = new Intent(this,OwnerActivity.class);i.putExtra("user_name", "");startActivity(i);break;

            case R.id.get_bill : i = new Intent(this,GenBill.class);startActivity(i);break;

            case R.id.get_rec : i = new Intent(this,AddReceipt.class);startActivity(i);break;

            case R.id.get_us : i = new Intent(this,Contact.class);startActivity(i);break;

            default:break;

        }
    }
}
