package com.pluralsight.DataModel;

import com.pluralsight.Dealership.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Contract {

    protected String Date; //this will be date of the contract
    protected String CustomerName;
    protected String email;
    protected static Vehicle VehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    //all of these could be used as titles as well.


    public Contract(String Date, String customerName, String email, Vehicle VehicleSold){
        this.Date = Date;
        this.CustomerName = customerName;
        this.email = email;
        this.VehicleSold = VehicleSold;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate(){return Date;}

    public void setDate(String Date){
        this.Date = Date;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public static Vehicle getVehicleSold() {
        return VehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        VehicleSold = vehicleSold;
    }


    //methods

    //alright this should now return the price of the vehicle
    public double getCurrentPrice(){
        double price  = 0;
        try{
            FileReader fr = new FileReader("src/main/java/com/WorkshopFiles/WorkshopFiles/inventory.csv");
            BufferedReader br = new BufferedReader(fr);

            br.readLine();

            String line;


            while((line = br.readLine()) != null){
                String[] part = line.split("\\|");

                int vin = Integer.parseInt(part[0]);
                int vehicleSoldVin = getVehicleSold().getVin();

                if(vin == vehicleSoldVin){
                    price += Double.parseDouble(part[7]);
                    break;
                }

            }
        }
        catch (IOException e){
            e.getMessage();
        }

        return price;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

}
