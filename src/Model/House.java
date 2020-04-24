package Model;

public class House extends Services{
    private String roomStandard;
    private String convenientDescription;
    private int numberOfFloors;

    public House() {
    }

    public House(String id, String serviceName, double areaUsed, double rentalCosts, int maxNumberOfPeople, String rentType) {
        super(id, serviceName, areaUsed, rentalCosts, maxNumberOfPeople, rentType);
    }

    public House(String roomStandard, String convenientDescription, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.convenientDescription = convenientDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String id, String serviceName, double areaUsed, double rentalCosts, int maxNumberOfPeople, String rentType, String roomStandard, String convenientDescription, int numberOfFloors) {
        super(id, serviceName, areaUsed, rentalCosts, maxNumberOfPeople, rentType);
        this.roomStandard = roomStandard;
        this.convenientDescription = convenientDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenientDescription() {
        return convenientDescription;
    }

    public void setConvenientDescription(String convenientDescription) {
        this.convenientDescription = convenientDescription;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInformation() {
        return "Service id: " + super.getId() +
                "\nService name: " + super.getServiceName() +
                "\nArea used: " + super.getAreaUsed() +
                "\nRental cost: " + super.getRentalCosts() +
                "\nMax number of people: " + super.getMaxNumberOfPeople() +
                "\nType rent: " + super.getRentType() +
                "\nRoom standard: " + this.roomStandard +
                "\nConvenient Description: " + this.convenientDescription +
                "\nNumber Of Floors: " + this.numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", convenientDescription='" + convenientDescription + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
