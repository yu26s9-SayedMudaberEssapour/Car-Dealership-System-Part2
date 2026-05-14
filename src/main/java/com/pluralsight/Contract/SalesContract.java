package com.pluralsight.Contract;

import com.pluralsight.Vehicle;

public class SalesContract extends Contract {

    private double salesTax = 0.05;// 5%
    private double recordingFee = 100; //$100
    private String wantFinance; //yes/no

    //Sales Tax Amount (5%)
    //• Recording Fee ($100)
    //• Processing fee ($295 for vehicles under $10,000 and $495 for all others
    //• Whether they want to finance (yes/no)
    //• Monthly payment (if financed) based on:
    //• All loans are at 4.25% for 48 months if the price is $10,000 or more
    //• Otherwise they are at 5.25% for 24 month

    //You should provide overrides for getTotalPrice() and getMonthlyPayment() that will
    //return computed values based on the rules above. It is possible that
    //getMonthlyPayment() would return 0 if they chose the NO loan option


    public SalesContract(String Date, String customerName, String email, boolean vehicleSold, double salesTax, double recordingFee, String wantFinance) {
        super(Date, customerName, email, vehicleSold);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.wantFinance = wantFinance;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public String getWantFinance() {
        return wantFinance;
    }

    public void setWantFinance(String wantFinance) {
        this.wantFinance = wantFinance;
    }

    public double getTheProcessingFee(Double vehicleValue){
        return 0;

    }

    @Override
    public double getTotalPrice(){
        return 0;
    };


    @Override
    public  double getMonthlyPayment(){
        //they are not financing so we simply just return 0;
        if(getWantFinance().equalsIgnoreCase("no")){
            return 0;
        }
        else if (getWantFinance().equalsIgnoreCase("yes")){


        }
        return 0;
    };
}
