package com.pluralsight.Dealership;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipFileManagerTest {

    @Test
    public void getDealershipGettingtherightVehicleGivenVin(){
        DealershipFileManager dlf = new DealershipFileManager();

        assertEquals("Vehicle: vin:66214, year:2015, make:'Chevrolet', model:'Tahoe', vehicleType:'SUV', color:'White', odometer:88321', price:18995.0", dlf.getDealership().getVehiclesByVin(66214));
    }

}