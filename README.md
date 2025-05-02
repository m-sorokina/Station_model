**Short Description:**  
This application simulates a station model that can handle two types of vehicles:
 - Truck
 - Bus
  
It also manages two types of events:
 - Arrival
 - Departure
  
Vehicles and events are added randomly during the simulation.  
If the station has no available capacity to accept a given vehicle, that vehicle is skipped.  
The program stops when all station capacities are exhausted or all vehicles are currently in use.  

**Sample of console output**  

```
+ | Truck | tank capacity: 500.00 | fuel available: 119.67 | cargo capacity:  25000.00 | cargo on board: 16492.81 | cargo on station:  366828.65 | people on station:  928 | fuel available on station:  128.01 |
  | Bus   | the current vehicle was skipped due to lack of available capacity at the station. Type of event: departure
- | Truck | tank capacity: 500.00 | fuel available: 463.93 | cargo capacity:  25000.00 | cargo on board: 16994.07 | cargo on station:  349834.58 | people on station:  927 | fuel available on station:   91.95 |
+ | Truck | tank capacity: 500.00 | fuel available: 198.86 | cargo capacity:  25000.00 | cargo on board: 21879.83 | cargo on station:  371714.41 | people on station:  928 | fuel available on station:   91.95 |
  | Truck | the current vehicle was skipped due to lack of available capacity at the station. Type of event: departure
  | Truck | the current vehicle was skipped due to lack of available capacity at the station. Type of event: departure
  | Bus   | the current vehicle was skipped due to lack of available capacity at the station. Type of event: departure
- | Truck | tank capacity: 500.00 | fuel available: 416.13 | cargo capacity:  25000.00 | cargo on board: 22159.95 | cargo on station:  349554.46 | people on station:  927 | fuel available on station:    8.07 |
The station has no capacities to accept next vehicle or all vehicles on station are in use
Station parameters after finish:
 - fuel: 8.07
 - cargo: 349554.46
 - people: 927
 - vehicles: 17
```
