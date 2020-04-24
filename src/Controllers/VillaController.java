package Controllers;

import Commons.FuncWriteAndReadFileCSV;
import Commons.Menu;
import Commons.ScannerUntil;
import Commons.ValidateData;
import Model.Services;
import Model.Villa;

import java.io.IOException;
import java.util.List;

public class VillaController {
    public static void addNewVilla() {
        Services villa = new Villa();

        ServiceController.servicesForAll(villa);

        do {
            System.out.println("Enter Room Standard");
            ((Villa) villa).setRoomStandard(ScannerUntil.scanner.nextLine());
        } while (!ValidateData.validateNameService(((Villa) villa).getRoomStandard()));

        while (true) {
            try {
                System.out.println("Enter Pool Area");
                ((Villa) villa).setAreaPool(ScannerUntil.scanner.nextDouble());
                while (!ValidateData.validateAreaUsedAndPool(((Villa) villa).getAreaPool())) {
                    System.out.println("Enter Pool Area");
                    ((Villa) villa).setAreaPool(ScannerUntil.scanner.nextDouble());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                ScannerUntil.scanner.nextLine();
            }
        }

        //mô tả tiện ích
        System.out.println("Enter Utilities Description");
        ScannerUntil.scanner.nextLine();
        ((Villa) villa).setConvenientDescription(ScannerUntil.scanner.nextLine());

        //số tầng
        while (true) {
            try {
                System.out.println("Enter Number Of Floors");
                ((Villa) villa).setNumberOfFloors(ScannerUntil.scanner.nextInt());
                while (!ValidateData.validateNumberOfFloor(((Villa) villa).getNumberOfFloors())) {
                    System.out.println("Enter Number Of Floors");
                    ((Villa) villa).setNumberOfFloors(ScannerUntil.scanner.nextInt());
                }
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu nhập vào sai định dạng");
                ScannerUntil.scanner.nextLine();
            }
        }

        FuncWriteAndReadFileCSV.writeVillaCSV((Villa) villa);
        System.out.println("Add new villa successfully!!");
        Menu.displayMenuBackToMain();
        Menu.displayMainMenu();
    }

    public static void showVilla() throws IOException {
        List<Villa> villaList = FuncWriteAndReadFileCSV.readVillaCSV();
        for (int i = 0; i < villaList.size(); i++) {
            System.out.print((i + 1) + ". \t");
            System.out.print(villaList.get(i).showInformation());
            System.out.println();
            System.out.println("********************************");
        }
        Menu.displayMenuBackToMain();
        MainController.processMain();
    }

    public static void showAllNameVilla() throws IOException {
        List<Villa> villaList = FuncWriteAndReadFileCSV.readVillaCSV();
        for (int i = 0; i < villaList.size(); i++) {
            System.out.print((i + 1) + ". \t");
            System.out.print(villaList.get(i).getServiceName());
            System.out.println();
            System.out.println("********************************");
        }
        Menu.displayMenuBackToMain();
        MainController.processMain();
    }
}
