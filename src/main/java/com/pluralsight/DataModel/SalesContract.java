package com.pluralsight.DataModel;

import com.pluralsight.Dealership.Vehicle;

public class SalesContract extends Contract {

    private final double salesTax = 0.05;// 5%
    private final double recordingFee = 100; //$100
    private String wantFinance; //yes/no



    public SalesContract(String Date, String customerName, String email, Vehicle vehicleSold, String wantFinance) {
        super(Date, customerName, email, vehicleSold);
        this.wantFinance = wantFinance; //this would either be yes or no
    }

    public double getSalesTax() {
        return salesTax;
    }
    public double getRecordingFee() {
        return recordingFee;
    }

    public String getWantFinance() {
        return wantFinance;
    }

    public void setWantFinance(String wantFinance) {
        this.wantFinance = wantFinance;
    }


    //• Processing fee ($295 for vehicles under $10,000 and $495 for all others
    @Override
    public double getTotalPrice(){
        double currentPrice = getCurrentPrice();
        double processingFee = 0;
        double taxAmount = currentPrice * salesTax;

        double totalPrice = 0;

        processingFee += (currentPrice >= 10000) ? 495 : 295;

        return (currentPrice + taxAmount + processingFee + recordingFee);
    };

    @Override
    public  double getMonthlyPayment(){
        //they are not financing so we simply just return 0;

        double currentPrice = getCurrentPrice(); //getCurrentPrice only give you current price if the vin number matches the one in the csv file
        double monthlyPayments = 0;

        if(getWantFinance().equalsIgnoreCase("no")){
            return 0;
        }
        else if (getWantFinance().equalsIgnoreCase("yes")){

            double interestRate;
            int numberOfMonths;

            if(currentPrice >= 10000){
                interestRate = 0.0425;
                numberOfMonths = 48;//17995
                monthlyPayments += ((currentPrice * interestRate) + currentPrice) / numberOfMonths;
            }
            else{
                interestRate = 0.0525;
                numberOfMonths = 25;
                monthlyPayments += ((currentPrice * interestRate) + currentPrice) / numberOfMonths;
            }


        }
        return monthlyPayments;
    }
}
