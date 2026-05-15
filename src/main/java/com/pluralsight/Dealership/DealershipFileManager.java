package com.pluralsight.Dealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealershipFileManager {


    //this is the inventory of cars in the dealership
    public String file = "src/main/java/com/WorkshopFiles/WorkshopFiles/inventory.csv";

    //this method will be getting the dealership
    //this method will add the vehicles inside of an array temporarily.
    public Dealership getDealership() {
        //add the information about the dealership here

        Dealership dealership = null;
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);


            String line = br.readLine();

            String[] splitTitle = line.split("\\|");
            String name = splitTitle[0];
            String address = splitTitle[1];
            String phone = splitTitle[2];
            dealership = new Dealership(name, address, phone);

            String title = name + "|" + address + "|" + phone;

            //extract the information about the dealership
            while((line = br.readLine()) != null){
                Vehicle vehicle = getVehicle(line);

                dealership.addVehicle(vehicle);

            }

            br.close();
        }
        catch (IOException e){
            e.getMessage();
            System.out.println(e);
        }

        //should return the dealership and all its info
    return dealership;
    }


    //this is a helper method for getDealership
    private static Vehicle getVehicle(String line) {
        String[] split = line.split("\\|");
        //10112|1993|Ford|Explorer|SUV|Red|525123|995.00
        // Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price)
        //I should make objects and then add them to dealership

        int vin = Integer.parseInt(split[0]);
        int year = Integer.parseInt(split[1]);
        String make = split[2];
        String model = split[3];
        String vehicleType = split[4];
        String color = split[5];
        int odometer = Integer.parseInt(split[6]);
        double price = Double.parseDouble(split[7]);

        //instance method
        return new Vehicle(
                vin,
                year,
                make,
                model,
                vehicleType,
                color,
                odometer,
                price);
    }



    //this method should save the data
    // write back to the file and saves it whenever this is called.
    public void saveDealership(Dealership dealership){
        //this will be reading from the dealership objects array
        //then it will be adding them all to the file again.

        try{

            FileWriter fr = new FileWriter(file);

            //header
            fr.write(dealership.getName() + "|" + dealership.getAdress() + "|" + dealership.getPhone() + "\n" );

            for(Vehicle v : dealership.getInventory()){
                fr.write(v.getVin() + "|" +
                        v.getYear() + "|" + v.getMake() + "|" + v.getModel()+ "|" + v.getVehicleType() + "|" + v.getColor() + "|" + v.getOdometer() + "|" + v.getPrice() + "\n");
            }
            fr.close();

        }
        catch (IOException e){
            e.getMessage();
        }

    }



    // It will parse the data, and create a Dealership object, and create each Vehicle to be
    //added to the Dealership's inventory. It will also be responsible for saving the
    //dealership and it's vehicles in the file in the same pipe-delimited format


    //read the dealership inventory file

    }
