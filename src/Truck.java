public class Truck extends Vehicle {

    private final double cargoCapacity;
    private double cargoVolume;

    public Truck(double tankCapacity, double cargoCapacity, double fuelVolume, double cargoVolume) {
        super(tankCapacity, fuelVolume);
        this.cargoCapacity = cargoCapacity;
        this.cargoVolume = cargoVolume;
        super.setPeopleValue(1);
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(double value) {
        cargoVolume = value;
    }

    public boolean ifCargoCapacityOk(double value) {
        if (value <= cargoCapacity) return true;
        else {
            System.out.println("Cargo volume is greater than truck capacity");
            return false;
        }
    }

    public void arriving(Station station) {
        super.arriving(station);
        station.addCargoVolume(getCargoVolume());
    }

    public void departing(Station station){
        super.departing(station);
        station.reduceCargoVolume(getCargoVolume());
    }

    public boolean ifCanArrive(Station station) {
        return (station.CARGO_ST_CAPACITY >= (station.getCargoVolume() + getCargoVolume())
                && (station.PEOPLE_ST_CAPACITY >= (station.getPeopleVolume() + getPeopleValue())));
    }

    public boolean ifCanLeave(Station station) {
        return (station.getCargoVolume() >= getCargoVolume())
                && (station.getFuelVolume() - addFuelToFull()) > 0
                && (station.getPeopleVolume() >= getPeopleValue());
    }

    public String toString() {
        return String.format("Truck | " + super.toString() + " | cargo capacity: %9.2f | cargo on board: %8.2f",
                cargoCapacity,
                cargoVolume
        );
    }

}
