package Commons;

import Model.Customer;
import Model.House;
import Model.Room;
import Model.Villa;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FuncWriteAndReadFileCSV {
    private static final char COMMA_DELIMITER = ',';
    private static final String[] HEADER_DEFAULT_VILLA = {"id", "nameServices", "areaUsed", "rentalCosts", "numberOfPeople", "typeRent", "roomStandard", "areaPool", "Convenient Description"};
    private static final String[] HEADER_DEFAULT_HOUSE = {"id", "nameServices", "areaUsed", "rentalCosts", "numberOfPeople", "typeRent", "roomStandard", "Convenient Description", "numberOfFloors"};
    private static final String[] HEADER_DEFAULT_ROOM = {"id", "nameServices", "areaUsed", "rentalCosts", "numberOfPeople", "typeRent", "freeServices"};
    private static final String[] HEADER_DEFAULT_CUSTOMER = {"id", "name", "birthday", "gender", "idCard", "phone", "email", "customerType", "address", "useService"};
    private static final String[] HEADER_DEFAULT_BOOKING = {"id", "name", "birthday", "gender", "idCard", "phone", "email", "customerType", "address", "useService"};

    public static void writeVillaCSV(Villa villa) {
        try {
            List<Villa> oldVilla = readVillaCSV();
            Writer writer = Files.newBufferedWriter(Paths.get("src/Data/villa.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_VILLA));
            if (oldVilla != null) {
                for (Villa villaItem : oldVilla) {
                    csvPrinter.printRecord(
                            villaItem.getId(),
                            villaItem.getServiceName(),
                            villaItem.getAreaUsed(),
                            villaItem.getRentalCosts(),
                            villaItem.getMaxNumberOfPeople(),
                            villaItem.getRentType(),
                            villaItem.getRoomStandard(),
                            villaItem.getAreaPool(),
                            villaItem.getConvenientDescription()
                    );
                }
            }
            csvPrinter.printRecord(
                    villa.getId(),
                    villa.getServiceName(),
                    villa.getAreaUsed(),
                    villa.getRentalCosts(),
                    villa.getNumberOfFloors(),
                    villa.getRentType(),
                    villa.getRoomStandard(),
                    villa.getAreaPool(),
                    villa.getConvenientDescription()
            );

            csvPrinter.flush();
            System.out.println("Write csv file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Villa> readVillaCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/Data/villa.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_VILLA).withIgnoreHeaderCase().withTrim());
        List<Villa> oldVillas = new ArrayList<>();
        int i = 0;
        for (CSVRecord csvRecords : csvParser) {
            //ignore header
            if (i == 0) {
                i++;
            } else {
                Villa villa = new Villa();
                villa.setId(csvRecords.get(0));
                villa.setServiceName(csvRecords.get(1));
                villa.setAreaUsed(Double.parseDouble(csvRecords.get(2)));
                villa.setRentalCosts(Double.parseDouble(csvRecords.get(3)));
                villa.setNumberOfFloors(Integer.parseInt(csvRecords.get(4)));
                villa.setRentType(csvRecords.get(5));
                villa.setRoomStandard(csvRecords.get(6));
                villa.setAreaPool(Double.parseDouble(csvRecords.get(7)));
                villa.setConvenientDescription(csvRecords.get(8));
                oldVillas.add(villa);
            }
        }
        return oldVillas;
    }

    public static void writeHouseCSV(House house) {
        try {
            List<House> oldHouse = readHouseCSV();
            Writer writer = Files.newBufferedWriter(Paths.get("src/Data/house.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_HOUSE));
            if (oldHouse != null) {
                for (House houseItem : oldHouse) {
                    csvPrinter.printRecord(
                            houseItem.getId(),
                            houseItem.getServiceName(),
                            houseItem.getAreaUsed(),
                            houseItem.getRentalCosts(),
                            houseItem.getMaxNumberOfPeople(),
                            houseItem.getRentType(),
                            houseItem.getRoomStandard(),
                            houseItem.getConvenientDescription(),
                            houseItem.getNumberOfFloors()
                    );
                }
            }
            csvPrinter.printRecord(
                    house.getId(),
                    house.getServiceName(),
                    house.getAreaUsed(),
                    house.getRentalCosts(),
                    house.getMaxNumberOfPeople(),
                    house.getRentType(),
                    house.getRoomStandard(),
                    house.getConvenientDescription(),
                    house.getNumberOfFloors()
            );

            csvPrinter.flush();
            System.out.println("Write csv file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<House> readHouseCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/Data/house.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_HOUSE).withIgnoreHeaderCase().withTrim());
        List<House> oldVHouses = new ArrayList<>();
        int i = 0;
        for (CSVRecord csvRecords : csvParser) {
            //ignore header
            if (i == 0) {
                i++;
            } else {
                House house = new House();
                house.setId(csvRecords.get(0));
                house.setServiceName(csvRecords.get(1));
                house.setAreaUsed(Double.parseDouble(csvRecords.get(2)));
                house.setRentalCosts(Double.parseDouble(csvRecords.get(3)));
                house.setMaxNumberOfPeople(Integer.parseInt(csvRecords.get(4)));
                house.setRentType(csvRecords.get(5));
                house.setRoomStandard(csvRecords.get(6));
                house.setConvenientDescription(csvRecords.get(7));
                house.setNumberOfFloors(Integer.parseInt(csvRecords.get(8)));
                oldVHouses.add(house);
            }
        }
        return oldVHouses;
    }
    //endregion

    //region CSV Room
    public static void writeRoomCSV(Room room) {
        try {
            List<Room> oldRooms = readRoomCSV();
            Writer writer = Files.newBufferedWriter(Paths.get("src/Data/room.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_HOUSE));
            if (oldRooms != null) {
                for (Room roomItem : oldRooms) {
                    csvPrinter.printRecord(
                            roomItem.getId(),
                            roomItem.getServiceName(),
                            roomItem.getAreaUsed(),
                            roomItem.getRentalCosts(),
                            roomItem.getMaxNumberOfPeople(),
                            roomItem.getRentType(),
                            roomItem.getFreeService()
                    );
                }
            }
            csvPrinter.printRecord(
                    room.getId(),
                    room.getServiceName(),
                    room.getAreaUsed(),
                    room.getRentalCosts(),
                    room.getMaxNumberOfPeople(),
                    room.getRentType(),
                    room.getFreeService()
            );

            csvPrinter.flush();
            System.out.println("Write csv file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Room> readRoomCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/Data/room.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_ROOM).withIgnoreHeaderCase().withTrim());
        List<Room> oldRooms = new ArrayList<>();
        int i = 0;
        for (CSVRecord csvRecords : csvParser) {
            //ignore header
            if (i == 0) {
                i++;
            } else {
                Room room = new Room();
                room.setId(csvRecords.get(0));
                room.setServiceName(csvRecords.get(1));
                room.setAreaUsed(Double.parseDouble(csvRecords.get(2)));
                room.setRentalCosts(Double.parseDouble(csvRecords.get(3)));
                room.setMaxNumberOfPeople(Integer.parseInt(csvRecords.get(4)));
                room.setRentType(csvRecords.get(5));
                room.setFreeService(csvRecords.get(6));
                oldRooms.add(room);
            }
        }
        return oldRooms;
    }

    public static void writeCustomerCSV(Customer customer) {
        try {
            List<Customer> customers = readCustomerCSV();
            Writer writer = Files.newBufferedWriter(Paths.get("src/Data/customer.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_CUSTOMER));
            if (customers != null) {
                //"id", "name", "birthday", "gender", "idCard", "phone", "email", "customerType", "address", "useService"};
                for (Customer customerItem : customers) {
                    csvPrinter.printRecord(
                            customerItem.getId(),
                            customerItem.getName(),
                            customerItem.getBirthday(),
                            customerItem.getGender(),
                            customerItem.getIdCard(),
                            customerItem.getPhone(),
                            customerItem.getEmail(),
                            customerItem.getCustomerType(),
                            customerItem.getAddress(),
                            customerItem.getServiceUse()
                    );
                }
            }
            csvPrinter.printRecord(
                    customer.getId(),
                    customer.getName(),
                    customer.getBirthday(),
                    customer.getGender(),
                    customer.getIdCard(),
                    customer.getPhone(),
                    customer.getEmail(),
                    customer.getCustomerType(),
                    customer.getAddress(),
                    customer.getServiceUse()
            );

            csvPrinter.flush();
            System.out.println("Write csv file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readCustomerCSV() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/Data/customer.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(HEADER_DEFAULT_CUSTOMER).withIgnoreHeaderCase().withTrim());
        List<Customer> oldCustomers = new ArrayList<>();
        int i = 0;
        for (CSVRecord csvRecords : csvParser) {
            //ignore header
            if (i == 0) {
                i++;
            } else {
                Customer customer = new Customer();
                customer.setId(csvRecords.get(0));
                customer.setName(csvRecords.get(1));
                customer.setBirthday(csvRecords.get(2));
                customer.setGender(csvRecords.get(3));
                customer.setIdCard(csvRecords.get(4));
                customer.setPhone(csvRecords.get(5));
                customer.setEmail(csvRecords.get(6));
                customer.setCustomerType(csvRecords.get(7));
                customer.setAddress(csvRecords.get(8));
                customer.setServiceUse(csvRecords.get(9));
                oldCustomers.add(customer);
            }
        }
        return oldCustomers;
    }
}
