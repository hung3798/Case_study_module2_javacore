package Controllers;

import Commons.Menu;
import Commons.ScannerUntil;
import Commons.ValidateData;
import Model.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static Commons.Menu.displayMenuAddNewService;
import static Controllers.HouseController.addNewHouse;
import static Controllers.RoomController.addNewRoom;
import static Controllers.VillaController.addNewVilla;

public class ServiceController {
    public static void addNewServices() {
        displayMenuAddNewService();
        processMenuAddNewService();
    }

    private static void processMenuAddNewService() {
        switch (ScannerUntil.scanner.nextLine()) {
            case "1":
                addNewVilla();
                break;
            case "2":
                addNewHouse();
                break;
            case "3":
                addNewRoom();
                break;
            case "4":
                System.exit(0);
            default:
                System.out.println("please select one task!!");
                addNewServices();
        }
    }

    public static void showServices() {
        Menu.displayMenuShowService();
        processMenuShowService();
    }

    private static void processMenuShowService() {
        switch (ScannerUntil.scanner.nextLine()) {
            case "1":
                try {
                    VillaController.showVilla();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "2":
                try {
                    HouseController.showHouse();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "3":
                try {
                    RoomController.showRoom();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "4":
                try {
                    VillaController.showAllNameVilla();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "5":
                try {
                    HouseController.showAllNameHouse();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "6":
                try {
                    RoomController.showAllNameRoom();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "7":
                Menu.displayMainMenu();
                break;
            case "8":
                System.exit(0);
            default:
                Menu.displayMenuShowService();
        }
    }

    public static Services servicesForAll(Services service) {

        service.setId(UUID.randomUUID().toString().replace("-", ""));

        //Tên dịch vụ
        do {
            System.out.println("Enter Services Name");
            service.setServiceName(ScannerUntil.scanner.nextLine());
        }
        while (!ValidateData.validateNameService(service.getServiceName()));

        //Diện tích sử dụng
        while (true) {
            try {
                System.out.println("Enter Area Used");
                service.setAreaUsed(ScannerUntil.scanner.nextDouble());
                while (!ValidateData.validateAreaUsedAndPool(service.getAreaUsed())) {
                    System.out.println("Enter Area Used");
                    service.setAreaUsed(ScannerUntil.scanner.nextDouble());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                ScannerUntil.scanner.nextLine();
            }
        }

        //Chi phí phải trả
        while (true) {
            try {
                System.out.println("Enter Rental Costs");
                service.setRentalCosts(ScannerUntil.scanner.nextDouble());
                while (!ValidateData.validateRentalCosts(service.getRentalCosts())) {
                    System.out.println("Enter Rental Costs");
                    service.setRentalCosts(ScannerUntil.scanner.nextDouble());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                ScannerUntil.scanner.nextLine();
            }
        }

        //số lượng người đi tối đa

        while (true) {
            try {
                System.out.println("Enter Number Of People");
                service.setMaxNumberOfPeople(ScannerUntil.scanner.nextInt());
                while (!ValidateData.validateNumberOfPeople(service.getMaxNumberOfPeople())) {
                    System.out.println("Enter Number Of People");
                    service.setMaxNumberOfPeople(ScannerUntil.scanner.nextInt());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                ScannerUntil.scanner.nextLine();
            }
        }

        //loại chi phí
        do {
            System.out.println("Enter TypeRent");
            service.setRentType(ScannerUntil.scanner.nextLine());
        } while (!ValidateData.validateTypeRent(service.getRentType()));

        return service;
    }

    public static void showAllNameService() {
        List<Services> services = new ArrayList<>();
        for (int i = 0; i < services.size(); i++) {
            System.out.println(i + 1 + ". " + services.get(i).getServiceName());
        }
    }
}
