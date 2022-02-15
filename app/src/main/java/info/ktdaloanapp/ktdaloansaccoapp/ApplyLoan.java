package info.ktdaloanapp.ktdaloansaccoapp;

import java.util.List;

public class ApplyLoan {

    String applyLoanId;
    String memberLoanDetails;
    String memberFullName;
    String memberAddress;
    String  memberContribution;
    String memberBankBranch;
    String bankAccount;
    String memberLoanType;
    String memberLoanAmount;
    String memberLoanInterest;
    String repayment;
    String guarantorFname;
    String guarantorPhoneNumber;


    public ApplyLoan(){

    }


    public  ApplyLoan(String applyLoanId, String memberLoanDetails,  String memberFullName, String memberAddress,
                      String memberContribution,String memberBankBranch,String bankAccount, String memberLoanType,
                      String memberLoanAmount, String memberLoanInterest,String repayment,
                      String guarantorFname,String guarantorPhoneNumber ){

        this.applyLoanId = applyLoanId;
        this.memberLoanDetails = memberLoanDetails;
        this.memberFullName = memberFullName;
        this.memberAddress = memberAddress;
        this.memberContribution = memberContribution;
        this.memberBankBranch = memberBankBranch;
        this.bankAccount = bankAccount;
        this.memberLoanType = memberLoanType;
        this.memberLoanAmount = memberLoanAmount;
        this.memberLoanInterest = memberLoanInterest;
        this.repayment = repayment;
        this.guarantorFname = guarantorFname;
        this.guarantorPhoneNumber = guarantorPhoneNumber;


    }

    public String getApplyLoanId() {
        return applyLoanId;
    }

    public String getMemberLoanDetails() {
        return memberLoanDetails;
    }



    public String getMemberFullName() {
        return memberFullName;
    }



    public String getMemberAddress() {

        return memberAddress;
    }

    public String getMemberContribution() {
        return memberContribution;
    }

    public String getMemberBankBranch() {
        return memberBankBranch;
    }


    public String getBankAccount() {
        return bankAccount;
    }


    public String getMemberLoanType() {
        return memberLoanType;
    }


    public String getMemberLoanAmount() {
        return memberLoanAmount;
    }



    public String getMemberLoanInterest() {
        return memberLoanInterest;
    }


    public String getRepayment() {
        return repayment;
    }


    public String getGuarantorFname() {
        return guarantorFname;
    }


    public String getGuarantorPhoneNumber() {
        return guarantorPhoneNumber;
    }

    public void setApplyLoanId(String applyLoanId) {
        this.applyLoanId = applyLoanId;
    }

    public void setMemberLoanDetails(String memberLoanDetails) {
        this.memberLoanDetails = memberLoanDetails;
    }


    public void setMemberFullName(String memberFullName) {
        this.memberFullName = memberFullName;
    }


    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }


    public void setMemberContribution(String memberContribution) {
        this.memberContribution = memberContribution;
    }

    public void setMemberBankBranch(String memberBankBranch) {
        this.memberBankBranch = memberBankBranch;
    }



    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }


    public void setMemberLoanType(String memberLoanType) {
        this.memberLoanType = memberLoanType;
    }



    public void setMemberLoanAmount(String memberLoanAmount) {
        this.memberLoanAmount = memberLoanAmount;
    }



    public void setMemberLoanInterest(String memberLoanInterest) {
        this.memberLoanInterest = memberLoanInterest;
    }



    public void setRepayment(String repayment) {
        this.repayment = repayment;
    }



    public void setGuarantorFname(String guarantorFname) {
        this.guarantorFname = guarantorFname;
    }



    public void setGuarantorPhoneNumber(String guarantorPhoneNumber) {
        this.guarantorPhoneNumber = guarantorPhoneNumber;
    }
}
