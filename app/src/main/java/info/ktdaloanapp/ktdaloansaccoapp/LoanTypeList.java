package info.ktdaloanapp.ktdaloansaccoapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LoanTypeList extends ArrayAdapter<LoanType> {

    private Activity context;
    private List<LoanType> loantypeList;

    public LoanTypeList(Activity context, List<LoanType> loantypeList){
        super(context, R.layout.list_layout, loantypeList);
        this.context = context;
        this.loantypeList = loantypeList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewLoanDetails = (TextView) listViewItem.findViewById(R.id.textViewLoanDetails);
        TextView textViewTypeOfLoan = (TextView) listViewItem.findViewById(R.id.textViewTypeOfLoan);
        TextView textViewLoanTypeDetails = (TextView) listViewItem.findViewById(R.id.textViewLoanTypeDetails);



        LoanType loanType = loantypeList.get(position);


        textViewLoanDetails.setText(loanType.getLoantypeLoanDetails());
        textViewTypeOfLoan.setText(loanType.getTypeofloan());
        textViewLoanTypeDetails.setText(loanType.getLoantypeLoanTypeDetails());

        return listViewItem;
    }
}
