package Ex2;
import java.util.ArrayList;

/**
 *
 * @author steven
 * @param <Gen> Gen represents generic types for the elements held in the queue
 */

public class QADT<Gen> {
    /*Overview: Queue abstract data type (QADT) implementation with an ArrayList. Follows FIFO (First-In-First-Out) principle.
    
      a) The abstraction function is:
            - AF(queue) = A queue of Gen type elements represented by the queue ArrayList
    
      b) The representation variants is that:
            - RI(queue) = True if queue is not null and properly reflects elements in the ArrayList
                        = False if queue is null or incorrectly reflects elements in the ArrayList
    */
    private final ArrayList<Gen> queue;

   //Constructor
    public QADT(){
        //Effects: creates a new queue object
        queue = new ArrayList<>();
    }

    public void enqueue(Gen element){
        //Modifies: queue
        //Effects: adds element to the end of the queue
        queue.add(element);
    }

    public boolean isEmpty(){
        //Effects: returns true if queue is empty, false if it is not
        return queue.isEmpty();
    }
    
    public Gen dequeue(){
        //Modifies: queue
        //Effects: removes element from the front of the queue
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue element from an empty queue");
        }
        return queue.remove(0);
    }

    private boolean repOK(){
        //Effects: returns false if queue is null
        if(queue==null) return false;
        
        //Effects: returns false if queue does not correctly represents arrayList
        int queueSize = queue.size();
        for(int i = 0; i < queueSize; i++){
            if(!queue.get(i).equals(this.dequeue())){
                return false;
            }
        }
       
        return true;
    }

    @Override
    public String toString() {
        //Effects: returns a string representation of the queue
        return queue.toString();
    }

    public static void main(String[] args) {
        // Test the queue implementation
        QADT<Integer> queue = new QADT<>();
        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        // Dequeue elements
        int dequeuedElement1 = queue.dequeue(); // 10
        int dequeuedElement2 = queue.dequeue(); // 20
        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty(); // false
        //Check if rep invariant is satisfied:
        
        //boolean isRepOK = queue.repOK();
        
        // Expected output
        System.out.println("Dequeued element 1: " + dequeuedElement1);
        System.out.println("Dequeued element 2: " + dequeuedElement2);
        System.out.println("Is the queue empty? " + isEmpty);
        
        //System.out.println("Is the rep invariant satisfied? " + isRepOK);

    }
}