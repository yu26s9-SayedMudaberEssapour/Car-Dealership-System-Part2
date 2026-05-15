package com.pluralsight;

import com.pluralsight.DataModel.SalesContract;
import com.pluralsight.Dealership.Vehicle;
import com.pluralsight.ui.UserInterface;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        //Program will be responsible for starting the application via its main() method and
        //then creating the user interface and getting it started.

        UserInterface ui = new UserInterface();
        ui.display();

        //77439|2020|Nissan|Altima|Sedan|Blue|32112|17995.0
//        Vehicle honda = new Vehicle(77439,2020,"Nissan", "Altima", "Sedan", "Blue", 32112, 17995.0);
//        SalesContract sc = new SalesContract("5/14/2026", "Sayed", "Sayed@yahoo.com",honda , "yes");
//
//
//
//        //System.out.println(sc.getCurrentPrice());
//        System.out.println(sc.getCurrentPrice());
//        System.out.println(sc.getMonthlyPayment());




    }
}
