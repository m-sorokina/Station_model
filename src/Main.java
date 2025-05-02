import java.util.*;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {

        Station station = new Station(5000.00, 150000.00, 300);
        station.stationCapacity();
        System.out.println("Station parameters on start:" + station);

        start(station);
        System.out.println();
        System.out.println();

        while ((station.checkIfCanAcceptArrival())) {
            int rEvent = random.nextInt(0, 2);
            if (rEvent == 0) {
                arrival(station);
            } else
                departure(station);
        }
        System.out.println("The station has no capacities to accept next vehicle or all vehicles on station are in use");
        System.out.println("Station parameters after finish:" + station);

    }

    private static Vehicle newVehicle() {
        int rVehicle = random.nextInt(0, 2);
        return switch (rVehicle) {
            case 0 -> new Truck(500.00, 25000.00, random.nextDouble(50, 500), random.nextDouble(9000.00, 26000.00));
            case 1 -> new Bus(460.00, 130, random.nextDouble(0, 460), random.nextInt(50, 135));
            default -> throw new IllegalStateException("Unexpected value: " + rVehicle);
        };
    }

    public static void start(Station station) {
        for (int i = 0; i < 10; i++) {
            arrival(station);
        }
    }

    public static void arrival(Station station) {
        Vehicle v = newVehicle();
        station.arrival(v);

    }

    public static void departure(Station station) {
        Vehicle v = station.getRandomVehicle(random);
        if (v instanceof Truck) {
            ((Truck) v).setCargoVolume(random.nextDouble(9000.00, 25000.00));
        }
        if (v instanceof Bus) {
            v.setPeopleValue(random.nextInt(50, 130));
        }
        station.departure(v);
    }
}


