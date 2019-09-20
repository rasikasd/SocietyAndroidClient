package com.example.retroclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private EditText editTextEmail, editTextPassword;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);

        buttonSignIn = (Button) findViewById(R.id.submit);

        buttonSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view == buttonSignIn) {
            userSignIn();
        }
    }

    private void userSignIn()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        String username = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        Login login = new Login(username,password);
         LoginService loginService =
                ServiceGenerator.createService(LoginService.class, username, password);

        Call<Message> call = loginService.basicLogin();
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {

                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Log.d("Login Success", response.body().toString());
                    finish();
                    startActivity(new Intent(getApplicationContext(), Options.class));
                    // user object available
                } else {
                    // error response, no access to resource?
                    Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t)
            {
                progressDialog.dismiss();
                Log.d("Error", t.getMessage());

            }
        });
    }

}




