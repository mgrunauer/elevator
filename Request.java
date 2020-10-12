/*
 * A class representing a request a person would make when calling an elevator 
 * 
 * @author Matthew Grunauer
 */
public class Request{
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;
    /*
     * This method is the main constructor for an object of type Request
     * 
     * @param numFloors
     * An int representing the number of floors in the building
     */
    public Request(int numFloors){
        this.sourceFloor = (int) (1 + (Math.random() * numFloors));
        this.destinationFloor = (int) (1 + (Math.random() * numFloors));
    }

    /*
     * This method is an alternate constructor for an object of type Request
     * 
     * @param numFloors
     * An int representing the number of floors in the building
     * 
     * @param time
     * An int representing the time the Request was created during the simulation
     */
    public Request(int numFloors, int time){
        this.timeEntered = time;
    }

    /*
     * This method sets the source floor of the Request object
     * 
     * @param newSourceFloor
     * An int representing the new source floor of the Request object
     */
    public void setSourceFloor(int newSourceFloor){
        this.sourceFloor = newSourceFloor;
    }

    /*
     * This method sets the destination floor of the Request object
     * 
     * @param newDestinationFloor
     * An int representing the new destination floor of the Request object
     */
    public void setDestinationFloor(int newDestinationFloor){
        this.destinationFloor = newDestinationFloor;
    }

    /*
     * This method sets the time the Request was made during the simulation
     * 
     * @param newTimeEntered
     * An int representing the time the Request was made during the simulation
     */
    public void setTimeEntered(int newTimeEntered){
        this.timeEntered = newTimeEntered;
    }

    /*
     * This method obtains the source floor of the current Request object
     * 
     * @return
     * An int representing the source floor of the current Request object
     */
    public int getSourceFloor(){
        return this.sourceFloor;
    }

    /*
     * This method obtains the destination floor of the current Request object
     * 
     * @return 
     * An int representing the destination floor of the current Request object
     */
    public int getDestinationFloor(){
        return this.destinationFloor;
    }

    /*
     * This method obtains the time the current Request was made during the simulation
     * 
     * @return
     * An int representing the time the current Request was made during the simulation
     */
    public int getTimeEntered(){
        return this.timeEntered;
    }
}
