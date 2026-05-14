package com.pluralsight.Contract;

public class LeaseContract extends Contract{

    public LeaseContract(String Date, String customerName, String email, boolean vehicleSold) {
        super(Date, customerName, email, vehicleSold);
    }
    //A LeaseContract will include the following additional information:
    //• Expected Ending Value (50% of the original price)
    //• Lease Fee (7% of the original price)
    //• Monthly payment based on
    //• All leases are financed at 4.0% for 36 months
    //Methods will include a constructor and getters and setters for all fields except total
    //price and monthly payment.
    //You should provide overrides for getTotalPrice() and getMonthlyPayment()
    //that will return computed values based on the rules above


    @Override
    public  double getTotalPrice(){
        return 0;
    };


    @Override
    public  double getMonthlyPayment(){
        return 0;
    };


}
