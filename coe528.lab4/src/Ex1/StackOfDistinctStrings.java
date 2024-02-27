package Ex1;
import java.util.ArrayList; 

/**
 *
 * @author steven
 */

public class StackOfDistinctStrings {
    /*Overview: StacksOfDistinctStrings are mutable, bounded 
      collection of distinct strings that operate in
      LIFO (Last-In-First-Out) order.
    
      a) The abstraction function is:
            - AF(items) = A stack of non-duplicate (distinct) strings represented by the items ArrayList
    
      b) The representation variants is that:
            - RI(items) = true if there are no duplicate strings in the items ArrayList, and the items ArrayList exists (ie. is not null)
                        = false if there are duplicate strings in the items ArrayList, or if the items ArrayList is null
    */
    
    //The rep
    private ArrayList<String> items;
    
    //Constructor
    public StackOfDistinctStrings(){
        //Effects: creates a new StackOfDistinctStrings object
        items = new ArrayList<String>();
    }
    
    public void push(String element) throws Exception{
        //Modifies: this
        /*Effects: appends the element at the top of the stack if the 
                   element is not in the stack, otherwise does nothing.
        */
        if(element==null) throw new Exception();
        if(false==items.contains(element))
            items.add(element);
    }
    
    public String pop() throws Exception{
        //Modifies: this
        /*Effects: removes an element from the top of the stack */
        if(items.size() == 0) throw new Exception();
        return items.remove(items.size()-1);
    }
    
    public boolean repOK(){
        /*Effects: returns true if the rep invariant holds 
                   for this object; otherwise returns false
        */
        //WRITE THE CODE
        if(items==null) return false;
        for(int i=0; i<items.size();i++){
            for(int j=i+1; j<items.size();j++){
                if(items.get(i).equals(items.get(j))){
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public String toString(){
        /*Effects: returns a string that contains the string in the stack 
                   and the top element. Implements the abstraction function
        */
        //WRITE THE CODE
        StringBuilder sb = new StringBuilder();
        for(String item : items){
            sb.append(item).append(", ");
        }
        return sb.toString();
    }
}
    

 