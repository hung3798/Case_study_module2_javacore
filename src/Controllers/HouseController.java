package Controllers;

import Commons.FuncWriteAndReadFileCSV;
import Commons.Menu;
import Commons.ScannerUntil;
import Commons.ValidateData;
import Model.House;
import Model.Services;

import java.io.IOException;
import java.util.List;

public class HouseController {
    public static void addNewHouse() {
        Services house = new House();

        ServiceController.servicesForAll(house);

        do {
            System.out.println("Enter Room Standard");
            ((House) house).setRoomStandard(ScannerUntil.scanner.nextLine());
        } while (!ValidateData.validateNameService(((House) house).getRoomStandard()));

        //mô tả tiện ích
        System.out.println("Enter Utilities Description");
        ((House) house).setConvenientDescription(ScannerUntil.scanner.nextLine());

        //số tầng
        while (true) {
            try {
                System.out.println("Enter Number Of Floors");
                ((House) house).setNumberOfFloors(ScannerUntil.scanner.nextInt());
                while (!ValidateData.validateNumberOfFloor(((House) house).getNumberOfFloors())) {
                    System.out.println("Enter Number Of Floors");
                    ((House) house).setNumberOfFloors(ScannerUntil.scanner.nextInt());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                ScannerUntil.scanner.nextLine();
            }
        }

        FuncWriteAndReadFileCSV.writeHouseCSV((House) house);
        System.out.println("Add new house successfully!!");
        Menu.displayMenuBackToMain();
        Menu.displayMainMenu();
    }

    public static void showHouse() throws IOException {
        List<House> houseList = FuncWriteAndReadFileCSV.readHouseCSV();
        for (int i = 0; i < houseList.size(); i++) {
            System.out.print((i + 1) + ". \t");
            System.out.print(houseList.get(i).showInformation());
            System.out.println();
            System.out.println("********************************");
        }
        Menu.displayMenuBackToMain();
        MainController.processMain();
    }

    public static void showAllNameHouse()throws IOException{
        List<House> houseList = FuncWriteAndReadFileCSV.readHouseCSV();
        for (int i = 0; i < houseList.size(); i++) {
            System.out.print((i + 1) + ". \t");
            System.out.print(houseList.get(i).getServiceName());
            System.out.println();
            System.out.println("********************************");
        }
        Menu.displayMenuBackToMain();
        MainController.processMain();
    }
}
