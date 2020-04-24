package Model;

public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String id, String serviceName, double areaUsed, double rentalCosts, int maxNumberOfPeople, String rentType) {
        super(id, serviceName, areaUsed, rentalCosts, maxNumberOfPeople, rentType);
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String id, String serviceName, double areaUsed, double rentalCosts, int maxNumberOfPeople, String rentType, String freeService) {
        super(id, serviceName, areaUsed, rentalCosts, maxNumberOfPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String showInformation() {
        return "Service id: " + super.getId() +
                "\nService name: " + super.getServiceName() +
                "\nArea used: " + super.getAreaUsed() +
                "\nRental cost: " + super.getRentalCosts() +
                "\nMax number of people: " + super.getMaxNumberOfPeople() +
                "\nType rent: " + super.getRentType() +
                "\nRoom standard: " + this.freeService;
    }
}
