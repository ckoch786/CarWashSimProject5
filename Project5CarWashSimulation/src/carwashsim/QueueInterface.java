//QueueInterface.java                 modified by Cory Koch 					Project 5
//
//

package carwashsim;

public interface QueueInterface<T> {
	
	T dequeue() throws QueueUnderFlowException;
	//Throws QueueUnderflowException if queue is empty
	//otherwise, removes front element from this queue and returns it.
	
	boolean isEmpty();
	//Returns true is this queue is empty; otherwise, returns false
	
	
}
