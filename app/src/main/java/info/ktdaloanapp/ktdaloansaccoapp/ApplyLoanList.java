package info.ktdaloanapp.ktdaloansaccoapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ApplyLoanList extends ArrayAdapter<ApplyLoan> {
    private Activity context;
    private List<ApplyLoan> applyloanList;

    public ApplyLoanList(Activity context, List<ApplyLoan> applyloanList){
        super(context, R.layout.list_loan, applyloanList);
        this.context = context;
        this.applyloanList = applyloanList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_loan, null, true);

       TextView textViewMemberLoanDetails = (TextView) listViewItem.findViewById(R.id.MemberDetails);
        EditText editTextMemberFullName = (EditText) listViewItem.findViewById(R.id.FullName);
       EditText editTextMemberAddress = (EditText) listViewItem.findViewById(R.id.Address);
       EditText editTextMemberContribution = (EditText) listViewItem.findViewById(R.id.Contribution);
       EditText editTextMemberBankBranch = (EditText) listViewItem.findViewById(R.id.Bank_branch);
       EditText editTextBankAccount = (EditText) listViewItem.findViewById(R.id.bank_account_number);
       EditText  editTextMemberLoanType = (EditText) listViewItem.findViewById(R.id.TypeOfLoan);
       EditText editTextMemberLoanAmount = (EditText) listViewItem.findViewById(R.id.type_of_loan_amount);
       EditText editTextMemberLoanInterest = (EditText) listViewItem.findViewById(R.id.loan_interest);
        EditText editTextRepayment = (EditText) listViewItem.findViewById(R.id.repayment_period);
       EditText editTextGuarantorFname = (EditText) listViewItem.findViewById(R.id.guarantors_Full_Name);
        EditText editTextGuarantorPhoneNumber = (EditText) listViewItem.findViewById(R.id.guarantors_phone_number);



        ApplyLoan applyLoan = applyloanList.get(position);

         textViewMemberLoanDetails.setText(applyLoan.getMemberLoanDetails());
         editTextMemberFullName.setText(applyLoan.getMemberFullName());
         editTextMemberAddress.setText(applyLoan.getMemberAddress());
         editTextMemberContribution.setText(applyLoan.getMemberContribution());
         editTextMemberBankBranch.setText(applyLoan.getMemberBankBranch());
         editTextBankAccount.setText(applyLoan.getBankAccount());
         editTextMemberLoanType.setText(applyLoan.getMemberLoanType());
         editTextMemberLoanAmount.setText(applyLoan.getMemberLoanAmount());
         editTextMemberLoanInterest.setText(applyLoan.getMemberLoanInterest());
         editTextRepayment.setText(applyLoan.getRepayment());
         editTextGuarantorFname.setText(applyLoan.getGuarantorFname());
         editTextGuarantorPhoneNumber.setText(applyLoan.getGuarantorPhoneNumber());



        return listViewItem;
    }

}
