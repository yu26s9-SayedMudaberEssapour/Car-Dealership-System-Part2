package com.pluralsight.Dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    //will hold information about the dealership and maintain a list of
    //vehicles. It will also have the methods to search, add, and remove vehicles from
    //the list


    private String name;
    private String adress;
    private String phone;

    //this arraylist will keep track of vehicles
    ArrayList<Vehicle> inventory = new ArrayList<>();

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public Dealership(String name, String adress, String phone) {
        this.name = name;
        this.adress = adress;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    //all the specialized methods here
    public List<Vehicle> getVehicleByPrice(double min, double max) {
        List<Vehicle> priceRange = new ArrayList<>();
        for(Vehicle v : inventory){
            if((v.getPrice() <= max) && (v.getPrice() >= min)){
                priceRange.add(v);
            }
        }
        return priceRange;
    }


    public List<Vehicle> getVehiclesByMakeModel(String make, String model){

        List<Vehicle> MakeModel = new ArrayList<>();
        for(Vehicle v : inventory){
            if((v.getMake().equalsIgnoreCase(make)) && (v.getModel().equalsIgnoreCase(model))){
                MakeModel.add(v);
            }
        }
        return MakeModel;

    }


    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> yearRange = new ArrayList<>();
        for(Vehicle v : inventory){
            if((v.getYear() <= maxYear) && (v.getYear() >= minYear)){
                yearRange.add(v);
            }
        }
        return yearRange;

    }

    public List<Vehicle> getVehiclesByColor(String color){List<Vehicle> colors = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                colors.add(v);
            }
        }
        return colors;
    }


    /**
     * this accounts for only less than the given mileage not a range
     * @param lowestMileage
     * @param highestMileage
     * @return
     */
    public List<Vehicle> getVehiclesByMileage(int lowestMileage, int highestMileage){

        List<Vehicle> miles = new ArrayList<>();
        for(Vehicle v : inventory){
            if((v.getOdometer() <= highestMileage) && (v.getOdometer() >= lowestMileage)){
                miles.add(v);
            }
        }
        return miles;
    }

    public List<Vehicle> getVehiclesByType(String type){


        List<Vehicle> types = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getVehicleType().equalsIgnoreCase(type)){
                types.add(v);
            }
        }
        return types;
    }


    //this returns the vehicle given a vin number
    //if the vehicle does not exist it will return null
    public Vehicle getVehiclesByVin(int vin){

        for(Vehicle v : inventory){
            if(v.getVin() == vin){
                return v;
            }
        }
        return null;
    }




    //add functionality
    public List<Vehicle> getAllVehicles(){

        return inventory;
    }


    //add functionality
    public void addVehicle(Vehicle vehicle){

        inventory.add(vehicle);
    }

    public void removeVehicles(Vehicle vehicle){

        for(Vehicle v: inventory){
            if(vehicle.getVin() == v.getVin() &&
                    vehicle.getYear() == v.getYear() &&
                    vehicle.getMake().equalsIgnoreCase(v.getMake()) &&
                    vehicle.getModel().equalsIgnoreCase(v.getModel()) &&
                    vehicle.getVehicleType().equalsIgnoreCase(v.getVehicleType()) &&
                    vehicle.getColor().equalsIgnoreCase(v.getColor()) &&
                    vehicle.getOdometer() == v.getOdometer() &&
                    vehicle.getPrice() == v.getPrice())
            {
                inventory.remove(v);
                break;
            }
        }

    }


}
