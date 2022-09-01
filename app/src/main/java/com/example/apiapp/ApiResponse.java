package com.example.apiapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiResponse extends AppCompatActivity {
    String alertTitle;
    String alertContent;
    private FloatingActionButton homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_response);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gamelaunch-stage.everymatrix.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Post> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    alert("Code", String.valueOf(response.code()));
                    return;
                }

                Post posts = response.body();

                alertTitle = "ErrorType: " + posts.getErrorType();

                alertContent = "";
                alertContent += "ErrorMessage: " + posts.getMessage() + "\n";
                alertContent += "RequestID: " + posts.getRequestId() + "\n";
                alertContent += "Time: " + posts.getTime() + "\n"+"\n" ;

                alert(alertTitle, alertContent);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                alert("Call failed", t.getMessage());

            }
        });

        FloatingActionButton homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }

    private void alert(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(ApiResponse.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        alertDialog.show();
    }


}