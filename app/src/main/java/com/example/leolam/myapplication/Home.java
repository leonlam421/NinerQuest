package com.example.leolam.myapplication;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Freezable;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 55;
    static final int REQUEST_IMAGE_CAPTURE = 98;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button Free_Roam = (Button)findViewById(R.id.Free_Roam);
        Button Navigation = (Button)findViewById(R.id.Navigation);
        Button Events = (Button)findViewById(R.id.Events);
        Button Contact = (Button)findViewById(R.id.Contact);

        //Free Roam Button to AR Page
        Free_Roam.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(Build.VERSION_CODES.M)
            public void onClick(View view) {

                //Intent signup = new Intent(MainActivity.this, AR_Activity.class);
                //startActivity(signup);

                ActivityCompat.requestPermissions(Home.this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);
            }

        });


        //Navigation Button to Building List
        Navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(Home.this, Building_List.class);
                startActivity(signup);
            }
        });

        //Events Button to Events Page
        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(Home.this, Events.class);
                startActivity(signup);
            }
        });

        //Contact Button to Contact Page
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(Home.this, Contact.class);
                startActivity(signup);
            }
        });
    }

    //Ask Permission to Use Camera
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }

                } else {

                    // permission denied

                }
                return;
            }

        }
    }
}
