package info.ktdaloanapp.ktdaloansaccoapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity  {


    //declaration of variables
    private ImageView  muser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization of variables

        muser = (ImageView) findViewById(R.id.user);

    }


    public void login(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }



}
