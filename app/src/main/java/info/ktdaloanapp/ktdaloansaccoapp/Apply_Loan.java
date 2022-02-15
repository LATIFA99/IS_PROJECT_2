package info.ktdaloanapp.ktdaloansaccoapp;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Apply_Loan extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Loan");

    TextView textViewMemberLoanDetails;
    EditText editTextMemberFullName,editTextMemberAddress,editTextMemberContribution,editTextMemberBankBranch,editTextBankAccount,
             editTextMemberLoanType,editTextMemberLoanAmount,editTextMemberLoanInterest,editTextRepayment,
             editTextGuarantorFname,editTextGuarantorPhoneNumber;
    Button buttonApply,buttonClear;


    DatabaseReference databaseApplyLoan;
    SimpleDateFormat datePatternformat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_loan);

        databaseApplyLoan = FirebaseDatabase.getInstance().getReference("Loan");
        textViewMemberLoanDetails = (TextView) findViewById(R.id.MemberDetails);
        editTextMemberFullName = (EditText) findViewById(R.id.FullName);
        editTextMemberAddress = (EditText) findViewById(R.id.Address);
        editTextMemberContribution = (EditText) findViewById(R.id.Contribution);
        editTextMemberBankBranch = (EditText) findViewById(R.id.Bank_branch);
        editTextBankAccount = (EditText) findViewById(R.id.bank_account_number);
        editTextMemberLoanType = (EditText) findViewById(R.id.TypeOfLoan);
        editTextMemberLoanAmount = (EditText) findViewById(R.id.type_of_loan_amount);
        editTextMemberLoanInterest = (EditText) findViewById(R.id.loan_interest);
        editTextRepayment = (EditText) findViewById(R.id.repayment_period);
        editTextGuarantorFname = (EditText) findViewById(R.id.guarantors_Full_Name);
        editTextGuarantorPhoneNumber = (EditText) findViewById(R.id.guarantors_phone_number);

        buttonApply = (Button) findViewById(R.id.applyBtn);
        buttonClear = (Button)findViewById(R.id.clearBtn);



        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplyLoan();
                printPDF();

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MemberFullName = editTextMemberFullName.getText().toString().trim();
                String MemberAddress = editTextMemberAddress.getText().toString();
                String MemberContribution = editTextMemberContribution.getText().toString();
                String MemberBankBranch = editTextMemberBankBranch.getText().toString().trim();
                String BankAccount = editTextBankAccount.getText().toString();
                String MemberLoanType = editTextMemberLoanType.getText().toString().trim();
                String MemberLoanAmount = editTextMemberLoanAmount.getText().toString();
                String MemberLoanInterest = editTextMemberLoanInterest.getText().toString();
                String Repayment = editTextRepayment.getText().toString();
                String GuarantorFname = editTextGuarantorFname.getText().toString().trim();
                String GuarantorPhoneNumber = editTextGuarantorPhoneNumber.getText().toString();

                if(MemberFullName.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextMemberFullName.setText("");
                }
                if(MemberAddress.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextMemberAddress.setText("");
                }
                if(MemberContribution.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextMemberContribution.setText("");
                }
                if(MemberBankBranch.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextMemberBankBranch.setText("");
                }
                if(BankAccount.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextBankAccount.setText("");
                }
                if(MemberLoanType.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextMemberLoanType.setText("");
                }
                if(MemberLoanAmount.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextMemberLoanAmount.setText("");
                }
                if(MemberLoanInterest.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextMemberLoanInterest.setText("");
                }
                if(Repayment.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextRepayment.setText("");
                }
                if(GuarantorFname.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextGuarantorFname.setText("");
                }
                if( GuarantorPhoneNumber.isEmpty()) {
                    Toast.makeText(Apply_Loan.this, "Already Empty", Toast.LENGTH_SHORT).show();
                }else{
                    editTextGuarantorPhoneNumber.setText("");
                }

            }
        });
    }

    private void printPDF() {
        PdfDocument myPdfDocument = new PdfDocument();
        Paint paint = new Paint();
        Paint forLinePaint = new Paint();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(250, 350,1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);
        Canvas canvas = myPage.getCanvas();

        paint.setTextSize(15.5f);
        paint.setColor(Color.rgb(0,50,250));

        canvas.drawText("KTDA SACCO", 20,20,paint);
        paint.setTextSize(8.5f);
        canvas.drawText("MEMBER LOAN APPLICATION DETAILS:", 20,40,paint);
        forLinePaint.setStyle(Paint.Style.STROKE);
        forLinePaint.setPathEffect(new DashPathEffect(new float[]{5,5},0));
        forLinePaint.setStrokeWidth(2);
        canvas.drawLine(20,60,230,60,forLinePaint);

        canvas.drawText("Member Name:" +editTextMemberFullName.getText(), 20,95,paint);
        canvas.drawLine(20,75, 230, 75, forLinePaint);

       canvas.drawText("Member's Address:" +editTextMemberAddress.getText(), 20,115,paint);
        canvas.drawText("Member's Contribution:" +editTextMemberContribution.getText(), 20,135,paint);
        canvas.drawText("Member Bank Branch Name:" +editTextMemberBankBranch.getText(), 20,155,paint);
       canvas.drawText("Member Bank Account Number:" +editTextBankAccount.getText(), 20,175,paint);
        canvas.drawText("Member Loan Type:" +editTextMemberLoanType.getText(), 20,195,paint);
        canvas.drawText("Member Loan Amount:" +editTextMemberLoanAmount.getText(), 20,215,paint);
       canvas.drawText("Member Loan Interest:" +editTextMemberLoanInterest.getText(), 20,235,paint);
       canvas.drawText("Member Repayment Period In Months:" +editTextRepayment.getText(), 20,255,paint);
       canvas.drawText("Member's Guarantors Name:" +editTextGuarantorFname.getText(), 20,275,paint);
        canvas.drawText("Member Guarantor's Phone Number:" +editTextGuarantorPhoneNumber.getText(), 20,295,paint);



        canvas.drawText("Date:"+datePatternformat.format(new Date().getTime()),20,315,paint);

        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(12f);
        canvas.drawText("All Rights Reserved @KTDA SACCO APP", canvas.getWidth()/2, 335,paint);

        myPdfDocument.finishPage(myPage);
        File file = new File(this.getExternalFilesDir("/"),"Member Loan Application Details.pdf");

        try{
            myPdfDocument.writeTo(new FileOutputStream(file));
        }catch(IOException e){
            e.printStackTrace();
        }

        myPdfDocument.close();
    }


    private void ApplyLoan() {
        String MemberLoanDetails = textViewMemberLoanDetails.getText().toString().trim();
        String MemberFullName = editTextMemberFullName.getText().toString().trim();
        String MemberAddress = editTextMemberAddress.getText().toString();
        String MemberContribution = editTextMemberContribution.getText().toString();
        String MemberBankBranch = editTextMemberBankBranch.getText().toString().trim();
        String BankAccount = editTextBankAccount.getText().toString();
        String MemberLoanType = editTextMemberLoanType.getText().toString().trim();
        String MemberLoanAmount = editTextMemberLoanAmount.getText().toString();
        String MemberLoanInterest = editTextMemberLoanInterest.getText().toString();
        String Repayment = editTextRepayment.getText().toString();
        String GuarantorFname = editTextGuarantorFname.getText().toString().trim();
        String GuarantorPhoneNumber = editTextGuarantorPhoneNumber.getText().toString();



        if(TextUtils.isEmpty(MemberFullName)) {
            editTextMemberFullName.setError("Member's Surname and OtherNames is required");
            return;
        }
        if (TextUtils.isEmpty(MemberAddress)) {
            editTextMemberAddress.setError("Address is required");
            return;
        }
        if (TextUtils.isEmpty(MemberContribution)) {
            editTextMemberContribution.setError("Address is required");
            return;
        }
        if (TextUtils.isEmpty(MemberBankBranch)) {
            editTextMemberBankBranch.setError("Member's Bank Branch Name is required");
            return;
        }
        if (TextUtils.isEmpty(BankAccount)) {
            editTextBankAccount.setError("Member's Bank Account Number is required");
            return;
        }
        if (TextUtils.isEmpty(MemberLoanType)) {
            editTextMemberLoanType.setError("Type Of Loan is required");
            return;
        }
        if (TextUtils.isEmpty(MemberLoanAmount)) {
            editTextMemberLoanAmount.setError("Loan Amount is required");
            return;
        }
        if (TextUtils.isEmpty(MemberLoanInterest)) {
            editTextMemberLoanInterest.setError("Interest Number is required");
            return;
        }
        if (TextUtils.isEmpty(Repayment)) {
            editTextRepayment.setError("Repayment Period  is required");
            return;
        }
        if (TextUtils.isEmpty(GuarantorFname)) {
            editTextGuarantorFname.setError("Guarantor's Surname and OtherNames  is required");
            return;
        }

        if (!TextUtils.isEmpty(GuarantorPhoneNumber)) {
            String id =  databaseApplyLoan.push().getKey();
            ApplyLoan applyLoan = new ApplyLoan(id,MemberLoanDetails,MemberFullName,MemberAddress,MemberContribution,
                                                MemberBankBranch,BankAccount,MemberLoanType,MemberLoanAmount,
                                                MemberLoanInterest, Repayment,GuarantorFname, GuarantorPhoneNumber);
            databaseApplyLoan.child(id).setValue(applyLoan);
            Toast.makeText(this, "You have Successfully Applied For A Loan", Toast.LENGTH_SHORT).show();
        }


        else{
            Toast.makeText(this, "Insert all fields Required", Toast.LENGTH_LONG).show();
        }
    }


}
