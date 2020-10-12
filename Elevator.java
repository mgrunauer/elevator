/*
 * A class representing an elevator operating in a building
 * 
 * @author Matthew Grunauer
*/
public class Elevator{
    private int currentFloor;
    private int elevatorState;
    private final int IDLE = 0;
    private final int TO_SOURCE = 1;
    private final int TO_DESTINATION = 2;
    private Request currentRequest;
    /*
     * This method is the constructor for an object of type Elevator
     */
    public Elevator(){
        this.currentRequest = null;
        this.elevatorState = IDLE;
        this.currentFloor = 1;
    }
    
    /*
     * This method is a getter method for the currentFloor member variable
     * 
     * @return
     * An int representing what floor the elevator currently is currently on
     */
    public int getCurrentFloor(){
        return this.currentFloor;
    }
    
    /*
     * This method is a getter method for the ElevatorState member variable
     * 
     * @return
     * An int representing what the elevator is currently doing
     */
    public int getElevatorState(){
        return this.elevatorState;
    }
    
    /*
     * This method is a getter method for the currentRequest member variable
     * 
     * @return
     * An object of type Request representing the Request the Elevator is currently handling
     */
    public Request getCurrentRequest(){
        return this.currentRequest;
    }
    
    /*
     * This method is a getter method for the IDLE member variable
     * 
     * @return
     * An int representing a state of the Elevator in which the Elevator is not handling a Request
     */
    public int getIdle(){
        return this.IDLE;
    }
    
    /*
     * This method is a getter method for the TO_SOURCE member variable
     * 
     * @return
     * An int representing a state of the Elevator in which the Elevator is currently moving toward the source floor of a Request
     */
    public int getToSource(){
        return this.TO_SOURCE;
    }
    
    /*
     * This method is a getter method for the TO_DESTINATION member variable
     * 
     * @return
     * An int representing a state of the Elevator in which the Elevator is currently moving toward the destination floor of a Request
     */
    public int getToDestination(){
        return this.TO_DESTINATION;
    }
    
    /*
     * This method is a setter method for the currentFloor member variable
     * 
     * @param floor
     * An int representing the floor that the Elevator is currently on
     */
    public void setCurrentFloor(int floor){
        this.currentFloor = floor;
    }
    
    /*
     * This method is a setter method for the elevatorState member variable
     * 
     * @param state
     * An int representing one of the three states that an Elevator can be in
     */
    public void setElevatorState(int state){
        if (state == 0){
            this.elevatorState = IDLE;
        }
        else if (state == 1){
            this.elevatorState = TO_SOURCE;
        }
        else if (state == 2){
            this.elevatorState = TO_DESTINATION;
        }
        else{
            throw new IllegalArgumentException("Invalid Elevator State.");
        }    
    }
    
    /*
     * This method is a setter method for the currentRequest member variable
     * 
     * @param request
     * An object of type Request representing a request made by someone in the building
     */
    public void setCurrentRequest(Request request){
        this.currentRequest = request;
    }
    
    /*
     * This method moves the current elevator based on its' state and relationship to either the source floor or destination floor
     */
    public void move(){
        if (this.getElevatorState() == TO_SOURCE){
            if (this.getCurrentFloor() > this.getCurrentRequest().getSourceFloor()){
                this.setCurrentFloor(this.getCurrentFloor() - 1);
            }
            else if (this.getCurrentFloor() < this.getCurrentRequest().getSourceFloor()){
                this.setCurrentFloor(this.getCurrentFloor() + 1);
            }
            else if (this.getCurrentFloor() == this.getCurrentRequest().getSourceFloor()){
                this.setElevatorState(TO_DESTINATION);
            }
        }
        else if (this.getElevatorState() == TO_DESTINATION){
            if (this.getCurrentFloor() > this.getCurrentRequest().getDestinationFloor()){
                this.setCurrentFloor(this.getCurrentFloor() - 1);
            }
            else if (this.getCurrentFloor() < this.getCurrentRequest().getDestinationFloor()){
                this.setCurrentFloor(this.getCurrentFloor() + 1);
            }
            else if (this.getCurrentFloor() == this.getCurrentRequest().getDestinationFloor()){
                this.setElevatorState(IDLE);
            }
        }
    }
}
