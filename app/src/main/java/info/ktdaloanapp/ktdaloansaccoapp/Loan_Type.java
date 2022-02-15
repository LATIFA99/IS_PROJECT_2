package info.ktdaloanapp.ktdaloansaccoapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Loan_Type  extends AppCompatActivity {

    TextView textViewLoanDetails;
    EditText editTextTypeOfLoan;
    Button buttonAdd;
    Spinner spinnerLoanTypeDetails;


    DatabaseReference databaseLoanTypes;
    ListView listViewLoanTypes;

    List<LoanType> loantypeList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_type);

        databaseLoanTypes = FirebaseDatabase.getInstance().getReference("loantype");

        textViewLoanDetails = (TextView) findViewById(R.id.textviewLoanDetails);
        editTextTypeOfLoan = (EditText) findViewById(R.id.editTextTypeOfLoan);
        buttonAdd = (Button) findViewById(R.id.buttonAddLoanType);
        spinnerLoanTypeDetails = (Spinner) findViewById(R.id.spinnerLoanTypeDetails);
        listViewLoanTypes = (ListView) findViewById(R.id.listViewLoanTypes);


        loantypeList = new ArrayList<>();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLoanType();

            }
        });
     listViewLoanTypes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
         @Override
         public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
             LoanType loanType =  loantypeList.get(i);
             showUpdateDialog(loanType.getLoantypeId(), loanType.getTypeofloan());
             return false;
         }
     });
    }


    @Override
    protected void onStart() {
        super.onStart();
        databaseLoanTypes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                loantypeList.clear();
                for(DataSnapshot loantypeSnapshot: dataSnapshot.getChildren()){
                    LoanType loanType = loantypeSnapshot.getValue(LoanType.class);

                    loantypeList.add(loanType);

                }
                LoanTypeList adapter = new LoanTypeList(Loan_Type.this, loantypeList);
                listViewLoanTypes.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void showUpdateDialog(final String loantypeId, String typeofloan){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final TextView  textViewLoanDetails= (TextView) dialogView.findViewById(R.id.textviewLoanDetails);
        final EditText editTextTypeOfLoan = (EditText) dialogView.findViewById(R.id.editTextTypeOfLoan);
        final Spinner spinnerLoanTypeDetails = (Spinner) dialogView.findViewById(R.id.spinnerLoanTypeDetails);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdate);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDelete);

        dialogBuilder.setTitle("Update or Delete Types Of Loan" + typeofloan);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loandetails = textViewLoanDetails.getText().toString().trim();
                String typeofloan = editTextTypeOfLoan.getText().toString().trim();
                String loantypedetails = spinnerLoanTypeDetails.getSelectedItem().toString();

                if(TextUtils.isEmpty(typeofloan)){
                    editTextTypeOfLoan.setError("Type of Loan required");
                    return;
                }

               updateLoanType(loantypeId, loandetails,typeofloan,loantypedetails);
                alertDialog.dismiss();

            }
        });

       buttonDelete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               deleteLoanType(loantypeId);
           }
       });

    }

    private void deleteLoanType(String loantypeId) {
        DatabaseReference drLoanType = FirebaseDatabase.getInstance().getReference("loantype").child(loantypeId);
        drLoanType.removeValue();
        Toast.makeText(this, "Loan Type is Deleted", Toast.LENGTH_LONG).show();

    }

    private boolean updateLoanType(String id,  String typeofloan, String loandetails,String loantypedetails){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("loantype").child(id);
        LoanType loanType = new LoanType(id,loandetails,typeofloan, loantypedetails);
        databaseReference.setValue(loanType);

        Toast.makeText(this, "Loan Type Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    private void addLoanType(){
        String loandetails = textViewLoanDetails.getText().toString().trim();
        String typeofloan = editTextTypeOfLoan.getText().toString().trim();
        String loantypedetails = spinnerLoanTypeDetails.getSelectedItem().toString();

        if(!TextUtils.isEmpty(typeofloan)){

            String id = databaseLoanTypes.push().getKey();
            LoanType loanType = new LoanType(id,loandetails,typeofloan, loantypedetails);
            databaseLoanTypes.child(id).setValue(loanType);
            Toast.makeText(this, "Loan Type Details Added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Enter the type of Loan", Toast.LENGTH_LONG).show();
        }



    }
}
