package info.ktdaloanapp.ktdaloansaccoapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.text.DecimalFormat;

public class LoanCalculatorActivity extends AppCompatActivity {
    private EditText mLoanAmount,mInterestRate, mLoanPeriod;
    private TextView mMonthlyPaymentResult, mTotalPayementsResult;
    private Button clickedButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);

        mLoanAmount = (EditText)findViewById(R.id.loan_amount);
        mInterestRate = (EditText)findViewById(R.id.interest_rate);
        mLoanPeriod = (EditText)findViewById(R.id.loan_period);
        mMonthlyPaymentResult = (TextView)findViewById(R.id.monthly_payment_result);
        mTotalPayementsResult = (TextView)findViewById(R.id.total_payments_result);
        clickedButton = (Button)findViewById(R.id.clickedButton);

        clickedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickedButton) {
                double loanAmount = Integer.parseInt(mLoanAmount.getText().toString());
                double interestRate = (Integer.parseInt(mInterestRate.getText().toString()));
                double loanperiod = Integer.parseInt(mLoanPeriod.getText().toString());
                double r = interestRate/1200;
                double r1 = Math.pow(r+1,loanperiod);

                double monthlyPayment = (double) ((r+(r/(r1-1))) * loanAmount);
                double totalPayment = monthlyPayment * loanperiod;

                mMonthlyPaymentResult.setText(new DecimalFormat("##.##").format(monthlyPayment));
                mTotalPayementsResult.setText(new DecimalFormat("##.##").format(totalPayment));
            }
        });

    }


    }
