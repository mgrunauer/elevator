/*
 * A class representing a queue of Request objects
 * 
 * @author Matthew Grunauer
 */
import java.util.ArrayList;
public class RequestQueue extends ArrayList{
    /*
     * This method is the no-arg constructor of an object of type RequestQueue
     */
    public RequestQueue(){
    }

    /*
     * This method adds a Request object to the current RequestQueue object
     * 
     * @param newRequest
     * An object of type Request representing a new request to be added to the queue
     */
    public void enqueue(Request newRequest){
        add(newRequest);
    }

    /*
     * This method removes a Request object from the current RequestQueue object
     * 
     * @return
     * An object of type Request representing the request that was at the front of the queue
     */
    public Request dequeue(){
        Request request = (Request) this.get(0);
        remove(0);
        return request;
    }
}
