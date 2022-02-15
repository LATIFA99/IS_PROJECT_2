package info.ktdaloanapp.ktdaloansaccoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.firebase.ui.auth.AuthUI;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class MainHomePage extends AppCompatActivity {





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhomepage);

    }

    public void Logout(View view) {
        if (view.getId() == R.id.sign_out) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            // user is now signed out
                            startActivity(new Intent(MainHomePage.this, Login.class));
                            finish();
                        }
                    });

        }
        }

    public void loan_applications(View view){
        Intent intent = new Intent(this, Apply_Loan.class);
        startActivity(intent);


    }

    public void loan_calculate(View view){
        Intent intent = new Intent(this, LoanCalculatorActivity.class);
        startActivity(intent);
    }

    public void loan_type_details(View view){
        Intent intent = new Intent(this, Loan_Type_Member.class);
        startActivity(intent);
    }
       }



