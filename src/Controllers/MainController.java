package Controllers;

import Commons.ScannerUntil;

import java.io.IOException;

import static Commons.Menu.displayMainMenu;
import static Commons.Menu.displayMenuBackToMain;
import static Controllers.BookingController.addNewBooking;
import static Controllers.BookingController.bookingMovieTicket4D;
import static Controllers.CustomerController.addNewCustomer;
import static Controllers.CustomerController.showInformationCustomer;
import static Controllers.EmployeeController.findEmployee;
import static Controllers.EmployeeController.showInformationOfEmployee;
import static Controllers.ServiceController.addNewServices;
import static Controllers.ServiceController.showServices;

public class MainController {
    public static void processMain() {
        try {
            displayMainMenu();
            processMainMenu();
        } catch (Exception e) {
            backMainMenu();
        }
    }

    private static void processMainMenu() {
        switch (ScannerUntil.scanner.nextLine()) {
            case "1":
                addNewServices();
                break;
            case "2":
                showServices();
                break;
            case "3":
                try {
                    addNewCustomer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "4":
                try {
                    showInformationCustomer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "5":
                addNewBooking();
                break;
            case "6":
                showInformationOfEmployee();
                break;
            case "7":
                bookingMovieTicket4D();
                break;
            case "8":
                findEmployee();
                break;
            case "9":
                System.exit(0);
            default:
                processMain();
        }
    }


    public static void backMainMenu() {
        displayMenuBackToMain();
        processMain();
    }
}
