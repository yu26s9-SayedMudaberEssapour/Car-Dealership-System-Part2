package com.pluralsight.ui;

import com.pluralsight.DataModel.LeaseContract;
import com.pluralsight.DataModel.SalesContract;
import com.pluralsight.Dealership.Dealership;
import com.pluralsight.Dealership.DealershipFileManager;
import com.pluralsight.Dealership.Vehicle;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.pluralsight.DataModel.Contract;

public class UserInterface {

    //UserInterface will be responsible for all output to the screen, reading of user
    //input, and "using the Dealership's search, add, and remove as needed. (ex: when
    //the user selects "List all Vehicles", UserInterface would call the Dealership
    //method and then display the vehicles it returns.)


    //____________________________________________________
    //Get all the list options working and then work on add and remove
    //vehicles
    //---------------------------------------------------------


    private Dealership dealership;

    private void init(){
        DealershipFileManager dlf = new DealershipFileManager();
        this.dealership = dlf.getDealership();
    }

    public void display(){

        init();
        String userInput;

        //a loop that will display the menu

        do {
            //add another option called Sell/Lease A vehicle
            //Collect basic sales info from the user
            //add the vehicle information to the contract
            //ask if it is a sale or lease (if a vehicle is over 3 years old you can't lease it
            //calculate the pricing of the vehicle.

            System.out.println("""
                
                Welcome to Sayed's Dealership!!
                
                Please type one of the corresponding numbers for your option
                1 - Find vehicles within a price range
                2 - Find vehicles by make / model
                3 - Find vehicles by year range
                4 - Find vehicles by color
                5 - Find vehicles by mileage range
                6 - Find vehicles by type (car, truck, SUV, van)
                7 - List ALL vehicles
                8 - Add a vehicle
                9 - Remove a vehicle
                10 - Sale/Lease
                99 - Quit \n
                """);
            userInput = Console.promptForString("Your Response: ");

            switch(userInput.toLowerCase()){

                case "1" :
                    processGetByPriceRequest();
                    break;

                case "2" :
                    processGetByMakeModelRequest();
                    break;

                case "3" :
                    processGetByYearRequest();
                    break;

                case "4" :
                    processGetByColorRequest();
                    break;

                case "5" :
                    processGetByMileageRequest();
                    break;

                case "6" :
                    processGetByVehicleTypeRequest();
                    break;

                case "7" :
                    processGetByAllVehiclesRequest();
                    break;

                case "8" :
                    processAddVehicleRequest();
                    break;

                case "9" :
                    processRemoveVehicleRequest();
                    break;
                case "10" :
                    sellOrLease();
                    break;


                case "99" :
                    System.out.println("You have exited the application: "
                            + "Good Bye!!!");
                    break;
                default:
                    break;

            }

        }
        while(!userInput.equalsIgnoreCase("99"));


    }


    //this is a helper method
    //that is used to display vehicle based on what is being given as data
    private void displayVehicle(List vehicle){

        //I should be displaying vehicles here
        int count = 1;
        System.out.println("(-------------------------------------------------------Vehicles--------------------------------------------------------------)");
        for(Object v: vehicle){
            System.out.println(count + ": " + v.toString());
            count += 1;
        }
        System.out.println("(-------------------------------------------------------End of Vehicles--------------------------------------------------------------)");

    }

    /**
     * this method should take a minimum and a maximum value
     * and look into the arraylist and then return the
     */
    public void processGetByPriceRequest(){

        double min = Console.promptForDouble("Enter you lowest price range: ");
        double max = Console.promptForDouble("Enter you highest price range: ");

        //I am using the displayVehicle method to display these vehicles.
        displayVehicle(dealership.getVehicleByPrice(min, max));

        //Vehicle{vin=37846, year=2001, make='Ford', model='Ranger', vehicleType='truck', color='Yellow', odometer=172544, price=1995.0}


    }

    /**
     * this method will be returning cars based on the make and model.
     */
    public void processGetByMakeModelRequest(){

        String make = Console.promptForString("Enter the Make of the Car: ");
        String model = Console.promptForString("Enter the Model of the Car: ");

        displayVehicle(dealership.getVehiclesByMakeModel(make, model));

    }


    public void processGetByYearRequest(){

        int lowYear = Console.promptForInt("Enter you lowest Year range: ");
        int highYear = Console.promptForInt("Enter you highest Year range: ");

        displayVehicle(dealership.getVehiclesByYear(lowYear, highYear));
    }

    public void processGetByColorRequest(){

        String color = Console.promptForString("Enter the Color of the Vehicle: ");
        displayVehicle(dealership.getVehiclesByColor(color));

    }


    public void processGetByMileageRequest(){

        int minMile = Console.promptForInt("Enter you lowest Mileage range: ");
        int maxMile = Console.promptForInt("Enter you highest Mileage range: ");
        displayVehicle(dealership.getVehiclesByMileage(minMile, maxMile));
    }


    public void processGetByVehicleTypeRequest(){
        String type = Console.promptForString("Enter the type (car, truck, SUV, van): ");
        displayVehicle(dealership.getVehiclesByType(type));

    }


    public void processGetByAllVehiclesRequest(){

        displayVehicle(dealership.getAllVehicles());
    }



    //called dealership file manager to save
    DealershipFileManager dlf = new DealershipFileManager();
    //IMPORTANT NOTE: Don't forget to have your UserInterface use the
    //DealershipFileManager to save the dealership each time the user adds or removes a
    //vehicle
    public void processAddVehicleRequest(){

        //public Vehicle(int vin, int year,
        // String make, String model, String vehicleType,
        // String color, int odometer, double price)

        int vin = Console.promptForInt("Enter the vin of the Vehicle: ");
        int year = Console.promptForInt("Enter the Year of the vehicle: ");
        String make = Console.promptForString("Enter the make of the Vehicle: ");
        String model = Console.promptForString("Enter the model of the Vehicle: ");
        String vehicleType = Console.promptForString("Enter the vehicleType of the Vehicle: ");
        String color = Console.promptForString("Enter the color of the Vehicle: ");
        int odometer = Console.promptForInt("Enter the Mileage of the vehicle: ");
        double price = Console.promptForDouble("Enter the Price of the vehicle: ");

        dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));

        //now I have to use the save vehicle method to save this.

        dlf.saveDealership(dealership);

    }

    public void processRemoveVehicleRequest(){

        int vin = Console.promptForInt("Enter the vin of the Vehicle: ");
        int year = Console.promptForInt("Enter the Year of the vehicle: ");
        String make = Console.promptForString("Enter the make of the Vehicle: ");
        String model = Console.promptForString("Enter the model of the Vehicle: ");
        String vehicleType = Console.promptForString("Enter the vehicleType of the Vehicle: ");
        String color = Console.promptForString("Enter the color of the Vehicle: ");
        int odometer = Console.promptForInt("Enter the Mileage of the vehicle: ");
        double price = Console.promptForDouble("Enter the Price of the vehicle: ");

        dealership.removeVehicles(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));


        dlf.saveDealership(dealership);
    }

    public void processAllVehiclesRequest(){

        displayVehicle(dealership.getAllVehicles());

    }



    //------------------------------sell Lease----------------------
    public void sellOrLease(){

        //use instanceof to differentiate between lease and sale
        int vin = Console.promptForInt("Please enter the vin number of the car: ");

        String date = Console.promptForString("Enter the date: ");
        String customerName = Console.promptForString("Enter customers Name: ");
        String email = Console.promptForString("Enter your email address: ");

        //gets vin number goes into the dealership and finds the vehicle and returns it.
        Vehicle vehicle = dlf.getDealership().getVehiclesByVin(vin);

        String saleOrLease = Console.promptForString("Is it a sale or lease: ");

        Contract contract;
        if(saleOrLease.equalsIgnoreCase("lease")){
            contract = new LeaseContract(date, customerName, email, vehicle);
        }
        else{

            //there is a fifth whether they want finance or not
            contract = new SalesContract(date, customerName, email, vehicle, "yes");
        }

        if(contract instanceof LeaseContract){
            LeaseContract lc = (LeaseContract) contract;

            try{
                FileWriter fr = new FileWriter("Contract.csv", true);

                fr.write("LEASE" + "|" + date + "|" +customerName+ "|" + email + "|" +vehicle+ "|" + lc.getExpectedEnding() + "|" + lc.getLeaseFee() + "|" + lc.getTotalPrice() + "|" + lc.getMonthlyPayment()+ "\n");
                fr.close();
            }

            catch (IOException e){
                e.getMessage();
            }
        }

        if(contract instanceof SalesContract){
            SalesContract sc = (SalesContract) contract;
            try{
                FileWriter fr = new FileWriter("Contract.csv", true);

                fr.write("SALE" + "|" + date + "|" +customerName+ "|" + email + "|" +vehicle+ "|" + sc.getRecordingFee() + "|" + sc.getProcessingFee() + "|" + sc.getTotalPrice() + "|" + sc.getWantFinance() + "|" + sc.getMonthlyPayment() + "\n");
                fr.close();
            }
            catch (IOException e){
                e.getMessage();
            }
        }


        //here I should account for the edge case where a car older than 3 years can't be leased

    }



}
