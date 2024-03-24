import java.util.*;

public class Station {

    public final double FUEL_ST_CAPACITY = 10000.00;
    public final double CARGO_ST_CAPACITY = 600000.00;
    public final int PEOPLE_ST_CAPACITY = 1000;
    private double fuelStVolume;
    private double cargoStVolume;
    private int peopleStVolume;
    private ArrayList<Vehicle> vehicles;

    public Station(double fuelStVolume, double cargoStVolume, int peopleStVolume) {
        this.fuelStVolume = fuelStVolume;
        this.cargoStVolume = cargoStVolume;
        this.peopleStVolume = peopleStVolume;
        vehicles = new ArrayList<>();
    }

    public double getFuelVolume() {
        return fuelStVolume;
    }

    public Vehicle getRandomVehicle(Random random) {
        return vehicles.get(random.nextInt(0, vehicles.size()));
    }

    public double getCargoVolume() {
        return cargoStVolume;
    }

    public int getPeopleVolume() {
        return peopleStVolume;
    }

    public void reduceFuelVolume(double value) {
        this.fuelStVolume -= value;
    }

    public void addCargoVolume(double value) {
        this.cargoStVolume += value;
    }

    public void reduceCargoVolume(double value) {
        this.cargoStVolume -= value;
    }

    public void addPeopleVolume(int value) {
        this.peopleStVolume += value;
    }

    public void reducePeopleVolume(int value) {
        this.peopleStVolume -= value;
    }

    public void stationCapacity() {
        System.out.printf("%s%n - fuel: %.2f%n - cargo: %.2f%n - people: %d%n", "Station general capacity:",
                FUEL_ST_CAPACITY, CARGO_ST_CAPACITY, PEOPLE_ST_CAPACITY);
    }

    public String toString() {
        return String.format("%n - fuel: %.2f%n - cargo: %.2f%n - people: %d%n - vehicles: %d%n",
                fuelStVolume,
                cargoStVolume,
                peopleStVolume,
                vehicles.size());
    }

    public boolean checkIfCanAcceptArrival(Vehicle v) {
        return (v.ifCanArrive(this));
    }

    public boolean checkIfCanAcceptDeparture(Vehicle v) {
        return (v.ifCanLeave(this));
    }

    public boolean checkIfCanAcceptArrival() {
        return ((PEOPLE_ST_CAPACITY > getPeopleVolume())
                && (CARGO_ST_CAPACITY > getCargoVolume())
                && (getFuelVolume() > 50) && (!vehicles.isEmpty()));
    }

    public void arrival(Vehicle v) {
        if (checkIfCanAcceptArrival(v)) {
            v.arriving(this);
            vehicles.add(v);
            printVehicle("+", v);
        } else
            System.out.println("Vehicle is skipped due to station capacities unavailability. Type of vehicle: "
                    + v.getClass().getSimpleName() + ", event: arrival");
    }

    public void departure(Vehicle v) {
        if (checkIfCanAcceptDeparture(v)) {
            v.departing(this);
            printVehicle("-", v);
            vehicles.remove(v);
        } else
            System.out.println("Vehicle is skipped due to station capacities unavailability. Type of vehicle: "
                    + v.getClass().getSimpleName() + ", event: arrival");
    }

    public void printVehicle(String s, Vehicle v) {
        System.out.printf("%s | %s | cargo on station: %10.2f | people on station: %4d | fuel available on station: %7.2f |%n",
                s, v, getCargoVolume(), getPeopleVolume(), getFuelVolume());
    }

}

