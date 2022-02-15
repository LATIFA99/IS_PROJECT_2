package info.ktdaloanapp.ktdaloansaccoapp;

public class LoanType {

    String loantypeId;
    String loantypeLoanDetails;
    String typeofloan;
    String loantypeLoanTypeDetails;

    public LoanType(){

    }

    public LoanType(String loantypeId, String loantypeLoanDetails,  String typeofloan, String loantypeLoanTypeDetails) {
        this.loantypeId = loantypeId;
        this.loantypeLoanDetails = loantypeLoanDetails;
        this.typeofloan = typeofloan;
        this.loantypeLoanTypeDetails = loantypeLoanTypeDetails;
    }

    public String getLoantypeId() {
        return loantypeId;
    }

    public String getLoantypeLoanDetails() {
        return loantypeLoanDetails;
    }

    public String getTypeofloan() {
        return typeofloan;
    }

    public String getLoantypeLoanTypeDetails()
    {
        return loantypeLoanTypeDetails;
    }
}
