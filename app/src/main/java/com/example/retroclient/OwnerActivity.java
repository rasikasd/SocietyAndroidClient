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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.sql.Types.NULL;

public class OwnerActivity extends AppCompatActivity {


    LoginService loginService;
    EditText edtUId;
    EditText edtFirstname;
    EditText edtLastname;
    EditText edtFlatno;
    Button btnSave;

   // Button btnShowBill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);

        setTitle("Owners");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        edtUId = (EditText) findViewById(R.id.edtUId);
        edtFirstname = (EditText) findViewById(R.id.edtFirstname);
        edtLastname = (EditText) findViewById(R.id.edtLastname);
        edtFlatno = (EditText) findViewById(R.id.edtFlatno);
        btnSave = (Button) findViewById(R.id.btnSave);


        loginService = ServiceGenerator.createService(LoginService.class);


        Bundle extras = getIntent().getExtras();
        final String Id = extras.getString("Owner_id");
        String FirstName = extras.getString("Owner_Firstname");
        String LastName = extras.getString("Owner_Lastname");
        String FlatNo = extras.getString("Owner_Flatno");

        edtUId.setText(Id);
        edtFirstname.setText(FirstName);
        edtLastname.setText(LastName);
        edtFlatno.setText(FlatNo);

        if(Id != null && Id.trim().length() > 0 ){
            edtUId.setFocusable(false);
        } else {
            edtUId.setVisibility(View.INVISIBLE);

        }


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Owner o = new Owner();


                o.setFirstname(edtFirstname.getText().toString());
                o.setLastname(edtLastname.getText().toString());
                o.setFlatno(edtFlatno.getText().toString());
                if(Id != null && Id.trim().length() > 0){
                    //update user
                    o.setId(Integer.parseInt(Id));
                    System.out.println(Id);
                    updateUser(Integer.parseInt(Id), o);
                }
                else
                {
                    o.setFirstname(edtFirstname.getText().toString().trim());
                    o.setLastname(edtLastname.getText().toString().trim());
                    o.setFlatno(edtFlatno.getText().toString().trim());

                    Call<Owner> call = loginService.addOwner(o);

                    call.enqueue(new Callback<Owner>() {
                        @Override
                        public void onResponse(Call<Owner> call, Response<Owner> response) {

                            if (response.isSuccessful()) {
                                Toast.makeText(OwnerActivity.this, "Owner Added", Toast.LENGTH_SHORT).show();
                                Log.d("Owner Added", response.body().toString());
                                startActivity(new Intent(getApplicationContext(), OwnerDisplay.class));
                                // user object available
                            } else {
                                // error response, no access to resource?
                                Toast.makeText(getApplicationContext(), "Cannot Add Owner", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Owner> call, Throwable t) {

                            Log.d("Error", t.getMessage());
                        }
                    });
                }

            }
        });



     /*   btnShowBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               // Intent intent = new Intent(OwnerActivity.this, OwnerDisplay.class);
               // startActivity(intent);
            }
        });*/


    }


    public void updateUser(int id, Owner o){
        Call<Owner> call = loginService.updateOwner(id, o);
        System.out.println(o);
        call.enqueue(new Callback<Owner>() {
            @Override
            public void onResponse(Call<Owner> call, Response<Owner> response) {
                if(response.isSuccessful()){
                    Toast.makeText(OwnerActivity.this, "User updated successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(OwnerActivity.this, OwnerDisplay.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Owner> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }


}
