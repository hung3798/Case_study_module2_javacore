package Controllers;

import Commons.FuncWriteAndReadFileCSV;
import Commons.Menu;
import Commons.ScannerUntil;
import Commons.ValidateData;
import Model.Room;
import Model.Services;

import java.io.IOException;
import java.util.List;

public class RoomController {
    public static void addNewRoom() {
        Services room = new Room();

        ServiceController.servicesForAll(room);


        do {
            System.out.println("Enter Free Services");
            ((Room) room).setFreeService(ScannerUntil.scanner.nextLine());
        } while (!ValidateData.validateAccompaniedService(((Room) room).getFreeService()));

        FuncWriteAndReadFileCSV.writeRoomCSV((Room) room);
        System.out.println("Create new room successfully!!");
        Menu.displayMenuBackToMain();
        Menu.displayMainMenu();

    }

    public static void showRoom() throws IOException {
        List<Room> roomList = FuncWriteAndReadFileCSV.readRoomCSV();
        for (int i = 0; i < roomList.size(); i++) {
            System.out.print((i + 1) + ". \t");
            System.out.print(roomList.get(i).showInformation());
            System.out.println();
            System.out.println("********************************");
        }
        Menu.displayMenuBackToMain();
        MainController.processMain();
    }

    public static void showAllNameRoom() throws IOException {
        List<Room> roomList = FuncWriteAndReadFileCSV.readRoomCSV();
        for (int i = 0; i < roomList.size(); i++) {
            System.out.print((i + 1) + ". \t");
            System.out.print(roomList.get(i).getServiceName());
            System.out.println();
            System.out.println("********************************");
        }
        Menu.displayMenuBackToMain();
        MainController.processMain();
    }
}
