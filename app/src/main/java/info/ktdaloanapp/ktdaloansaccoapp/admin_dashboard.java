package info.ktdaloanapp.ktdaloansaccoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class admin_dashboard extends AppCompatActivity {



   @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

    }

    public void Logout(View view) {
        if (view.getId() == R.id.sign_out) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            // user is now signed out
                            startActivity(new Intent(admin_dashboard.this, Login.class));
                            finish();
                        }
                    });

        }
    }
    public void loan_type(View view){
        Intent intent = new Intent(this, Loan_Type.class);
        startActivity(intent);
    }
    public void reports(View view){
        Intent intent = new Intent(this, Report.class);
        startActivity(intent);
    }
    public void bar_chart(View view){
        Intent intent = new Intent(this, chart.class);
        startActivity(intent);
    }
    public void graph(View view){
        Intent intent = new Intent(this, graph.class);
        startActivity(intent);
    }
    }

