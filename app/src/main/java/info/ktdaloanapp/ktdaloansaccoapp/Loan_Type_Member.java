package info.ktdaloanapp.ktdaloansaccoapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Loan_Type_Member extends AppCompatActivity {
    ListView listViewLoanTypes;
    DatabaseReference databaseLoanTypes;
    List<LoanType> loantypeList;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_type_member);
        databaseLoanTypes = FirebaseDatabase.getInstance().getReference("loantype");


        listViewLoanTypes = (ListView) findViewById(R.id.listViewLoanTypes);

        loantypeList = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseLoanTypes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                loantypeList.clear();
                for(DataSnapshot loantypeSnapshot: dataSnapshot.getChildren()){
                    LoanType loantype = loantypeSnapshot.getValue(LoanType.class);

                    loantypeList.add(loantype);

            }
                LoanTypeList adapter = new LoanTypeList(Loan_Type_Member.this, loantypeList);
                listViewLoanTypes.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
