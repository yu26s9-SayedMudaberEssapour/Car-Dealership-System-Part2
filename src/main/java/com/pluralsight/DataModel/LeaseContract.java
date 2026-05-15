package com.pluralsight.DataModel;

import com.pluralsight.Dealership.Vehicle;

public class LeaseContract extends Contract{

    //• Expected Ending Value (50% of the original price)
    private double expectedEnding = getCurrentPrice() * 0.50;
    //• Lease Fee (7% of the original price)
    private double leaseFee = getCurrentPrice() + 0.07;


    public LeaseContract(String Date, String customerName, String email, Vehicle vehicleSold) {
        super(Date, customerName, email, vehicleSold);
    }
    //A LeaseContract will include the following additional information:
    //• Monthly payment based on
    //• All leases are financed at 4.0% for 36 months
    //Methods will include a constructor and getters and setters for all fields except total
    //price and monthly payment.
    //You should provide overrides for getTotalPrice() and getMonthlyPayment()
    //that will return computed values based on the rules above


    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getExpectedEnding() {
        return expectedEnding;
    }

    public void setExpectedEnding(double expectedEnding) {
        this.expectedEnding = expectedEnding;
    }

    @Override
    public  double getTotalPrice(){

        return 0;
    };


    @Override
    public  double getMonthlyPayment(){
        //look back to this
        //getCurrentPrice only give you current price if the vin number matches the one in the csv file


        //get the current price

        //figure out the amountFinanced


        
        //find total with interest


        //total with interest should be devided by 36
        return 0;
    };


}
