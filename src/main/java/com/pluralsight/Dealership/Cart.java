package com.pluralsight.Dealership;

import com.pluralsight.ui.Console;

import java.util.ArrayList;

public class Cart {

    //Vehicle VCart = new Vehicle();
    private ArrayList<Vehicle> Cart =  new ArrayList<>();


    //customers should be able to create their carts

    public Cart(ArrayList<Vehicle> Cart){
        this.Cart = Cart;

    }


    //and then should be able to add things to card

    public void addToCart(){

        int vin = Console.promptForInt("Enter the vin of the Vehicle: ");
        int year = Console.promptForInt("Enter the Year of the vehicle: ");
        String make = Console.promptForString("Enter the make of the Vehicle: ");
        String model = Console.promptForString("Enter the model of the Vehicle: ");
        String vehicleType = Console.promptForString("Enter the vehicleType of the Vehicle: ");
        String color = Console.promptForString("Enter the color of the Vehicle: ");
        int odometer = Console.promptForInt("Enter the Mileage of the vehicle: ");
        double price = Console.promptForDouble("Enter the Price of the vehicle: ");

        Cart.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));


        //should add to another file as purchased items for customer.
        //String continueing = Console.promptForString("Would you like to buy this item? ");



    }



    //remove things from the card

    public void remove(){

        if (!(Cart.isEmpty())) {
            int vin = Console.promptForInt("Enter the vin of the Vehicle: ");
            int year = Console.promptForInt("Enter the Year of the vehicle: ");
            String make = Console.promptForString("Enter the make of the Vehicle: ");
            String model = Console.promptForString("Enter the model of the Vehicle: ");
            String vehicleType = Console.promptForString("Enter the vehicleType of the Vehicle: ");
            String color = Console.promptForString("Enter the color of the Vehicle: ");
            int odometer = Console.promptForInt("Enter the Mileage of the vehicle: ");
            double price = Console.promptForDouble("Enter the Price of the vehicle: ");


            for(Vehicle v: Cart){
                if(v.getVin() == vin &&
                        v.getYear() == year &&
                        v.getMake().equalsIgnoreCase(make) &&
                        v.getModel().equalsIgnoreCase(model) &&
                        v.getVehicleType().equalsIgnoreCase(vehicleType) &&
                        v.getColor().equalsIgnoreCase(color) &&
                        v.getOdometer() == odometer &&
                        v.getPrice() == price)
                {
                    Cart.remove(v);
                    break;
                }
                
        }
        }

    }



    //purchase things from the card it should calculate the prices and then list out total and prices


}
