import java.util.ArrayList;

/**
 * This is the generic stack class that I created 
 * @author Rachel C 
 * @param <T> makes this class generic 
 */
public class Stack<T> {
	/**is the arrayList that will represent the stack**/
	ArrayList<T> stack;
	
	/**
	 * This constructor initializes the arrayList 
	 */
	public Stack() {
		stack = new ArrayList<T>();
	}
	
	/**
	 * this constructor adds data to the last position/top of the stack 
	 * @param d is the data being added
	 */
	public void push(T d){
		stack.add(d);
	}
	
	/**
	 * this allow you to see what the data is in the last position 
	 * @return the data of the object in the last position 
	 */
	public T peek(){
		T temp  = stack.get(stack.size()-1);
		return temp;
	}
	
	/**
	 * this allows you to removed the object in the last position in the arraylist 
	 * @return the object that was removed 
	 */
	public T pop(){
		T temp  = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return temp;
		
	}
	
	/**
	 * this method checks if the arrayList is empty or not 
	 * @return a boolean based on whether it is empty or not
	 */
	public Boolean isEmpty(){
		Boolean ans = stack.isEmpty();
		return ans;
	}
	
	/**
	 * this method empties the arrayList 
	 */
	public void clear(){
		stack.clear();
	}
	
	/**
	 * this method returns the size of the arrayList
	 * @return int value of the size of the arrayList 
	 */
	public int size(){
		return stack.size();
	}
	
}
