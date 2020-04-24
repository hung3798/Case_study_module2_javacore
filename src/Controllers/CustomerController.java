package Controllers;

import Commons.FuncWriteAndReadFileCSV;
import Commons.Menu;
import Commons.ScannerUntil;
import Commons.ValidateData;
import Model.Customer;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class CustomerController {
    public static void addNewCustomer() throws IOException {
        Customer customer = new Customer();

        customer.setId(UUID.randomUUID().toString().replace("-", ""));

        do {
            System.out.println("Enter name customer: ");
            customer.setId(ScannerUntil.scanner.nextLine());
        } while (!ValidateData.validateNameCustomer(customer.getName()));

        do {
            System.out.println("Enter birthday customer: ");
            customer.setBirthday(ScannerUntil.scanner.nextLine());
        } while (!ValidateData.validateBirthday(customer.getBirthday()));

        do {
            System.out.println("Enter gender customer: ");
            customer.setGender(ScannerUntil.scanner.nextLine());
        } while (!ValidateData.validateGender(customer.getGender()));

        do {
            System.out.println("Enter idcard customer: ");
            customer.setIdCard(ScannerUntil.scanner.nextLine());
        } while (!ValidateData.validateIdCard(customer.getIdCard()));

        do {
            System.out.println("Enter phone customer: ");
            customer.setPhone(ScannerUntil.scanner.nextLine());
        } while (!ValidateData.validateNumberPhone(customer.getPhone()));

        do {
            System.out.println("Enter email customer: ");
            customer.setEmail(ScannerUntil.scanner.nextLine());
        } while (!ValidateData.validateEmail(customer.getEmail()));

        System.out.println("Enter type customer: ");
        customer.setCustomerType(ScannerUntil.scanner.nextLine());

        System.out.println("Enter address customer: ");
        customer.setAddress(ScannerUntil.scanner.nextLine());

        FuncWriteAndReadFileCSV.writeCustomerCSV(customer);
        System.out.println("create new customer successfully");
        Menu.displayMenuBackToMain();
        MainController.processMain();
    }

    public static void showInformationCustomer() throws IOException {
        List<Customer> customers = FuncWriteAndReadFileCSV.readCustomerCSV();

        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". \t");
            customers.get(i).showInformation();
            System.out.println("*************************");
        }
        Menu.displayMenuBackToMain();
        MainController.processMain();
    }
}
