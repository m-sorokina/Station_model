abstract public class Vehicle {

    private enum brands {}

    private final double tankCapacity;
    private double fuelVolume;
    private int peopleValue;

    public Vehicle() {
        this.tankCapacity = 0.00;
        this.fuelVolume = 0.00;
        this.peopleValue = 0;
    }

    public Vehicle(double tankCapacity, double fuelVolume) {
        this.tankCapacity = tankCapacity;
        this.fuelVolume = fuelVolume;
        this.peopleValue = 1;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public int getPeopleValue() {
        return peopleValue;
    }

    public void setPeopleValue(int value) {
        peopleValue = value;
    }

    public void setFuelVolume(double value) {
        if (ifTankCapacityOk(value))
            fuelVolume = value;
    }

    public double addFuelToFull() {
        return tankCapacity - fuelVolume;
    }

    public boolean ifTankCapacityOk(double value) {
        if (value <= tankCapacity) return true;
        else {
            System.out.println("Fuel volume is greater that tank capacity");
            return false;
        }
    }

    public abstract boolean ifCanArrive(Station station);

    public abstract boolean ifCanLeave(Station station);

    public void arriving(Station station) {
        station.addPeopleVolume(getPeopleValue());
    }

    public void departing(Station station){
        station.reduceFuelVolume(addFuelToFull());
        station.reducePeopleVolume(getPeopleValue());
    }

    public String toString() {
        return String.format("tank capacity: %5.2f | fuel available: %6.2f",
                tankCapacity,
                fuelVolume);
    }


}
