package com.pluralsight.DataModel;

import com.pluralsight.Dealership.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {


    @Test
    public void getMonthlyPaymentShouldGetMeTheMonthlyPaymentOfACarUnder10000(){
        //Arrange
        //10112|1993|Ford|Explorer|SUV|Red|525123|995.0
        Vehicle honda = new Vehicle(77439,2020,"Nissan", "Altima", "Sedan", "Blue", 32112, 17995.0);
        SalesContract sc = new SalesContract("5/14/2026", "Sayed", "Sayed@yahoo.com",honda , "yes");


        //Act
        //sc.getMonthlyPayment();



        //Assert
        //expected, actual
        assertEquals(390.82890625, sc.getMonthlyPayment());
    }

}