/*
 * A class that handles the main execution of the elevator simulation
 * 
 * @author Matthew Grunauer
 */
import java.util.ArrayList;
import java.text.DecimalFormat;
public class Simulator{
    /*
     * This method runs the elevator simulator and reports the results to the user
     * 
     * @param probability
     * A double representing the chance that a new Request will be added to the queue during each time iteration of the main loop
     * 
     * @param numFloors
     * An int representing the number of floors in the simulated building
     * 
     * @param numElevators
     * An int representing the number of elevators in the simulated building
     * 
     * @param simulationLength
     * An int representing the length of the simulation (in time units)
     */
    public static void simulate(double probability, int numFloors, int numElevators, int simulationLength){
        BooleanSource requestCheck = new BooleanSource(probability);
        RequestQueue elevatorQueue = new RequestQueue();
        ArrayList<Elevator> elevators = new ArrayList<Elevator>();
        int requestsReceived = 0;
        int totalWait = 0;
        Request currentRequest = null;
        for (int j = 0; j < numElevators; j++){
            elevators.add(new Elevator());
        }
        for (int i = 0; i < simulationLength; i++){
            if (requestCheck.requestArrived()){
                elevatorQueue.enqueue(new Request(numFloors, i + 1));
                for (Elevator elevator : elevators){
                    if (elevator.getElevatorState() == 0){
                        elevator.setElevatorState(1);
                        elevator.setCurrentRequest(elevatorQueue.dequeue());
                        break;
                    }
                }
            }
            for (Elevator elevator : elevators){
                if (elevator.getElevatorState() != 0){
                    if (elevator.getCurrentFloor() == elevator.getCurrentRequest().getSourceFloor() && elevator.getElevatorState() == 2){
                        totalWait += ((i + 1) - elevator.getCurrentRequest().getTimeEntered());
                        requestsReceived++;
                    }
                    elevator.move();
                }
            }
        }
        System.out.println("Total Wait Time: " + totalWait);
        System.out.println("Total Requests: " + requestsReceived);
        double averageWait = (double) totalWait / requestsReceived;
        System.out.println("Average Wait Time: " + (Math.round(averageWait * 100.0) / 100.0)) ;
    }
}
