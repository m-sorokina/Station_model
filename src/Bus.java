public class Bus extends Vehicle {
    private final int peopleCapacity;

    public Bus(double tankCapacity, int peopleCapacity, double fuelVolume, int peopleValue) {
        super(tankCapacity, fuelVolume);
        this.peopleCapacity = peopleCapacity;
        super.setPeopleValue(peopleValue + 1);
    }

    public void setPeopleValue(int value){
        if (ifPeopleCapacityOk(value + 1))
            super.setPeopleValue(value + 1);
    }

    public boolean ifPeopleCapacityOk(int value) {
        if (value <= peopleCapacity) return true;
        else {
            System.out.println("Value of people is greater that landing capacity");
            return false;
        }
    }

    public boolean ifCanArrive(Station station){
        return ((station.PEOPLE_ST_CAPACITY >= (station.getPeopleVolume() + getPeopleValue())));
    }

    public boolean ifCanLeave(Station station) {
        return  ((station.getFuelVolume() - addFuelToFull()) > 0
                && (station.getPeopleVolume() >= getPeopleValue()));
    }

    public void arriving(Station station) {
        super.arriving(station);
    }

    public void departing(Station station){
        super.departing(station);
    }
    public String toString() {
        return String.format("Bus   | " + super.toString() + " | landing capacity: %7d | people on board: %7d",
                peopleCapacity,
                getPeopleValue() - 1);
    }
}
