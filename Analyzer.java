/*
 * A class that handles the user's interaction with the elevator simulation
 * 
 * @author Matthew Grunauer
 */
import java.util.Scanner;
public class Analyzer{
    public static void main(String[] args){
        double probability = -1.0;
        int numFloors = 0;
        int numElevators = -1;
        int simLength = -1;
        Scanner input = new Scanner(System.in);
        Simulator simulation = new Simulator();
        System.out.println("Welcome to the Elevator simulator!\n");
        while (probability < 0.0 || probability > 1.0){
            System.out.print("Please enter the probability of arrival for Requests: ");
            probability = Double.parseDouble(input.nextLine());
        }
        while (numFloors < 1){
            System.out.print("Please enter the number of floors: ");
            numFloors = Integer.parseInt(input.nextLine());
        }
        while (numElevators < 0){
            System.out.print("Please enter the number of elevators: ");
            numElevators = Integer.parseInt(input.nextLine());
        }
        while (simLength < 0){
            System.out.print("Please enter the length of the simulation (in time units): ");
            simLength = Integer.parseInt(input.nextLine());
        }
        System.out.println();
        simulation.simulate(probability, numFloors, numElevators, simLength);
    }
}
