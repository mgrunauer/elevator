/*
 * A class representing the chance of an event occuring based on its' specified probability
 * 
 * @author Matthew Grunauer
 */
public class BooleanSource{
    private double probability;
    /*
     * This method is a constructor for an object of type BooleanSource
     * 
     * @param p
     * A double representing the probability of an event occuring
     */
    public BooleanSource(double p){
        if (p < 0.0 || p > 1.0){
            throw new IllegalArgumentException("Invalid Probability.");
        }
        this.probability = p;
    }
    
    /*
     * This method decides if an event has occurred based on its' probability
     * 
     * @return
     * A boolean value representing whether or not an event has occurred based on its' probability
     */
    public boolean requestArrived(){
        return (Math.random() < this.probability);
    }
}
